package cn.edu.zhku.oa.web.actions;

import java.io.ByteArrayInputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.dom4j.io.SAXReader;

import cn.edu.zhku.oa.manager.WorkflowManager;
import cn.edu.zhku.oa.model.DWZResponser;
import cn.edu.zhku.oa.model.Workflow;
import cn.edu.zhku.oa.web.common.DWZConstants;
import cn.edu.zhku.oa.web.common.util.DWZResponseFactory;
import cn.edu.zhku.oa.web.forms.WorkflowActionForm;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class WorkflowAction extends BaseAction {
	
	private WorkflowManager workflowManager;

	/**
	 * 打开流程管理主界面，列出当前所有的流程
	 */
	@Override
	protected ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setAttribute("workflows", workflowManager.searchAllWorkflows());
		return mapping.findForward("index");
	}
	
	/**
	 * 打开流程发布页面
	 */
	public ActionForward addInput(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("add_input");
	}
	
	//添加流程定义
	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		WorkflowActionForm waf = (WorkflowActionForm)form;
		
		//做一些判断，判断上传的文件是否为空，决定是否抛出异常，等等！！
		
		//部署流程
		if(waf.getProcessDefinition()!=null && waf.getProcessImage()!=null){
			workflowManager.addOrUpdateWorkflow(waf.getProcessDefinition().getFileData(), waf.getProcessImage().getFileData());
		}
		
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		
		DWZResponser dwzResponser = DWZResponseFactory.create();
		dwzResponser.setStatusCode(DWZConstants.SUCCESS_CODE);
		dwzResponser.setMessage(DWZConstants.SUCCESS_OPERATE);
		dwzResponser.setCallbackType(DWZConstants.CALLBACK_CLOSE_CURRENT);
		dwzResponser.setForwardUrl("workflow.do");
		
		String json = gson.toJson(dwzResponser);
		response.getWriter().write(json);
		response.getWriter().flush();
		return null;
	}
	
	//删除流程定义
	public ActionForward del(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		WorkflowActionForm waf = (WorkflowActionForm)form;
		
		workflowManager.delWorkflow(waf.getId());
		
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		
		DWZResponser dwzResponser = DWZResponseFactory.create();
		dwzResponser.setStatusCode(DWZConstants.SUCCESS_CODE);
		dwzResponser.setMessage(DWZConstants.SUCCESS_OPERATE);
		dwzResponser.setCallbackType(DWZConstants.CALLBACK_CLOSE_CURRENT);
		dwzResponser.setForwardUrl("workflow.do");
		
		String json = gson.toJson(dwzResponser);
		response.getWriter().write(json);
		response.getWriter().flush();
		return null;
	}
	
	//打开查看流程图片的界面
	public ActionForward openViewImage(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)
			throws Exception{
		return mapping.findForward("flow_image");
	}
	
	//查看图片（此请求由flow_image.jsp中的<img src="workflow.do?method=viewImage">发起的请求）
	public ActionForward viewImage(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)
			throws Exception{
		WorkflowActionForm waf = (WorkflowActionForm)form;
		Workflow wf = workflowManager.findWorkflow(waf.getId());
		response.setContentType("image/jpeg");
		response.getOutputStream().write(wf.getProcessImage());
		return null;
	}
	
	//查看流程定义文件的内容
	public ActionForward viewFlowDef(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)
			throws Exception{
		WorkflowActionForm waf = (WorkflowActionForm)form;
		Workflow wf = workflowManager.findWorkflow(waf.getId());
		byte[] defs = wf.getProcessDefinition();
		
		//将byte[]转换为字符串
		//String defString = new String(defs,"UTF-8");
		
		//为了避免硬编码encoding，可以利用dom4j工具来帮助我们转换xml文件
		String defString = new SAXReader().read(
			new ByteArrayInputStream(defs)
		).asXML();
		request.setAttribute("def", defString);
		return mapping.findForward("flow_def");
	}
	public void setWorkflowManager(WorkflowManager workflowManager) {
		this.workflowManager = workflowManager;
	}
}
