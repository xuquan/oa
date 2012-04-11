package cn.edu.zhku.oa.web.actions;

import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cn.edu.zhku.oa.manager.DocumentManager;
import cn.edu.zhku.oa.manager.WorkflowManager;
import cn.edu.zhku.oa.model.ApproveInfo;
import cn.edu.zhku.oa.model.Document;
import cn.edu.zhku.oa.web.forms.DocumentActionForm;

public class DocumentAction extends BaseAction {

	private DocumentManager documentManager;
	private WorkflowManager workflowManager;
	
	public void setDocumentManager(DocumentManager documentManager) {
		this.documentManager = documentManager;
	}

	public void setWorkflowManager(WorkflowManager workflowManager) {
		this.workflowManager = workflowManager;
	}

	//公文管理主界面，显示我的公文列表
	@Override
	protected ActionForward unspecified(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setAttribute("pm", documentManager.searchMyDocuments(currentUser(request).getId()));
		
		return mapping.findForward("index");
	}
	
	/**
	 * 已审公文列表，显示由当前登录人员审核的公文列表
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward approvedList(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setAttribute("pm", documentManager.searchApprovedDocuments(currentUser(request).getId()));
		
		return mapping.findForward("approved_list");
	}
	
	/**
	 * 待审公文列表，显示等待当前登录人员审核的公文列表
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward approvingList(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setAttribute("pm", documentManager.searchApprovingDocuments(currentUser(request).getId()));
		
		return mapping.findForward("approving_list");
	}
	
	/**
	 * 在待审公文列表上，针对某个文档，可以点击打开审批界面，对此文档进行审批
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward approveInput(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return mapping.findForward("approve_input");
	}
	
	/**
	 * 用户输入审批信息之后，点击保存，对文档进行审批操作
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward approve(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		DocumentActionForm daf = (DocumentActionForm)form;
		
		String comment = daf.getApproveInfo();
		int documentId = daf.getId();
		int approverId = currentUser(request).getId();
		
		ApproveInfo approveInfo = new ApproveInfo();
		approveInfo.setApproveTime(new Date());
		approveInfo.setComment(comment);
		
		documentManager.addApproveInfo(approveInfo, documentId, approverId, daf.isBack());
		
		return mapping.findForward("pub_add_success");
	}
	
	/**
	 * 在我的公文或待审公文列表上，点击提交，可打开提交的选择界面
	 * 在这个界面上，列出下一步所有可选的步骤，用户可以选择其中一个
	 * 步骤进行提交操作。系统将按照用户的选择转移到下一个节点
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward submitInput(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		DocumentActionForm daf = (DocumentActionForm)form;
		
		List transitions = documentManager.searchNextSteps(daf.getId(), currentUser(request).getId());
		request.setAttribute("steps", transitions);
		return mapping.findForward("submit_input");
	}
	
	/**
	 * 用户选择了其中一个步骤，点击提交
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward submit(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		DocumentActionForm daf = (DocumentActionForm)form;
		
		documentManager.submitToWorkflow(currentUser(request).getId(), daf.getId(), daf.getTransitionName());
		
		return mapping.findForward("pub_add_success");
	}
	
	/**
	 * 查看公文的审批历史
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward approvedHistory(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		DocumentActionForm daf = (DocumentActionForm)form;
		request.setAttribute("historys", documentManager.searchApproveInfos(daf.getId()));		
		
		return mapping.findForward("approve_history");
	}
	
	public ActionForward del(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		DocumentActionForm daf = (DocumentActionForm)form;
		documentManager.delDocument(daf.getId());
		
		return mapping.findForward("pub_del_success");
	}
	
	/**
	 * 点击添加公文的时候，需要选择相应的流程，此界面列出所有的流程以供选择
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward selectFlow(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setAttribute("workflows", workflowManager.searchAllWorkflows());
		
		return mapping.findForward("select_flow");
	}
	
	/**
	 * 选择了流程之后（即点击流程名称），需要打开公文录入界面
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward addInput(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return mapping.findForward("add_input");
	}
	
	/**
	 * 添加公文的操作
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward add(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		DocumentActionForm daf = (DocumentActionForm)form;
		Document document = new Document();
		BeanUtils.copyProperties(document, daf);
		
		if(daf.getContentFile() != null){
			document.setContent(daf.getContentFile().getFileData());
		}
		
		documentManager.addDocument(document, daf.getWorkflowId(), currentUser(request).getId(), daf.getProps());
		
		return mapping.findForward("pub_add_success");
	}
	
	//下载公文附件
	public ActionForward download(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		DocumentActionForm daf = (DocumentActionForm)form;
		
		Document document = documentManager.findDocument(daf.getId());

		response.reset();
		response.setContentType("application/x-download;charset=GBK");
		response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(document.getTitle(), "UTF-8")+".doc");
		
		response.getOutputStream().write(document.getContent());
		
		response.getOutputStream().flush();
		response.getOutputStream().close();
		
		//指示struts，不要对返回值进行处理
		return null;
	}
	
	/**
	 * 公文归档
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward searchAllFinishedDocuments(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setAttribute("pm", documentManager.searchAllFinishedDocuments("收文结束"));
		
		return mapping.findForward("finished_docs");
	}
	
}
