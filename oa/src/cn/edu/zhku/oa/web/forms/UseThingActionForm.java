package cn.edu.zhku.oa.web.forms;

import org.apache.struts.action.ActionForm;

public class UseThingActionForm extends ActionForm {

	private static final long serialVersionUID = 1L;
	
	private int id;
	
	private String name;
	
	private String serialNumber;
	
	private int amount;
	
	private int categoryId;

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

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
}
