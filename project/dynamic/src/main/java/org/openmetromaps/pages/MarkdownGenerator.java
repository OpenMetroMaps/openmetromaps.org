package org.openmetromaps.pages;

import java.io.IOException;

import org.openmetromaps.BaseGenerator;

import de.topobyte.jsoup.Markdown;
import de.topobyte.pagegen.core.Context;
import de.topobyte.webpaths.WebPath;

public class MarkdownGenerator extends BaseGenerator
{

	private String resource;

	public MarkdownGenerator(Context context, WebPath path, String resource)
	{
		super(context, path);
		this.resource = resource;
	}

	@Override
	public void generate() throws IOException
	{
		super.generate();

		menu();

		Markdown.renderResource(content, resource);

		footer();
	}

}
