package net.progfish.arisen.blocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.Icon;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.progfish.arisen.WorldSaveHandlerServer;
import net.progfish.arisen.client.item.ArisenItems;
import net.progfish.arisen.network.ArisenPacketHandler;

public class BlockMonument extends Block {

	@SideOnly(Side.CLIENT)
	private Icon iconTop;
	@SideOnly(Side.CLIENT)
	private Icon iconSide;
	
	public BlockMonument(int i)
	{
		super(i, Material.rock);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int meta)
	{
		return side == 1 ? iconTop : iconSide;
	}
	
	@Override
	public int idDropped(int par1, Random par2Random, int par3)
	{
		return ArisenItems.monumentDust.itemID;
	}
	
	@Override
	public void onBlockDestroyedByPlayer(World world, int i, int j, int k, int l) {
		blockDestroyed(world, i, j, k);
	}
	
	@Override
	public void onBlockDestroyedByExplosion(World world, int i, int j, int k, Explosion explosion) {
		blockDestroyed(world, i, j, k);
	}

	private void blockDestroyed(World world, int i, int j, int k) {
		if(!world.isRemote) {
			if(!WorldSaveHandlerServer.instance.isReady) {
				WorldSaveHandlerServer.instance.init();
			}
			WorldSaveHandlerServer.instance.removeCoord(new ChunkCoordinates(i, 0, k));
		}
	}
	
    public int getMobilityFlag() {
        return 2;
    }
    
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister registry) {
		iconTop = registry.registerIcon("arisen:monument_top");
		iconSide = registry.registerIcon("arisen:monument_side");
	}
	
}
