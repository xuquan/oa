package cn.edu.zhku.oa.manager.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.edu.zhku.oa.dao.AclDao;
import cn.edu.zhku.oa.manager.AclManager;
import cn.edu.zhku.oa.model.ACL;
import cn.edu.zhku.oa.model.Permission;

public class AclManagerImpl implements AclManager {
	
	private AclDao aclDao;

	//授权过程
	@Override
	public void addOrUpdatePermission(String principalType, int principalSn,
			int resourceSn, int permission, boolean yes) {
		//根据主体标识和资源标识查找ACL实例
		ACL acl = aclDao.findACL(principalType,principalSn,resourceSn);
		
		//如果存在ACL实例，则更新其授权
		if(acl != null){
			acl.setPermission(permission, yes);
			aclDao.updatePermission(acl);
			return;
		}
		
		//不存在ACL实例，则创建ACL实例
		acl = new ACL();
		acl.setPrincipalType(principalType);
		acl.setPrincipalSn(principalSn);
		acl.setResourceSn(resourceSn);
		acl.setPermission(permission, yes);
		aclDao.addPermission(acl);
	}

	//设置用户某个资源授权的继承特性
	@Override
	public void addOrUpdateUserExtends(int userId, int resourceSn, boolean yes) {
		//根据主体标识和资源标识查找ACL实例
		ACL acl = aclDao.findACL(ACL.TYPE_USER,userId,resourceSn);
		
		//如果存在ACL实例，则更新其授权
		if(acl != null){
			acl.setExtends(yes);
			aclDao.updatePermission(acl);
			return;
		}
		
		//不存在ACL实例，则创建ACL实例
		acl = new ACL();
		acl.setPrincipalType(ACL.TYPE_USER);
		acl.setPrincipalSn(userId);
		acl.setResourceSn(resourceSn);
		aclDao.addPermission(acl);
	}

	//删除授权
	@Override
	public void delPermission(String principalType, int principalSn,
			int resourceSn) {
		aclDao.delPermission(aclDao.findACL(principalType, principalSn, resourceSn));
	}

	//即时认证
	@Override
	public boolean hasPermission(int userId, int resourceSn, int permission) {
		
		//查找直接授予用户的授权
		ACL acl = aclDao.findACL(ACL.TYPE_USER,userId,resourceSn);
		
		if(acl != null){
			int yesOrNo = acl.getPermission(permission);
			
			//如果是确定的授权
			if(yesOrNo != ACL.ACL_NEUTRAL){
				return yesOrNo == ACL.ACL_YES ? true :false;
			}
		}
		
		//继续查找用户的角色授权
		List aclIds = aclDao.findACLById(userId);
		
		//依照角色优先级依次查找其授权
		for(Iterator iter=aclIds.iterator();iter.hasNext();){
			Integer rid = (Integer)iter.next();
			acl = aclDao.findACL(ACL.TYPE_ROLE,rid,resourceSn);
			
			//一旦发现授权，即可返回结果
			if(acl != null){
				return acl.getPermission(permission) == ACL.ACL_YES ? true : false;
			}
		}
		return false;
	}

	@Override
	public boolean hasPermissionByResourceSn(int userId, String resourceSn,int permission) {
		return hasPermission(userId,aclDao.findResourceSn(resourceSn),permission);
	}

	@Override
	public List searchAclRecord(String principalType, int principalSn) {
		return aclDao.searchAclRecord(principalType, principalSn);
	}

	//搜索某个用户拥有读取权限的模块列表（用于登录，形成导航菜单的时候）
	@Override
	public List searchModules(int userId) {
		
		//定义临时变量
		Map temp = new HashMap();
		
		//按优先级从低到高查找用户拥有的角色
		List aclIds = aclDao.findACLById(userId);
		
		//依次循环角色
		for(Iterator iter=aclIds.iterator();iter.hasNext();){
			Integer rid = (Integer)iter.next();
			
			//根据角色获得角色拥有的授权列表
			//根据角色查找角色的授权列表，返回列表的元素是：ACL实例
			List acls = aclDao.findRoleACLs(userId);
			
			//把授权放入临时变量
			for(Iterator iterator=acls.iterator();iterator.hasNext();){
				ACL acl = (ACL)iterator.next();
				temp.put(acl.getResourceSn(), acl);
			}
		}
		
		//查找直接授予用户的授权列表
		//根据用户查找直接授予用户的授权列表（注意：如果直接授予用户的授权是继承的话，则不应该包含在这个列表中），返回的列表元素是：ACL实例
		List acls = aclDao.findUserACLs(userId);
		for(Iterator iter = acls.iterator();iter.hasNext();){
			ACL acl = (ACL)iter.next();
			temp.put(acl.getResourceSn(), acl);
		}
		
		//现在已获得用户拥有的所有授权（包括直接授予用户自身以及其包含的角色的授权)
		List delResources = new ArrayList();
		Set entries = temp.entrySet();
		for(Iterator iter=entries.iterator();iter.hasNext();){
			Map.Entry entry = (Map.Entry)iter.next();
			ACL acl = (ACL)entry.getValue();
			
			//如果没有读取权限，则需要在临时变量中删除这个授权
			if(acl.getPermission(Permission.READ) == ACL.ACL_NO){
				delResources.add(entry.getKey());
			}
		}
		
		//在临时变量中删除这些需要删除的授权
		for(Iterator iter = delResources.iterator();iter.hasNext();){
			Object key = iter.next();
			temp.remove(key);
		}
		
		//如果授权列表是空的，则返回0长度的集合
		if(temp.isEmpty()){
			return new ArrayList();
		}
		
		//现在已获得用户拥有读取权限的授权
		return aclDao.searchModules(temp);
	}
	
	public void setAclDao(AclDao aclDao) {
		this.aclDao = aclDao;
	}

}
