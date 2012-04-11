package cn.edu.zhku.oa.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import cn.edu.zhku.oa.model.User;

public class BaseAction extends DispatchAction {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		//添加权限判断的代码
		User user = (User)request.getSession().getAttribute("login");
		if(user == null){
			return mapping.findForward("login");
		}
		
		//继续父类的职责，即将请求分发到不同的方法中！
		return super.execute(mapping, form, request, response);
	}
	
	protected User currentUser(HttpServletRequest request){
		return (User)request.getSession().getAttribute("login");
	}
	
}
