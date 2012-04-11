package cn.edu.zhku.oa.dao.impl;

import java.util.Date;
import java.util.List;

import cn.edu.zhku.oa.dao.MeetingRoomDao;
import cn.edu.zhku.oa.model.MeetingRoom;
import cn.edu.zhku.oa.model.MeetingRoomApply;

public class MeetingRoomDaoImpl extends AbstractDao implements
		MeetingRoomDao {

	public void addRoom(MeetingRoom room) {
		getHibernateTemplate().save(room);
	}

	public void applyRoom(MeetingRoomApply apply) {
		getHibernateTemplate().save(apply);
	}
	
	@Override
	public long findSize(MeetingRoomApply apply,String sn) {
		//是否有冲突？
		Long size = (Long)getSession()
			.createQuery(
					"select count(*) from MeetingRoomApply ap where ap.room.sn = ? and " +
					"(" +
					"(:begin between ap.beginDate and ap.endDate ) or " +
					"(:end between ap.beginDate and ap.endDate )" +
					")")
			.setParameter(0, sn)
			.setParameter("begin", apply.getBeginDate())
			.setParameter("end", apply.getEndDate())
			.uniqueResult();
		return size;
	}
	
	@Override
	public MeetingRoom findMeetingRoom(String sn) {
		return (MeetingRoom)getSession()
			.createQuery("from MeetingRoom ap where ap.sn = ?")
			.setParameter(0, sn)
			.uniqueResult();
	}


	public MeetingRoomApply findRoomApply(int applyId) {
		return (MeetingRoomApply)getHibernateTemplate().load(MeetingRoomApply.class, applyId);
	}

	public void updateApply(MeetingRoomApply apply) {
		getHibernateTemplate().update(apply);
	}
	
	@Override
	public long findSizeForUpdate(MeetingRoomApply apply, String sn) {
		//是否有冲突？
		Long size = (Long)getSession()
			.createQuery(
					"select count(*) from MeetingRoomApply ap where ap.room.sn = ? and " +
					"(" +
					"(:begin between ap.beginDate and ap.endDate ) or " +
					"(:end between ap.beginDate and ap.endDate )" +
					") and " +
					"ap.id <> "+apply.getId())
			.setParameter(0, sn)
			.setParameter("begin", apply.getBeginDate())
			.setParameter("end", apply.getEndDate())
			.uniqueResult();
		return size;
	}


	public List searchAllRooms() {
		return getHibernateTemplate().find("from MeetingRoom");
	}

	public List searchApplies(Date begin, Date end) {
		return getSession().createQuery(
				"select a from MeetingRoomApply a where (a.beginDate between :begin and :end ) " +
				"or (a.endDate between :begin and :end)"
			)
			.setParameter("begin", begin)
			.setParameter("end", end)
			.list();
	}


	

	
}
