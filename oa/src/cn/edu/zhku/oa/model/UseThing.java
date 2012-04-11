package cn.edu.zhku.oa.model;

/**
 * 用品
 * 编写作者：许权
 * 编写日期：2011-4-14 下午07:48:50
 * @hibernate.class table="t_usething" lazy="false"
 */
public class UseThing {
	
	/**
	 * @hibernate.id
	 * generator-class="native"
	 */
	private int id;
	
	/**
	 * 用品名称
	 * @hibernate.property
	 */
	private String name;
	
	/**
	 * 用品编号
	 * @hibernate.property
	 */
	private String serialNumber;
	
	/**
	 * 数量
	 * @hibernate.property
	 */
	private int amount;
	
	/**
	 * 所属类别
	 * @hibernate.many-to-one
	 */
	private Category category;

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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}
