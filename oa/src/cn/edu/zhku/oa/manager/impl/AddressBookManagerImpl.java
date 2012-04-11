package cn.edu.zhku.oa.manager.impl;

import cn.edu.zhku.oa.PagerModel;
import cn.edu.zhku.oa.dao.AddressBookDao;
import cn.edu.zhku.oa.dao.UserDao;
import cn.edu.zhku.oa.manager.AddressBookManager;
import cn.edu.zhku.oa.model.AddressBook;

public class AddressBookManagerImpl implements AddressBookManager {
	
	private AddressBookDao addressBookDao;
	private UserDao userDao;
	
	public void setAddressBookDao(AddressBookDao addressBookDao) {
		this.addressBookDao = addressBookDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void addAddressBook(AddressBook addressBook, int userId) {
		if(userId != 0){
			addressBook.setUser(userDao.findUser(userId));
		}
		addressBookDao.addAddressBook(addressBook);
	}

	@Override
	public void delAddressBook(int addressBookId) {
		addressBookDao.delAddressBook(addressBookId);
	}

	@Override
	public AddressBook findAddressBookById(int addressBookId) {
		return addressBookDao.findAddressBookById(addressBookId);
	}

	@Override
	public PagerModel findAddressBooks(int userId) {
		return addressBookDao.findAddressBooks(userId);
	}

	@Override
	public void updateAddressBook(AddressBook addressBook, int userId) {
		if(userId != 0){
			addressBook.setUser(userDao.findUser(userId));
		}
		addressBookDao.updateAddressBook(addressBook);
	}

}
