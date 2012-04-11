package cn.edu.zhku.oa.manager.impl;

import java.util.Calendar;
import java.util.Date;

import cn.edu.zhku.oa.PagerModel;
import cn.edu.zhku.oa.dao.InfoDao;
import cn.edu.zhku.oa.dao.UserDao;
import cn.edu.zhku.oa.manager.InfoManager;
import cn.edu.zhku.oa.model.Info;

public class InfoManagerImpl implements InfoManager {
	
	private InfoDao infoDao;
	
	private UserDao userDao;

	public void setInfoDao(InfoDao infoDao) {
		this.infoDao = infoDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void addInfo(Info info,int userId) {
		info.setTime(new Date());
		info.setPublisher(userDao.findUser(userId));
		infoDao.addInfo(info);
	}

	@Override
	public void delInfo(int infoId) {
		infoDao.delInfo(infoId);
	}

	@Override
	public PagerModel findInfo(int userId) {
		return infoDao.findInfo(userId);
	}

	@Override
	public Info findInfoById(int infoId) {
		return infoDao.findInfoById(infoId);
	}

	@Override
	public PagerModel findInfoByTime() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_WEEK, -7);
		return infoDao.findInfo(calendar.getTime());
	}

	@Override
	public PagerModel findInfos() {
		return infoDao.findInfos();
	}

	@Override
	public void updateInfo(Info info) {
		info.setTime(new Date());
		infoDao.updateInfo(info);
	}

}
