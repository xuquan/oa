package cn.edu.zhku.oa.model;

/**
 * 类别
 * 编写作者：许权
 * 编写日期：2011-4-15 上午12:43:11
 * @hibernate.class table="t_category" lazy="false"
 */
public class Category {
	
	/**
	 * @hibernate.id
	 * generator-class="native"
	 */
	private int id;
	
	/**
	 * 类名
	 * @hibernate.property
	 */
	private String name;
	
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
	
}
