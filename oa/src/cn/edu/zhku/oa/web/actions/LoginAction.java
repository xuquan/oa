package cn.edu.zhku.oa.web.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import cn.edu.zhku.oa.manager.AclManager;
import cn.edu.zhku.oa.manager.UserManager;
import cn.edu.zhku.oa.model.User;
import cn.edu.zhku.oa.web.forms.UserActionForm;

public class LoginAction extends DispatchAction {

	private UserManager userManager;
	private AclManager aclManager;
	
	//执行登录操作
	@Override
	protected ActionForward unspecified(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		UserActionForm uaf = (UserActionForm)form;
		
		User user = userManager.login(uaf.getUsername(), uaf.getPassword());
		
		if(null == user){
			response.sendRedirect("index.jsp");
			return null;
		}
		
		List modules = aclManager.searchModules(user.getId());
		
		request.getSession().setAttribute("login", user);
		
		request.getSession().setAttribute("modules", modules);
		
		return mapping.findForward("main");
	}

	/**
	 * 退出系统
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward logout(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//获取当前登录用户的所有授权
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("index.jsp");
		return null;
	}
	
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	public void setAclManager(AclManager aclManager) {
		this.aclManager = aclManager;
	}

}
