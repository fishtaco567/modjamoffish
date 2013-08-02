package net.progfish.arisen;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.ServerStarting;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.event.FMLServerStoppedEvent;
import cpw.mods.fml.common.network.NetworkMod;

@NetworkMod(clientSideRequired = true, serverSideRequired = false)
@Mod(modid = ModInfo.MOD_ID, name = ModInfo.MOD_NAME, version = ModInfo.MOD_VERSION)
public class ArisenMod {

	@Instance(ModInfo.MOD_ID)
	public static ArisenMod instance;
	
	@EventHandler
	public void serverStarting(FMLServerStartingEvent event) {
		
	}
	
	@EventHandler
	public void serverStop(FMLServerStoppedEvent event) {
		
	}
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event) {
		
	}
	
	@EventHandler
	public void modsLoaded(FMLPostInitializationEvent event) {
		
	}
	
}
