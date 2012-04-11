package cn.edu.zhku.oa.web;

import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.commons.beanutils.ConvertUtils;

public class UtilDateConverterInitServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
		ConvertUtils.register(new UtilDateConverter(), Date.class);
	}

}
