package cn.edu.zhku.oa.dao.impl;

import cn.edu.zhku.oa.PagerModel;
import cn.edu.zhku.oa.dao.RoleDao;
import cn.edu.zhku.oa.model.Role;

public class RoleDaoImpl extends AbstractDao implements RoleDao {

	@Override
	public void addRole(Role role) {
		this.getHibernateTemplate().save(role);
	}

	@Override
	public void delRole(int roleId) {
		this.getHibernateTemplate().delete(this.getHibernateTemplate().load(Role.class, roleId));
	}

	@Override
	public Role findRole(int roleId) {
		return (Role)this.getHibernateTemplate().load(Role.class, roleId);
	}

	@Override
	public PagerModel searchRoles() {
		return this.searchPaginated("from Role");
	}

	@Override
	public void updateRole(Role role) {
		this.getHibernateTemplate().update(role);
	}

}
