package net.progfish.arisen.client.item;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.progfish.arisen.ModInfo;

public class ArisenItems {

	public static int monumentDustID = 10772;
	public static int monumentFinderID = 10773;
	
	public static ItemMonumentDust monumentDust = (ItemMonumentDust) new ItemMonumentDust(monumentDustID).setCreativeTab(CreativeTabs.tabMisc);
	public static Item monumentFinder = new ItemMonumentFinder(monumentFinderID).setCreativeTab(CreativeTabs.tabMisc);
	
	public static void init() {
		registerItem(monumentDust, "Monument Dust");
		registerItem(monumentFinder, "Monument Finder");
	}
	
	private static void registerItem(Item item, String name) {
		GameRegistry.registerItem(item, name, ModInfo.MOD_ID);
		LanguageRegistry.addName(item, name);
	}
	
}
