package org.openmetromaps;

import java.io.IOException;

import de.topobyte.pagegen.core.Context;
import de.topobyte.webpaths.WebPath;

public class ErrorGenerator extends BaseGenerator
{

	public ErrorGenerator(Context context, WebPath path)
	{
		super(context, path);
	}

	@Override
	public void generate() throws IOException
	{
		super.generate();
		menu();
		footer();
	}

}
