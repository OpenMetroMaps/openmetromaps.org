package org.openmetromaps.flexmark;

import java.util.HashSet;
import java.util.Set;

import com.vladsch.flexmark.ext.wikilink.WikiLink;
import com.vladsch.flexmark.ext.wikilink.WikiLinkExtension;
import com.vladsch.flexmark.ext.wikilink.internal.WikiLinkNodeRenderer;
import com.vladsch.flexmark.html.CustomNodeRenderer;
import com.vladsch.flexmark.html.HtmlWriter;
import com.vladsch.flexmark.html.renderer.DelegatingNodeRendererFactory;
import com.vladsch.flexmark.html.renderer.NodeRenderer;
import com.vladsch.flexmark.html.renderer.NodeRendererContext;
import com.vladsch.flexmark.html.renderer.NodeRendererFactory;
import com.vladsch.flexmark.html.renderer.NodeRenderingHandler;
import com.vladsch.flexmark.html.renderer.ResolvedLink;
import com.vladsch.flexmark.util.options.DataHolder;
import com.vladsch.flexmark.util.sequence.BasedSequence;

public class CustomLinkRenderer implements NodeRenderer
{

	public static class Factory implements DelegatingNodeRendererFactory
	{

		@Override
		public NodeRenderer create(final DataHolder options)
		{
			return new CustomLinkRenderer();
		}

		@Override
		public Set<Class<? extends NodeRendererFactory>> getDelegates()
		{
			Set<Class<? extends NodeRendererFactory>> set = new HashSet<Class<? extends NodeRendererFactory>>();
			set.add(WikiLinkNodeRenderer.Factory.class);
			return set;
		}

	};

	@Override
	public Set<NodeRenderingHandler<?>> getNodeRenderingHandlers()
	{
		HashSet<NodeRenderingHandler<?>> set = new HashSet<NodeRenderingHandler<?>>();
		set.add(new NodeRenderingHandler<WikiLink>(WikiLink.class,
				new CustomNodeRenderer<WikiLink>() {

					@Override
					public void render(WikiLink node,
							NodeRendererContext context, HtmlWriter html)
					{
						BasedSequence text = node.getText();

						String url = node.getLink().toString();
						GithubLink githubLink = new GithubLink(url);
						if (githubLink.isValid() && text.isBlank()) {
							ResolvedLink resolvedLink = context.resolveLink(
									WikiLinkExtension.WIKI_LINK,
									node.getLink().unescape(), null);
							html.attr("href", resolvedLink.getUrl());
							html.srcPos(node.getChars()).withAttr(resolvedLink)
									.tag("a");
							html.text(githubLink.text());
							html.tag("/a");
						} else {
							context.delegateRender();
						}
					}

				}));

		return set;
	}

}
