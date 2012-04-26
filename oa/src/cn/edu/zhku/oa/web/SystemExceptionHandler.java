package cn.edu.zhku.oa.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ExceptionHandler;
import org.apache.struts.config.ExceptionConfig;


public class SystemExceptionHandler extends ExceptionHandler {

	private static Log logger = LogFactory.getLog(SystemExceptionHandler.class);
	
	/**
	 * 自己处理SystemException异常
	 */
	@Override
	public ActionForward execute(
			Exception ex, 
			ExceptionConfig ae,
			ActionMapping mapping, 
			ActionForm formInstance,
			HttpServletRequest request, 
			HttpServletResponse response)throws ServletException {
		
		ActionForward forward = null;
		if(ae.getPath() != null){
			forward = new ActionForward(ae.getPath());
		}else{
			forward = mapping.getInputForward();
		}
		
		logger.debug("出现异常",ex);
		//ex.printStackTrace();
		
		if(ex instanceof SystemException){
			SystemException se = (SystemException)ex;
			
			//1、取出key值
			String key = se.getKey();
			
			//2、根本key创建异常消息
			ActionMessage error = null;
			if(key == null){
				error = new ActionMessage(ae.getKey(),se.getMessage());
			}else{
				if(se.getValues() != null){
					error = new ActionMessage(key,se.getValues());
				}else{
					error = new ActionMessage(key);
				}
			}
			
			//3、将异常消息放到request对象里
			this.storeException(request, key, error, forward, ae.getScope());
			
			return forward;
		}
		
		//父类处理异常
		return super.execute(ex, ae, mapping, formInstance, request, response);
	}

}
