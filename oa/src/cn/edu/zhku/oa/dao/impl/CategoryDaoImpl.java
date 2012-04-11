package cn.edu.zhku.oa.dao.impl;

import java.util.List;

import cn.edu.zhku.oa.PagerModel;
import cn.edu.zhku.oa.dao.CategoryDao;
import cn.edu.zhku.oa.model.Category;

public class CategoryDaoImpl extends AbstractDao implements CategoryDao {

	@Override
	public void addCategory(Category category) {
		getHibernateTemplate().save(category);
	}

	@Override
	public void delCategory(int categoryId) {
		getHibernateTemplate().delete(getHibernateTemplate().load(Category.class, categoryId));
	}

	@Override
	public Category findCategory(int categoryId) {
		return (Category) getHibernateTemplate().load(Category.class, categoryId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> findCategorys() {
		return getSession().createQuery("from Category").list();
	}

	@Override
	public void updateCategory(Category category) {
		getHibernateTemplate().update(category);
	}

	@Override
	public PagerModel findCategory() {
		return searchPaginated("from Category");
	}

}
