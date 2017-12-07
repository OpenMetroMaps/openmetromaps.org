package org.openmetromaps.pages;

import java.io.IOException;

import org.openmetromaps.BaseGenerator;

import de.topobyte.jsoup.HTML;
import de.topobyte.jsoup.components.P;
import de.topobyte.jsoup.components.Span;
import de.topobyte.jsoup.nodes.Element;
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
		p.inner("Schematic maps for public transportation networks are"
				+ " essential tools for orientation and navigation in cities.");
		p.inner(" Unfortunately, these maps are usually proprietary"
				+ " resources that pose strong limits on what you are"
				+ " allowed to do with them.");
		p.inner(" The owners of the material often charge a fee for"
				+ " displaying the content on websites, apps or printed"
				+ " material and they don't allow you to change anything"
				+ " on the map itself.");
		p.inner(" This alone prevents creative use of these maps.");
		p.inner(" Furthermore, you only get a PDF document – this makes"
				+ " interactive content hard to create.");
		p.inner(" We're here to change that by providing open source tools"
				+ " and file formats for creating free schematic metro maps.");

		String urlArticleManagua = "https://qz.com/742755/nicaraguans-are-using-crowdsourcing-technology-to-prove-that-a-good-map-can-change-your-life/";

		p = content.ac(HTML.p());
		p.ac(bold(
				"In many cities and regions, there are no maps available at all!"));
		p.appendText(" As ");
		p.ac(HTML.a(urlArticleManagua, "this article"));
		p.inner(" about a mapping project in Managua, Nicaragua");
		p.inner(" points out, the situation is pretty chaotic in");
		p.inner(" some regions.");
		p.inner(" When the local transportation organizations do not");
		p.inner(" provide a map, it is pretty useful if the users of");
		p.inner(" the transit network can collaborate on creating a map");
		p.inner(" on their own.");

		p = content.ac(HTML.p());
		p.ac(bold("Free maps are important."));
		p.inner(" Although maps are available");
		p.inner(" for hundreds of transit networks, it does make a");
		p.inner(" difference if the maps are free.");
		p.inner(" People can get creative and start producing unexpected");
		p.inner(" material. We've seen these things happen in various");
		p.inner(" Open Source and Open Data projects in the past.");

		p = content.ac(HTML.p());
		p.ac(bold("Creating maps is hard."));
		p.inner(" It shouldn't be though.");
		p.inner(" One should not need to be a professional graphics");
		p.inner(" designer in order to create a custom version of a");
		p.inner(" transit map.");
		p.inner(" Nor should it require non-free software.");

		p = content.ac(HTML.p());
		p.ac(bold("Interactive maps allow new applications and increase"
				+ " their value to the users."));
		p.inner(" From what we've seen, there are not many interactive");
		p.inner(" applications for transit maps yet.");
		p.inner(" We believe there's potential for new types of interfaces");
		p.inner(" and ways to interact with maps.");
		p.inner(" Traditional file formats for images and documents");
		p.inner(" don't offer much support for such interaction.");
	}

	private Element bold(String text)
	{
		Span span = HTML.span();
		span.attr("style", "font-weight:bold");
		span.appendText(text);
		return span;
	}

}
