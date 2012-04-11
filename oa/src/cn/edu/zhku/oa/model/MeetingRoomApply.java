package cn.edu.zhku.oa.model;

import java.util.Date;

/**
 * 
 * @hibernate.class table="t_meetingRoomApply"
 */
public class MeetingRoomApply {
	
	public static final String STATUS_APPLY = "A";
	public static final String STATUS_OCCUR = "O";
	
	/**
	 * @hibernate.id
	 * 		generator-class="native"
	 */
	private int id;
	
	/**
	 * @hibernate.many-to-one
	 */
	private MeetingRoom room;
	
	/**
	 * @hibernate.property
	 */
	private Date beginDate;
	
	/**
	 * @hibernate.property
	 */
	private Date endDate;
	
	/**
	 * @hibernate.property
	 */
	private String applyReason;
	
	/**
	 * @hibernate.property
	 */
	private String status;
	
	public String getApplyReason() {
		return applyReason;
	}
	public void setApplyReason(String applyReason) {
		this.applyReason = applyReason;
	}
	public Date getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public MeetingRoom getRoom() {
		return room;
	}
	public void setRoom(MeetingRoom room) {
		this.room = room;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
