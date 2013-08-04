package net.progfish.arisen.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;

public class ArisenBlocks {
	
	public static BlockForcefield forcefield;
	
	public static void init()
	{
		forcefield = (BlockForcefield) new BlockForcefield(1072).setResistance(100000).setCreativeTab(CreativeTabs.tabMisc); //TODO: Add config
		
		registerBlock(forcefield, "Forcefield");
	}
	
	private static void registerBlock(Block block, String name)
	{
		GameRegistry.registerBlock(block, name);
		LanguageRegistry.addName(block, name);
	}
	
}
