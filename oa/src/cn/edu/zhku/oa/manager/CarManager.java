package cn.edu.zhku.oa.manager;

import cn.edu.zhku.oa.PagerModel;
import cn.edu.zhku.oa.model.Car;

/**
 * 车辆接口
 * 编写作者：许权
 * 编写日期：2011-4-13 上午10:29:05
 */
public interface CarManager {
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
	 * 查找指定用户所借的车辆
	 * @param carId
	 * @param userId
	 * @return
	 */
	public PagerModel findCar(int userId);
	
	/**
	 * 借用车辆
	 * @param car
	 */
	public void borrowCar(int carId,int userId);
	
	/**
	 * 归还车辆
	 * @param car
	 */
	public void returnCar(int carId);
	
}
