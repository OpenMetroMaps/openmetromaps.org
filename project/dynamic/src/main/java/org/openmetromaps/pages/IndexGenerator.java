package org.openmetromaps.pages;

import java.io.IOException;

import org.openmetromaps.BaseGenerator;

import de.topobyte.jsoup.HTML;
import de.topobyte.jsoup.Markdown;
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

		Markdown.renderResource(content, "markdown/index.md");

		funding();

		footer();
	}

	private void funding()
	{
		content.ac(HTML.h1("Funding"));

		content.appendText("This project is has been funded by the");
		content.ac(
				HTML.a("https://okfn.de", "Open Knowledge Foundation Germany"));
		content.appendText(" via the");
		content.ac(HTML.a("https://prototypefund.de", "Prototype Fund"));
		content.appendText(", which is backed by the");
		content.ac(HTML.a("https://www.bmbf.de",
				"German Federal Ministry of Education and Resesarch"));
		content.appendText(" from September 2017 until March 2018.");

		Div div = content.ac(HTML.div());
		Img img = div.ac(HTML.img("images/BMBF_en.jpg"));
		img.attr("style", "height:16em;width:auto");
	}

}
