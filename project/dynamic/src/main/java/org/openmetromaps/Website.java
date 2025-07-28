package org.openmetromaps;

import de.topobyte.webgun.util.CacheBuster;
import lombok.Getter;
import lombok.Setter;

public class Website
{

	public static final String TITLE = "OpenMetroMaps";

	public static final Website INSTANCE = new Website();

	@Getter
	@Setter
	private CacheBuster cacheBuster;

}
