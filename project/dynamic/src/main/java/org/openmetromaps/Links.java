package org.openmetromaps;

import de.topobyte.jsoup.HTML;
import de.topobyte.jsoup.components.A;

public class Links
{

	public static A github(String user)
	{
		return HTML.a("https://github.com/" + user, user);
	}

	public static A github(String user, String repo)
	{
		return HTML.a("https://github.com/" + user + "/" + repo,
				user + "/" + repo);
	}

	public static A github(String user, String repo, String path, String text)
	{
		return HTML.a("https://github.com/" + user + "/" + repo + path, text);
	}

}
