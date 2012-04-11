package cn.edu.zhku.oa.dao;

import cn.edu.zhku.oa.PagerModel;
import cn.edu.zhku.oa.model.Module;

/**
 * 模块管理持久化接口
 * 编写作者：许权
 * 编写日期：2011-2-15 下午02:54:38
 */
public interface ModuleDao {
	
	/**
	 * 添加模块信息
	 * @param module 模块信息
	 */
	public void addModule(Module module);
	
	/**
	 * 删除模块
	 * @param module
	 */
	public void delModule(Module module);
	
	/**
	 * 更新模块信息
	 * @param module
	 */
	public void updateModule(Module module);
	
	/**
	 * 查询特定的模块
	 * @param moduleId
	 * @return
	 */
	public Module findModule(int moduleId);
	
	/**
	 * 分页查询模块的信息
	 * @param parentId
	 * @return
	 */
	public PagerModel searchModules(int parentId);
	
	/**
	 * 分页查询模块的信息(查顶级模块)
	 * @return
	 */
	public PagerModel searchModules();
	
}
