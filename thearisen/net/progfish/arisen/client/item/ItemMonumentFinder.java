package net.progfish.arisen.client.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.item.Item;
import net.progfish.arisen.client.render.TextureFinder;

public class ItemMonumentFinder extends Item {

	public static final String TEX_NAME = "arisen:finder";
	
	public ItemMonumentFinder(int par1) {
		super(par1);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister registry) {
		if(registry instanceof TextureMap) {
			((TextureMap)registry).setTextureEntry(TEX_NAME, new TextureFinder(TEX_NAME));
			itemIcon = ((TextureMap)registry).registerIcon(TEX_NAME);
		}
	}

}
