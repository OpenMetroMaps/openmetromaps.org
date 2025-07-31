package org.openmetromaps.widgets;

import static de.topobyte.jsoup.ElementBuilder.script;

import de.topobyte.cachebusting.CacheBusting;
import de.topobyte.jsoup.HTML;
import de.topobyte.jsoup.HtmlBuilder;
import de.topobyte.jsoup.components.Div;
import de.topobyte.jsoup.nodes.Element;

public class Map
{

	public static void setupHead(HtmlBuilder builder)
	{
		builder.getHead().ac(script("/client/demo/demo.nocache.js"));
		builder.getHead().ac(script("/" + CacheBusting.resolve("script.js")));
	}

	public static void widget(Element<?> content, String file)
	{
		Div div = content.ac(HTML.div());
		div.attr("id", "gwt");
		div.attr("style", "position:relative;height:600px");

		Div params = content.ac(HTML.div());
		params.attr("id", "parameters");
		params.attr("style", "display:none");
		addParameter(params, "file", file);
		addParameter(params, "debug-size", "false");
	}

	private static void addParameter(Div params, String name, String value)
	{
		Div div = params.ac(HTML.div());
		div.attr("id", name);
		div.text(value);
	}

}
