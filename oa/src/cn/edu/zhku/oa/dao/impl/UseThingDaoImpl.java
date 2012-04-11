package cn.edu.zhku.oa.dao.impl;

import cn.edu.zhku.oa.PagerModel;
import cn.edu.zhku.oa.dao.UseThingDao;
import cn.edu.zhku.oa.model.Category;
import cn.edu.zhku.oa.model.UseThing;

public class UseThingDaoImpl extends AbstractDao implements UseThingDao {

	@Override
	public void addUseThing(UseThing useThing) {
		getHibernateTemplate().save(useThing);
	}

	@Override
	public void delUseThing(int useThingId) {
		getHibernateTemplate().delete(getHibernateTemplate().load(UseThing.class, useThingId));
	}

	@Override
	public UseThing findUseThing(int useThingId) {
		return (UseThing) getHibernateTemplate().load(UseThing.class, useThingId);
	}

	@Override
	public PagerModel findUseThing(Category category) {
		return searchPaginated("select u from UseThing where u.category=?", category);
	}

	@Override
	public PagerModel findUseThings() {
		return searchPaginated("from UseThing");
	}

	@Override
	public void updateUseThing(UseThing useThing) {
		getHibernateTemplate().update(useThing);
	}

}
