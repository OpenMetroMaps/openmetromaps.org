package org.openmetromaps.pages;

import java.io.IOException;

import org.openmetromaps.BaseGenerator;
import org.openmetromaps.Website;

import de.topobyte.jsoup.HTML;
import de.topobyte.jsoup.Markdown;
import de.topobyte.jsoup.components.Div;
import de.topobyte.jsoup.components.Img;
import de.topobyte.jsoup.components.Span;
import de.topobyte.webgun.util.CacheBuster;
import de.topobyte.webpaths.WebPath;

public class IndexGenerator extends BaseGenerator
{

	public IndexGenerator(WebPath path)
	{
		super(path);
	}

	@Override
	public void generate() throws IOException
	{
		super.generate();

		menu();

		Span headline = content.ac(HTML.span());
		headline.appendText("Open Metro Maps");
		headline.attr("style",
				"display:block; font-family: 'Sans', serif; font-weight: normal; font-size: 36pt; text-align: center");

		Span slogan = content.ac(HTML.span());
		slogan.appendText("Free maps for rapid transit networks");
		slogan.attr("style",
				"display:block; font-weight: normal; text-align: center");

		Markdown.renderResource(content, "markdown/index.md");

		funding();

		footer();
	}

	private void funding() throws IOException
	{
		CacheBuster cacheBuster = Website.INSTANCE.getCacheBuster();

		content.ac(HTML.h1("Funding"));

		content.ac(HTML.h2("Current Funding"));

		Markdown.renderResource(content, "markdown/funding-current.md");

		content.ac(HTML.h2("Past Funding"));

		Markdown.renderResource(content, "markdown/funding-prototype-fund.md");

		Div div = content.ac(HTML.div());
		Img img = div.ac(HTML.img(cacheBuster.resolve("images/BMBF_en.jpg")));
		img.attr("style", "height:16em;width:auto");
	}

}
