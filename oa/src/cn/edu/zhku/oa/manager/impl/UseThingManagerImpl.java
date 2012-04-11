package cn.edu.zhku.oa.manager.impl;

import cn.edu.zhku.oa.PagerModel;
import cn.edu.zhku.oa.dao.CategoryDao;
import cn.edu.zhku.oa.dao.UseThingDao;
import cn.edu.zhku.oa.manager.UseThingManager;
import cn.edu.zhku.oa.model.Category;
import cn.edu.zhku.oa.model.UseThing;

public class UseThingManagerImpl implements UseThingManager {
	
	private UseThingDao useThingDao;
	
	private CategoryDao categoryDao;

	public void setUseThingDao(UseThingDao useThingDao) {
		this.useThingDao = useThingDao;
	}

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	@Override
	public void addUseThing(UseThing useThing,int categoryId) {
		useThing.setCategory(categoryDao.findCategory(categoryId));
		useThingDao.addUseThing(useThing);
	}

	@Override
	public void delUseThing(int useThingId) {
		useThingDao.delUseThing(useThingId);
	}

	@Override
	public UseThing findUseThing(int useThingId) {
		return useThingDao.findUseThing(useThingId);
	}

	@Override
	public PagerModel findUseThing(Category category) {
		return useThingDao.findUseThing(category);
	}

	@Override
	public PagerModel findUseThings() {
		return useThingDao.findUseThings();
	}

	@Override
	public void updateUseThing(UseThing useThing,int categoryId) {
		useThing.setCategory(categoryDao.findCategory(categoryId));
		useThingDao.updateUseThing(useThing);
	}

}
