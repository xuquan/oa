package cn.edu.zhku.oa.dao.impl;

import java.util.List;

import cn.edu.zhku.oa.dao.UserDao;
import cn.edu.zhku.oa.model.User;
import cn.edu.zhku.oa.model.UsersRoles;

public class UserDaoImpl extends AbstractDao implements UserDao {

	@Override
	public void addUserRole(UsersRoles ur) {
			this.getHibernateTemplate().save(ur);
	}
	
	public void updateUserRole(UsersRoles ur){
		this.getHibernateTemplate().update(ur);
	}

	@Override
	public void addUser(User user) {
		this.getHibernateTemplate().save(user);
	}

	@Override
	public void delUser(int userId) {
		this.getHibernateTemplate().delete(this.getHibernateTemplate().load(User.class, userId));
	}

	@Override
	public void delUserRole(int userId, int roleId) {
		this.getHibernateTemplate().delete(this.findUsersRoles(userId, roleId));
	}

	@Override
	public User findUser(int userId) {
		return (User)this.getHibernateTemplate().load(User.class, userId);
	}

	@Override
	public List searchUserRoles(int userId) {
		return this.getHibernateTemplate().find("select ur from UsersRoles ur where ur.user.id=?",userId);
	}

	@Override
	public void updateUser(User user) {
		this.getHibernateTemplate().merge(user);
	}
	
	public UsersRoles findUsersRoles(int userId,int roleId){
		return (UsersRoles)getSession().createQuery(
				"select ur from UsersRoles ur where ur.role.id=? and ur.user.id=?")
				.setParameter(0, roleId)
				.setParameter(1, userId)
				.uniqueResult();
	}

	@Override
	public User findUserByName(String username) {
		/**
		 * 因为设置了User的auto-import="false"，所以，在这里使用
		 * HQL查询的时候，必须使用全路径的类名
		 */
		return (User)getSession().createQuery(
				"select u from cn.edu.zhku.oa.model.User u where u.username=?")
				.setParameter(0, username)
				.uniqueResult();
	}

}
