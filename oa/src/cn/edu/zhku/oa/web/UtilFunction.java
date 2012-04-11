package cn.edu.zhku.oa.web;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import cn.edu.zhku.oa.model.MeetingRoomApply;
import cn.edu.zhku.oa.model.MeetingRoomApplyVO;

public class UtilFunction {
	
	//用来判断某个日期是否周六周日
	public static boolean isHoliday(int year,int month,int date){
		Calendar now = Calendar.getInstance();
		now.set(year, month - 1, date);
		int current = now.get(Calendar.DAY_OF_WEEK);
		if(current == Calendar.SUNDAY || current == Calendar.SATURDAY){
			return true;
		}
		return false;
	}
	
	//将一条申请记录，分离成多个VO，以便于界面上的显示
	public static List splitApply(MeetingRoomApply apply){
		Date begin = apply.getBeginDate();
		Date end = apply.getEndDate();
		
		Calendar beginCal = Calendar.getInstance();
		beginCal.setTime(begin);
		
		Calendar endCal = Calendar.getInstance();
		endCal.setTime(end);
		
		List applyVO = new ArrayList();
		
		do{
			
			if(beginCal.get(Calendar.HOUR_OF_DAY) < 8 || beginCal.get(Calendar.HOUR_OF_DAY) > 18){
				beginCal.add(Calendar.HOUR_OF_DAY, 1);
				continue;
			}
			
			MeetingRoomApplyVO vo = new MeetingRoomApplyVO();
			vo.setId(
					apply.getRoom().getSn() + "_" +
					beginCal.get(Calendar.YEAR) + "-" +
					(beginCal.get(Calendar.MONTH)+1) + "-" +
					beginCal.get(Calendar.DAY_OF_MONTH) + "-" +
					beginCal.get(Calendar.HOUR_OF_DAY)
					);
			vo.setOid(apply.getId());
			vo.setApplyReason(apply.getApplyReason());
			vo.setStatus(apply.getStatus());
			applyVO.add(vo);
			
			beginCal.add(Calendar.HOUR_OF_DAY, 1);
		}while(endCal.after(beginCal));
		
		return applyVO;
	}
}
