package cn.edu.zhku.oa.dao.impl;

import cn.edu.zhku.oa.PagerModel;
import cn.edu.zhku.oa.dao.MailDao;
import cn.edu.zhku.oa.model.Mail;

public class MailDaoImpl extends AbstractDao implements MailDao {

	@Override
	public void addMail(Mail mail) {
		this.getHibernateTemplate().save(mail);
	}

	@Override
	public void delMail(int mailId) {
		this.getHibernateTemplate().delete(this.getHibernateTemplate().load(Mail.class, mailId));
	}

	@Override
	public PagerModel findMail(int userId) {
		return searchPaginated("select m from Mail m where m.sender.id=?", userId);
	}

	@Override
	public Mail findMailById(int mailId) {
		return (Mail) this.getHibernateTemplate().load(Mail.class, mailId);
	}

	@Override
	public PagerModel findMails() {
		return searchPaginated("from Mail");
	}

	@Override
	public void updateMail(Mail mail) {
		this.getHibernateTemplate().update(mail);
	}

	

}
