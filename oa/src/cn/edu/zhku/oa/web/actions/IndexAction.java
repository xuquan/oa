package cn.edu.zhku.oa.web.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cn.edu.zhku.oa.manager.AclManager;
import cn.edu.zhku.oa.model.User;

public class IndexAction extends BaseAction {
	
	private AclManager aclManager;
	
	//打开outlook界面
	public ActionForward outlook(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//获取当前登录用户的所有授权
		User user = (User)request.getSession().getAttribute("login");
		List modules = aclManager.searchModules(user.getId());
		
		request.setAttribute("modules", modules);
		
		return mapping.findForward("left");
	}
	
	//打开main界面
	public ActionForward main(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

		return mapping.findForward("main");
	}

	public void setAclManager(AclManager aclManager) {
		this.aclManager = aclManager;
	}
}
