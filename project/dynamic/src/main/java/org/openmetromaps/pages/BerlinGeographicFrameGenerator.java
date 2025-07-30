package org.openmetromaps.pages;

import java.io.IOException;

import org.openmetromaps.BaseGenerator;

import de.topobyte.jsoup.HTML;
import de.topobyte.jsoup.components.Div;
import de.topobyte.jsoup.components.Script;
import de.topobyte.webpaths.WebPath;

public class BerlinGeographicFrameGenerator extends BaseGenerator
{

	public BerlinGeographicFrameGenerator(WebPath path)
	{
		super(path);
	}

	@Override
	public void generate() throws IOException
	{
		super.generate();

		Script script = builder.getHead().ac(HTML.script());
		script.attr("type", "text/javascript").attr("language", "javascript")
				.attr("src",
						// "client/scrollable_advanced/scrollable_advanced.nocache.js");
						"client/demo/demo.nocache.js");

		Div gwt = content.ac(HTML.div());
		gwt.attr("id", "gwt");
		// gwt.attr("style",
		// "position:absolute;top:4em;bottom:0;left:0;right:0");

		Div params = content.ac(HTML.div());
		params.attr("id", "parameters").attr("style", "visibility:hidden");
		params.ac(HTML.div().attr("id", "file")
				.at("/client/berlin/geographic.xml"));
		params.ac(HTML.div().attr("id", "debug-size").at("false"));
	}

}
