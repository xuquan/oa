package cn.edu.zhku.oa.model;

import java.util.Date;

/**
 * 车辆信息
 * 编写作者：许权
 * @hibernate.class table="t_car" lazy="false"
 */
public class Car {
	
	/**
	 * @hibernate.id
	 * generator-class="native"
	 */
	private int id;
	
	/**
	 * 车辆名称
	 * @hibernate.property
	 */
	private String name;
	
	/**
	 * 车牌号码
	 * @hibernate.property
	 */
	private String carNumber;
	
	/**
	 * 载客数量
	 * @hibernate.property
	 */
	private int carLoad;
	
	/**
	 * 申请日期
	 * @hibernate.property
	 */
	private Date applyDate;
	
	/**
	 * 归还日期
	 * @hibernate.property
	 */
	private Date returnDate;
	
	/**
	 * 申请人
	 * @hibernate.many-to-one column="user_car_id"
	 */
	private User user;
	
	/**
	 * 借用状态 （true：表示已借用，false：表示未借用）
	 * @hibernate.property
	 */
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}
