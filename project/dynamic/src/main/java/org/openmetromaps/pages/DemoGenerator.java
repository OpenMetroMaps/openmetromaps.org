package org.openmetromaps.pages;

import java.io.IOException;

import org.openmetromaps.BaseGenerator;
import org.openmetromaps.Links;

import de.topobyte.jsoup.HTML;
import de.topobyte.jsoup.components.Img;
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

		intro();

		mapEditor();

		webViewer();

		fileFormat();

		footer();
	}

	private void intro()
	{
		content.ap(HTML.h1("Demo"));

		content.appendText(
				"The Berlin metro system is used as a testing ground for the components");
		content.appendText(" developed for OpenMetroMaps.");
		content.appendText(
				" The examples below feature the work-in-progress maps of Berlin.");
	}

	private void mapEditor()
	{
		content.ap(HTML.h2("Map Editor"));

		content.appendText("This is a screenshot of the ");
		content.ac(Links.github("OpenMetroMaps", "OpenMetroMaps",
				"#desktop-tools", "Map Editor"));
		content.appendText(", which is used");
		content.appendText(" for creating and editing maps:");

		Img image = content
				.ac(HTML.img("/images/map-editor.png", "Map Editor"));
		image.addClass("img-responsive");
	}

	private void webViewer()
	{
		content.ap(HTML.h2("Web Viewer"));

		content.appendText("Here are links to instances of the ");
		content.ac(Links.github("OpenMetroMaps", "OpenMetroMaps", "#web-viewer",
				"JavaScript view"));
		content.appendText(":");

		UnorderedList list = content.ac(HTML.ul());
		list.addItem(HTML.a("http://demo.openmetromaps.org/schematic.html",
				"Berlin, schematic"));
		list.addItem(HTML.a("http://demo.openmetromaps.org/geographic.html",
				"Berlin, geographic"));
	}

	private void fileFormat()
	{
		content.ap(HTML.h2("File Format"));

		content.appendText("One major goal of OpenMetroMaps is to define a");
		content.appendText(" file format for storing metro maps.");
		content.appendText(" The current draft is a relatively simple");
		content.appendText(" XML-based document.");
		content.appendText(" It has not been formally specified yet,");
		content.appendText(" but there are existing files and running code");
		content.appendText(" that reads and writes data in such a format.");
		content.appendText(
				" Have a look at this example document from the main repository:");

		content.ac(Links.github("OpenMetroMaps", "OpenMetroMaps",
				"/blob/master/java/test-data/src/main/resources/berlin.xml",
				"berlin.xml"));
	}

}
