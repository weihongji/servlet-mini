package web;

import entity.Customer;
import service.CustomerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

public class Page2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try (Connection connection = DB.getConnection(request)) {
			CustomerService service = new CustomerService(connection);
			int id = Integer.parseInt(request.getParameter("id"));
			Customer item = service.getCustomer(id);
			request.setAttribute("item", item);
		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/page2.jsp");
		dispatcher.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("message", request.getParameter("name") + " is saved");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/page3.jsp");
		dispatcher.forward(request, response);
	}
}
