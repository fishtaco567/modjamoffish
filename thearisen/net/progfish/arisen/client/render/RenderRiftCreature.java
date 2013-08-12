package net.progfish.arisen.client.render;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderRiftCreature extends RenderLiving  {

    private static final ResourceLocation textureLocation = new ResourceLocation("arisen:textures/mobs/riftcreature.png");
    int time = 0;
    
	public RenderRiftCreature(ModelBase par1ModelBase, float par2) {
		super(par1ModelBase, par2);
	}
	
	@Override
	protected ResourceLocation func_110775_a(Entity entity) {
		return textureLocation;
	}


}
