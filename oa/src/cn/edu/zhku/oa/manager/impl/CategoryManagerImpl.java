package cn.edu.zhku.oa.manager.impl;

import java.util.List;

import cn.edu.zhku.oa.PagerModel;
import cn.edu.zhku.oa.dao.CategoryDao;
import cn.edu.zhku.oa.manager.CategoryManager;
import cn.edu.zhku.oa.model.Category;

public class CategoryManagerImpl implements CategoryManager {
	
	private CategoryDao categoryDao;

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	@Override
	public void addCategory(Category category) {
		categoryDao.addCategory(category);
	}

	@Override
	public void delCategory(int categoryId) {
		categoryDao.delCategory(categoryId);
	}

	@Override
	public Category findCategory(int categoryId) {
		return categoryDao.findCategory(categoryId);
	}

	@Override
	public List<Category> findCategorys() {
		return categoryDao.findCategorys();
	}

	@Override
	public void updateCategory(Category category) {
		categoryDao.updateCategory(category);
	}

	@Override
	public PagerModel findCategory() {
		return categoryDao.findCategory();
	}

}
