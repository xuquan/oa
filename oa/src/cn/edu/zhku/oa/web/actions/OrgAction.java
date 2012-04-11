package cn.edu.zhku.oa.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import cn.edu.zhku.oa.manager.OrgManager;
import cn.edu.zhku.oa.model.Organization;
import cn.edu.zhku.oa.web.forms.OrgActionForm;

public class OrgAction extends DispatchAction {

	private OrgManager orgManager;
	public void setOrgManager(OrgManager orgManager) {
		this.orgManager = orgManager;
	}

	/**
	 * 打开机构管理主界面
	 */
	@Override
	protected ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		OrgActionForm oaf = (OrgActionForm)form;
		
		//获取机构列表，并传递到界面
		request.setAttribute("pm", orgManager.findOrgs(oaf.getParentId()));
		
		//返回逻辑
		int ppid = 0;
		if(oaf.getParentId() != 0){
			Organization org = orgManager.findOrg(oaf.getParentId());
			Organization parent = org.getParent();
			if(parent != null){
				ppid = parent.getId();
			}
		}
		request.setAttribute("ppid", ppid);
		
		if(oaf.isSelect()){
			return mapping.findForward("select");
		}
		return mapping.findForward("index");
	}
	
	/**
	 * 打开机构管理录入界面
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward addInput(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("add_input");
	}
	
	/**
	 * 添加机构信息
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		OrgActionForm oaf = (OrgActionForm)form;
		
		Organization org = new Organization();
		
		BeanUtils.copyProperties(org, oaf);
		
		orgManager.addOrg(org, oaf.getParentId());
		
		return mapping.findForward("pub_add_success");
	}
	
	/**
	 * 打开机构管理更新界面
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward updateInput(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		OrgActionForm oaf = (OrgActionForm)form;
		Organization org = orgManager.findOrg(oaf.getId());
		
		request.setAttribute("org", org);
		return mapping.findForward("update_input");
	}
	
	public ActionForward update(ActionMapping mapping, ActionForm form,HttpServletRequest request,HttpServletResponse response) 
			throws Exception{
		
		OrgActionForm oaf = (OrgActionForm)form;
		Organization org = new Organization();
		BeanUtils.copyProperties(org, oaf);
		
		orgManager.updateOrg(org, oaf.getParentId());
		
		return mapping.findForward("pub_update_success");
	}
	
	/**
	 * 删除机构信息
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward del(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		OrgActionForm oaf = (OrgActionForm)form;
		
		orgManager.delOrg(oaf.getId());
		
		return mapping.findForward("pub_del_success");
	}
}
