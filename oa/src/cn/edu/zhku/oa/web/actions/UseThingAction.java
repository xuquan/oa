package cn.edu.zhku.oa.web.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import cn.edu.zhku.oa.manager.CategoryManager;
import cn.edu.zhku.oa.manager.UseThingManager;
import cn.edu.zhku.oa.model.Category;
import cn.edu.zhku.oa.model.UseThing;
import cn.edu.zhku.oa.web.forms.UseThingActionForm;

public class UseThingAction extends DispatchAction {
	
	private UseThingManager useThingManager;
	private CategoryManager categoryManager;

	public void setUseThingManager(UseThingManager useThingManager) {
		this.useThingManager = useThingManager;
	}

	public void setCategoryManager(CategoryManager categoryManager) {
		this.categoryManager = categoryManager;
	}

	@Override
	protected ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		request.setAttribute("pm",useThingManager.findUseThings());
		
		return mapping.findForward("index");
	}
	
	//打开添加界面	
	public ActionForward addInput(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		List<Category> categoryList = categoryManager.findCategorys();
		
		request.setAttribute("categoryList", categoryList);
		
		return mapping.findForward("add_input");
	}
	
	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		UseThingActionForm uaf = (UseThingActionForm)form;
		
		UseThing useThing = new UseThing();
		
		BeanUtils.copyProperties(useThing, uaf);
		
		useThingManager.addUseThing(useThing,uaf.getCategoryId());
		
		return mapping.findForward("pub_add_success");
	}
	
	//打开更新界面	
	public ActionForward updateInput(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		UseThingActionForm uaf = (UseThingActionForm)form;
		
		request.setAttribute("useThing", useThingManager.findUseThing(uaf.getId()));
		
		List<Category> categoryList = categoryManager.findCategorys();
		
		request.setAttribute("categoryList", categoryList);
		
		return mapping.findForward("update_input");
	}
	
	public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		UseThingActionForm uaf = (UseThingActionForm)form;
		
		UseThing useThing = useThingManager.findUseThing(uaf.getId());
		
		BeanUtils.copyProperties(useThing, uaf);
		
		useThingManager.updateUseThing(useThing,uaf.getCategoryId());
		
		return mapping.findForward("pub_update_success");
	}
	
	public ActionForward del(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		UseThingActionForm uaf = (UseThingActionForm)form;
		
		useThingManager.delUseThing(uaf.getId());
		
		return mapping.findForward("pub_del_success");
	}
	
}
