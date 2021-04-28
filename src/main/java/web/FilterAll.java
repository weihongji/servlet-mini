package web;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class FilterAll implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		request.setCharacterEncoding("utf-8");
		request.setAttribute("relative", getRelativePath(request));
		filterChain.doFilter(request, servletResponse);
	}

	private String getRelativePath(HttpServletRequest request) {
		String result = "";
		String path = request.getServletPath().substring(1);
		int n = path.length() - path.replace("/", "").length();
		for (int i = 0; i < n; i++) {
			result += "../";
		}
		if (result.length() == 0) {
			result = request.getContextPath() + "/";
		}
		return result;
	}

	@Override
	public void destroy() {

	}
}
