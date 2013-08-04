package net.progfish.arisen.client.render;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelLich extends ModelBase
{
	
	ModelRenderer body;
	ModelRenderer hunch;
	ModelRenderer flap1;
	ModelRenderer flap2;
	ModelRenderer head;
	ModelRenderer backOfHead;

	public ModelLich()
	{
		textureWidth = 64;
		textureHeight = 32;

		body = new ModelRenderer(this, 0, 0);
		body.addBox(-4F, 0F, -2F, 8, 18, 4);
		body.setRotationPoint(0F, 0F, 0F);
		body.setTextureSize(64, 32);
		body.mirror = true;
		setRotation(body, 0F, 0F, 0F);
		hunch = new ModelRenderer(this, 24, 6);
		hunch.addBox(-3F, 0F, 2F, 6, 4, 1);
		hunch.setRotationPoint(0F, 1F, 0F);
		hunch.setTextureSize(64, 32);
		hunch.mirror = true;
		setRotation(hunch, 0F, 0F, 0F);
		flap1 = new ModelRenderer(this, 24, 0);
		flap1.addBox(-4F, 0F, 0F, 8, 5, 1);
		flap1.setRotationPoint(0F, 18F, -2F);
		flap1.setTextureSize(64, 32);
		flap1.mirror = true;
		setRotation(flap1, 0F, 0F, 0F);
		flap2 = new ModelRenderer(this, 42, 0);
		flap2.addBox(-4F, 0F, -1F, 8, 5, 1);
		flap2.setRotationPoint(0F, 18F, 2F);
		flap2.setTextureSize(64, 32);
		flap2.mirror = true;
		setRotation(flap2, 0F, 0F, 0F);
		head = new ModelRenderer(this, 0, 22);
		head.addBox(-2F, -3F, -2F, 4, 6, 4);
		head.setRotationPoint(0F, -4F, 0F);
		head.setTextureSize(64, 32);
		head.mirror = true;
		setRotation(head, 0F, 0F, 0F);
		backOfHead = new ModelRenderer(this, 10, 27);
		backOfHead.addBox(-1F, -2F, 2F, 2, 3, 1);
		backOfHead.setRotationPoint(0F, -4F, 0F);
		backOfHead.setTextureSize(64, 32);
		backOfHead.mirror = true;
		setRotation(backOfHead, 0F, 0F, 0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		body.render(f5);
		hunch.render(f5);
		flap1.render(f5);
		flap2.render(f5);
		head.render(f5);
		backOfHead.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
	}

}
