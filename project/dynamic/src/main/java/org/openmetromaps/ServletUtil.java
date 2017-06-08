package org.openmetromaps;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.function.Consumer;

import javax.servlet.http.HttpServletResponse;

import org.jsoup.nodes.Document;

import de.topobyte.jsoup.nodes.Element;
import de.topobyte.pagegen.core.Context;
import de.topobyte.webpaths.WebPath;

public class ServletUtil
{

	public static void respond404(Context context, WebPath output,
			HttpServletResponse response) throws IOException
	{
		respond(404, context, output, response, content -> {
			ErrorUtil.write404(content);
		});
	}

	public static void respond404(Context context, WebPath output,
			HttpServletResponse response, Consumer<Element> contentGenerator)
			throws IOException
	{
		respond(404, context, output, response, contentGenerator);
	}

	public static void respond(int code, Context context, WebPath output,
			HttpServletResponse response, Consumer<Element> contentGenerator)
			throws IOException
	{
		response.setStatus(code);

		response.setCharacterEncoding("UTF-8");

		PrintWriter writer = response.getWriter();

		ErrorGenerator generator = new ErrorGenerator(context, output);
		generator.generate();
		Element content = generator.getContent();

		contentGenerator.accept(content);

		Document document = generator.getBuilder().getDocument();
		writer.write(document.toString());

		writer.close();
	}

}
