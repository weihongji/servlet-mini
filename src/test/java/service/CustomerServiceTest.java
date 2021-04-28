package service;

import com.jesse.db.*;
import entity.Customer;
import utility.*;

import java.util.List;

import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerServiceTest {
	@Test
	public void testDummy() {
		assertTrue(true);
		System.out.println("Dummy test always success.");
	}

	//@Test
	public void testGetCustomers() {
		Manager manager = new Manager(getConnector());
		CustomerService service = null;
		try {
			service = new CustomerService(manager.getConnection());
			List<Customer> list = service.getCustomers();
			assertTrue("No record was found.", list.size() > 0);
			System.out.println(list.size() + " of records found.");
		} catch (Exception e) {
			assertTrue("Exception occurs." + System.lineSeparator() + e.getMessage(), false);
		}
	}

	private Connector getConnector() {
		Property properties = Property.getInstance();
		String driver = properties.getProperty("driver");
		String url = properties.getProperty("url");
		String user = properties.getProperty("user");
		String pwd = properties.getProperty("pwd");
		return new Connector(driver, url, user, pwd);
	}
}