package org.openmetromaps.pages;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.openmetromaps.BaseGenerator;
import org.openmetromaps.Markdown;

import de.topobyte.pagegen.core.Context;
import de.topobyte.webpaths.WebPath;

public class AboutGenerator extends BaseGenerator
{

	public AboutGenerator(Context context, WebPath path)
	{
		super(context, path);
	}

	@Override
	public void generate() throws IOException
	{
		super.generate();

		menu();

		InputStream input = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("markdown/impressum.md");
		String markdown = IOUtils.toString(input, StandardCharsets.UTF_8);

		Markdown.generate(content, markdown);

		footer();
	}

}
