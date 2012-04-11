package cn.edu.zhku.oa.dao.impl;

import cn.edu.zhku.oa.PagerModel;
import cn.edu.zhku.oa.dao.OrgDao;
import cn.edu.zhku.oa.model.Organization;

public class OrgDaoImpl extends AbstractDao implements OrgDao {

	@Override
	public void addOrg(Organization org) {
		getHibernateTemplate().save(org);
	}

	@Override
	public void delOrg(Organization org) {
		getHibernateTemplate().delete(org);
	}

	@Override
	public Organization findOrg(int orgId) {
		return (Organization)getHibernateTemplate().load(Organization.class, orgId);
	}

	@Override
	public PagerModel findOrgs() {
		return searchPaginated("from Organization o where o.parent is null");
	}
	@Override
	public PagerModel findOrgs(int parentId) {
		return searchPaginated("from Organization o where o.parent.id=?",parentId);
	}

	@Override
	public void updateOrg(Organization org) {
		getHibernateTemplate().update(org);
	}

}
