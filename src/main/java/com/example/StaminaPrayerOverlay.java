package com.example;

import net.runelite.api.Client;
import net.runelite.api.Player;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.TextComponent;
import javax.inject.Inject;
import java.awt.*;

public class StaminaPrayerOverlay extends Overlay
{
    private final Client client;
    private final ExampleConfig config;

    @Inject
    public StaminaPrayerOverlay(Client client, ExampleConfig config)
    {
        this.client = client;
        this.config = config;
        setPosition(OverlayPosition.DYNAMIC);
        setLayer(OverlayLayer.ABOVE_SCENE);
        setPriority(OverlayPriority.HIGH);
    }

    @Override
    public Dimension render(Graphics2D graphics)
    {
        for (Player player : client.getPlayers())
        {
            if (player != null)
            {
                StringBuilder displayText = new StringBuilder();
                if (config.showStamina())
                {
                    displayText.append("Stamina: ").append(client.getVarpValue(173)).append(" ");
                }
                if (config.showPrayer())
                {
                    displayText.append("Prayer: ").append(client.getVarpValue(83));
                }

                LocalPoint lp = player.getLocalLocation();
                if (lp != null)
                {
                    Point textLocation = player.getCanvasTextLocation(graphics, displayText.toString(), player.getLogicalHeight() + 40);
                    if (textLocation != null)
                    {
                        TextComponent textComponent = new TextComponent();
                        textComponent.setText(displayText.toString());
//                        textComponent.setPosition(textLocation);
                        textComponent.setColor(Color.WHITE); // Set text color
                        textComponent.render(graphics);
                    }
                }
            }
        }

        return null;
    }
}
