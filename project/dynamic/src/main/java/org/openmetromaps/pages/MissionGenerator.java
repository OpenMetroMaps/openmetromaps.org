package org.openmetromaps.pages;

import java.io.IOException;

import org.openmetromaps.BaseGenerator;

import de.topobyte.jsoup.HTML;
import de.topobyte.jsoup.components.P;
import de.topobyte.pagegen.core.Context;
import de.topobyte.webpaths.WebPath;

public class MissionGenerator extends BaseGenerator
{

	public MissionGenerator(Context context, WebPath path)
	{
		super(context, path);
	}

	@Override
	public void generate() throws IOException
	{
		super.generate();

		menu();

		content();

		footer();
	}

	private void content()
	{
		content.ac(HTML.h1("Our mission"));

		P p = content.ac(HTML.p());
		p.appendText(
				"Schematic maps for public transportation networks are essential tools for orientation and navigation in cities.");
		p.appendText(
				" Unfortunately, these maps are usually proprietary resources that pose strong limits on what you are allowed to do with them.");
		p.appendText(
				" The owners of the material often charge a fee for displaying the content on websites, apps or printed material and they don't allow you to change anything on the map itself.");
		p.appendText(" This alone prevents creative use of these maps.");
		p.appendText(
				" Furthermore, you only get a PDF document – this makes interactive content hard to create.");
		p.appendText(
				" We're here to change that by providing open source tools and file formats for creating free schematic metro maps.");

		p = content.ac(HTML.p());
		p.appendText("Free maps are important.");

		p = content.ac(HTML.p());
		p.appendText("Creating maps is hard. It shouldn't be though.");

		p = content.ac(HTML.p());
		p.appendText(
				"In many cities and regions, there are no maps available at all!");

		p = content.ac(HTML.p());
		p.appendText(
				"Interactive maps allow new applications and increase their value to the users.");
	}

}
