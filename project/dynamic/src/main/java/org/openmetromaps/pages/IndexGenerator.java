package org.openmetromaps.pages;

import java.io.IOException;

import org.openmetromaps.BaseGenerator;

import de.topobyte.jsoup.HTML;
import de.topobyte.jsoup.nodes.Element;
import de.topobyte.pagegen.core.Context;
import de.topobyte.webpaths.WebPath;

public class IndexGenerator extends BaseGenerator
{

	public IndexGenerator(Context context, WebPath path)
	{
		super(context, path);
	}

	@Override
	public void generate() throws IOException
	{
		super.generate();

		menu();

		Element headline = content.ac(HTML.span());
		headline.appendText("Open Metro Maps");
		headline.attr(
				"style",
				"display:block; font-family: 'Sans', serif; font-weight: normal; font-size: 36pt; text-align: center");

		Element slogan = content.ac(HTML.span());
		slogan.appendText("Free maps for rapid transit networks");
		slogan.attr("style",
				"display:block; font-weight: normal; text-align: center");

		content.ac(HTML.h1("Coming soon..."));

		footer();
	}

}
