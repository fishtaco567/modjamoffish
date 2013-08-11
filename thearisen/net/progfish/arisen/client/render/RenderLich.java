package net.progfish.arisen.client.render;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.progfish.arisen.entities.EntityLich;

public class RenderLich extends RenderLiving {

    private static final ResourceLocation textureLocation = new ResourceLocation("arisen:textures/mobs/lich.png");
    int time = 0;
    
	public RenderLich(ModelBase par1ModelBase, float par2) {
		super(par1ModelBase, par2);
	}
	
	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
	{
		GL11.glPushMatrix();
		GL11.glTranslatef(0.0F, (float)(Math.cos(time / 81F)) / 20F, 0.0F);
		if(time > 512)
		{
			time = 0;
		}
		time++;
		super.doRender(par1Entity, par2, par4, par6, par8, par9);
		GL11.glPopMatrix();
	}
	
	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
	{
		GL11.glPushMatrix();
		GL11.glTranslatef(0.0F, (float)(Math.cos(time / 81F)) / 20F, 0.0F);
		if(time > 512)
		{
			time = 0;
		}
		time++;
		super.doRenderLiving(par1EntityLiving, par2, par4, par6, par8, par9);
		GL11.glPopMatrix();
	}
	
	@Override
	protected ResourceLocation func_110775_a(Entity entity) {
		return textureLocation;
	}

}
