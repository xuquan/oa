package cn.edu.zhku.oa.dao;

import java.util.List;
import java.util.Map;

import cn.edu.zhku.oa.model.ACL;

/**
 * 授权接口
 * 编写作者：许权
 * 编写日期：2011-2-15 下午07:04:37
 */
public interface AclDao {
	
	/**
	 * 授权
	 * @param principalType 主体类型
	 * @param principalSn 主体标识
	 * @param resourceSn 资源标识
	 * @param permission 权限：C/R/U/D
	 * @param yes 是否允许，true表示允许；false表示不允许
	 */
	public void addPermission(ACL acl);
	public void updatePermission(ACL acl);
	
	/**
	 * 删除授权
	 * @param acl
	 */
	public void delPermission(ACL acl);
	
	/**
	 * 搜索某个用户拥有读取权限的模块列表（用于登录，形成导航菜单的时候）
	 * @return 模块列表（即列表的元素是Module对象）
	 */
	public List searchModules(Map map);
	
	/**
	 * 根据主体类型和主体标识查找ACL记录
	 * @param principalType
	 * @param principalSn
	 * @return
	 */
	public List searchAclRecord(String principalType,int principalSn);
	
	/**
	 * 查找授权
	 * @param principalType
	 * @param principalSn
	 * @param resourceSn
	 * @return
	 */
	public ACL findACL(String principalType, int principalSn, int resourceSn);
	
	/**
	 * 通过用户Id查找用户授权
	 * @param userId
	 * @return
	 */
	public List findACLById(int userId);
	
	/**
	 * 查找资源标识
	 * @param resourceSn
	 * @return
	 */
	public int findResourceSn(String resourceSn);
	
	public List findUserACLs(int userId);
	
	public List findRoleACLs(Integer userId);
}
