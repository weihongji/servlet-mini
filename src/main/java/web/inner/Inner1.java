package web.inner;

import com.jesse.db.Manager;
import web.DB;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Inner1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("contextpath", getServletContext().getContextPath());
		request.setAttribute("pathinfo", request.getPathInfo());
		request.setAttribute("servletpath", request.getServletPath());
		request.setAttribute("uri", request.getRequestURI());
		request.setAttribute("url", request.getRequestURL().toString());
		request.setAttribute("qs", request.getQueryString());

		if (DB.getManager(request) != null) {
			Manager manager = DB.getManager(request);
			request.setAttribute("managerstatus", manager.getStatus().replace(System.lineSeparator(), "<br/>" + System.lineSeparator()));
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/inner/inner1.jsp");
		dispatcher.forward(request, response);
	}
}
