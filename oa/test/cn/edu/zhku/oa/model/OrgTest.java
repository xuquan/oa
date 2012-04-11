package cn.edu.zhku.oa.model;

import junit.framework.TestCase;

import org.hibernate.HibernateException;
import org.hibernate.Session;

public class OrgTest extends TestCase {

	public void testSaveOrg1() {
		Session session = HibernateUtils.getSession();
		try {
			session.beginTransaction();

			Organization org1 = new Organization();
			org1.setName("org1");
			session.save(org1);

			Organization org2 = new Organization();
			org2.setName("org2");
			org2.setParent(org1);
			session.save(org2);

			Organization org3 = new Organization();
			org3.setName("org3");
			org3.setParent(org1);
			session.save(org3);

			Organization org4 = new Organization();
			org4.setName("org4");
			org4.setParent(org1);
			session.save(org4);

			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			HibernateUtils.closeSession(session);
		}
	}

	public void testLoadOrg() {
		Session session = HibernateUtils.getSession();
		try {
			session.beginTransaction();

			Organization org2 = (Organization) session.load(Organization.class,
					new Integer(2));
			System.out.println(org2.getName() + ","
					+ org2.getParent().getName());
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			HibernateUtils.closeSession(session);
		}
	}
}
