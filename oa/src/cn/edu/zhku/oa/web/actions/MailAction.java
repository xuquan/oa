package cn.edu.zhku.oa.web.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import cn.edu.zhku.oa.PagerModel;
import cn.edu.zhku.oa.manager.MailManager;
import cn.edu.zhku.oa.model.MailUser;
import cn.edu.zhku.oa.model.User;
import cn.edu.zhku.oa.web.forms.MailActionForm;
import cn.edu.zhku.oa.web.forms.UserActionForm;

public class MailAction extends DispatchAction {
	private MailManager mailManager;
	public void setMailManager(MailManager mailManager) {
		this.mailManager = mailManager;
	}

	//首页，显示邮件列表
	@Override
	protected ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		request.setAttribute("pm", mailManager.findMails());
		
		return mapping.findForward("index");
	}
	
	//打开发邮件界面	
	public ActionForward sendInput(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		return mapping.findForward("send_input");
	}
	
	public ActionForward send(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		MailActionForm maf = (MailActionForm)form;
		
		
		
		return mapping.findForward("pub_add_success");
	}
	
	//打开更新界面	
	public ActionForward updateInput(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		MailActionForm maf = (MailActionForm)form;
		return mapping.findForward("update_input");
	}
	
	public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		MailActionForm maf = (MailActionForm)form;
		
		
		return mapping.findForward("pub_update_success");
	}
	
	public ActionForward del(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		MailActionForm maf = (MailActionForm)form;
		
		
		
		return mapping.findForward("pub_add_success");
	}
	
	public ActionForward inbox(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		MailActionForm maf = (MailActionForm)form;
		
		
		return mapping.findForward("inbox");
		
	}
	
	public ActionForward draft(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		MailActionForm maf = (MailActionForm)form;
		
		return mapping.findForward("user_role_list");
	}
	
	public ActionForward sendbox(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		MailActionForm maf = (MailActionForm)form;
		
		
		return mapping.findForward("user_role_input");
	}
	
	public ActionForward trash(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		MailActionForm maf = (MailActionForm)form;
		
		return mapping.findForward("pub_add_success");
	}
	
	public ActionForward outbox(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		MailActionForm maf = (MailActionForm)form;
		
		return mapping.findForward("pub_del_success");
	}
}
