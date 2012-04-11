package cn.edu.zhku.oa.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import cn.edu.zhku.oa.manager.ModuleManager;
import cn.edu.zhku.oa.model.Module;
import cn.edu.zhku.oa.web.forms.ModuleActionForm;

public class ModuleAction extends DispatchAction {

	private ModuleManager moduleMgr;

	public void setModuleMgr(ModuleManager moduleMgr) {
		this.moduleMgr = moduleMgr;
	}

	/**
	 * 打开模块管理主界面
	 */
	@Override
	protected ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ModuleActionForm maf = (ModuleActionForm) form;

		request.setAttribute("pm", moduleMgr.searchModules(maf.getParentId()));

		return mapping.findForward("index");
	}

	// 打开模块管理录入界面
	public ActionForward addInput(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		return mapping.findForward("add_input");
	}

	// 添加模块信息
	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ModuleActionForm maf = (ModuleActionForm) form;

		Module module = new Module();

		BeanUtils.copyProperties(module, maf);

		moduleMgr.addModule(module, maf.getParentId());

		return mapping.findForward("pub_add_success");
	}

	//删除模块信息
	public ActionForward del(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		ModuleActionForm maf = (ModuleActionForm)form;
		
		moduleMgr.delModule(maf.getId());
		
		return mapping.findForward("pub_del_success");
	}
	
	//打开更新模块信息界面
	public ActionForward updateInput(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		ModuleActionForm maf = (ModuleActionForm) form;
		
		request.setAttribute("module", moduleMgr.findModule(maf.getId()));
		
		return mapping.findForward("update_input");
	}
	
	//更新模块信息
	public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ModuleActionForm maf = (ModuleActionForm) form;

		Module module = new Module();

		BeanUtils.copyProperties(module, maf);

		moduleMgr.updateModule(module, maf.getParentId());

		return mapping.findForward("pub_update_success");
	}
}
