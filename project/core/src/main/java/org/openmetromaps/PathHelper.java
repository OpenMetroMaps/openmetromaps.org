package org.openmetromaps;

import de.topobyte.webpaths.WebPath;
import de.topobyte.webpaths.WebPaths;

public class PathHelper
{

	public static WebPath about()
	{
		return WebPaths.get("about");
	}

	public static WebPath demo()
	{
		return WebPaths.get("demo");
	}

}
