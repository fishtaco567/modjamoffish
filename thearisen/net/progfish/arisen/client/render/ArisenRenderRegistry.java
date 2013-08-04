package net.progfish.arisen.client.render;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.progfish.arisen.entities.EntityLich;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ArisenRenderRegistry {

	public static void init() {
		addRenderer(EntityLich.class, new RenderLich(new ModelLich(), 0.25F));
	}
	
	public static void addRenderer(Class<? extends Entity> entity, Render render) {
		RenderingRegistry.registerEntityRenderingHandler(entity, render);
	}
	
}
