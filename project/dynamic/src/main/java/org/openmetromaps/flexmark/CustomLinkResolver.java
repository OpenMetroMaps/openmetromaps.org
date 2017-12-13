package org.openmetromaps.flexmark;

import java.util.Set;

import com.vladsch.flexmark.ast.Node;
import com.vladsch.flexmark.ext.wikilink.WikiLink;
import com.vladsch.flexmark.html.LinkResolver;
import com.vladsch.flexmark.html.LinkResolverFactory;
import com.vladsch.flexmark.html.renderer.LinkResolverContext;
import com.vladsch.flexmark.html.renderer.LinkStatus;
import com.vladsch.flexmark.html.renderer.ResolvedLink;

public class CustomLinkResolver implements LinkResolver
{

	static class Factory implements LinkResolverFactory
	{
		@Override
		public Set<Class<? extends LinkResolverFactory>> getAfterDependents()
		{
			return null;
		}

		@Override
		public Set<Class<? extends LinkResolverFactory>> getBeforeDependents()
		{
			return null;
		}

		@Override
		public boolean affectsGlobalScope()
		{
			return false;
		}

		@Override
		public LinkResolver create(final LinkResolverContext context)
		{
			return new CustomLinkResolver(context);
		}
	}

	public CustomLinkResolver(final LinkResolverContext context)
	{
		// empty
	}

	@Override
	public ResolvedLink resolveLink(final Node node,
			final LinkResolverContext context, final ResolvedLink link)
	{
		if (node instanceof WikiLink) {
			String def = link.getUrl();
			GithubLink githubLink = new GithubLink(def);
			if (githubLink.isValid()) {
				return link.withStatus(LinkStatus.VALID)
						.withUrl(githubLink.url());
			}
			return link.withStatus(LinkStatus.VALID).withUrl(def);
		}
		return link;
	}

}