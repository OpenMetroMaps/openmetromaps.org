package org.openmetromaps;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openmetromaps.pages.FAQGenerator;
import org.openmetromaps.pages.IndexGenerator;
import org.openmetromaps.pages.MarkdownGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.topobyte.jsoup.ContentGeneratable;
import de.topobyte.jsoup.JsoupServletUtil;
import de.topobyte.webpaths.WebPath;
import de.topobyte.webpaths.WebPaths;

@WebServlet("/pages/*")
public class IndexServlet extends HttpServlet
{

	final static Logger logger = LoggerFactory.getLogger(IndexServlet.class);

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		// Remove "/pages" prefix
		String uri = request.getRequestURI().substring(6);
		WebPath path = WebPaths.get(uri);
		int nc = path.getNameCount();

		logger.info("URI: " + uri);
		logger.info("Path: " + path);

		WebContext context = new WebContext();

		ContentGeneratable generator = null;
		if (nc < 1) {
			generator = new IndexGenerator(context, path);
		} else if (nc == 1 && !path.isDir()) {
			String first = path.getName(0);
			if (first.equals("demo")) {
				generator = new MarkdownGenerator(context, path,
						"markdown/demo.md");
			} else if (first.equals("mission")) {
				generator = new MarkdownGenerator(context, path,
						"markdown/mission.md");
			} else if (first.equals("user-guide")) {
				generator = new MarkdownGenerator(context, path,
						"markdown/user-guide.md");
			} else if (first.equals("developer-guide")) {
				generator = new MarkdownGenerator(context, path,
						"markdown/developer-guide.md");
			} else if (first.equals("mailing-list")) {
				generator = new MarkdownGenerator(context, path,
						"markdown/mailing-list.md");
			} else if (first.equals("imprint")) {
				generator = new MarkdownGenerator(context, path,
						"markdown/impressum.md");
			} else if (first.equals("privacy-policy")) {
				generator = new MarkdownGenerator(context, path,
						"markdown/privacy-policy.md");
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
