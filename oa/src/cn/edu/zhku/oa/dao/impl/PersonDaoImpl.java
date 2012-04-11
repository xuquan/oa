package cn.edu.zhku.oa.dao.impl;

import cn.edu.zhku.oa.PagerModel;
import cn.edu.zhku.oa.dao.PersonDao;
import cn.edu.zhku.oa.model.Person;

public class PersonDaoImpl extends AbstractDao implements PersonDao {

	@Override
	public void addPerson(Person person) {
		this.getHibernateTemplate().save(person);
	}

	@Override
	public void delPerson(Person person) {
		this.getHibernateTemplate().delete(person);
	}

	@Override
	public Person findPerson(int personId) {
		return (Person)this.getHibernateTemplate().load(Person.class, personId);
	}

	@Override
	public PagerModel searchPersons() {
		return searchPaginated("from Person");
	}

	@Override
	public PagerModel searchPersons(int orgId) {
		return searchPaginated("select p from Person p where p.org.id ="+orgId);
	}

	@Override
	public void updatePerson(Person person) {
		this.getHibernateTemplate().update(person);
	}

	
}
