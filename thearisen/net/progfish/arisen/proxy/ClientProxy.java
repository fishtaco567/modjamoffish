package net.progfish.arisen.proxy;

import java.io.File;

import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.util.ResourceLocation;
import net.progfish.arisen.client.render.ArisenRenderRegistry;
import net.progfish.arisen.client.render.particle.EntityCustomFX;

public class ClientProxy extends CommonProxy {

	public static final String TEXTURE_PATH = "arisen:textures";

	@Override
	public void initRenderers() {
		ArisenRenderRegistry.init();
	}
	
	@Override
	public void bindTexture(String texName) {
		Minecraft.getMinecraft().renderEngine.func_110577_a(new ResourceLocation(TEXTURE_PATH + File.separator + texName));
	}
	
	@Override
	public void spawnParticle(String tex, double x, double y, double z, double xMov, double yMov, double zMov) {
		Minecraft.getMinecraft().effectRenderer.addEffect(new EntityCustomFX(Minecraft.getMinecraft().theWorld, tex, x, y, z, xMov, yMov, zMov));
	}
	
}
