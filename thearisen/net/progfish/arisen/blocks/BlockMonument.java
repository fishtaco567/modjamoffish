package net.progfish.arisen.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.Icon;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.progfish.arisen.MonumentHandler;

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
	public void onBlockDestroyedByPlayer(World world, int i, int j, int k, int l) {
		blockDestroyed(i, j, k);
	}
	
	@Override
	public void onBlockDestroyedByExplosion(World world, int i, int j, int k, Explosion explosion) {
		blockDestroyed(i, j, k);
	}

	private void blockDestroyed(int i, int j, int k) {
		if(!MonumentHandler.instance.isReady) {
			MonumentHandler.instance.init();
		}
		MonumentHandler.instance.removeCoord(new ChunkCoordinates(i, 0, k));
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
