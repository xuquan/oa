package cn.edu.zhku.oa.manager;

import cn.edu.zhku.oa.PagerModel;
import cn.edu.zhku.oa.model.Role;

public interface RoleManager {
	
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
