package org.openmetromaps.pages;

import java.io.IOException;

import org.openmetromaps.BaseGenerator;
import org.openmetromaps.widgets.Map;

import de.topobyte.cachebusting.CacheBusting;
import de.topobyte.webpaths.WebPath;

public class MapGenerator extends BaseGenerator
{

	private String region;
	private String version;

	public MapGenerator(WebPath path, String region, String version)
	{
		super(path);
		this.region = region;
		this.version = version;
	}

	@Override
	public void generate() throws IOException
	{
		super.generate();

		menu();

		Map.setupHead(builder);

		String mapfile = String.format("client/%s/%s.omm", region, version);
		Map.widget(content, "/" + CacheBusting.resolve(mapfile));

		footer();
	}

}
