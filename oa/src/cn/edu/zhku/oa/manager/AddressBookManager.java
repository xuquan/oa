package cn.edu.zhku.oa.manager;

import cn.edu.zhku.oa.PagerModel;
import cn.edu.zhku.oa.model.AddressBook;

/**
 * 通信录接口
 * 编写作者：许权
 * 编写日期：2011-4-12 上午12:12:46
 */
public interface AddressBookManager {
	/**
	 * 添加通信录
	 * @param addressBook
	 */
	public void addAddressBook(AddressBook addressBook, int userId);
	
	/**
	 * 删除通信录
	 * @param addressBookId
	 */
	public void delAddressBook(int addressBookId);
	
	/**
	 * 修改通信录
	 * @param addressBook
	 */
	public void updateAddressBook(AddressBook addressBook, int userId);
	
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
