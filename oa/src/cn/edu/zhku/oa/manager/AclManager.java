package cn.edu.zhku.oa.manager;

import java.util.List;

public interface AclManager {
	
	/**
	 * 授权
	 * @param principalType 主体类型
	 * @param principalSn 主体标识
	 * @param resourceSn 资源标识
	 * @param permission 权限：C/R/U/D
	 * @param yes 是否允许，true表示允许；false表示不允许
	 */
	public void addOrUpdatePermission(
			String principalType,
			int principalSn,
			int resourceSn,
			int permission,
			boolean yes
	);
	
	/**
	 * 删除授权
	 * @param principalType
	 * @param principalSn
	 * @param resourceSn
	 */
	public void delPermission(
			String principalType,
			int principalSn,
			int resourceSn
	);
	
	/**
	 * 添加或更新用户的继承特性
	 * @param userId 用户标识
	 * @param resourceSn 资源标识
	 * @param yes true表示继承,false表示不继承
	 */
	public void addOrUpdateUserExtends(
			int userId,
			int resourceSn,
			boolean yes
	);
	
	/**
	 * 判断用户对某模块的某操作的授权（允许或不允许）
	 * @param userId 用户标识
	 * @param reourceSn 资源标识(id)
	 * @param permission 权限（C/R/U/D）
	 * @return 允许（true）或不允许（false）
	 */
	public boolean hasPermission(int userId,int resouceId,int permission);
	
	/**
	 * 判断用户对某模块的某操作的授权（允许或不允许）
	 * @param userId 用户ID
	 * @param reourceSn 资源唯一标识（sn）
	 * @param permission 权限（C/R/U/D）
	 * @return 允许（true）或不允许（false）
	 */
	public boolean hasPermissionByResourceSn(
			int userId,
			String resourceSn,
			int permission
	);
	
	/**
	 * 搜索某个用户拥有读取权限的模块列表（用于登录，形成导航菜单的时候）
	 * @param userId 用户标识
	 * @return 模块列表（即列表的元素是Module对象）
	 */
	public List searchModules(int userId);
	
	/**
	 * 根据主体类型和主体标识查找ACL记录
	 * @param principalType
	 * @param principalSn
	 * @return
	 */
	public List searchAclRecord(String principalType,int principalSn);
}
