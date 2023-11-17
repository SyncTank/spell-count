package com.syncTank;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;

@ConfigGroup("spellCount")
public interface spellCountConfig extends Config
{
	@ConfigSection(
		name = "SpellCount",
		description = "The message to show to the user when they login",
		position = 99
	)
	String overlaySection = "overlay";

	@ConfigItem(
			position = 0,
			keyName = "uniqueKey",
			name = "Display text",
			description = "Hover text"
	)
	default boolean myCheckbox(){return true;}

	@ConfigItem(
			position = 1,
			keyName = "greeting",
			name = "Welcome Greeting",
			description = "The message to show to the user when they login",
			section = overlaySection
	)
	default String greeting() {return "Yee";}

	@ConfigItem(
			keyName = "spellCountDisplayStyle",
			name = "Spell display type",
			description = "How to display amount used",
			position = 2
	)
	default SpellCountDisplayStyle spellCountDisplayStyle(){return SpellCountDisplayStyle.TEXT;}


}