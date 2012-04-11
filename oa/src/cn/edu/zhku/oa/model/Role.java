package cn.edu.zhku.oa.model;

/**
 * 作者：许权
 * @hibernate.class table="t_role"
 */
public class Role {
	
	/**
	 * @hibernate.id
	 * 		generator-class="native"
	 */
	private int id;
	
	/**
	 * @hibernate.property
	 * 		not-null="true"
	 * 		unique="true"
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
