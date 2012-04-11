package cn.edu.zhku.oa.web.forms;

import java.util.Date;

import org.apache.struts.action.ActionForm;

public class CarActionForm extends ActionForm {

	private static final long serialVersionUID = 1L;
	
	private int id;
	
	private String name;
	
	private String carNumber;
	
	private int carLoad;
	
	private Date applyDate;
	
	private Date returnDate;
	
	private int userId;
	
	private boolean status;

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

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public int getCarLoad() {
		return carLoad;
	}

	public void setCarLoad(int carLoad) {
		this.carLoad = carLoad;
	}

	public Date getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}
