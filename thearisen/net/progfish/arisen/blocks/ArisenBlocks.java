package net.progfish.arisen.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;

public class ArisenBlocks {
	
	public static BlockForcefield forcefield;
	public static BlockAbyssBrick abyssBrick;
	public static BlockAbyssBarrier abyssBarrier;
	public static BlockMonument monument;
	
	public static void init()
	{
		forcefield = (BlockForcefield) new BlockForcefield(1072).setResistance(100000).setCreativeTab(CreativeTabs.tabMisc); //TODO: Add config
		abyssBrick = (BlockAbyssBrick) new BlockAbyssBrick(1073).setResistance(100000).setCreativeTab(CreativeTabs.tabMisc); //TODO: Add config
		abyssBarrier = (BlockAbyssBarrier) new BlockAbyssBarrier(1074).setResistance(100000).setCreativeTab(CreativeTabs.tabMisc); //TODO: Add config
		monument = (BlockMonument) new BlockMonument(1075).setResistance(100000).setCreativeTab(CreativeTabs.tabMisc); //TODO: Add config
		
		registerBlock(forcefield, "Forcefield");
		registerBlock(abyssBrick, "Abbysal Brick");
		registerBlock(abyssBarrier, "Abbysal Barrier");
		registerBlock(monument, "Monuement Barrier");
	}
	
	private static void registerBlock(Block block, String name)
	{
		GameRegistry.registerBlock(block, name);
		LanguageRegistry.addName(block, name);
	}
	
}
