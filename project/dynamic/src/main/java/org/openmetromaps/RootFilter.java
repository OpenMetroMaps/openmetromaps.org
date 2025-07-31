package org.openmetromaps;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.topobyte.cachebusting.CacheBusting;
import de.topobyte.servlet.utils.Servlets;

@WebFilter("/*")
public class RootFilter implements Filter
{

	final static Logger logger = LoggerFactory.getLogger(RootFilter.class);

	private static Set<String> staticFiles = new HashSet<>();
	private static List<Pattern> staticPatternsNoCache = new ArrayList<>();
	private static List<String> staticPatterns = new ArrayList<>();

	static {
		staticPatterns.add("/client/");
		staticPatterns.add("/images/");
		staticPatternsNoCache.add(Pattern.compile(".*\\.cache.js"));
		for (String entry : CacheBusting.getValues()) {
			staticFiles.add("/" + entry);
		}
		staticFiles.add("/sticky-footer-navbar.css");
		staticFiles.add("/googleb4d9f938be253b7a.html");
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

			if (staticFiles.contains(path)) {
				HttpServletResponse r = (HttpServletResponse) response;
				r.setHeader("Cache-Control", "public, max-age=31536000");
				Servlets.forwardToDefault(request, response);
				return;
			}
			for (Pattern pattern : staticPatternsNoCache) {
				if (pattern.matcher(path).matches()) {
					HttpServletResponse r = (HttpServletResponse) response;
					r.setHeader("Cache-Control", "public, max-age=31536000");
					Servlets.forwardToDefault(request, response);
				}
			}
			for (String staticPrefix : staticPatterns) {
				if (path.startsWith(staticPrefix)) {
					Servlets.forwardToDefault(request, response);
					return;
				}
			}

			// Normalize multiple consecutive forward slashes to single slashes
			if (path.contains("//")) {
				String newUri = path.replaceAll("/+/", "/");
				((HttpServletResponse) response).sendRedirect(newUri);
				return;
			}

			request.setCharacterEncoding("UTF-8");
		}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy()
	{
	}

}
