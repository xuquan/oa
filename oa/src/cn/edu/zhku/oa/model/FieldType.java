package cn.edu.zhku.oa.model;

/**
 * 表单的类型
 * 作者：许权
 * @hibernate.class table="t_fieldType"
 */
public class FieldType {
	
	/**
	 * @hibernate.id
	 * 		generator-class="native"
	 */
	private int id;
	
	/**
	 * 类型的名称，如：字符串、整型、文件等等
	 * @hibernate.property
	 */
	private String name;
	
	/**
	 * 对应的Java类型，如：String、Integer、File
	 * @hibernate.property
	 */
	private String type;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
