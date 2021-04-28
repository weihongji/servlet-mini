package web;

import com.jesse.db.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;

public class DB {
	private static Manager manager = null;

	public static Manager getManager(ServletContext context) {
		if (manager != null) {
			return manager;
		}
		if (context != null && context.getAttribute("manager") != null) {
			manager = (Manager) context.getAttribute("manager");
			return manager;
		}
		return  null;
	}

	public static Manager getManager(HttpServletRequest request) {
		if (request == null) {
			return  null;
		}
		return getManager(request.getServletContext());
	}

	public static Connection getConnection(ServletContext context) {
		Manager m = getManager(context);
		if (m != null) {
			try {
				return m.getConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public static Connection getConnection(HttpServletRequest request) {
		if (request == null) {
			return null;
		}
		return getConnection(request.getServletContext());
	}
}
