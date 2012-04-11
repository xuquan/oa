package cn.edu.zhku.oa.dao;

import java.util.List;

import cn.edu.zhku.oa.model.Workflow;

/**
 * 流程管理接口
 * 作者：许权
 * 时间：2010-7-28 上午12:05:22
 */
public interface WorkflowDao {
	
	/**
	 * 根据流程名称，查询已有Workflow对象
	 * @param workflowName
	 * @return
	 */
	public Workflow findWorkflowByName(String workflowName);
	
	/**
	 * 保存工作流程
	 * @param workflow 工作流程
	 */
	public void saveWorkflow(Workflow workflow);
	
	/**
	 * 更新工作流程
	 * @param workflow 工作流程
	 */
	public void updateWorkflow(Workflow workflow);
	
	/**
	 * 删除工作流程
	 * @param workflow
	 */
	public void delWorkflow(Workflow workflow);
	
	/**
	 * 根据工作流程标识查找特定工作流
	 * @param workflowId 流程标识
	 * @return
	 */
	public Workflow findWorkflowById(int workflowId);
	
	/**
	 * 查询所有工作流程
	 * @return
	 */
	public List searchAllWorkflows();
}
