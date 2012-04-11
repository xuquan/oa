package cn.edu.zhku.oa.manager;

import junit.framework.TestCase;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.edu.zhku.oa.manager.InitSystemDatas;

public class InitSystemDatasTest extends TestCase {
	
	private static BeanFactory factory = new ClassPathXmlApplicationContext("beans.xml");
	
	public void testAddOrUpdateInitDatas(){
		InitSystemDatas init = (InitSystemDatas)factory.getBean("initSystemDatas");
		init.addOrUpdateInitDatas("init_datas.xml");
	}
}
