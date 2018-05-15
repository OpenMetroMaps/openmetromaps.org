package org.openmetromaps;

import de.topobyte.webpaths.WebPath;
import de.topobyte.webpaths.WebPaths;

public class PathHelper
{

	public static WebPath imprint()
	{
		return WebPaths.get("imprint");
	}

	public static WebPath privacyPolicy()
	{
		return WebPaths.get("privacy-policy");
	}

	public static WebPath demo()
	{
		return WebPaths.get("demo");
	}

	public static WebPath mission()
	{
		return WebPaths.get("mission");
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

	public static WebPath mailingList()
	{
		return WebPaths.get("mailing-list");
	}

}
