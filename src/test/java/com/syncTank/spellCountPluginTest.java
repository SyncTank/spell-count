package com.syncTank;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class spellCountPluginTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(spellCountPlugin.class);
		RuneLite.main(args);
	}
}