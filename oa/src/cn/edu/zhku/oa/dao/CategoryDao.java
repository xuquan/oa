package cn.edu.zhku.oa.dao;

import java.util.List;

import cn.edu.zhku.oa.PagerModel;
import cn.edu.zhku.oa.model.Category;

/**
 * 类别接口
 * 编写作者：许权
 * 编写日期：2011-4-15 下午01:48:30
 */
public interface CategoryDao {
	public void addCategory(Category category);
	public void delCategory(int categoryId);
	public void updateCategory(Category category);
	public Category findCategory(int categoryId);
	public List<Category> findCategorys();
	public PagerModel findCategory();
}
