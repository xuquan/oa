package cn.edu.zhku.oa.manager.impl;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jbpm.JbpmConfiguration;
import org.jbpm.JbpmContext;
import org.jbpm.graph.def.ProcessDefinition;
import org.jbpm.graph.def.Transition;
import org.jbpm.graph.exe.ProcessInstance;
import org.jbpm.taskmgmt.exe.TaskInstance;

import cn.edu.zhku.oa.dao.impl.AbstractDao;
import cn.edu.zhku.oa.manager.JbpmFacade;
import cn.edu.zhku.oa.model.Document;
import cn.edu.zhku.oa.web.actions.CreateTransitionAction;

public class JbpmFacadeImpl extends AbstractDao implements JbpmFacade {

	private JbpmConfiguration jbpmConfiguration;
	
	public long addProcessInstance(String processName, Document document) {
		
		JbpmContext context = getJbpmContext();
		
		ProcessDefinition def = context.getGraphSession().findLatestProcessDefinition(processName);
		
		ProcessInstance instance = new ProcessInstance(def);
		
		instance.getContextInstance().setVariable("document", document.getId());
		
		//将公文标题也提交到流程实例变量中，以便在E-Mail中能够提示这个公文的名称
		instance.getContextInstance().setVariable("docTitle", document.getTitle());
		
		//将公文的相关属性设置进入流程实例变量
		Map props = document.getProps();
		if(props != null){
			Set entries = props.entrySet();
			for (Iterator iterator = entries.iterator(); iterator.hasNext();) {
				Map.Entry entry = (Map.Entry) iterator.next();
				String propertyName = (String)entry.getKey();
				Object obj = document.getProperty(propertyName);
				//将变量放入流程实例变量
				instance.getContextInstance().setVariable(propertyName, obj);
			}
		}
		
		context.save(instance);
		
		return instance.getId();
	}

	public void delProcessDefinition(String processName) {
		JbpmContext context = getJbpmContext();
		List defs = context.getGraphSession().findAllProcessDefinitionVersions(processName);
		for (Iterator iterator = defs.iterator(); iterator.hasNext();) {
			ProcessDefinition def = (ProcessDefinition) iterator.next();
			context.getGraphSession().deleteProcessDefinition(def);
		}
	}

	public void delProcessInstance(long processInstanceId) {
		JbpmContext context = getJbpmContext();
		context.getGraphSession().deleteProcessInstance(processInstanceId);
	}

	public String deployProcessDefinition(byte[] processDef) {
		
		JbpmContext context = getJbpmContext();
		
		ProcessDefinition def = ProcessDefinition.parseXmlInputStream(
			new ByteArrayInputStream(processDef)
		);
		
		context.deployProcessDefinition(def);
		
		return def.getName();
	}

	public String nextStep(long processInstanceId, String actorId,
			String transitionName) {
		
		JbpmContext context = getJbpmContext();
		ProcessInstance instance = context.getProcessInstance(processInstanceId);
		
		//当前节点
		String currentNodeName = instance.getRootToken().getNode().getName();
		
		//起点的名称
		String startNodeName = instance.getProcessDefinition().getStartState().getName();
				
		//如果是在起点
		if(startNodeName.equals(currentNodeName)){
			if(transitionName == null){
				instance.signal();
			}else{
				instance.signal(transitionName);
			}
		}else{
			List taskInstances = context.getTaskMgmtSession().findTaskInstances(actorId);
			for (Iterator iterator = taskInstances.iterator(); iterator
					.hasNext();) {
				TaskInstance ti = (TaskInstance) iterator.next();
				if(ti.getProcessInstance().getId() == processInstanceId){
					if(transitionName == null){
						ti.end();
					}else{
						ti.end(transitionName);
					}
					break;
				}
			}
			
			
			//查找所属组的任务实例
			List pooledTaskInstances = context.getTaskMgmtSession().findPooledTaskInstances(actorId);
			for (Iterator iterator = pooledTaskInstances.iterator(); iterator
					.hasNext();) {
				TaskInstance ti = (TaskInstance) iterator.next();
				if(ti.getProcessInstance().getId() == processInstanceId){
					if(transitionName == null){
						ti.end();
					}else{
						ti.end(transitionName);
					}
					break;
				}
			}
		}
		
		//返回转向之后的节点名称
		return instance.getRootToken().getNode().getName();
	}
	
