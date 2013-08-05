package net.progfish.arisen.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import cpw.mods.fml.relauncher.SideOnly;
import cpw.mods.fml.relauncher.Side;

public class BlockForcefield extends Block {

	public BlockForcefield(int par1) {
		super(par1, Material.iron);
		this.setBlockUnbreakable();
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

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister registry) {
		blockIcon = registry.registerIcon("arisen:forcefield");
	}

}
