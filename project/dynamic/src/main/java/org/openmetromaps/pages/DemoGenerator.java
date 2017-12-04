package org.openmetromaps.pages;

import java.io.IOException;

import org.openmetromaps.BaseGenerator;

import de.topobyte.jsoup.HTML;
import de.topobyte.jsoup.components.UnorderedList;
import de.topobyte.pagegen.core.Context;
import de.topobyte.webpaths.WebPath;

public class DemoGenerator extends BaseGenerator
{

	public DemoGenerator(Context context, WebPath path)
	{
		super(context, path);
	}

	@Override
	public void generate() throws IOException
	{
		super.generate();

		menu();

		content.ap(HTML.h1("Demo"));

		content.appendText(
				"The Berlin metro system is a used as a testing environment");
		content.appendText(" for OpenMetroMaps.");
		content.appendText(
				" You can have a look at the work-in-progress maps of Berlin here:");

		UnorderedList list = content.ac(HTML.ul());
		list.addItem(HTML.a("http://demo.openmetromaps.org/schematic.html",
				"Berlin, schematic"));
		list.addItem(HTML.a("http://demo.openmetromaps.org/geographic.html",
				"Berlin, geographic"));

		footer();
	}

}
