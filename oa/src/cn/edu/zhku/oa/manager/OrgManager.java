package cn.edu.zhku.oa.manager;

import cn.edu.zhku.oa.PagerModel;
import cn.edu.zhku.oa.model.Organization;

/**
 * 机构管理接口
 * 编写作者：许权
 * 编写日期：2011-2-15 上午10:30:29
 */
public interface OrgManager {

	/**
	 * 添加机构信息
	 * @param org
	 * @param parentId 减少Action的工作，保持Action逻辑的单一性，让OrgManager完成
	 */
	public void addOrg(Organization org,int parentId);
	
	public void delOrg(int orgId);
	
	public void updateOrg(Organization org,int parentId);
	
	public Organization findOrg(int orgId);
	
	/**
	 * 查找机构列表
	 * 如果parentId为0，则查找顶级机构列表
	 * @param parentId
	 * @return
	 */
	public PagerModel findOrgs(int parentId);
}
