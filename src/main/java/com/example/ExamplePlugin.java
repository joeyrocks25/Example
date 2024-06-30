package com.example;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Player;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@Slf4j
@PluginDescriptor(
		name = "Stamina and Prayer Display"
)
public class ExamplePlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private ExampleConfig config;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private StaminaPrayerOverlay staminaPrayerOverlay;

	@Override
	protected void startUp() throws Exception
	{
		log.info("Stamina and Prayer Display started!");
		overlayManager.add(staminaPrayerOverlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		log.info("Stamina and Prayer Display stopped!");
		overlayManager.remove(staminaPrayerOverlay);
	}

	@Provides
	ExampleConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ExampleConfig.class);
	}
}
