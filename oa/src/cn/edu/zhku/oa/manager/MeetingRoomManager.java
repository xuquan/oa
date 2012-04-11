package cn.edu.zhku.oa.manager;

import java.util.Date;
import java.util.List;

import cn.edu.zhku.oa.model.MeetingRoom;
import cn.edu.zhku.oa.model.MeetingRoomApply;

public interface MeetingRoomManager {
	public void addRoom(MeetingRoom room);
	public void applyRoom(MeetingRoomApply apply,String sn);
	public MeetingRoomApply findRoomApply(int applyId);
	public void updateApply(MeetingRoomApply apply,String sn);
	
	/**
	 * ËÑË÷»áÒéÊÒ
	 * @return
	 */
	public List searchAllRooms();
	
	/**
	 * ËÑË÷»áÒéÊÒÉêÇë¼ÇÂ¼
	 * @param begin
	 * @param end
	 * @return
	 */
	public List searchApplies(Date begin,Date end);
}
