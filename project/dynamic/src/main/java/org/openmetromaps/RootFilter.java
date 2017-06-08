package org.openmetromaps;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebFilter("/*")
public class RootFilter implements Filter
{

	final static Logger logger = LoggerFactory.getLogger(RootFilter.class);

	private static List<String> statics = new ArrayList<>();

	static {
		statics.add("/bower/");
		statics.add("/images/");
		statics.add("/custom.css");
		statics.add("/sticky-footer-navbar.css");
		statics.add("/googleb4d9f938be253b7a.html");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException
	{
		// nothing to do here
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException
	{
		if (request instanceof HttpServletRequest) {
			HttpServletRequest hsr = (HttpServletRequest) request;

			String path = hsr.getRequestURI();

			for (String staticPrefix : statics) {
				if (path.startsWith(staticPrefix)) {
					chain.doFilter(request, response);
					return;
				}
			}

			request.getRequestDispatcher("/pages" + path).forward(request,
					response);
			return;
		}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy()
	{
	}

}
