package cn.edu.zhku.oa.model;

/**
 * 
 * @hibernate.class table="t_meetingRoom"
 */
public class MeetingRoom {
	
	/**
	 * @hibernate.id
	 * 		generator-class="native"
	 */
	private int id;
	/**
	 * @hibernate.property
	 * 		unique="true"
	 */
	private String sn;
	
	/**
	 * @hibernate.property
	 */
	private String position;
	
	/**
	 * @hibernate.property
	 */
	private String description;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
}
