package org.openmetromaps.pages;

import java.io.IOException;

import org.openmetromaps.BaseGenerator;

import de.topobyte.jsoup.HTML;
import de.topobyte.jsoup.components.IFrame;
import de.topobyte.webpaths.WebPath;

public class BerlinGeographicGenerator extends BaseGenerator
{

	public BerlinGeographicGenerator(WebPath path)
	{
		super(path);
	}

	@Override
	public void generate() throws IOException
	{
		super.generate();

		menu();

		IFrame frame = content.ac(HTML.iframe());
		frame.attr("src", "/berlin-frame").attr("style",
				"width: 100%; height: 80vh");

		footer();
	}

}
