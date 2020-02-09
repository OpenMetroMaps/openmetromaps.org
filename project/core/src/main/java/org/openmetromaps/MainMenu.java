package org.openmetromaps;

import static de.topobyte.jsoup.HTML.a;

import org.jsoup.nodes.Element;

import de.topobyte.jsoup.HTML;
import de.topobyte.jsoup.bootstrap3.components.Menu;
import de.topobyte.jsoup.components.A;
import de.topobyte.jsoup.components.Img;
import de.topobyte.pagegen.core.LinkResolver;
import de.topobyte.webpaths.WebPaths;

public class MainMenu extends Menu
{

	public MainMenu(LinkResolver resolver)
	{
		A brandIcon = a("/");
		brandIcon.attr("style", "float:left");
		navbarHeader.ap(brandIcon);

		Img image = HTML.img(resolver.getLink(WebPaths.get("images/icon.svg")));
		image.attr("width", "50px");
		image.attr("style", "padding:5px");
		brandIcon.ap(image);

		A brand = a("/");
		brand.appendText("OpenMetroMaps");

		addBrand(brand);

		String aboutLink = resolver.getLink(PathHelper.mission());
		String demoLink = resolver.getLink(PathHelper.demo());
		String devGuideLink = resolver.getLink(PathHelper.devGuide());

		Element linkDemo = a(demoLink).inner("Demo");
		addMain(linkDemo, false);

		Element linkDevGuide = a(devGuideLink).inner("Developer Guide");
		addMain(linkDevGuide, false);

		Element linkAbout = a(aboutLink).inner("About");
		addRight(linkAbout, false);
	}

}
