package cn.edu.zhku.oa.manager.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import cn.edu.zhku.oa.PagerModel;
import cn.edu.zhku.oa.dao.DocumentDao;
import cn.edu.zhku.oa.dao.UserDao;
import cn.edu.zhku.oa.dao.WorkflowDao;
import cn.edu.zhku.oa.manager.DocumentManager;
import cn.edu.zhku.oa.manager.JbpmFacade;
import cn.edu.zhku.oa.model.ApproveInfo;
import cn.edu.zhku.oa.model.Document;
import cn.edu.zhku.oa.model.User;

public class DocumentManagerImpl implements DocumentManager {

	private DocumentDao documentDao;
	public void setDocumentDao(DocumentDao documentDao) {
		this.documentDao = documentDao;
	}
	
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	private WorkflowDao workflowDao;
	public void setWorkflowDao(WorkflowDao workflowDao) {
		this.workflowDao = workflowDao;
	}

	private JbpmFacade jbpmFacade;
	
	//审批
	public void addApproveInfo(ApproveInfo approveInfo, int documentId,
			int approverId,boolean back) {
		Document doc = documentDao.findDocument(documentId);
		User user = userDao.findUser(approverId);
		approveInfo.setDocument(doc);
		approveInfo.setApprover(user);
		documentDao.addApproveInfo(approveInfo);
		
		//如果是驳回，则返回上一个节点
		if(back){
			Object[] os = jbpmFacade.backStep(doc.getProcessInstanceId(), user.getUsername());
			doc.setStatus((String)os[0]);
			doc.setProcessInstanceId((Long)os[1]);
			documentDao.updateDocument(doc);
		}		
	}

	//添加公文
	public void addDocument(Document document, int workflowId, int userId,Map props) {
		
		//保存公文信息
		document.setWorkflow(workflowDao.findWorkflowById(workflowId));
		document.setCreator(userDao.findUser(userId));
		document.setStatus(Document.STATUS_NEW);
		document.setCreateTime(new Date());
		
		//设置其它属性
		document.setPropertiesMap(props);
		
		documentDao.addDocument(document);
		
		//添加流程实例
		long processInstanceId = jbpmFacade.addProcessInstance(document.getWorkflow().getName(), document);
		
		//绑定流程实例的标识到公文对象
		document.setProcessInstanceId(processInstanceId);
		documentDao.updateDocument(document);
	}

	//删除公文
	public void delDocument(int documentId) {
		Document document = documentDao.findDocument(documentId);
		
		//删除公文信息
		documentDao.delDocument(document);
		
		//删除流程实例
		jbpmFacade.delProcessInstance(document.getProcessInstanceId());
	} 

	//查找特定公文
	public Document findDocument(int documentId) {
		
		return documentDao.findDocument(documentId);
	}

	//查找公文的审批历史
	public List searchApproveInfos(int documentId) {
		
		return documentDao.searchApproveInfos(documentId);
	}

	//查找用户已审批过的公文
	public PagerModel searchApprovedDocuments(int userId) {
		
		return documentDao.searchApprovedDocuments(userId);
	}

	//查找正在等待审批的公文
	public PagerModel searchApprovingDocuments(int userId) {
		User user = userDao.findUser(userId);
		
		//搜索已流转到用户那里的公文标识列表
		List docIds = jbpmFacade.searchMyTaskList(user.getUsername());
		
		if(docIds == null || docIds.isEmpty()){
			return null;
		}
		
		//根据公文标识查找所有的公文对象
		return documentDao.findAllDocumentsByIds(docIds);
	}

	//查找用户创建的所有公文
	public PagerModel searchMyDocuments(int userId) {
		
		return documentDao.searchMyDocuments(userId);
	}

	public List searchNextSteps(int documentId, int userId) {
		Document doc = documentDao.findDocument(documentId);
		User user = userDao.findUser(userId);
		String username = user.getUsername();
		
		return jbpmFacade.searchNextTransitions(doc.getProcessInstanceId(), username);
	}

	//提交到流程
	public void submitToWorkflow(int userId, int documentId, String transitionName) {
		User user = userDao.findUser(userId);
		String username = user.getUsername();
		
		Document document = documentDao.findDocument(documentId);
		long processInstanceId = document.getProcessInstanceId();
		
		String status = jbpmFacade.nextStep(processInstanceId,username,  transitionName);
		
		document.setStatus(status);
		documentDao.updateDocument(document);
	}
	
	//更新公文信息
	public void updateDocument(Document document,int workflowId,int userId) {
		documentDao.updateDocument(document);
	}

	public void setJbpmFacade(JbpmFacade jbpmFacade) {
		this.jbpmFacade = jbpmFacade;
	}

	@Override
	public PagerModel searchAllFinishedDocuments(String status) {
		return documentDao.searchAllFinishedDocuments(status);
	}

}
