package org.openmetromaps;

import java.util.Arrays;

import com.vladsch.flexmark.Extension;
import com.vladsch.flexmark.ast.Document;
import com.vladsch.flexmark.ext.gfm.strikethrough.StrikethroughExtension;
import com.vladsch.flexmark.ext.tables.TablesExtension;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.options.MutableDataHolder;
import com.vladsch.flexmark.util.options.MutableDataSet;

import de.topobyte.jsoup.nodes.Element;

public class Markdown
{

	public static void generate(Element container, String markdown)
	{
		MutableDataSet options = new MutableDataSet();

		Extension tables = new TablesExtension() {

			@Override
			public void rendererOptions(MutableDataHolder options)
			{
				options.set(TablesExtension.CLASS_NAME, "table");
			}

		};

		Extension strikethrough = StrikethroughExtension.create();

		options.set(Parser.EXTENSIONS, Arrays.asList(tables, strikethrough));

		Parser parser = Parser.builder(options).build();
		HtmlRenderer renderer = HtmlRenderer.builder(options).build();

		Document document = parser.parse(markdown);
		String html = renderer.render(document);

		container.append(html);
	}

}
