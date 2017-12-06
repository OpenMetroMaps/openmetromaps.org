package org.openmetromaps;

import de.topobyte.pagegen.core.Context;
import de.topobyte.webpaths.WebPath;
import de.topobyte.webpaths.WebPaths;

public class WebContext implements Context
{

	private WebPath favicon = WebPaths.get("favicon.ico");

	@Override
	public WebPath getFavIcon()
	{
		return favicon;
	}

}
