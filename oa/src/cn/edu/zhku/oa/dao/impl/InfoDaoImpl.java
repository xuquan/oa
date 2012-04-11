package cn.edu.zhku.oa.dao.impl;

import java.util.Date;

import cn.edu.zhku.oa.PagerModel;
import cn.edu.zhku.oa.dao.InfoDao;
import cn.edu.zhku.oa.model.Info;

public class InfoDaoImpl extends AbstractDao implements InfoDao {

	@Override
	public void addInfo(Info info) {
		getHibernateTemplate().save(info);
	}

	@Override
	public void delInfo(int infoId) {
		getHibernateTemplate().delete(getHibernateTemplate().load(Info.class, infoId));
	}

	@Override
	public PagerModel findInfo(int userId) {
		return searchPaginated("from Info i where i.user.id=? order by i.time desc", userId);
	}

	@Override
	public PagerModel findInfo(Date time) {
		return searchPaginated("from Info i where i.time > ? order by i.time desc", time);
	}

	@Override
	public Info findInfoById(int infoId) {
		return (Info) getSession().createQuery("select i from Info i where i.id=?")
							.setParameter(0, infoId)
							.uniqueResult();
	}

	@Override
	public PagerModel findInfos() {
		return searchPaginated("from Info");
	}

	@Override
	public void updateInfo(Info info) {
		getHibernateTemplate().update(info);
	}

}
