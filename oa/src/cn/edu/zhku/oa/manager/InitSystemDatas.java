package cn.edu.zhku.oa.manager;

/**
 * 初始化系统数据
 * 作者：许权
 * 时间：2010-7-26 下午11:12:10
 */
public interface InitSystemDatas {
	/**
	 * 添加或更新（如果已存在则更新）系统的初始化数据
	 * @param xmlFilePath
	 */
	public void addOrUpdateInitDatas(String xmlFilePath);
}
