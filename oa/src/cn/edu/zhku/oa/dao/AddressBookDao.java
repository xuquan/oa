package cn.edu.zhku.oa.dao;

import cn.edu.zhku.oa.PagerModel;
import cn.edu.zhku.oa.model.AddressBook;

/**
 * 通信录接口
 * 编写作者：许权
 * 编写日期：2011-4-11 下午11:48:42
 */
public interface AddressBookDao {
	
	/**
	 * 添加通信录
	 * @param addressBook
	 */
	public void addAddressBook(AddressBook addressBook);
	
	/**
	 * 删除通信录
	 * @param addressBookId
	 */
	public void delAddressBook(int addressBookId);
	
	/**
	 * 修改通信录
	 * @param addressBook
	 */
	public void updateAddressBook(AddressBook addressBook);
	
	/**
	 * 根据id查找通信录
	 * @param addressBookId
	 * @return
	 */
	public AddressBook findAddressBookById(int addressBookId);
	
	/**
	 * 查找所有通信录
	 * @return
	 */
	public PagerModel findAddressBooks(int userId);
}
