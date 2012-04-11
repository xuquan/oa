package cn.edu.zhku.oa.manager.impl;


import java.util.Date;

import cn.edu.zhku.oa.PagerModel;
import cn.edu.zhku.oa.dao.CarDao;
import cn.edu.zhku.oa.dao.UserDao;
import cn.edu.zhku.oa.manager.CarManager;
import cn.edu.zhku.oa.model.Car;

public class CarManagerImpl implements CarManager {
	
	private CarDao carDao;
	
	private UserDao userDao;

	public void setCarDao(CarDao carDao) {
		this.carDao = carDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void addCar(Car car) {
		carDao.addCar(car);
	}

	@Override
	public void delCar(int carId) {
		carDao.delCar(carId);
	}

	@Override
	public PagerModel findCar(boolean status) {
		return carDao.findCar(status);
	}

	@Override
	public Car findCarById(int carId) {
		return carDao.findCarById(carId);
	}

	@Override
	public PagerModel findCars() {
		return carDao.findCars();
	}

	@Override
	public void updateCar(Car car) {
		carDao.updateCar(car);
	}

	@Override
	public PagerModel findCar(int userId) {
		return carDao.findCar(userId);
	}
	
	@Override
	public void borrowCar(int carId, int userId) {
		Car car = carDao.findCarById(carId);
		car.setApplyDate(new Date());
		car.setStatus(true);
		car.setUser(userDao.findUser(userId));
		carDao.updateCar(car);
	}
	
	@Override
	public void returnCar(int carId) {
		Car car = carDao.findCarById(carId);
		if(car != null){
			car.setReturnDate(new Date());
			car.setStatus(false);
			car.setUser(null);
		}
		carDao.updateCar(car);
	}

}
