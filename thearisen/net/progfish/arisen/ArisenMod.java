package net.progfish.arisen;

import net.progfish.arisen.blocks.ArisenBlocks;
import net.progfish.arisen.commands.CommandRegistry;
import net.progfish.arisen.entities.ArisenEntityRegistry;
import net.progfish.arisen.proxy.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
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
	
	@SidedProxy(clientSide = "net.progfish.arisen.proxy.ClientProxy", serverSide = "net.progfish.arisen.proxy.CommonProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void serverStarting(FMLServerStartingEvent event) {
		CommandRegistry.init(event);
	}
	
	@EventHandler
	public void serverStop(FMLServerStoppedEvent event) {
		
	}
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event) {
		ArisenEntityRegistry.init(event);
		
		ArisenBlocks.init();
		
		proxy.initRenderers();
	}
	
	@EventHandler
	public void modsLoaded(FMLPostInitializationEvent event) {
		
	}
	
}
