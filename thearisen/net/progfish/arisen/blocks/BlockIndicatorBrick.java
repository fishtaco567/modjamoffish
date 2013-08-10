package net.progfish.arisen.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.Icon;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.progfish.arisen.WorldSaveHandlerClient;
import net.progfish.arisen.WorldSaveHandlerServer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockIndicatorBrick extends Block {

	@SideOnly(Side.CLIENT)
	private Icon[] icons;
	
	public BlockIndicatorBrick(int i)
	{
		super(i, Material.rock);
		this.setBlockUnbreakable();
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int meta)
	{
		if(WorldSaveHandlerClient.isReady) {
			return icons[WorldSaveHandlerClient.coordList.size()];
		}
		return icons[0];
	}
	
    public int getMobilityFlag() {
        return 2;
    }
    
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister registry) {
		int index = 0;
		icons = new Icon[13];
		for(int i = 12; i >= 0; i--)
		{
			icons[index] = registry.registerIcon("arisen:indicator_" + i);
			index++;
		}
	}
	
}
