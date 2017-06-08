package org.openmetromaps;

import static de.topobyte.jsoup.ElementBuilder.create;

import java.io.IOException;

import org.jsoup.nodes.Element;

import de.topobyte.pagegen.bootstrap.BootstrapGenerator;
import de.topobyte.pagegen.core.Context;
import de.topobyte.webpaths.WebPath;

public class BaseGenerator extends BootstrapGenerator
{

	public BaseGenerator(Context context, WebPath path)
	{
		super(context, path);
	}

	@Override
	public void generate() throws IOException
	{
		super.generate();
		Element head = builder.getHead();
		head.appendChild(create("link", "href",
				"https://fonts.googleapis.com/css?family=Ultra", "rel",
				"stylesheet"));
	}

	protected void menu()
	{
		MainMenu menu = new MainMenu(this);
		getBuilder().getBody().prependChild(menu);
	}

	protected void footer()
	{
		getBuilder().getBody().appendChild(new Footer());
	}

}
