package org.openmetromaps.pages;

import java.io.IOException;

import org.openmetromaps.BaseGenerator;
import org.openmetromaps.PathHelper;

import de.topobyte.jsoup.HTML;
import de.topobyte.jsoup.components.Div;
import de.topobyte.jsoup.components.Img;
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
		headline.attr("style",
				"display:block; font-family: 'Sans', serif; font-weight: normal; font-size: 36pt; text-align: center");

		Element slogan = content.ac(HTML.span());
		slogan.appendText("Free maps for rapid transit networks");
		slogan.attr("style",
				"display:block; font-weight: normal; text-align: center");

		mission();

		status();

		license();

		documentation();

		funding();

		footer();
	}

	private void mission()
	{
		content.ac(HTML.h1("Our mission"));

		content.appendText(
				"Schematic maps for public transportation networks are essential tools for orientation and navigation in cities.");
		content.appendText(
				" Unfortunately, these maps are usually proprietary resources that pose strong limits on what you are allowed to do with them.");
		content.appendText(
				" The owners of the material often charge a fee for displaying the content on websites, apps or printed material and they don't allow you to change anything on the map itself.");
		content.appendText(" This alone prevents creative use of these maps.");
		content.appendText(
				" Furthermore, you only get a PDF document – this makes interactive content hard to create.");
		content.appendText(
				" We're here to change that by providing open source tools and file formats for creating free schematic metro maps.");
	}

	private void status()
	{
		content.ac(HTML.h1("Project status"));

		Element status = content.ac(HTML.span());

		status.appendText("The project is in alpha stage.");
		status.appendText(
				" Things are still changing quickly and many things are not easy to use and fully functional yet.");
		status.appendText(
				" At this point, some expertise in programming is required to get involved with the project.");

		status.appendText(
				" To get an impression of what we're getting at, have a look at the ");
		status.ac(HTML.a(getLink(PathHelper.demo()), "Demo page"));
		status.appendText(".");

		status.appendText(" You can also follow us on ");
		status.ac(HTML.a("https://twitter.com/openmetromaps", "Twitter"));

		status.appendText(
				" or have a look at the contributions we submitted to the OpenStreetMap with ");
		status.ac(HTML.a("https://www.openstreetmap.org/user/OpenMetroMaps",
				"our OSM account"));
		status.appendText(". ");
	}

	private void license()
	{
		content.ac(HTML.h1("License"));

		Element license = content.ac(HTML.span());

		license.appendText("This is a free software project.");
		license.appendText(
				" All source code is released under the terms of the ");
		license.appendText("GNU Lesser General Public License (LGPL).");

		license.appendText(
				" For details, have a look at the terms of both the ");
		license.ac(
				HTML.a("https://www.gnu.org/licenses/lgpl-3.0.html", "LGPL"));
		license.appendText(" and the ");
		license.ac(HTML.a("https://www.gnu.org/licenses/gpl-3.0.html", "GPL"));
		license.appendText(".");

		license.appendText(" We're also producing free data");
		license.appendText(", which is published under the terms of the ");

		license.ac(HTML.a("https://opendatacommons.org/licenses/odbl/1.0/",
				"Open Database License (ODbL)"));
		license.appendText(".");

		license.appendText(
				" To understand what that means, have a look at the ");
		license.ac(HTML.a("https://opendatacommons.org/licenses/odbl/summary/",
				"plain language summary"));
		license.appendText(" of the ODbL.");
	}

	private void documentation()
	{
		content.ac(HTML.h1("Documentation"));

		content.appendText(
				"If you're interested in viewing maps, making your own maps or customizing existing ones, have a look at the ");
		content.ac(HTML.a(getLink(PathHelper.userGuide()), "User Guide"));
		content.appendText(".");

		content.appendText(
				" If you would like to help improve the software, read the ");
		content.ac(HTML.a(getLink(PathHelper.devGuide()), "Developer Guide"));
		content.appendText(".");

		content.appendText(" There's also a list of ");
		content.ac(HTML.a(getLink(PathHelper.faq()),
				"Frequently Asked Questions"));
		content.appendText(".");

		content.appendText(" Otherwise get in touch via the ");
		content.ac(HTML.a("https://www.freelists.org/list/openmetromaps",
				"Mailing List"));
		content.appendText(".");
	}

	private void funding()
	{
		content.ac(HTML.h1("Funding"));

		content.appendText("This project is currently funded by the");
		content.ac(
				HTML.a("https://okfn.de", "Open Knowledge Foundation Germany"));
		content.appendText(" via the");
		content.ac(HTML.a("https://prototypefund.de", "Prototype Fund"));
		content.appendText(", which is backed by the");
		content.ac(HTML.a("https://www.bmbf.de",
				"German Federal Ministry of Education and Resesarch"));
		content.appendText(".");

		Div div = content.ac(HTML.div());
		Img img = div.ac(HTML.img("images/BMBF_en.jpg"));
		img.attr("style", "height:16em;width:auto");
	}

}
