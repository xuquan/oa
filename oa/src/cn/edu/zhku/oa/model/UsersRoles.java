package cn.edu.zhku.oa.model;

/**
 * 作者：许权
 * @hibernate.class table="t_usersroles"
 */
public class UsersRoles {
	
	/**
	 * @hibernate.id
	 * 		generator-class="native"
	 */
	private int id;
	
	/**
	 * 对应的角色
	 * @hibernate.many-to-one
	 */
	private Role role;
	
	/**
	 * 对应的用户
	 * @hibernate.many-to-one
	 */
	private User user;
	
	/**
	 * 角色在这个用户中的优先级
	 * @hibernate.property
	 */
	private int orderNo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
}
