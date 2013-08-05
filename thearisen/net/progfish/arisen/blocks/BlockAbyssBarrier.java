package net.progfish.arisen.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.progfish.arisen.MonumentHandler;

public class BlockAbyssBarrier extends Block {
	
	public BlockAbyssBarrier(int i) {
		super(i, Material.cloth);
	}

	@Override
	public int getRenderBlockPass()
	{
		return 1;
	}
	
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	@Override
	public boolean renderAsNormalBlock() {
        return false;
    }
	
    public int getMobilityFlag() {
        return 2;
    }
    
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4) {
		if(!MonumentHandler.instance.isReady) {
			MonumentHandler.instance.init();
		}
    	return (MonumentHandler.instance.coordList.size() > 3) ? super.getCollisionBoundingBoxFromPool(par1World, par2, par3, par4) : null;
    }
    
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister registry) {
		blockIcon = registry.registerIcon("arisen:barrier");
	}
	
}
