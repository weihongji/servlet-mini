package service;

import entity.Customer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {
	private Connection connection;
	private DBType DbType = DBType.MySQL;

	public CustomerService(Connection connection) {
		this.connection = connection;
		try {
			if (connection != null && connection.getSchema() != null && connection.getSchema().equals("dbo")) {
				DbType = DBType.SQLServer;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Customer getCustomer(int id) {
		Customer item = null;
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from customer where id = " + id);
			if (rs.next()) {
				item = new Customer(rs.getInt("id"), rs.getString("name"));
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return item;
	}

	public List<Customer> getCustomers() {
		return getCustomers("");
	}

	public List<Customer> getCustomers(String name) {
		List<Customer> list = new ArrayList<>();
		try {
			Statement stmt = connection.createStatement();
			String sql = "select * from customer order by id";
			if (name != null && name.trim().length() > 0) {
				if (DbType == DBType.SQLServer) {
					sql = "select * from customer where name like N'%" + name + "%' order by id";
				}
				else {
					sql = "select * from customer where name like '%" + name + "%' order by id";
				}
			}
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Customer item = new Customer(rs.getInt("id"), rs.getString("name"));
				list.add(item);
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
