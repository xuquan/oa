package cn.edu.zhku.oa.dao;

import cn.edu.zhku.oa.PagerModel;
import cn.edu.zhku.oa.model.Person;
/**
 * 人员管理持久化接口
 * 编写作者：许权
 * 编写日期：2011-2-15 下午01:02:09
 */
public interface PersonDao {

	/**
	 * 添加人员信息
	 * @param person 人员信息
	 */
	public void addPerson(Person person);
	
	/**
	 * 更新人员的信息
	 * @param person 人员信息
	 */
	public void updatePerson(Person person);
	
	/**
	 * 根据人员标识删除人员信息
	 * @param person 人员信息
	 */
	public void delPerson(Person person);
	
	/**
	 * 查找特定人员的信息
	 * @param personId 人员标识
	 * @return
	 */
	public Person findPerson(int personId);
	
	/**
	 * 搜索所有人员的列表（分页查询）
	 * @return
	 */
	public PagerModel searchPersons();
	
	/**
	 * 搜索某个机构下的人员列表
	 * @param orgId
	 * @return
	 */
	public PagerModel searchPersons(int orgId);
}
