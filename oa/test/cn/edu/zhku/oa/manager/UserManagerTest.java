package cn.edu.zhku.oa.manager;

import junit.framework.TestCase;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.edu.zhku.oa.model.MailUser;
import cn.edu.zhku.oa.model.User;

public class UserManagerTest extends TestCase {
	private static BeanFactory factory = new ClassPathXmlApplicationContext("beans.xml");
	
	public void testAddUser() {
		fail("Not yet implemented");
	}

	public void testUpdateUser() {
		UserManager um = (UserManager) factory.getBean("userMgr");
		User user = um.findUser(1);
		MailUser mu = new MailUser();
		mu.setAddress("780391665@qq.com");
		mu.setPassword("linxiaoling");
		user.setMailUser(mu);
		um.updateUser(user, 1);
	}

	public void testFindUser() {
		UserManager um = (UserManager) factory.getBean("userMgr");
		User user = um.findUser(1);
		System.out.println(user.getUsername()+":"+user.getMailUser().getAddress()+":"+user.getMailUser().getPassword()+":"+user.getMailUser().getUsername());
	}

	public void testFindUserByName() {
		fail("Not yet implemented");
	}

}
