package cn.edu.zhku.oa.dao;

import cn.edu.zhku.oa.PagerModel;
import cn.edu.zhku.oa.model.Role;

/**
 * 角色持久化接口
 * 编写作者：许权
 * 编写日期：2011-2-15 下午03:32:18
 */
public interface RoleDao {
	
	/**
	 * 添加角色
	 * @param role
	 */
	public void addRole(Role role);
	
	/**
	 * 删除角色
	 * @param roleId
	 */
	public void delRole(int roleId);
	
	/**
	 * 更新角色
	 * @param roleId
	 */
	public void updateRole(Role role);
	
	/**
	 * 查找角色
	 * @param roleId
	 */
	public Role findRole(int roleId);
	
	/**
	 * 分页查询角色的信息
	 * @return
	 */
	public PagerModel searchRoles();
}
