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

	public static WebPath devGuide()
	{
		return WebPaths.get("developer-guide");
	}

	public static WebPath userGuide()
	{
		return WebPaths.get("user-guide");
	}

	public static WebPath faq()
	{
		return WebPaths.get("faq");
	}

}
