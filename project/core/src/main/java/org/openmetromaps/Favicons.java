package org.openmetromaps;

import static de.topobyte.jsoup.ElementBuilder.create;

import org.jsoup.nodes.Element;

public class Favicons
{

	public static void addToHeader(Element head, String path, int size)
	{
		String sizeDef = size + "x" + size;
		Element favicon = create("link", "rel", "icon", "type", "image/png",
				"sizes", sizeDef, "href", path);
		head.appendChild(favicon);
	}

}
