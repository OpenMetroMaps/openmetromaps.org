package org.openmetromaps;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openmetromaps.pages.FAQGenerator;
import org.openmetromaps.pages.IndexGenerator;
import org.openmetromaps.pages.MapGenerator;
import org.openmetromaps.pages.MarkdownGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.topobyte.jsoup.ContentGeneratable;
import de.topobyte.jsoup.JsoupServletUtil;
import de.topobyte.webgun.exceptions.WebStatusException;
import de.topobyte.webpaths.WebPath;
import de.topobyte.webpaths.WebPaths;

@WebServlet("/*")
public class IndexServlet extends HttpServlet
{

	final static Logger logger = LoggerFactory.getLogger(IndexServlet.class);

	private static final long serialVersionUID = 1L;

	private interface Responder<T>
	{

		public void respond(int code, WebPath output,
				HttpServletResponse response, T data) throws IOException;

	}

	private <T> void tryGenerate(HttpServletResponse response, WebPath path,
			ContentGeneratable generator, Responder<T> responder, T data)
			throws IOException
	{
		if (generator != null) {
			try {
				JsoupServletUtil.respond(response, generator);
			} catch (WebStatusException e) {
				responder.respond(e.getCode(), path, response, data);
			}
		} else {
			responder.respond(404, path, response, data);
		}

	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		String uri = URLDecoder.decode(request.getRequestURI(), "UTF-8");
		WebPath path = WebPaths.get(uri);
		int nc = path.getNameCount();

		logger.info("URI: " + uri);
		logger.info("Path: " + path);

		ContentGeneratable generator = null;
		if (nc < 1) {
			generator = new IndexGenerator(path);
		} else if (nc == 1 && !path.isDir()) {
			String first = path.getName(0);
			if (first.equals("demo")) {
				generator = new MarkdownGenerator(path, "markdown/demo.md");
			} else if (first.equals("mission")) {
				generator = new MarkdownGenerator(path, "markdown/mission.md");
			} else if (first.equals("user-guide")) {
				generator = new MarkdownGenerator(path,
						"markdown/user-guide.md");
			} else if (first.equals("developer-guide")) {
				generator = new MarkdownGenerator(path,
						"markdown/developer-guide.md");
			} else if (first.equals("mailing-list")) {
				generator = new MarkdownGenerator(path,
						"markdown/mailing-list.md");
			} else if (first.equals("imprint")) {
				generator = new MarkdownGenerator(path,
						"markdown/impressum.md");
			} else if (first.equals("privacy-policy")) {
				generator = new MarkdownGenerator(path,
						"markdown/privacy-policy.md");
			} else if (first.equals("faq")) {
				generator = new FAQGenerator(path);
			}
		} else if (nc == 3 && !path.isDir()) {
			String first = path.getName(0);
			String second = path.getName(1);
			String third = path.getName(2);
			if (first.equals("demo")) {
				if (second.equals("berlin") && third.equals("geographic")) {
					generator = new MapGenerator(path, second, third);
				} else if (second.equals("berlin")
						&& third.equals("schematic")) {
					generator = new MapGenerator(path, second, third);
				} else if (second.equals("berlin")
						&& third.equals("nicknames")) {
					generator = new MapGenerator(path, second, third);
				} else if (second.equals("vienna")
						&& third.equals("geographic")) {
					generator = new MapGenerator(path, second, third);
				} else if (second.equals("vienna")
						&& third.equals("schematic")) {
					generator = new MapGenerator(path, second, third);
				}
			}
		}

		tryGenerate(response, path, generator, ServletUtil::respond,
				(Void) null);
	}
}
