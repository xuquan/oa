package cn.edu.zhku.oa.web.forms;

import java.util.Date;

import org.apache.struts.action.ActionForm;

public class UserActionForm extends ActionForm {

	private static final long serialVersionUID = 1L;
	
	private int id;
	
	private String username;
	
	private String password;
	
	private String oldPassword;
	
	private Date createTime;
	
	private Date expireTime;
	
	private int personId;
	
	//此字段用于给用户分配角色时：角色标识
	private int roleId;
	
	//此字段用户给用户分配角色时：优先级
	private int orderNo;
	
	private String address;
	
	private String addrPassword;
	
	public Date getCreateTime() {
		return createTime;
	}

	public Date getExpireTime() {
		return expireTime;
	}

	public int getId() {
		return id;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public String getPassword() {
		return password;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public int getPersonId() {
		return personId;
	}

	public int getRoleId() {
		return roleId;
	}

	public String getUsername() {
		return username;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddrPassword() {
		return addrPassword;
	}

	public void setAddrPassword(String addrPassword) {
		this.addrPassword = addrPassword;
	}
}