	//回退
	public Object[] backStep(long processInstanceId, String actorId) {
		JbpmContext context = getJbpmContext();
		
		//根据流程实例标识查找流程实例
		ProcessInstance instance = context.getProcessInstance(processInstanceId);
		Object[] os = new Object[2];
		//搜索用户对应的所有的任务实例
		List taskInstances = context.getTaskMgmtSession().findTaskInstances(actorId);
		for (Iterator iterator = taskInstances.iterator(); iterator
				.hasNext();) {
			TaskInstance ti = (TaskInstance) iterator.next();
			if(ti.getProcessInstance().getId() == processInstanceId){
				
				//先判断是否是要回退到起点
				Set set = ti.getToken().getNode().getArrivingTransitions();
				for (Iterator iterator2 = set.iterator(); iterator2.hasNext();) {
					Transition t = (Transition) iterator2.next();
					//如果它需要回退到起点
					if(t.getFrom().equals(ti.getProcessInstance().getProcessDefinition().getStartState())){
						int docId = (Integer)ti.getProcessInstance().getContextInstance().getVariable("document");
						//结束当前的流程实例
						ti.getProcessInstance().end();
						//结束当前任务实例
						ti.end();
						
						//重新创建流程实例对象
						ProcessInstance pi = new ProcessInstance(ti.getProcessInstance().getProcessDefinition());
						pi.getContextInstance().setVariable("document", docId);
						//将流程实例对象重新持久化到数据库
						context.save(pi);
						
						os[0] = Document.STATUS_NEW;
						os[1] = pi.getId();
						
						return os;
					}
				}
				
				//如果不需要回退到起点
				ti.end(CreateTransitionAction.BACK_TRANSITION);
				break;
			}
		}
		
		os[0] = instance.getRootToken().getNode().getName();
		os[1] = processInstanceId;
		
		return os;
	}

	public List searchMyTaskList(String actorId) {
		
		JbpmContext context = getJbpmContext();
		List docIds = new ArrayList();
		List taskInstances = context.getTaskMgmtSession().findTaskInstances(actorId);
		for (Iterator iterator = taskInstances.iterator(); iterator.hasNext();) {
			TaskInstance ti = (TaskInstance) iterator.next();
			Integer docId = (Integer)ti.getProcessInstance().getContextInstance().getVariable("document");
			docIds.add(docId);
		}
		
		//查找所属组的任务实例
		List pooledTaskInstances = context.getTaskMgmtSession().findPooledTaskInstances(actorId);
		for (Iterator iterator = pooledTaskInstances.iterator(); iterator
				.hasNext();) {
			TaskInstance ti = (TaskInstance) iterator.next();
			Integer docId = (Integer)ti.getProcessInstance().getContextInstance().getVariable("document");
			docIds.add(docId);
		}		
		
		return docIds;
	}

	public List searchNextTransitions(long processInstanceId, String actorId) {
		JbpmContext context = getJbpmContext();
		ProcessInstance instance = context.getProcessInstance(processInstanceId);
		
		//当前节点
		String currentNodeName = instance.getRootToken().getNode().getName();
		
		//起点的名称
		String startNodeName = instance.getProcessDefinition().getStartState().getName();
		
		Collection transitions = null;
		
		//如果是在起点
		if(startNodeName.equals(currentNodeName)){
			transitions = instance.getRootToken().getAvailableTransitions();
		}else{
			List taskInstances = context.getTaskMgmtSession().findTaskInstances(actorId);
			for (Iterator iterator = taskInstances.iterator(); iterator
					.hasNext();) {
				TaskInstance ti = (TaskInstance) iterator.next();
				if(ti.getProcessInstance().getId() == processInstanceId){
					transitions = ti.getAvailableTransitions();
					break;
				}
			}
			
			//查找所属组的任务实例
			List pooledTaskInstances = context.getTaskMgmtSession().findPooledTaskInstances(actorId);
			for (Iterator iterator = pooledTaskInstances.iterator(); iterator
					.hasNext();) {
				TaskInstance ti = (TaskInstance) iterator.next();
				if(ti.getProcessInstance().getId() == processInstanceId){
					transitions = ti.getAvailableTransitions();
				}
			}
		}
		
		List transitionNames = new ArrayList();
		
		if(transitions != null){
			//为了不把Transition对象直接暴露给OA系统，需要将其转换为名称列表
			for (Iterator iterator = transitions.iterator(); iterator.hasNext();) {
				Transition transition = (Transition) iterator.next();
				transitionNames.add(transition.getName());
			}
		}
		
		return transitionNames;
	}
	
	private JbpmContext getJbpmContext(){
		JbpmContext context = jbpmConfiguration.createJbpmContext();
		context.setSession(getSession());
		return context;
	}

	public void setJbpmConfiguration(JbpmConfiguration jbpmConfiguration) {
		this.jbpmConfiguration = jbpmConfiguration;
	}

}
