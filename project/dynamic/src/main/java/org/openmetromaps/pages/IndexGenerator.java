package org.openmetromaps.pages;

import java.io.IOException;

import org.openmetromaps.BaseGenerator;

import de.topobyte.jsoup.HTML;
import de.topobyte.jsoup.components.Div;
import de.topobyte.jsoup.components.Img;
import de.topobyte.jsoup.components.ListItem;
import de.topobyte.jsoup.components.UnorderedList;
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

		projectStatus();

		userGuide();

		developerGuide();

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

	private void projectStatus()
	{
		content.ac(HTML.h1("Project status"));

		Element stuff = content.ac(HTML.span());

		stuff.appendText("The project is in alpha stage.");
		stuff.appendText(
				" Things are still changing quickly and many things are not easy to use and fully functional yet.");
		stuff.appendText(
				" At this point, some expertise in programming is required to get involved with the project.");

		stuff.appendText(" You can follow us on ");
		stuff.ac(HTML.a("https://twitter.com/openmetromaps", "Twitter"));

		stuff.appendText(
				" or have a look at the contributions we submitted to the OpenStreetMap with ");
		stuff.ac(HTML.a("https://www.openstreetmap.org/user/OpenMetroMaps",
				"our OSM account"));
		stuff.appendText(". ");
	}

	private void userGuide()
	{
		content.ac(HTML.h1("User Guide"));

		content.appendText(
				" The desktop software is already in a partially usable state, however there are no installers available yet.");
		content.appendText(
				" Hence some familiarity with software development is still required to get the software running.");
	}

	private void developerGuide()
	{
		content.ac(HTML.h1("Developer Guide"));

		UnorderedList list = content.ac(HTML.ul());

		UnorderedList github = content.ac(HTML.ul());
		ListItem itemGithub = list.addItem();
		itemGithub.appendText("We use GitHub to coordinate development:");
		itemGithub.ac(github);

		github.addItem().appendText("The main repository for soure code: ")
				.ap(HTML.a("https://github.com/OpenMetroMaps/OpenMetroMaps",
						"OpenMetroMaps/OpenMetroMaps"));
		github.addItem().appendText("An organization for data projects: ")
				.ap(HTML.a("https://github.com/OpenMetroMapsData",
						"OpenMetroMapsData"));
		github.addItem().appendText("We use ")
				.ap(HTML.a(
						"https://github.com/OpenMetroMaps/OpenMetroMaps/issues",
						"GitHub issues"))
				.appendText(" as a Bug Tracker");
		list.addItem().appendText("Subscribe to the ")
				.ap(HTML.a("https://www.freelists.org/list/openmetromaps",
						"Mailing List"))
				.appendText(
						" to participate in discussions around the project");
	}

	private void funding()
	{
		content.ac(HTML.h1("Funding"));

		content.appendText("This project is funded by the");
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
