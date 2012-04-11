package cn.edu.zhku.oa.web;

import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import cn.edu.zhku.oa.manager.FormManager;
import cn.edu.zhku.oa.model.FlowForm;
import freemarker.template.Configuration;
import freemarker.template.Template;

public class DynaFormFunction {
	
	private static FormManager formManager;
	public static void setFormManager(FormManager formManager) {
		DynaFormFunction.formManager = formManager;
	}

	private static Configuration cfg = FreemarkerUtil.getConfiguration();
	
	public static String form(int workflowId){
		try {
			FlowForm form = formManager.findForm(workflowId);
			if(form == null){
				return null;
			}
			
			Template template = cfg.getTemplate(form.getTemplate());
			
			//最终输出的位置
			Writer out = new StringWriter();
			
			Map rootMap = new HashMap();
			rootMap.put("form", form);
			
			template.process(rootMap, out);
			
			return out.toString();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
