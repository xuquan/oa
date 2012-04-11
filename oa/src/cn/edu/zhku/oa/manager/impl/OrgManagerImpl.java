package cn.edu.zhku.oa.manager.impl;

import cn.edu.zhku.oa.PagerModel;
import cn.edu.zhku.oa.dao.OrgDao;
import cn.edu.zhku.oa.manager.OrgManager;
import cn.edu.zhku.oa.manager.SystemException;
import cn.edu.zhku.oa.model.Organization;

/**
 * 机构管理实现类
 * 作者：许权
 * 时间：2010-7-15 下午08:25:20
 */
public class OrgManagerImpl implements OrgManager {
	
	private OrgDao orgDao;
	
	public void addOrg(Organization org, int parentId) {
		if(parentId != 0){
			org.setParent(orgDao.findOrg(parentId));
		}
		orgDao.addOrg(org);
		
		
		//设置Organization的唯一编号
		org.setSn(
			org.getParent() == null? (""+org.getId()) : (org.getParent().getSn()+"_"+org.getId())
		);
		
		orgDao.updateOrg(org);
	}

	public void delOrg(int orgId) {
		
		Organization org = orgDao.findOrg(orgId);
		
		if(org.getChildren().size()>0){
			throw new SystemException("存在子机构，不允许删除","exception.org.del",org.getId());
		}
		
		orgDao.delOrg(org);
	}

	public Organization findOrg(int orgId) {
		return orgDao.findOrg(orgId);
	}

	public PagerModel findOrgs(int parentId) {
		//如果parentId==0，则查找顶级机构列表
		if(parentId == 0){
			return orgDao.findOrgs();
		}
		return orgDao.findOrgs(parentId);
	}

	public void updateOrg(Organization org, int parentId) {
		if(parentId != 0){
			org.setParent(
				orgDao.findOrg(parentId)
			);
		}
		
		orgDao.updateOrg(org);
	}

	public void setOrgDao(OrgDao orgDao) {
		this.orgDao = orgDao;
	}
}
