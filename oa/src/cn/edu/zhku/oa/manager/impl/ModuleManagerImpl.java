package cn.edu.zhku.oa.manager.impl;

import cn.edu.zhku.oa.PagerModel;
import cn.edu.zhku.oa.dao.ModuleDao;
import cn.edu.zhku.oa.manager.ModuleManager;
import cn.edu.zhku.oa.model.Module;
import cn.edu.zhku.oa.web.SystemException;

public class ModuleManagerImpl implements ModuleManager {
	
	private ModuleDao moduleDao;
	@Override
	public void addModule(Module module, int parentId) {
		if(parentId != 0){
			module.setParent(
				moduleDao.findModule(parentId)
			);
		}
		moduleDao.addModule(module);
	}

	@Override
	public void delModule(int moduleId) {
		Module module = moduleDao.findModule(moduleId);
		
		if(module.getChildren().size() > 0){
			throw new SystemException("存在子模块，不允许删除！");
		}
		
		moduleDao.delModule(module);
	}

	@Override
	public Module findModule(int moduleId) {
		return moduleDao.findModule(moduleId);
	}

	@Override
	public PagerModel searchModules(int parentId) {
		if(parentId==0){
			return moduleDao.searchModules();
		}
		return moduleDao.searchModules(parentId);
	}

	@Override
	public void updateModule(Module module, int parentId) {
		if(parentId != 0){
			module.setParent(
				moduleDao.findModule(parentId)
			);
		}
		moduleDao.updateModule(module);
	}

	public void setModuleDao(ModuleDao moduleDao) {
		this.moduleDao = moduleDao;
	}

}
