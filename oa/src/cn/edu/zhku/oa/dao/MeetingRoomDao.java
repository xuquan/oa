package cn.edu.zhku.oa.dao;

import java.util.Date;
import java.util.List;

import cn.edu.zhku.oa.model.MeetingRoom;
import cn.edu.zhku.oa.model.MeetingRoomApply;

public interface MeetingRoomDao {
	public void addRoom(MeetingRoom room);
	public void applyRoom(MeetingRoomApply apply);
	public MeetingRoomApply findRoomApply(int applyId);
	public void updateApply(MeetingRoomApply apply);
	
	/**
	 * 搜索会议室
	 * @return
	 */
	public List searchAllRooms();
	
	/**
	 * 搜索会议室申请记录
	 * @param begin
	 * @param end
	 * @return
	 */
	public List searchApplies(Date begin,Date end);
	
	/**
	 * 查找是否冲突
	 * @param apply
	 * @return
	 */
	public long findSize(MeetingRoomApply apply,String sn);
	
	/**
	 * 查找是否冲突
	 * @param apply
	 * @return
	 */
	public long findSizeForUpdate(MeetingRoomApply apply,String sn);
	
	/**
	 * 通过sn查找会议室
	 * @param sn
	 * @return
	 */
	public MeetingRoom findMeetingRoom(String sn);
}
