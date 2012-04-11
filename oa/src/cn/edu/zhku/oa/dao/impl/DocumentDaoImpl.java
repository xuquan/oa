package cn.edu.zhku.oa.dao.impl;

import java.util.List;

import cn.edu.zhku.oa.PagerModel;
import cn.edu.zhku.oa.dao.DocumentDao;
import cn.edu.zhku.oa.dao.WorkflowDao;
import cn.edu.zhku.oa.model.ApproveInfo;
import cn.edu.zhku.oa.model.Document;

public class DocumentDaoImpl extends AbstractDao implements
		DocumentDao {

	private WorkflowDao workflowDao;
	public void setWorkflowDao(WorkflowDao workflowDao) {
		this.workflowDao = workflowDao;
	}

	//审批
	@Override
	public void addApproveInfo(ApproveInfo approveInfo) {
		getHibernateTemplate().save(approveInfo);
	}

	//添加公文
	@Override
	public void addDocument(Document document) {
		//保存公文信息
		getHibernateTemplate().save(document);
	}

	//删除公文
	@Override
	public void delDocument(Document document) {
		//删除公文信息
		getHibernateTemplate().delete(document);
	}

	//查找特定公文
	@Override
	public Document findDocument(int documentId) {
		return (Document)getHibernateTemplate().load(Document.class, documentId);
	}

	//查找用户已审批过的公文
	@Override
	public PagerModel searchApprovedDocuments(int userId) {
		return searchPaginated("select distinct ai.document from ApproveInfo ai where ai.approver.id=?",userId);
	}

	@Override
	public List searchApproveInfos(int documentId) {
		return getHibernateTemplate().find("from ApproveInfo ai where ai.document.id=?",documentId);
	}

	//查找用户创建的所有公文
	@Override
	public PagerModel searchMyDocuments(int userId) {
		return searchPaginated("select d from Document d where d.creator.id = ?",userId);
	}

	//更新公文信息
	@Override
	public void updateDocument(Document document) {
		getHibernateTemplate().update(document);
	}
	
	@Override
	public PagerModel findAllDocumentsByIds(List docIds) {
		//根据公文标识查找所有的公文对象
		PagerModel pm = new PagerModel();
		pm.setDatas(getSession().createQuery("select d from Document d where d.id in (:ids)")
				   .setParameterList("ids", docIds)
				   .list());
		return pm;
	}

	@Override
	public PagerModel searchAllFinishedDocuments(String status) {
		return searchPaginated("select d from Document d where d.status=?", status);
	}

}
