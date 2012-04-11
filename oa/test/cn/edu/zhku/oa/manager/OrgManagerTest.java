package cn.edu.zhku.oa.manager;

import junit.framework.TestCase;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.edu.zhku.oa.manager.OrgManager;
import cn.edu.zhku.oa.model.Organization;

public class OrgManagerTest extends TestCase {

	private static BeanFactory factory = new ClassPathXmlApplicationContext("beans.xml");
	public void testAddOrg() {
		OrgManager orgManager = (OrgManager)factory.getBean("orgManager");
		Organization org = new Organization();
		org.setName("机构");
		org.setDescription("仲恺农业工程学院");
		
		orgManager.addOrg(org, 1);
	}

	public void testDelOrg() {
		OrgManager orgManager = (OrgManager)factory.getBean("orgManager");
		orgManager.delOrg(1);
	}

	public void testUpdateOrg() {
		OrgManager orgManager = (OrgManager)factory.getBean("orgManager");
		Organization org = new Organization();
		org.setId(2);
		org.setName("仲恺");
		orgManager.updateOrg(org, 1);
	}

	public void testFindOrg() {
		OrgManager orgManager = (OrgManager)factory.getBean("orgManager");
		Organization org = orgManager.findOrg(1);
		System.out.println("name="+org.getName()+"  desc="+org.getDescription()+"  pid="+org.getParent());
	}

	/*public void testFindOrgs() {
		OrgManager orgManager = (OrgManager)factory.getBean("orgManager");
		List orgs = orgManager.findOrgs(1);
		for(Iterator iter=orgs.iterator(); iter.hasNext();){
			Organization org = (Organization)iter.next();
			System.out.println("name="+org.getName()+"  desc="+org.getDescription()+"  pid="+org.getParent().getId());
		}
	}*/

}
