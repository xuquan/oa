package cn.edu.zhku.oa.web;

import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class OrgTreeFunction {
	private static Configuration cfg = FreemarkerUtil.getConfiguration();
	public static String tree(List orgs){
		try {
			Template template = cfg.getTemplate("tree.ftl");
			Writer out = new StringWriter();
			Map rootMap = new HashMap();
			rootMap.put("orgs", orgs);
			template.process(rootMap, out);
			return out.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
