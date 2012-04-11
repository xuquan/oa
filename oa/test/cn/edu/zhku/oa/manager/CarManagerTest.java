package cn.edu.zhku.oa.manager;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import junit.framework.TestCase;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.edu.zhku.oa.PagerModel;
import cn.edu.zhku.oa.model.Car;

public class CarManagerTest extends TestCase {
	
	private static BeanFactory factory = new ClassPathXmlApplicationContext("beans.xml");

	public void testUpdateCar() {
		CarManager carManager = (CarManager) factory.getBean("carManager");
		UserManager userMgr = (UserManager)factory.getBean("userMgr");
		Car car = new Car();
		car.setId(1);
		car.setCarLoad(4);
		car.setCarNumber("‘¡A20001");
		car.setName("±º≥€600");
		car.setStatus(false);
		car.setApplyDate(new Date());
		car.setUser(userMgr.findUser(1));
		carManager.updateCar(car);
	}

	public void testBorrowCar() {
		CarManager carManager = (CarManager) factory.getBean("carManager");
		
		carManager.borrowCar(1, 3);
	}

	public void testReturnCar() {
		CarManager carManager = (CarManager) factory.getBean("carManager");
		carManager.returnCar(1);
	}
	
	public void testFindCar(){
		CarManager carManager = (CarManager) factory.getBean("carManager");
		PagerModel pm = carManager.findCar(1);
		List<Car> carList = pm.getDatas();
		for(Iterator<Car> iter=carList.iterator();iter.hasNext();){
			Car car = iter.next();
			System.out.println(car.getId());
		}
		
	}

}
