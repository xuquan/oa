package cn.edu.zhku.oa.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import cn.edu.zhku.oa.manager.CarManager;
import cn.edu.zhku.oa.model.Car;
import cn.edu.zhku.oa.web.forms.CarActionForm;

public class CarAction extends DispatchAction {
	private CarManager carManager;
	public void setCarManager(CarManager carManager) {
		this.carManager = carManager;
	}

	//首页，显示车辆信息列表
	@Override
	protected ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		request.setAttribute("pm",carManager.findCars());
		
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
		
		CarActionForm caf = (CarActionForm)form;
		
		Car car = new Car();
		
		BeanUtils.copyProperties(car, caf);
		
		carManager.addCar(car);
		
		return mapping.findForward("pub_add_success");
	}
	
	//打开更新界面	
	public ActionForward updateInput(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		CarActionForm caf = (CarActionForm)form;
		
		request.setAttribute("car", carManager.findCarById(caf.getId()));
		
		return mapping.findForward("update_input");
	}
	
	public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		CarActionForm caf = (CarActionForm)form;
		
		Car car = new Car();
		
		BeanUtils.copyProperties(car, caf);
		
		carManager.updateCar(car);
		
		return mapping.findForward("pub_update_success");
	}
	
	public ActionForward del(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		CarActionForm caf = (CarActionForm)form;
		
		carManager.delCar(caf.getId());
		
		return mapping.findForward("pub_del_success");
	}
	
	public ActionForward borrowingList(ActionMapping mapping, ActionForm form,HttpServletRequest request,
			HttpServletResponse response)throws Exception {
		
		request.setAttribute("pm", carManager.findCar(false));
		
		return mapping.findForward("car_borrowingList");
	}
	
	public ActionForward borrow(ActionMapping mapping, ActionForm form,HttpServletRequest request,
			HttpServletResponse response)throws Exception {
		
		CarActionForm caf = (CarActionForm)form;
		
		carManager.borrowCar(caf.getId(), caf.getUserId());
		
		request.setAttribute("pm", carManager.findCar(caf.getUserId()));
		
		return mapping.findForward("car_borrowedList");
	}
	
	public ActionForward borrowedList(ActionMapping mapping, ActionForm form,HttpServletRequest request,
			HttpServletResponse response)throws Exception {
		
		CarActionForm caf = (CarActionForm)form;
		
		request.setAttribute("pm", carManager.findCar(caf.getUserId()));
		
		return mapping.findForward("car_borrowedList");
	}
	
	public ActionForward returnCar(ActionMapping mapping, ActionForm form,HttpServletRequest request,
			HttpServletResponse response)throws Exception {
		
		CarActionForm caf = (CarActionForm)form;
		
		carManager.returnCar(caf.getId());
		
		request.setAttribute("pm",carManager.findCars());
		
		return mapping.findForward("index");
	}
	
}
