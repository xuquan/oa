package cn.edu.zhku.oa.manager;

import cn.edu.zhku.oa.PagerModel;
import cn.edu.zhku.oa.model.Info;

/**
 * 公共信息接口
 * 编写作者：许权
 * 编写日期：2011-4-14 上午10:23:13
 */
public interface InfoManager {
	/**
	 * 添加信息
	 * @param info
	 */
	public void addInfo(Info info,int userId);
	
	/**
	 * 删除信息
	 * @param infoId
	 */
	public void delInfo(int infoId);
	
	/**
	 * 更新信息
	 * @param info
	 */
	public void updateInfo(Info info);
	
	/**
	 * 根据Id查找信息
	 * @param infoId
	 * @return
	 */
	public Info findInfoById(int infoId);
	
	/**
	 * 根据用户Id查找信息
	 * @param userId
	 * @return
	 */
	public PagerModel findInfo(int userId);
	
	/**
	 * 查找所有信息
	 * @return
	 */
	public PagerModel findInfos();
	
	/**
	 * 根据时间查找信息
	 * @return
	 */
	public PagerModel findInfoByTime();
}
