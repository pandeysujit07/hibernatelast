package test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import com.lti.dao.GenericDao;
import com.lti.entity.Order;
import com.lti.entity.Payment;

import model.Customer;

public class PaymentTest {

	@Test
	public void testAdd() {
		
		GenericDao dao = new GenericDao();
		Payment pay=new Payment();
		Order or=(Order) dao.fetchById(Order.class,61);
		
		pay.setMod("Cash");
		pay.setStatus("Paid");
		pay.setAmount(5000);
		pay.setOrder(or);
		dao.insertOrUpdate(pay);
	}
	
	/*@Test
	public void linkOrderandPayment() {
		
		GenericDao dao=new GenericDao();
		Order o=(Order)dao.fetchById(Order.class, 61);
		Payment p=(Payment)dao.fetchById(Payment.class, 81);
		p.setOrder(o);
		dao.insertOrUpdate(o);
	}*/

}
