package cn.edu.zhku.oa.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import cn.edu.zhku.oa.manager.CategoryManager;
import cn.edu.zhku.oa.model.Category;
import cn.edu.zhku.oa.web.forms.CategoryActionForm;

public class CategoryAction extends DispatchAction {
	
	private CategoryManager categoryManager;
	
	public void setCategoryManager(CategoryManager categoryManager) {
		this.categoryManager = categoryManager;
	}

	@Override
	protected ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		request.setAttribute("pm",categoryManager.findCategory());
		
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
		
		CategoryActionForm caf = (CategoryActionForm)form;
		
		Category category = new Category();
		
		BeanUtils.copyProperties(category, caf);
		
		categoryManager.addCategory(category);
		
		return mapping.findForward("pub_add_success");
	}
	
	//打开更新界面	
	public ActionForward updateInput(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		CategoryActionForm caf = (CategoryActionForm)form;
		
		request.setAttribute("category", categoryManager.findCategory(caf.getId()));
		
		return mapping.findForward("update_input");
	}
	
	public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		CategoryActionForm caf = (CategoryActionForm)form;
		
		Category category = categoryManager.findCategory(caf.getId());
		
		BeanUtils.copyProperties(category, caf);
		
		categoryManager.updateCategory(category);
		
		return mapping.findForward("pub_update_success");
	}
	
	public ActionForward del(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		CategoryActionForm caf = (CategoryActionForm)form;
		
		categoryManager.delCategory(caf.getId());
		
		return mapping.findForward("pub_del_success");
	}
	
}
