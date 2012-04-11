package cn.edu.zhku.oa.dao.impl;

import cn.edu.zhku.oa.PagerModel;
import cn.edu.zhku.oa.dao.ModuleDao;
import cn.edu.zhku.oa.model.Module;

public class ModuleDaoImpl extends AbstractDao implements ModuleDao {

	@Override
	public void addModule(Module module) {
		this.getHibernateTemplate().save(module);
	}

	@Override
	public void delModule(Module module) {
		this.getHibernateTemplate().delete(module);
	}

	@Override
	public Module findModule(int moduleId) {
		return (Module)this.getHibernateTemplate().load(Module.class, moduleId);
	}

	@Override
	public PagerModel searchModules(int parentId) {
		return this.searchPaginated("select m from Module m where m.parent.id=" + parentId);
	}
	
	@Override
	public PagerModel searchModules() {
		return this.searchPaginated("select m from Module m where m.parent is null");
	}
	
	@Override
	public void updateModule(Module module) {
		this.getHibernateTemplate().update(module);
	}
}
