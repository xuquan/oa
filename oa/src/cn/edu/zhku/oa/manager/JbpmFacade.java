package cn.edu.zhku.oa.manager;

import java.util.List;

import cn.edu.zhku.oa.model.Document;

/**
 * Jbpm流程接口（采用门面模式）
 * 编写作者：许权
 * 编写日期：2011-3-1 上午10:05:51
 */
public interface JbpmFacade {
	/**
	 * 部署流程定义
	 * @param processDef 流程定义文件的数据
	 * @return 流程名称
	 */
	public String deployProcessDefinition(byte[] processDef);
	
	/**
	 * 删除流程定义
	 * @param processName 流程名称
	 */
	public void delProcessDefinition(String processName);
	
	/**
	 * 添加流程实例
	 * @param processName 流程实例对应的流程名称
	 * @param docId 公文ID
	 * @return 流程实例
	 */
	public long addProcessInstance(String processName,Document doc);
	
	/**
	 * 删除流程实例对象
	 * @param processInstanceId 删除流程实例对象
	 */
	public void delProcessInstance(long processInstanceId);
	
	/**
	 * 搜索某个用户手上的公文列表
	 * @param actorId 用户帐号
	 * @return List中的元素是docId
	 */
	public List searchMyTaskList(String actorId);
	
	/**
	 * 查询下一步Transition列表
	 * @param processInstanceId 流程实例标识
	 * @param actorId 用户帐号
	 * @return List中的元素是Transition对象的名称
	 */
	public List searchNextTransitions(long processInstanceId,String actorId);
	
	/**
	 * 触发JBPM引擎流转到下一步
	 * @param processInstanceId 流程实例标识
	 * @param actorId 用户帐号
	 * @param transitionName transition Name
	 * @return 流转之后，当前流程实例所对应的rootToken所指向的节点的名称
	 */
	public String nextStep(long processInstanceId,String actorId,String transitionName);
	
	/**
	 * 回退操作
	 * 
	 * @param processInstanceId 流程实例标识
	 * @param actorId 参与者
	 * @return 长度为2的数组，第一个值是转向之后的节点名称，第二个值是流程实例标识
	 */
	public Object[] backStep(long processInstanceId,String actorId);
}
