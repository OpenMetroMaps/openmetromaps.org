package org.openmetromaps.pages;

import java.io.IOException;

import org.openmetromaps.BaseGenerator;

import de.topobyte.jsoup.HTML;
import de.topobyte.jsoup.components.A;
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
		headline.attr(
				"style",
				"display:block; font-family: 'Sans', serif; font-weight: normal; font-size: 36pt; text-align: center");

		Element slogan = content.ac(HTML.span());
		slogan.appendText("Free maps for rapid transit networks");
		slogan.attr("style",
				"display:block; font-weight: normal; text-align: center");

		content.ac(HTML.h1("Get in touch"));

		Element stuff = content.ac(HTML.span());
		stuff.appendText("Our code is hosted on ");
		A linkGithub = stuff.ac(HTML.a("https://github.com/OpenMetroMaps"));
		linkGithub.appendText("GitHub");
		stuff.appendText(". ");

		stuff.appendText("You can follow us on ");
		A linkTwitter = stuff.ac(HTML.a("https://twitter.com/openmetromaps"));
		linkTwitter.appendText("Twitter");

		stuff.appendText(" or have a look at the contributions we submitted to the OpenStreetMap with ");
		A linkOsmProfile = stuff.ac(HTML
				.a("https://www.openstreetmap.org/user/OpenMetroMaps"));
		linkOsmProfile.appendText("our OSM account");
		stuff.appendText(". ");

		stuff.appendText("There's also a ");
		A linkMailingList = stuff.ac(HTML
				.a("https://www.freelists.org/list/openmetromaps"));
		linkMailingList.appendText("Mailing List");
		stuff.appendText(" that you can subscribe to if you want to participate in discussions around the project.");

		content.ac(HTML.h1("What's this?"));

		content.appendText("Schematic maps for public transportation networks are essential tools for orientation and navigation in cities.");
		content.appendText(" Unfortunately, these maps are usually proprietary resources that pose strong limits on what you are allowed to do with them.");
		content.appendText(" The owners of the material often charge a fee for displaying the content on websites, apps or printed material and they don't allow you to change anything on the map itself.");
		content.appendText(" This alone prevents creative use of these maps.");
		content.appendText(" Furthermore, you only get a PDF document – this makes interactive content hard to create.");
		content.appendText(" We're here to change that by providing tools and file formats for creating free schematic metro maps.");

		content.ac(HTML.h1("Funding"));

		A linkPF = stuff.ac(HTML.a("https://prototypefund.de"));
		linkPF.appendText("Prototype Fund");

		A linkOKFN = stuff.ac(HTML.a("https://okfn.de"));
		linkOKFN.appendText("Open Knowledge Foundation Germany");

		A linkBMBF = stuff.ac(HTML.a("https://www.bmbf.de"));
		linkBMBF.appendText("German Federal Ministry of Education and Resesarch");

		content.appendText("This project is funded by the");
		content.ap(linkOKFN);
		content.appendText(" via the");
		content.ap(linkPF);
		content.appendText(", which is backed by the");
		content.ap(linkBMBF);
		content.appendText(".");

		Div div = content.ac(HTML.div());
		Img img = div.ac(HTML.img("images/BMBF_en.jpg"));
		img.attr("style", "height:16em;width:auto");

		footer();
	}

}
