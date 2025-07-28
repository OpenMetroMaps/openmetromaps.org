package org.openmetromaps.widgets;

import static de.topobyte.jsoup.HTML.a;
import static de.topobyte.jsoup.HTML.p;

import org.openmetromaps.PathHelper;

import de.topobyte.jsoup.HTML;
import de.topobyte.jsoup.bootstrap4.Bootstrap;
import de.topobyte.jsoup.bootstrap4.components.Container;
import de.topobyte.jsoup.components.A;
import de.topobyte.jsoup.components.P;
import de.topobyte.jsoup.components.UnorderedList;
import de.topobyte.jsoup.feather.Feather;
import de.topobyte.jsoup.nodes.Element;
import de.topobyte.pagegen.core.LinkResolver;

public class Footer extends Element<Footer>
{

	public Footer(LinkResolver resolver)
	{
		super("footer");
		attr("class", "footer");

		Container container = ac(Bootstrap.container());

		UnorderedList links = container.ac(HTML.ul());

		String imprintLink = resolver.getLink(PathHelper.imprint());
		A linkAbout = a(imprintLink, "Impressum");
		links.addItem(linkAbout);

		String privacyLink = resolver.getLink(PathHelper.privacyPolicy());
		A linkPrivacy = a(privacyLink, "Privacy policy");
		links.addItem(linkPrivacy);

		P p = container.ac(p().addClass("text-muted"));

		p.at("Made with ");
		p.ac(Feather.heart("1em"));
		p.at(" in Berlin-Brandenburg");
	}

}
