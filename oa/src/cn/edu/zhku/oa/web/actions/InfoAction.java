package cn.edu.zhku.oa.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import cn.edu.zhku.oa.manager.InfoManager;
import cn.edu.zhku.oa.model.DWZResponser;
import cn.edu.zhku.oa.model.Info;
import cn.edu.zhku.oa.web.common.DWZConstants;
import cn.edu.zhku.oa.web.common.util.DWZResopnseFactory;
import cn.edu.zhku.oa.web.forms.InfoActionForm;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class InfoAction extends DispatchAction {
	
	private InfoManager infoManager;
	
	public void setInfoManager(InfoManager infoManager) {
		this.infoManager = infoManager;
	}

	//首页，显示最新信息列表
	@Override
	protected ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		request.setAttribute("pm",infoManager.findInfos());
		
		return mapping.findForward("index");
	}
	
	/**
	 * 打开添加界面	
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
	
	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		InfoActionForm iaf = (InfoActionForm)form;
		
		Info info = new Info();
		
		BeanUtils.copyProperties(info, iaf);
		
		infoManager.addInfo(info,iaf.getUserId());
		
		return mapping.findForward("pub_add_success");
	}
	
	/**
	 * 打开更新界面
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
		
		InfoActionForm iaf = (InfoActionForm)form;
		
		request.setAttribute("info", infoManager.findInfoById(iaf.getId()));
		
		return mapping.findForward("update_input");
	}
	
	/**
	 * 更新公共信息
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		InfoActionForm iaf = (InfoActionForm)form;
		
		Info info = infoManager.findInfoById(iaf.getId());
		
		BeanUtils.copyProperties(info, iaf);
		
		infoManager.updateInfo(info);
		
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		
		DWZResponser dwzResponser = DWZResopnseFactory.create();
		
		dwzResponser.setMessage(DWZConstants.SUCCESS_OPERATE);
		dwzResponser.setStatusCode(DWZConstants.SUCCESS_CODE);
		dwzResponser.setCallbackType(DWZConstants.CALLBACK_CLOSE_CURRENT);
		dwzResponser.setForwardUrl("info.do");
		
		String ret = gson.toJson(dwzResponser);
		response.getWriter().write(ret);
		response.getWriter().flush();
		return null;
	}
	
	/**
	 * 删除公共信息
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
		
		InfoActionForm iaf = (InfoActionForm)form;
		
		infoManager.delInfo(iaf.getId());
		
		return mapping.findForward("pub_del_success");
	}
	
	public ActionForward show(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		InfoActionForm iaf = (InfoActionForm)form;
		
		Info info = infoManager.findInfoById(iaf.getId());
		
		request.setAttribute("info", info);
		
		return mapping.findForward("show_info");
	}
}
