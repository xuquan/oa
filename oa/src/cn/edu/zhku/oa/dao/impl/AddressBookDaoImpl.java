package cn.edu.zhku.oa.dao.impl;

import cn.edu.zhku.oa.PagerModel;
import cn.edu.zhku.oa.dao.AddressBookDao;
import cn.edu.zhku.oa.model.AddressBook;

public class AddressBookDaoImpl extends AbstractDao implements AddressBookDao {

	@Override
	public void addAddressBook(AddressBook addressBook) {
		getHibernateTemplate().save(addressBook);
	}

	@Override
	public void delAddressBook(int addressBookId) {
		getHibernateTemplate().delete(getHibernateTemplate().load(AddressBook.class, addressBookId));
	}

	@Override
	public AddressBook findAddressBookById(int addressBookId) {
		return (AddressBook) getHibernateTemplate().load(AddressBook.class, addressBookId);
	}

	@Override
	public PagerModel findAddressBooks(int userId) {
		return searchPaginated("from AddressBook addr where addr.user.id=?",userId);
	}

	@Override
	public void updateAddressBook(AddressBook addressBook) {
		getHibernateTemplate().update(addressBook);
	}

}
