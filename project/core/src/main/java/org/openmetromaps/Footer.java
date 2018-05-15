package org.openmetromaps;

import static de.topobyte.jsoup.HTML.a;
import static de.topobyte.jsoup.HTML.p;
import static de.topobyte.jsoup.HTML.span;

import de.topobyte.jsoup.Bootstrap;
import de.topobyte.jsoup.HTML;
import de.topobyte.jsoup.components.A;
import de.topobyte.jsoup.components.UnorderedList;
import de.topobyte.jsoup.nodes.Element;
import de.topobyte.pagegen.core.LinkResolver;

public class Footer extends Element
{

	public Footer(LinkResolver resolver)
	{
		super("footer");
		attr("class", "footer");

		Element container = ac(Bootstrap.container());

		UnorderedList links = container.ac(HTML.ul());

		String imprintLink = resolver.getLink(PathHelper.imprint());
		A linkAbout = a(imprintLink, "Impressum");
		links.addItem(linkAbout);

		String privacyLink = resolver.getLink(PathHelper.privacyPolicy());
		A linkPrivacy = a(privacyLink, "Privacy policy");
		links.addItem(linkPrivacy);

		Element p = container.ac(p().addClass("text-muted"));

		Element heart = span().addClass("glyphicon glyphicon-heart");
		p.appendText("Made with ");
		p.appendChild(heart);
		p.appendText(" in Berlin");
	}

}
