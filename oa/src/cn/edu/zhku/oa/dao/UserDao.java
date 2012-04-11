package cn.edu.zhku.oa.dao;

import java.util.List;

import cn.edu.zhku.oa.model.User;
import cn.edu.zhku.oa.model.UsersRoles;

/**
 * 用户持久化接口
 * 编写作者：许权
 * 编写日期：2011-2-15 下午03:50:04
 */
public interface UserDao {
	
	/**
	 * 添加用户信息
	 * @param user
	 */
	public void addUser(User user);
	
	/**
	 * 更新用户信息
	 * @param user
	 */
	public void updateUser(User user);
	
	/**
	 * 删除用户信息
	 * @param userId
	 */
	public void delUser(int userId);
	
	/**
	 * 查找特定的用户
	 * @param userId
	 * @return
	 */
	public User findUser(int userId);
	
	/**
	 * 根据用户名查找特定用户
	 * @param username
	 * @return
	 */
	public User findUserByName(String username);
	
	/**
	 * 查询用户拥有的所有的角色
	 * @param userId 用户ID
	 * @return UsersRoles对象的集合
	 */
	public List searchUserRoles(int userId);
	
	/**
	 * 添加或更新用户拥有的角色，如果用户[userId]已经拥有角色[roleId]，
	 * 则更新其优先级[orderNo]，否则给用户分配相应的角色，并设置优先级
	 * @param userId
	 * @param roleId
	 * @param orderNo
	 */
	public void addUserRole(UsersRoles ur);
	
	/**
	 * 更新用户关联的角色
	 * @param ur
	 */
	public void updateUserRole(UsersRoles ur);
	
	/**
	 * 删除分配给用户的角色（关联）
	 * @param userId
	 * @param roleId
	 */
	public void delUserRole(int userId,int roleId);
	
	/**
	 * 查找用户关联的角色
	 * @param userId
	 * @param roleId
	 * @return
	 */
	public UsersRoles findUsersRoles(int userId,int roleId);
}
