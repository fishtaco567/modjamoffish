package net.progfish.arisen.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;

public class ArisenBlocks {
	
	public static int forcefieldID = 1072;
	public static int abyssBrickID = 1073;
	public static int abyssBarrierID = 1074;
	public static int monumentID = 1075;
	public static int indicatorID = 1076;
	
	public static BlockForcefield forcefield;
	public static BlockAbyssBrick abyssBrick;
	public static BlockAbyssBarrier abyssBarrier;
	public static BlockMonument monument;
	public static BlockIndicatorBrick indicator;
	
	public static void init()
	{
		forcefield = (BlockForcefield) new BlockForcefield(forcefieldID).setResistance(100000).setCreativeTab(CreativeTabs.tabMisc); //TODO: Add config
		abyssBrick = (BlockAbyssBrick) new BlockAbyssBrick(abyssBrickID).setResistance(100000).setCreativeTab(CreativeTabs.tabMisc); //TODO: Add config
		abyssBarrier = (BlockAbyssBarrier) new BlockAbyssBarrier(abyssBarrierID).setResistance(100000).setCreativeTab(CreativeTabs.tabMisc); //TODO: Add config
		monument = (BlockMonument) new BlockMonument(monumentID).setCreativeTab(CreativeTabs.tabMisc); //TODO: Add config
		indicator = (BlockIndicatorBrick) new BlockIndicatorBrick(indicatorID).setResistance(100000).setCreativeTab(CreativeTabs.tabMisc); //TODO: Add config
		
		registerBlock(forcefield, "Forcefield");
		registerBlock(abyssBrick, "Abbysal Brick");
		registerBlock(abyssBarrier, "Abbysal Barrier");
		registerBlock(monument, "Monuement Barrier");
		registerBlock(indicator, "Indicator Brick");
	}
	
	private static void registerBlock(Block block, String name)
	{
		GameRegistry.registerBlock(block, name);
		LanguageRegistry.addName(block, name);
	}
	
}
