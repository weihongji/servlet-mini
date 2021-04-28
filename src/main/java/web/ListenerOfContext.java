package web;

import com.jesse.db.*;

import javax.servlet.*;

public class ListenerOfContext implements ServletContextListener {
	public void contextInitialized(ServletContextEvent e) {
		ServletContext context = e.getServletContext();
		context.setAttribute("manager", createManager(e));
	}

	public void contextDestroyed(ServletContextEvent e) {
		closeManager(e.getServletContext());
	}

	private Manager createManager(ServletContextEvent e) {
		try {
			ServletContext context = e.getServletContext();
			String driver = context.getInitParameter("driver");
			String url = context.getInitParameter("url");
			String user = context.getInitParameter("user");
			String pwd = context.getInitParameter("pwd");
			Connector connector = new Connector(driver, url, user, pwd);
			Manager manager = new Manager(connector);
			System.out.println("DB connection manager created.");
			return manager;
		} catch (Exception ex) {
			System.out.println("Failed to create db manager:" + System.lineSeparator() + ex.getMessage());
		}
		return null;
	}

	public void closeManager(ServletContext context) {
		if (context.getAttribute("manager") != null) {
			try {
				Manager manager = (Manager) context.getAttribute("manager");
				manager.close();
				System.out.println("DB connection manager closed.");
			} catch (Exception ex) {
				System.out.println("Failed to close db manager:" + System.lineSeparator() + ex.getMessage());
			}
		}
	}
}
