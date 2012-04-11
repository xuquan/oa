package cn.edu.zhku.oa.manager;

import java.util.List;

import cn.edu.zhku.oa.model.Workflow;

/**
 * 流程管理接口
 * 作者：许权
 * 时间：2010-7-28 上午12:05:22
 */
public interface WorkflowManager {
	
	/**
	 * 添加或更新工作流程
	 * @param processDef 流程定义
	 * @param processImage 流程图片
	 */
	public void addOrUpdateWorkflow(byte[] processDef,byte[] processImage);
	
	/**
	 * 删除工作流程
	 * @param workflow 流程标识
	 */
	public void delWorkflow(int workflow);
	
	/**
	 * 查找特定工作流程
	 * @param workflow 流程标识
	 * @return
	 */
	public Workflow findWorkflow(int workflow);
	
	/**
	 * 查找所有工作流程
	 * @return
	 */
	public List searchAllWorkflows();
	
}
