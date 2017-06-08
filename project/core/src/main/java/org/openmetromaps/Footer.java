package org.openmetromaps;

import static de.topobyte.jsoup.HTML.p;
import static de.topobyte.jsoup.HTML.span;
import de.topobyte.jsoup.Bootstrap;
import de.topobyte.jsoup.nodes.Element;

public class Footer extends Element
{

	public Footer()
	{
		super("footer");
		attr("class", "footer");

		Element div = ac(Bootstrap.container());
		Element p = div.ac(p().addClass("text-muted"));

		Element heart = span().addClass("glyphicon glyphicon-heart");
		p.appendText("Made with ");
		p.appendChild(heart);
		p.appendText(" in Berlin");
	}

}
