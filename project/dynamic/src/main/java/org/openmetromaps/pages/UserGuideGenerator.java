package org.openmetromaps.pages;

import java.io.IOException;

import org.openmetromaps.BaseGenerator;

import de.topobyte.jsoup.HTML;
import de.topobyte.pagegen.core.Context;
import de.topobyte.webpaths.WebPath;

public class UserGuideGenerator extends BaseGenerator
{

	public UserGuideGenerator(Context context, WebPath path)
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
		content.ac(HTML.h1("User Guide"));

		content.appendText(
				" The desktop software is already in a partially usable state, however there are no installers available yet.");
		content.appendText(
				" Hence some familiarity with software development is still required to get the software running.");
	}

}
