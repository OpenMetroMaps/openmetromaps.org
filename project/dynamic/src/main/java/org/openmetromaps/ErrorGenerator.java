package org.openmetromaps;

import java.io.IOException;

import de.topobyte.pagegen.bootstrap.BootstrapGenerator;
import de.topobyte.pagegen.core.Context;
import de.topobyte.webpaths.WebPath;

public class ErrorGenerator extends BootstrapGenerator
{

	public ErrorGenerator(Context context, WebPath path)
	{
		super(context, path);
	}

	@Override
	public void generate() throws IOException
	{
		super.generate();

		MainMenu menu = new MainMenu(this);
		getBuilder().getBody().prependChild(menu);

		getBuilder().getBody().appendChild(new Footer());
	}

}
