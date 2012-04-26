package cn.edu.zhku.oa.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import cn.edu.zhku.oa.PagerModel;
import cn.edu.zhku.oa.SystemContext;
import cn.edu.zhku.oa.manager.ModuleManager;
import cn.edu.zhku.oa.manager.RoleManager;
import cn.edu.zhku.oa.manager.UserManager;
import cn.edu.zhku.oa.model.ACL;
import cn.edu.zhku.oa.web.SystemException;
import cn.edu.zhku.oa.web.forms.AclActionForm;

public class AclAction extends DispatchAction {

	private RoleManager roleMgr;
	private UserManager userMgr;
	private ModuleManager moduleMgr;
	
	@Override
	protected ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		AclActionForm aaf = (AclActionForm)form;
		
		//如果主体类型是角色
		if(ACL.TYPE_ROLE.equals(aaf.getPrincipalType())){
			request.setAttribute("role",roleMgr.findRole(aaf.getPrincipalSn()));
		}else if(ACL.TYPE_USER.equals(aaf.getPrincipalType())){
			request.setAttribute("user", userMgr.findUser(aaf.getPrincipalSn()));
		}else{
			throw new SystemException("无效的主体类型!");
		}
		
		//获得所有顶级模块列表
		SystemContext.setOffset(0);
		SystemContext.setPagesize(Integer.MAX_VALUE);
		PagerModel pm = moduleMgr.searchModules(0);
		request.setAttribute("modules", pm.getDatas());
		
		return mapping.findForward("index");
	}

	public void setRoleMgr(RoleManager roleMgr) {
		this.roleMgr = roleMgr;
	}

	public void setUserMgr(UserManager userMgr) {
		this.userMgr = userMgr;
	}

	public void setModuleMgr(ModuleManager moduleMgr) {
		this.moduleMgr = moduleMgr;
	}

}
