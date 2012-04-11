package cn.edu.zhku.oa.dao.impl;

import java.util.List;
import java.util.Map;

import cn.edu.zhku.oa.dao.AclDao;
import cn.edu.zhku.oa.model.ACL;

public class AclDaoImpl extends AbstractDao implements AclDao {

	//授权过程
	@Override
	public void addPermission(ACL acl) {
		this.getHibernateTemplate().save(acl);
	}
	
	@Override
	public void updatePermission(ACL acl) {
		this.getHibernateTemplate().update(acl);
	}

	//删除授权
	@Override
	public void delPermission(ACL acl) {
		this.getHibernateTemplate().delete(acl);
	}

	@Override
	public List searchAclRecord(String principalType, int principalSn) {
		String sql = "select resourceSn,aclState&1,aclState&2,"+
				"aclState&4,aclState&8,aclTriState " + 
				"from T_ACL where principalType = '"+principalType +
				"' and principalSn = "+principalSn;
		
		return this.getSession().createSQLQuery(sql).list();
	}

	//搜索某个用户拥有读取权限的模块列表（用于登录，形成导航菜单的时候）
	@Override
	public List searchModules(Map temp){
		
		//现在已获得用户拥有读取权限的授权
		String searchModules = "select m from Module m where m.id in (:ids)";
		return getSession().createQuery(searchModules)
				.setParameterList("ids", temp.keySet())
				.list();
	}
	
	//根据主体类型、主体标识和资源标识查找ACL实例
	@Override
	public ACL findACL(String principalType, int principalSn, int resourceSn) {
		return (ACL)getSession().createQuery(
				"select acl from ACL acl where acl.principalType=?"+
				"and acl.principalSn=? and acl.resourceSn=?")
				.setParameter(0, principalType)
				.setParameter(1, principalSn)
				.setParameter(2, resourceSn)
				.uniqueResult();
	}

	//根据用户查找直接授予用户的授权列表（注意：如果直接授予用户的授权是继承的话，则不应该包含在这个列表中），返回的列表元素是：ACL实例
	@Override
	public List findUserACLs(int userId) {
		String hql = "select acl from ACL acl where acl.principalType = ? " +
			"and acl.principalSn = ? and acl.aclTriState = 0";		
		return getHibernateTemplate().find(hql, new Object[]{ACL.TYPE_USER,userId});
	}

	//根据角色查找角色的授权列表，返回列表的元素是：ACL实例
	@Override
	public List findRoleACLs(Integer userId) {
		String hql = "select acl from ACL acl where acl.principalType = ? "+
				"and acl.principalSn= ? ";
		return this.getHibernateTemplate().find(hql, new Object[]{ACL.TYPE_ROLE,userId});
	}

	@Override
	public List findACLById(int userId) {
		
		//按优先级从低到高查找用户拥有的角色
		String hql = "select r.id from UsersRoles ur join ur.role r join ur.user u " + 
					 "where u.id = ? order by ur.orderNo desc";
		List aclIds = this.getHibernateTemplate().find(hql,userId);
		return aclIds;
	}

	@Override
	public int findResourceSn(String resourceSn) {
		String hql = "select m.id from Module m where m.sn=? ";
		return (Integer)getSession().createQuery(hql).setParameter(0, resourceSn).uniqueResult();
	}

}
