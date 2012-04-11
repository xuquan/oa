package cn.edu.zhku.oa.web.actions;

import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.jbpm.graph.def.ActionHandler;
import org.jbpm.graph.def.Node;
import org.jbpm.graph.def.Transition;
import org.jbpm.graph.exe.ExecutionContext;
import org.jbpm.graph.node.EndState;

public class CreateTransitionAction implements ActionHandler {

	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(CreateTransitionAction.class);
	public static final String BACK_TRANSITION = "回退";
	
	public void execute(ExecutionContext executionContext) throws Exception {
		logger.debug("进入Action");
		
		//如果当前节点是在结束节点，则无需创建任何返回Transition
		if(executionContext.getNode() instanceof EndState){
			return;
		}
		
		boolean ignore = false;
		
		//得到当前指向的节点所有可以使用的transition对象列表
		Set ts = executionContext.getToken().getAvailableTransitions();
		for (Iterator iterator = ts.iterator(); iterator.hasNext();) {
			Transition t = (Transition) iterator.next();
			if(t.getName().equals(BACK_TRANSITION)){
				ignore = true;
				break;
			}
		}
		
		//如果尚未创建回退Transition对象，就可以继续创建
		if(!ignore){
			String preNodeName = (String)executionContext.getContextInstance().getVariable("preNodeName");
			if(preNodeName != null){ //前一个节点非空，需要创建回退Transition
				
				//从当前节点
				Node from = executionContext.getNode();
				
				//将上一个节点作为终点
				Node to = executionContext.getProcessDefinition().getNode(preNodeName);
				
				//创建回退Transition对象
				Transition transition = new Transition();
				transition.setName(BACK_TRANSITION);
				transition.setDescription("自动生成的回退Transition对象");
				from.addLeavingTransition(transition);
				to.addArrivingTransition(transition);
			}
			executionContext.getContextInstance().setVariable("preNodeName", executionContext.getNode().getName());
		}
		
	}

}
