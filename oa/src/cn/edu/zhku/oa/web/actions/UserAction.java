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
import cn.edu.zhku.oa.manager.PersonManager;
import cn.edu.zhku.oa.manager.RoleManager;
import cn.edu.zhku.oa.manager.UserManager;
import cn.edu.zhku.oa.model.MailUser;
import cn.edu.zhku.oa.model.User;
import cn.edu.zhku.oa.web.forms.UserActionForm;

public class UserAction extends DispatchAction {
	
	private PersonManager personMgr;
	private UserManager userMgr;
	private RoleManager roleMgr;
	
	//首页，显示人员列表
	@Override
	protected ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		request.setAttribute("pm", personMgr.searchPersons());
		
		return mapping.findForward("index");
	}
	
	//打开添加界面	
	public ActionForward addInput(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		return mapping.findForward("add_input");
	}
	
	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		UserActionForm uaf = (UserActionForm)form;
		
		User user = new User();
		
		BeanUtils.copyProperties(user, uaf);
		
		userMgr.addUser(user, uaf.getPersonId());
		
		return mapping.findForward("pub_add_success");
	}
	
	//打开更新界面	
	public ActionForward updateInput(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		UserActionForm uaf = (UserActionForm)form;
		request.setAttribute("user", userMgr.findUser(uaf.getId()));
		
		return mapping.findForward("update_input");
	}
	
	public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UserActionForm uaf = (UserActionForm)form;
		
		User user = new User();
		
		BeanUtils.copyProperties(user, uaf);
		
		userMgr.updateUser(user, uaf.getPersonId());
		
		return mapping.findForward("pub_update_success");
	}
	
	public ActionForward updatePassword(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		UserActionForm uaf = (UserActionForm)form;
		
		userMgr.updatePassword(uaf.getId(), uaf.getOldPassword(), uaf.getPassword());
		
		return mapping.findForward("done");
	}
	
	public ActionForward chgpsw(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		User user = (User) request.getSession().getAttribute("login");
		
		request.setAttribute("user", userMgr.findUser(user.getId()));
		
		return mapping.findForward("password_input");
		
	}
	
	//打开用户已有角色的列表页面，在页面上需要显示：用户的姓名、以及用户已拥有的角色列表
	public ActionForward userRoleList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		UserActionForm uaf = (UserActionForm)form;
		
		User user = userMgr.findUser(uaf.getId());
		
		//需要加载已分配给用户的角色列表
		List userRoleList = userMgr.searchUserRoles(uaf.getId());
		
		request.setAttribute("user", user);
		request.setAttribute("urs", userRoleList);
		
		return mapping.findForward("user_role_list");
	}
	
	//打开给用户分配角色页面：即从角色列表中选择某个角色，并设置优先级
	public ActionForward userRoleInput(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		UserActionForm uaf = (UserActionForm)form;
		
		//查找角色列表，并传输到界面，以便用户的选择
		PagerModel roles = roleMgr.searchRoles();
		
		request.setAttribute("pm", roles);
		
		return mapping.findForward("user_role_input");
	}
	
	//给用户分配角色：页面上需要传递过来的参数包括：用户标识、角色标识、优先级
	public ActionForward addUserRole(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		UserActionForm uaf = (UserActionForm)form;
		//用户标识
		int userId = uaf.getId();
		//角色标识
		int roleId = uaf.getRoleId();
		//优先级
		int orderNo = uaf.getOrderNo();
		
		userMgr.addOrUpdateUserRole(userId, roleId, orderNo);
		
		return mapping.findForward("pub_add_success");
	}
	
	//删除分配给用户的角色，页面上需要传输过来的参数包括：用户标识、角色标识
	public ActionForward delUserRole(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		UserActionForm uaf = (UserActionForm)form;
		//用户标识
		int userId = uaf.getId();
		//角色标识
		int roleId = uaf.getRoleId();
		
		userMgr.delUserRole(userId, roleId);
		
		return mapping.findForward("pub_del_success");
	}
	
	public ActionForward delUser(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		UserActionForm uaf = (UserActionForm)form;
		userMgr.delUser(uaf.getId());
		
		return mapping.findForward("pub_del_success");
	}
	
	//打开界面	
	public ActionForward bindingInput(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UserActionForm uaf = (UserActionForm)form;
		
		request.setAttribute("userId", uaf.getId());
		
		return mapping.findForward("binding_input");
	}
	
	public ActionForward binding(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		UserActionForm uaf = (UserActionForm)form;
		
		User user = userMgr.findUser(uaf.getId());
		
		MailUser mailUser = new MailUser();
		mailUser.setAddress(uaf.getAddress());
		mailUser.setPassword(uaf.getAddrPassword());
		
		user.setMailUser(mailUser);
		
		userMgr.updateUser(user, user.getPerson().getId());
		
		return mapping.findForward("pub_update_success");
	}
	
	public void setPersonMgr(PersonManager personMgr) {
		this.personMgr = personMgr;
	}
	
	public void setUserMgr(UserManager userMgr) {
		this.userMgr = userMgr;
	}
	
	public void setRoleMgr(RoleManager roleMgr) {
		this.roleMgr = roleMgr;
	}
}
