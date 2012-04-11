package cn.edu.zhku.oa.dao;

import java.util.List;

import cn.edu.zhku.oa.PagerModel;
import cn.edu.zhku.oa.model.ApproveInfo;
import cn.edu.zhku.oa.model.Document;

/**
 * 公文持久化接口
 * 编写作者：许权
 * 编写日期：2011-2-15 下午08:24:06
 */
public interface DocumentDao {
	
	/**
	 * 添加公文信息
	 * @param document
	 * @param workfowId
	 * @param userId
	 */
	public void addDocument(Document document);

	/**
	 * 查找某个公文的信息
	 * @param documentId
	 * @return
	 */
	public Document findDocument(int documentId);
	
	/**
	 * 更新公文信息
	 * @param document
	 */
	public void updateDocument(Document document);
	
	/**
	 * 删除公文信息
	 * @param documentId
	 */
	public void delDocument(Document document);
	
	/**
	 * 搜索用户自身创建的公文列表
	 * @param userId
	 * @return
	 */
	public PagerModel searchMyDocuments(int userId);
	
	/**
	 * 查询公文的审批信息
	 * @param documentId
	 * @return
	 */
	public List searchApproveInfos(int documentId);
	
	/**
	 * 查询公文列表
	 * @param docIds
	 * @return
	 */
	public PagerModel findAllDocumentsByIds(List docIds);
	
	/**
	 * 查询用户已审批过的公文列表
	 * @param userId
	 * @return
	 */
	public PagerModel searchApprovedDocuments(int userId);
	
	/**
	 * 存储审批信息
	 * @param approveInfo 审批信息
	 * @param documentId 被审批的公文
	 * @param approverId 审批者ID
	 */
	public void addApproveInfo(ApproveInfo approveInfo);
	
	/**
	 * 公文归档处理
	 * @param status
	 * @return
	 */
	public PagerModel searchAllFinishedDocuments(String status);
	
}
