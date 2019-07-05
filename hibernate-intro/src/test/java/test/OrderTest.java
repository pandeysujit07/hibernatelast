package test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.lti.dao.GenericDao;
import com.lti.entity.Order;

import dao.CustomerDao;
import model.Customer;

public class OrderTest {
	
	@Test
	public void testAdd() {
		
		GenericDao dao = new GenericDao();
		Customer cust = (Customer) dao.fetchById(Customer.class,25);
		
		Order order = new Order();
		order.setOrderDate( new Date());
		order.setAmount(12000);
		order.setCustomer(cust);
		dao.insertOrUpdate(order);
		
	}
	
	@Test
	public void fetchAlls() {
		//Customer c = new Customer();
		GenericDao dao = new GenericDao();
		//	List<Order> cu=(List<Order>)dao.fetchAll(Order.class);
		List<Order> cu=dao.fetchAll(Order.class);
		for (Order q:cu) {
			System.out.println(q.getId());
			System.out.println(q.getAmount());
			System.out.println(q.getOrderDate());
			System.out.println(q.getCustomer().getName());

		}
	}

}
