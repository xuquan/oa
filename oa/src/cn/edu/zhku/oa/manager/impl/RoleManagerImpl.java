package cn.edu.zhku.oa.manager.impl;

import cn.edu.zhku.oa.PagerModel;
import cn.edu.zhku.oa.dao.RoleDao;
import cn.edu.zhku.oa.manager.RoleManager;
import cn.edu.zhku.oa.model.Role;

public class RoleManagerImpl implements RoleManager {
	
	private RoleDao roleDao;
	@Override
	public void addRole(Role role) {
		roleDao.addRole(role);
	}

	@Override
	public void delRole(int roleId) {
		roleDao.delRole(roleId);
	}

	@Override
	public Role findRole(int roleId) {
		return roleDao.findRole(roleId);
	}

	@Override
	public PagerModel searchRoles() {
		return roleDao.searchRoles();
	}

	@Override
	public void updateRole(Role role) {
		roleDao.updateRole(role);
	}

	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

}
