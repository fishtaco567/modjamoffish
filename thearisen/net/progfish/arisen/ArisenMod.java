package net.progfish.arisen;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.progfish.arisen.blocks.ArisenBlocks;
import net.progfish.arisen.client.item.ArisenItems;
import net.progfish.arisen.commands.CommandRegistry;
import net.progfish.arisen.entities.ArisenEntityRegistry;
import net.progfish.arisen.proxy.CommonProxy;
import net.progfish.arisen.worldgen.WorldGenHandler;
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
import cpw.mods.fml.common.registry.GameRegistry;

@NetworkMod(clientSideRequired = true, serverSideRequired = false, connectionHandler = ConnectionHandlerArisen.class)
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
		WorldSaveHandler.instance.close();
	}
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		Config.loadConfig(event);
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event) {
		ArisenEntityRegistry.init(event);
		
		ArisenBlocks.init();
		ArisenItems.init();
		
		proxy.initRenderers();
		
		GameRegistry.registerWorldGenerator(WorldGenHandler.instance);
		GameRegistry.addRecipe(new ItemStack(ArisenItems.monumentFinder, 1), new Object[] {" x " , "xzx", " x ", 'x', new ItemStack(Item.ingotIron, 1), 'z', new ItemStack(ArisenItems.monumentDust, 1)});
	}
	
	
	
	@EventHandler
	public void modsLoaded(FMLPostInitializationEvent event) {
		
	}
	
}
