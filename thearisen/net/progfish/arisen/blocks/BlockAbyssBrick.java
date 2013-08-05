package net.progfish.arisen.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockAbyssBrick extends Block {

	public BlockAbyssBrick(int par1) {
		super(par1, Material.rock);
		this.setBlockUnbreakable();
	}
	
    public int getMobilityFlag() {
        return 2;
    }

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister registry) {
		blockIcon = registry.registerIcon("arisen:abyssbrick");
	}
	
}
