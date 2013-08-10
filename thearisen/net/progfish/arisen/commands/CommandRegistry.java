package net.progfish.arisen.commands;

import cpw.mods.fml.common.event.FMLServerStartingEvent;

public class CommandRegistry {
	
	public static void init(FMLServerStartingEvent event) {
		event.registerServerCommand(new CommandOptOut());
		event.registerServerCommand(new CommandSpawnLich());
	}
	
}
