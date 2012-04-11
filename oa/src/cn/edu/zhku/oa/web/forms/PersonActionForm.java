package cn.edu.zhku.oa.web.forms;

import org.apache.struts.action.ActionForm;

public class PersonActionForm extends ActionForm {

	private static final long serialVersionUID = 1L;
	
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	
	private int id;					//序号
	
	private String name;			//姓名
	
	private String sex;				//性别
	
	private String duty;			//职务
	
	private String phone;			//电话
	
	private String address;			//地址

	private String description;     //描述

	private int orgId;				//所属机构
	
	public String getAddress() {
		return address;
	}

	public String getDescription() {
		return description;
	}

	public String getDuty() {
		return duty;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getOrgId() {
		return orgId;
	}

	public String getPhone() {
		return phone;
	}

	public String getSex() {
		return sex;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	
}
