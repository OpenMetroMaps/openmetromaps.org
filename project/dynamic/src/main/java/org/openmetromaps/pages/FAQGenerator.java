package org.openmetromaps.pages;

import java.io.IOException;

import org.openmetromaps.BaseGenerator;

import de.topobyte.jsoup.HTML;
import de.topobyte.jsoup.components.Div;
import de.topobyte.jsoup.components.List;
import de.topobyte.jsoup.components.ListItem;
import de.topobyte.jsoup.components.OrderedList;
import de.topobyte.jsoup.nodes.Element;
import de.topobyte.pagegen.core.Context;
import de.topobyte.webpaths.WebPath;

public class FAQGenerator extends BaseGenerator
{

	public FAQGenerator(Context context, WebPath path)
	{
		super(context, path);
	}

	@Override
	public void generate() throws IOException
	{
		super.generate();

		menu();

		content();

		footer();
	}

	private void content()
	{
		content.ac(HTML.h1("Frequently Asked Questions"));

		OrderedList list = content.ac(HTML.ol());

		add(list, "Questions will go here?", "Absolutely!");

		add(list, "My question is not answered, what can I do?",
				HTML.span().appendText("You can get in touch via the ")
						.appendChild(
								HTML.a("https://www.freelists.org/list/openmetromaps",
										"Mailing List"))
						.appendText("."));
	}

	private Div question()
	{
		Div div = HTML.div();
		div.attr("style", "font-weight:bold");
		return div;
	}

	private Div answer()
	{
		Div div = HTML.div();
		return div;
	}

	private void add(List list, String question, String answer)
	{
		ListItem item = list.addItem();
		Div divQuestion = item.ac(question());
		Div divAnswer = item.ac(answer());

		divQuestion.appendText(question);
		divAnswer.appendText(answer);
	}

	private void add(List list, String question, Element answer)
	{
		ListItem item = list.addItem();
		Div divQuestion = item.ac(question());
		Div divAnswer = item.ac(answer());

		divQuestion.appendText(question);
		divAnswer.ac(answer);
	}

}
