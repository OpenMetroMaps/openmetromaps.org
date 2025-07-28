package org.openmetromaps.widgets;

import static de.topobyte.jsoup.HTML.a;

import org.openmetromaps.PathHelper;
import org.openmetromaps.Website;

import de.topobyte.cachebusting.CacheBusting;
import de.topobyte.jsoup.HTML;
import de.topobyte.jsoup.bootstrap4.components.Expand;
import de.topobyte.jsoup.bootstrap4.components.Menu;
import de.topobyte.jsoup.bootstrap4.components.MenuBuilder;
import de.topobyte.jsoup.components.A;
import de.topobyte.jsoup.components.Div;
import de.topobyte.jsoup.components.Img;
import de.topobyte.jsoup.components.UnorderedList;
import de.topobyte.pagegen.core.LinkResolver;
import de.topobyte.webpaths.WebPaths;

public class MainMenu
{

	public static Menu create(LinkResolver resolver)
	{
		MenuBuilder builder = new MenuBuilder();
		builder.setExpand(Expand.MD).setFixed(true);
		Menu menu = builder.create();

		menu.addClass("shadow-sm");

		A brand = a("/");

		Img image = HTML.img(
				"/" + WebPaths.get(CacheBusting.resolve("images/icon.svg")));
		image.attr("height", "40px");
		image.attr("style", "padding-right:15px");
		brand.ap(image);

		brand.at(Website.TITLE);

		menu.addBrand(brand);
		menu.addToggleButton();

		Div collapse = menu.addCollapsible();
		UnorderedList main = menu.addSection(collapse);
		UnorderedList right = menu.addSectionRight(collapse);

		String aboutLink = resolver.getLink(PathHelper.mission());
		String demoLink = resolver.getLink(PathHelper.demo());
		String devGuideLink = resolver.getLink(PathHelper.devGuide());

		menu.addLink(main, demoLink, "Demo", false);
		menu.addLink(main, devGuideLink, "Developer Guide", false);
		menu.addLink(right, aboutLink, "About", false);

		return menu;
	}

}
