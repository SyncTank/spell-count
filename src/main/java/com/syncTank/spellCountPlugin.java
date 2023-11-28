package com.syncTank;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.*;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;

@Slf4j
@PluginDescriptor(
	name = "spellCount"
)
public class spellCountPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private spellCountConfig config;

	private int itemSlots;

	@Override
	protected void startUp() throws Exception
	{
	}

	@Override
	protected void shutDown() throws Exception
	{

	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() == GameState.LOGGED_IN)
		{
			client.addChatMessage(ChatMessageType.GAMEMESSAGE, "LOG", "Example says " + "test " + config.greeting(), null);
			runeSearch();
		}
	}

	private void runeSearch(){
		final ItemContainer container = client.getItemContainer(InventoryID.INVENTORY);
		for (Item exis : container.getItems()) {
			client.addChatMessage(ChatMessageType.GAMEMESSAGE, "LOG", "Bla bla bla " + exis, null);
		}
	}
	
	//@Subscribe
	//public void onGameTick(GameTick tick){
	//	final ItemContainer container = client.getItemContainer(InventoryID.INVENTORY);
	//	client.addChatMessage(ChatMessageType.GAMEMESSAGE, "LOG", "Bla bla bla " + itemSlots, null);
	//	client.addChatMessage(ChatMessageType.GAMEMESSAGE, "LOG", "Amount of items: " + container.getItem(0) + config.greeting(), null);
	//}

	@Provides
	spellCountConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(spellCountConfig.class);
	}


}
