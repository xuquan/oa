package cn.edu.zhku.oa.model;

/**
 * 
 * 作者：许权
 * @hibernate.class lazy="false" table="t_person" 
 */
public class Person {
	
	/**
	 * @hibernate.id
	 * 		generator-class="native"
	 */
	private int id;					//主键
	
	/**
	 * @hibernate.property
	 */
	private String name;			//姓名
	
	/**
	 * @hibernate.property
	 */
	private String sex;				//性别
	
	/**
	 * @hibernate.property
	 */
	private String address;			//地址
	
	/**
	 * @hibernate.property
	 */
	private String duty;			//职务
	
	/**
	 * @hibernate.property
	 */
	private String phone;			//电话
	
	/**
	 * @hibernate.property
	 */
	private String description;		//描述
	
	/**
	 * @hibernate.many-to-one
	 */
	private Organization org;		//机构
	
	/**
	 * Person 1<---->1 User
	 * @hibernate.one-to-one
	 * 		property-ref="person"
	 */
	private User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Organization getOrg() {
		return org;
	}

	public void setOrg(Organization org) {
		this.org = org;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
