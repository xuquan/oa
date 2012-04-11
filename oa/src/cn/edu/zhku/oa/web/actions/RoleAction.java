package cn.edu.zhku.oa.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import cn.edu.zhku.oa.manager.RoleManager;
import cn.edu.zhku.oa.model.Role;
import cn.edu.zhku.oa.web.forms.RoleActionForm;

public class RoleAction extends DispatchAction {

	private RoleManager roleMgr;

	public void setRoleMgr(RoleManager roleMgr) {
		this.roleMgr = roleMgr;
	}

	@Override
	protected ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setAttribute("pm", roleMgr.searchRoles());
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
		//从页面表单接收数据
		RoleActionForm raf = (RoleActionForm)form;
		
		Role role = new Role();
		
		BeanUtils.copyProperties(role, raf);
		
		roleMgr.addRole(role);
		
		return mapping.findForward("pub_add_success");
	}
	
	public ActionForward del(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//从页面表单接收数据
		RoleActionForm raf = (RoleActionForm)form;
		
		roleMgr.delRole(raf.getId());
		
		return mapping.findForward("pub_del_success");
	}
	
	public ActionForward updateInput(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		RoleActionForm raf = (RoleActionForm)form;
		Role role = roleMgr.findRole(raf.getId());
		request.setAttribute("role", role);
		return mapping.findForward("update_input");
	}
	
	public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//从页面表单接收数据
		RoleActionForm raf = (RoleActionForm)form;
		
		Role role = new Role();
		
		BeanUtils.copyProperties(role, raf);
		
		roleMgr.updateRole(role);
		
		return mapping.findForward("pub_update_success");
	}
}
