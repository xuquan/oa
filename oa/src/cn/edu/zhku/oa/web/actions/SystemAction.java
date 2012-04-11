package cn.edu.zhku.oa.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.springframework.beans.BeanUtils;

import cn.edu.zhku.oa.manager.UserManager;
import cn.edu.zhku.oa.model.User;
import cn.edu.zhku.oa.web.forms.UserActionForm;

public class SystemAction extends DispatchAction {
	
	private UserManager userManager;
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	public ActionForward updatePasswordInput(ActionMapping mapping,ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		//获取登录用户的信息
		User user = (User) request.getSession().getAttribute("login");
		request.setAttribute("user", user);
		return mapping.findForward("update_password_input");
	}
	
	public ActionForward updatePassword(ActionMapping mapping,ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		UserActionForm uaf = (UserActionForm)form;
		User user = new User();
		BeanUtils.copyProperties(user, uaf);
		userManager.updateUser(user, uaf.getPersonId());
		return mapping.findForward("pub_update_success");
		
	}
}
