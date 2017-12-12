package org.openmetromaps;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openmetromaps.pages.DemoGenerator;
import org.openmetromaps.pages.DeveloperGuideGenerator;
import org.openmetromaps.pages.FAQGenerator;
import org.openmetromaps.pages.IndexGenerator;
import org.openmetromaps.pages.MarkdownGenerator;

import de.topobyte.jsoup.ContentGeneratable;
import de.topobyte.jsoup.JsoupServletUtil;
import de.topobyte.webpaths.WebPath;
import de.topobyte.webpaths.WebPaths;

@WebServlet("/pages/*")
public class IndexServlet extends HttpServlet
{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		// Remove "/pages" prefix
		String uri = request.getRequestURI().substring(6);
		WebPath path = WebPaths.get(uri);
		int nc = path.getNameCount();

		System.out.println("URI: " + uri);
		System.out.println("Path: " + path);

		WebContext context = new WebContext();

		ContentGeneratable generator = null;
		if (nc < 1) {
			generator = new IndexGenerator(context, path);
		} else if (nc == 1 && !path.isDir()) {
			String first = path.getName(0);
			if (first.equals("about")) {
				generator = new MarkdownGenerator(context, path,
						"markdown/impressum.md");
			} else if (first.equals("demo")) {
				generator = new DemoGenerator(context, path);
			} else if (first.equals("mission")) {
				generator = new MarkdownGenerator(context, path,
						"markdown/mission.md");
			} else if (first.equals("user-guide")) {
				generator = new MarkdownGenerator(context, path,
						"markdown/user-guide.md");
			} else if (first.equals("developer-guide")) {
				generator = new DeveloperGuideGenerator(context, path);
			} else if (first.equals("faq")) {
				generator = new FAQGenerator(context, path);
			}
		}

		if (generator != null) {
			JsoupServletUtil.respond(response, generator);
		} else {
			ServletUtil.respond404(context, path, response);
		}
	}
}
