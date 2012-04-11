package cn.edu.zhku.oa.web.forms;

import java.util.Date;

import org.apache.struts.action.ActionForm;

public class AddressBookActionForm extends ActionForm{
	
	private static final long serialVersionUID = 1L;

	private int id;
	
	private String name;
	
	private String email;
	
	private String mobilePhone;
	
	private String phs;
	
	private String nickName;
	
	private Date birthday;
	
	private String street;
	
	private String company;
	
	private String notes;
	
	private int userId;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getPhs() {
		return phs;
	}

	public void setPhs(String phs) {
		this.phs = phs;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}
