package org.openmetromaps;

import org.jsoup.nodes.Element;

import de.topobyte.jsoup.HTML;

public class ErrorUtil
{

	public static void write404(Element content)
	{
		content.appendChild(HTML.h1().text("Page not found"));
		content.appendText("That's an error (404)");
	}

	public static void writeError(Element content)
	{
		content.appendChild(HTML.h1().text("Something went wrong"));
		content.appendText("That's an error");
	}

}
