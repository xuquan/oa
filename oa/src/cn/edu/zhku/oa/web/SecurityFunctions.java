package cn.edu.zhku.oa.web;

import cn.edu.zhku.oa.manager.AclManager;

/**
 * JSTL函数，主要功能是可以完成权限的即时认证
 * @author Administrator
 *
 */
public class SecurityFunctions {
	
	private static AclManager aclManager;
	
	public static boolean hasPermission(int userId,String resourceSn,int permission){
		
		return aclManager.hasPermissionByResourceSn(userId, resourceSn, permission);
	}

	//这个方法不能定义为static，因为这将导致spring无法注入
	public void setAclManager(AclManager aclManager) {
		SecurityFunctions.aclManager = aclManager;
	}
}
