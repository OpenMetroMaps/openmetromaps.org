package org.openmetromaps.flexmark;

import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.util.options.MutableDataHolder;

public class CustomExtension implements HtmlRenderer.HtmlRendererExtension
{

	@Override
	public void rendererOptions(final MutableDataHolder options)
	{
		// empty
	}

	@Override
	public void extend(final HtmlRenderer.Builder rendererBuilder,
			final String rendererType)
	{
		rendererBuilder.linkResolverFactory(new CustomLinkResolver.Factory());
		rendererBuilder.nodeRendererFactory(new CustomLinkRenderer.Factory());
	}

	public static CustomExtension create()
	{
		return new CustomExtension();
	}

}