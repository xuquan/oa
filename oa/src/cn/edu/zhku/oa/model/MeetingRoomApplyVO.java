package cn.edu.zhku.oa.model;

public class MeetingRoomApplyVO {
	
	
	/**
	 * ¸ñÊ½Îª£ºyear-month-day-hour
	 */
	private String id;
	
	private int oid;

	/**
	 */
	private String applyReason;
	
	/**
	 */
	private String status;

	public String getApplyReason() {
		return applyReason;
	}

	public void setApplyReason(String applyReason) {
		this.applyReason = applyReason;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}
	
}
