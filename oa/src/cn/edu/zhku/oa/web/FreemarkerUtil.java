package cn.edu.zhku.oa.web;

import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;

public class FreemarkerUtil {
	private static Configuration cfg = new Configuration();
	static{

		//从什么地方加载freemarker模板文件
		cfg.setTemplateLoader(new ClassTemplateLoader(DynaFormFunction.class,"templates"));
		
		//设置异常处理器
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);
		
	}
	
	public static Configuration getConfiguration(){
		return cfg;
	}
}
