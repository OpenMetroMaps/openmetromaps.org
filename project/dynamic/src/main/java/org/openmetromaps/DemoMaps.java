package org.openmetromaps;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;

public class DemoMaps
{

	private static final Set<MapKey> MAPS = new HashSet<>();

	static {
		register("berlin", "geographic");
		register("berlin", "schematic");
		register("berlin", "nicknames");
		register("vienna", "geographic");
		register("vienna", "schematic");
		register("stuttgart", "sbahn-geographic");
		register("stuttgart", "sbahn-schematic");
	}

	private static void register(String city, String variant)
	{
		MAPS.add(new MapKey(city, variant));
	}

	public static boolean isValid(String city, String variant)
	{
		return MAPS.contains(new MapKey(city, variant));
	}

	@Data
	private static class MapKey
	{

		private final String city;
		private final String variant;

		MapKey(String city, String variant)
		{
			this.city = city;
			this.variant = variant;
		}

	}

}
