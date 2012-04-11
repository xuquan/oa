package cn.edu.zhku.oa.manager.impl;

import java.util.List;

import cn.edu.zhku.oa.dao.WorkflowDao;
import cn.edu.zhku.oa.manager.JbpmFacade;
import cn.edu.zhku.oa.manager.WorkflowManager;
import cn.edu.zhku.oa.model.Workflow;

public class WorkflowManagerImpl implements	WorkflowManager {

	private WorkflowDao workflowDao;
	public void setWorkflowDao(WorkflowDao workflowDao) {
		this.workflowDao = workflowDao;
	}

	private JbpmFacade jbpmFacade;
	
	public void addOrUpdateWorkflow(byte[] processDef, byte[] processImage) {
		String workflowName = jbpmFacade.deployProcessDefinition(processDef);
		
		//首先根据流程名称，查询是否已有Workflow对象
		Workflow wf = workflowDao.findWorkflowByName(workflowName);
		if(wf == null){
			wf = new Workflow();
			wf.setName(workflowName);
			wf.setProcessDefinition(processDef);
			wf.setProcessImage(processImage);
			workflowDao.saveWorkflow(wf);
		}else{
			wf.setProcessDefinition(processDef);
			wf.setProcessImage(processImage);
			workflowDao.updateWorkflow(wf);
		}
	}

	public void delWorkflow(int workflowId) {
		Workflow wf = findWorkflow(workflowId);
		jbpmFacade.delProcessDefinition(wf.getName());
		workflowDao.delWorkflow(wf);
	}

	public Workflow findWorkflow(int workflowId) {
		return workflowDao.findWorkflowById(workflowId);
	}

	public List searchAllWorkflows() {
		return workflowDao.searchAllWorkflows();
	}

	public void setJbpmFacade(JbpmFacade jbpmFacade) {
		this.jbpmFacade = jbpmFacade;
	}
}
