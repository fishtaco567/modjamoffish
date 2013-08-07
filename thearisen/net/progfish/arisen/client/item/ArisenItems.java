package net.progfish.arisen.client.item;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.progfish.arisen.ModInfo;

public class ArisenItems {

	public static ItemMonumentDust monumentDust = (ItemMonumentDust) new ItemMonumentDust(10772).setCreativeTab(CreativeTabs.tabMisc);
	public static Item monumentFinder = new ItemMonumentFinder(10773).setCreativeTab(CreativeTabs.tabMisc);
	
	public static void init() {
		registerItem(monumentDust, "Monument Dust");
		registerItem(monumentFinder, "Monument Finder");
	}
	
	private static void registerItem(Item item, String name) {
		GameRegistry.registerItem(item, name, ModInfo.MOD_ID);
		LanguageRegistry.addName(item, name);
	}
	
}
