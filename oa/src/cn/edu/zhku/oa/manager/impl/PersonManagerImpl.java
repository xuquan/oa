package cn.edu.zhku.oa.manager.impl;

import cn.edu.zhku.oa.PagerModel;
import cn.edu.zhku.oa.dao.OrgDao;
import cn.edu.zhku.oa.dao.PersonDao;
import cn.edu.zhku.oa.manager.PersonManager;
import cn.edu.zhku.oa.model.Person;

public class PersonManagerImpl implements PersonManager {
	private OrgDao orgDao;
	private PersonDao personDao;
	@Override
	public void addPerson(Person person, int orgId) {
		if(orgId != 0){
			person.setOrg(orgDao.findOrg(orgId));
		}
		personDao.addPerson(person);
	}

	@Override
	public void delPerson(int personId) {
		Person person = personDao.findPerson(personId);
		personDao.delPerson(person);
	}

	@Override
	public Person findPerson(int personId) {
		return personDao.findPerson(personId);
	}

	@Override
	public PagerModel searchPersons() {
		return personDao.searchPersons();
	}

	@Override
	public PagerModel searchPersons(int orgId) {
		return personDao.searchPersons(orgId);
	}

	@Override
	public void updatePerson(Person person, int orgId) {
		if(orgId != 0){
			person.setOrg(orgDao.findOrg(orgId));
		}
		personDao.updatePerson(person);
	}

	public void setOrgDao(OrgDao orgDao) {
		this.orgDao = orgDao;
	}

	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}

	
}
