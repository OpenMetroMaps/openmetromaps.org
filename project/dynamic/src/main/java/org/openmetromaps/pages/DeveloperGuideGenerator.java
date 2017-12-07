package org.openmetromaps.pages;

import java.io.IOException;

import org.openmetromaps.BaseGenerator;
import org.openmetromaps.Links;

import de.topobyte.jsoup.HTML;
import de.topobyte.jsoup.components.ListItem;
import de.topobyte.jsoup.components.UnorderedList;
import de.topobyte.pagegen.core.Context;
import de.topobyte.webpaths.WebPath;

public class DeveloperGuideGenerator extends BaseGenerator
{

	public DeveloperGuideGenerator(Context context, WebPath path)
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
		content.ac(HTML.h1("Developer Guide"));

		UnorderedList list = content.ac(HTML.ul());

		UnorderedList github = content.ac(HTML.ul());
		ListItem itemGithub = list.addItem();
		itemGithub.appendText("We use GitHub to coordinate development:");
		itemGithub.ac(github);

		github.addItem().appendText("The main repository for soure code: ")
				.ap(Links.github("OpenMetroMaps", "OpenMetroMaps"));
		github.addItem().appendText("This website's code: ")
				.ap(Links.github("OpenMetroMaps", "openmetromaps.org"));
		github.addItem().appendText("An organization for data projects: ")
				.ap(Links.github("OpenMetroMapsData"));
		github.addItem()
				.appendText("We use ").ap(Links.github("OpenMetroMaps",
						"OpenMetroMaps", "/issues", "GitHub issues"))
				.appendText(" as a Bug Tracker");
		list.addItem().appendText("Subscribe to the ")
				.ap(HTML.a("https://www.freelists.org/list/openmetromaps",
						"Mailing List"))
				.appendText(
						" to participate in discussions around the project");

		gettingStarted();
	}

	private void gettingStarted()
	{
		content.ac(HTML.h1("Getting Started"));

		content.appendText("As a first step, we recommend to get the desktop ");
		content.appendText(" tools running. How to do this ");
		content.ap(Links.github("OpenMetroMaps", "OpenMetroMaps",
				"/blob/master/java/README.md", "is described here in detail"));
		content.appendText(".");
	}

}
