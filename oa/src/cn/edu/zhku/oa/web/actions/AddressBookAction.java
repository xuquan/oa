package cn.edu.zhku.oa.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import cn.edu.zhku.oa.manager.AddressBookManager;
import cn.edu.zhku.oa.model.AddressBook;
import cn.edu.zhku.oa.model.User;
import cn.edu.zhku.oa.web.forms.AddressBookActionForm;

public class AddressBookAction extends DispatchAction {
	private AddressBookManager addressBookManager;
	//首页，显示通信录列表
	@Override
	protected ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		User user = (User) request.getSession().getAttribute("login");
		
		request.setAttribute("pm",addressBookManager.findAddressBooks(user.getId()));
		
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
		
		AddressBookActionForm abaf = (AddressBookActionForm)form;
		
		AddressBook addressBook = new AddressBook();
		
		BeanUtils.copyProperties(addressBook, abaf);
		
		addressBookManager.addAddressBook(addressBook, abaf.getUserId());
		
		return mapping.findForward("pub_add_success");
	}
	
	//打开更新界面	
	public ActionForward updateInput(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		AddressBookActionForm abaf = (AddressBookActionForm)form;
		
		request.setAttribute("addressBook", addressBookManager.findAddressBookById(abaf.getId()));
		
		return mapping.findForward("update_input");
	}
	
	public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		AddressBookActionForm abaf = (AddressBookActionForm)form;
		
		AddressBook addressBook = new AddressBook();
		
		BeanUtils.copyProperties(addressBook, abaf);
		
		addressBookManager.updateAddressBook(addressBook, abaf.getUserId());
		
		return mapping.findForward("pub_update_success");
	}
	
	public ActionForward del(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		AddressBookActionForm abaf = (AddressBookActionForm)form;
		
		addressBookManager.delAddressBook(abaf.getId());
		
		return mapping.findForward("pub_del_success");
	}
	
	public ActionForward schedule(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		return mapping.findForward("schedule");
	}
	
	public void setAddressBookManager(AddressBookManager addressBookManager) {
		this.addressBookManager = addressBookManager;
	}
}
