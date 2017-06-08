package org.openmetromaps.pages;

import java.io.IOException;

import org.openmetromaps.BaseGenerator;

import de.topobyte.jsoup.ElementBuilder;
import de.topobyte.jsoup.HTML;
import de.topobyte.pagegen.core.Context;
import de.topobyte.webpaths.WebPath;

public class AboutGenerator extends BaseGenerator
{

	public AboutGenerator(Context context, WebPath path)
	{
		super(context, path);
	}

	@Override
	public void generate() throws IOException
	{
		super.generate();

		menu();

		content.ap(HTML.h1("Impressum"));

		content.appendText("Sebastian Kürten");
		content.ap(HTML.br());
		content.appendText("Siegfriedstr. 21");
		content.ap(HTML.br());
		content.appendText("12051 Berlin");
		content.ap(HTML.br());
		content.ap(HTML.br());
		content.appendText("Mail: ");
		content.ap(ElementBuilder.createAnchor(
				"mailto:sebastian@openmetromaps.org",
				"sebastian@openmetromaps.org"));

		footer();
	}

}
