package com.example;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("example")
public interface ExampleConfig extends Config
{
	@ConfigItem(
			keyName = "showStamina",
			name = "Show Stamina",
			description = "Display stamina above player's head"
	)
	default boolean showStamina()
	{
		return true;
	}

	@ConfigItem(
			keyName = "showPrayer",
			name = "Show Prayer",
			description = "Display prayer above player's head"
	)
	default boolean showPrayer()
	{
		return true;
	}
}
