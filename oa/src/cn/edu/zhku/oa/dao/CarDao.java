package cn.edu.zhku.oa.dao;

import cn.edu.zhku.oa.PagerModel;
import cn.edu.zhku.oa.model.Car;

/**
 * 车辆接口
 * 编写作者：许权
 * 编写日期：2011-4-13 上午10:03:33
 */
public interface CarDao {
	/**
	 * 添加车辆
	 * @param car
	 */
	public void addCar(Car car);
	
	/**
	 * 删除车辆
	 * @param carId
	 */
	public void delCar(int carId);
	
	/**
	 * 修改车辆
	 * @param car
	 */
	public void updateCar(Car car);
	
	/**
	 * 查找特定车辆
	 * @param carId
	 * @return
	 */
	public Car findCarById(int carId);
	
	/**
	 * 查找所有车辆
	 * @return
	 */
	public PagerModel findCars();
	
	/**
	 * 根据借用状态查找车辆
	 * @param status
	 * @return
	 */
	public PagerModel findCar(boolean status);
	
	/**
	 * 查找待归还的车辆
	 * @param userId
	 * @return
	 */
	public PagerModel findCar(int userId);
	
}
