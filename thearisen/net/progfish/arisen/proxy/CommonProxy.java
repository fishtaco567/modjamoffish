package net.progfish.arisen.proxy;

import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class CommonProxy {

	public void initRenderers()	{
		
	}
	
	public void spawnEntity(Entity e) {
		World world = FMLCommonHandler.instance().getMinecraftServerInstance().worldServerForDimension(0);
		if(!world.isRemote)
		{
			world.joinEntityInSurroundings(e);
		}
	}
	
}
