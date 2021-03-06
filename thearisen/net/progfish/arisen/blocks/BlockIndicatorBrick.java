package net.progfish.arisen.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.Icon;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.progfish.arisen.MonumentHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockIndicatorBrick extends Block {

	@SideOnly(Side.CLIENT)
	private Icon[] icons = new Icon[13];
	
	public BlockIndicatorBrick(int i)
	{
		super(i, Material.rock);
		this.setBlockUnbreakable();
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int meta)
	{
		if(!MonumentHandler.instance.isReady) {
			MonumentHandler.instance.init();
		}
		return icons[MonumentHandler.instance.coordList.size()];
	}
	
    public int getMobilityFlag() {
        return 2;
    }
    
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister registry) {
		int index = 0;
		for(int i = 12; i >= 0; i--)
		{
			icons[index] = registry.registerIcon("arisen:indicator_" + i);
			index++;
		}
	}
	
}
