package cn.edu.zhku.oa.dao.impl;

import cn.edu.zhku.oa.PagerModel;
import cn.edu.zhku.oa.dao.CarDao;
import cn.edu.zhku.oa.model.Car;

public class CarDaoImpl extends AbstractDao implements CarDao {

	@Override
	public void addCar(Car car) {
		getHibernateTemplate().save(car);
	}

	@Override
	public void delCar(int carId) {
		getHibernateTemplate().delete(getHibernateTemplate().load(Car.class, carId));
	}

	@Override
	public PagerModel findCar(boolean status) {
		return searchPaginated("select c from Car c where c.status=?", status);
	}

	@Override
	public Car findCarById(int carId) {
		return (Car) getHibernateTemplate().load(Car.class, carId);
	}

	@Override
	public PagerModel findCars() {
		return searchPaginated("from Car");
	}

	@Override
	public void updateCar(Car car) {
		getHibernateTemplate().saveOrUpdate(car);
	}

	@Override
	public PagerModel findCar(int userId) {
		return searchPaginated("select c from Car c where c.user.id=?", userId);
	}

}
