package cn.edu.zhku.oa.model;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

	private static SessionFactory factory;

	private HibernateUtils() {

	}

	static {
		try {
			// 默认读取hibernate.cfg.xml文件
			Configuration cfg = new Configuration().configure();
			//建立SessionFactory
			factory = cfg.buildSessionFactory();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	//取得SessionFactory
	public static SessionFactory getSessionFactory() {
		return factory;
	}

	//取得Session
	public static Session getSession() {
		return factory.openSession();
	}

	//关闭session
	public static void closeSession(Session session) {
		if (session != null) {
			if (session.isOpen()) {
				session.close();
			}
		}
	}
}
