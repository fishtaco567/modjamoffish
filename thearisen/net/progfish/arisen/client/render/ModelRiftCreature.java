package net.progfish.arisen.client.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;

public class ModelRiftCreature extends ModelBase
{
	//fields
	ModelRenderer bodyMain;
	ModelRenderer bodySideL;
	ModelRenderer bodySideB;
	ModelRenderer bodyCornerFL;
	ModelRenderer bodyCornerBL;
	ModelRenderer bodyCornerBR;
	ModelRenderer bodyCornerFR;
	ModelRenderer footFL;
	ModelRenderer head;
	ModelRenderer tailMid;
	ModelRenderer tailBase;
	ModelRenderer tailEnd;
	ModelRenderer bodySideF;
	ModelRenderer hornL;
	ModelRenderer hornR;
	ModelRenderer bodySideR;
	ModelRenderer footBL;
	ModelRenderer footFR;
	ModelRenderer footBR;

	public ModelRiftCreature()
	{
		textureWidth = 64;
		textureHeight = 32;

		bodyMain = new ModelRenderer(this, 0, 0);
		bodyMain.addBox(-3F, 0F, -6F, 6, 1, 12);
		bodyMain.setRotationPoint(0F, 20F, 0F);
		bodyMain.setTextureSize(64, 32);
		bodyMain.mirror = true;
		setRotation(bodyMain, 0F, 0F, 0F);
		bodySideL = new ModelRenderer(this, 36, 0);
		bodySideL.addBox(-4F, -1F, -5.5F, 1, 3, 11);
		bodySideL.setRotationPoint(0F, 20F, 0F);
		bodySideL.setTextureSize(64, 32);
		bodySideL.mirror = true;
		setRotation(bodySideL, 0F, 0F, 0F);
		bodySideB = new ModelRenderer(this, 0, 0);
		bodySideB.addBox(-2F, -1F, 6F, 4, 3, 1);
		bodySideB.setRotationPoint(0F, 20F, 0F);
		bodySideB.setTextureSize(64, 32);
		bodySideB.mirror = true;
		setRotation(bodySideB, 0F, 0F, 0F);
		bodyCornerFL = new ModelRenderer(this, 24, 0);
		bodyCornerFL.addBox(-1F, 0F, -2F, 1, 3, 2);
		bodyCornerFL.setRotationPoint(-3F, 19F, -5F);
		bodyCornerFL.setTextureSize(64, 32);
		bodyCornerFL.mirror = true;
		setRotation(bodyCornerFL, 0F, -0.7679449F, 0F);
		bodyCornerBL = new ModelRenderer(this, 24, 0);
		bodyCornerBL.addBox(-1F, 0F, 0F, 1, 3, 2);
		bodyCornerBL.setRotationPoint(-3F, 19F, 5F);
		bodyCornerBL.setTextureSize(64, 32);
		bodyCornerBL.mirror = true;
		setRotation(bodyCornerBL, 0F, 0.7679449F, 0F);
		bodyCornerBR = new ModelRenderer(this, 24, 0);
		bodyCornerBR.addBox(0F, 0F, 0F, 1, 3, 2);
		bodyCornerBR.setRotationPoint(3F, 19F, 5F);
		bodyCornerBR.setTextureSize(64, 32);
		bodyCornerBR.mirror = true;
		setRotation(bodyCornerBR, 0F, -0.7679449F, 0F);
		bodyCornerFR = new ModelRenderer(this, 24, 0);
		bodyCornerFR.addBox(0F, 0F, -2F, 1, 3, 2);
		bodyCornerFR.setRotationPoint(3F, 19F, -5F);
		bodyCornerFR.setTextureSize(64, 32);
		bodyCornerFR.mirror = true;
		setRotation(bodyCornerFR, 0F, 0.7679449F, 0F);
		footFL = new ModelRenderer(this, 0, 13);
		footFL.addBox(-1F, 0F, -2F, 2, 3, 2);
		footFL.setRotationPoint(-4F, 21F, -3F);
		footFL.setTextureSize(64, 32);
		footFL.mirror = true;
		setRotation(footFL, 0F, 0F, 0F);
		head = new ModelRenderer(this, 0, 24);
		head.addBox(-2F, -3F, -3F, 4, 4, 4);
		head.setRotationPoint(0F, 19F, -7.1F);
		head.setTextureSize(64, 32);
		head.mirror = true;
		setRotation(head, 0F, 0F, 0F);
		tailMid = new ModelRenderer(this, 38, 0);
		tailMid.addBox(-1F, -2F, -1F, 2, 2, 1);
		tailMid.setRotationPoint(0F, 19.46667F, 4F);
		tailMid.setTextureSize(64, 32);
		tailMid.mirror = true;
		setRotation(tailMid, -0.6108652F, 0F, 0F);
		tailBase = new ModelRenderer(this, 30, 0);
		tailBase.addBox(-1F, 0F, -1F, 2, 1, 2);
		tailBase.setRotationPoint(0F, 19F, 3F);
		tailBase.setTextureSize(64, 32);
		tailBase.mirror = true;
		setRotation(tailBase, 0F, 0F, 0F);
		tailEnd = new ModelRenderer(this, 30, 3);
		tailEnd.addBox(-1F, 0F, 0F, 2, 1, 6);
		tailEnd.setRotationPoint(0F, 17F, 4.5F);
		tailEnd.setTextureSize(64, 32);
		tailEnd.mirror = true;
		setRotation(tailEnd, 0.3346075F, 0F, 0F);
		bodySideF = new ModelRenderer(this, 0, 0);
		bodySideF.addBox(-2F, -1F, -7F, 4, 3, 1);
		bodySideF.setRotationPoint(0F, 20F, 0F);
		bodySideF.setTextureSize(64, 32);
		bodySideF.mirror = true;
		setRotation(bodySideF, 0F, 0F, 0F);
		hornL = new ModelRenderer(this, 0, 24);
		hornL.addBox(0F, -3F, 0F, 1, 3, 1);
		hornL.setRotationPoint(-1.9F, -3F, -3F);
		hornL.setTextureSize(64, 32);
		hornL.mirror = true;
		setRotation(hornL, -0.4363323F, 0F, 0F);
		hornR = new ModelRenderer(this, 0, 24);
		hornR.addBox(0F, -3F, 0F, 1, 3, 1);
		hornR.setRotationPoint(0.9F, -3F, -3F);
		hornR.setTextureSize(64, 32);
		hornR.mirror = true;
		setRotation(hornR, -0.4461433F, 0F, 0F);
		bodySideR = new ModelRenderer(this, 36, 0);
		bodySideR.addBox(3F, -1F, -4.5F, 1, 3, 11);
		bodySideR.setRotationPoint(0F, 20F, -1F);
		bodySideR.setTextureSize(64, 32);
		bodySideR.mirror = true;
		setRotation(bodySideR, 0F, 0F, 0F);
		footBL = new ModelRenderer(this, 0, 13);
		footBL.addBox(-1F, 0F, -2F, 2, 3, 2);
		footBL.setRotationPoint(-4F, 21F, 5F);
		footBL.setTextureSize(64, 32);
		footBL.mirror = true;
		setRotation(footBL, 0F, 0F, 0F);
		footFR = new ModelRenderer(this, 0, 13);
		footFR.addBox(-1F, 0F, -2F, 2, 3, 2);
		footFR.setRotationPoint(4F, 21F, -3F);
		footFR.setTextureSize(64, 32);
		footFR.mirror = true;
		setRotation(footFR, 0F, 0F, 0F);
		footBR = new ModelRenderer(this, 0, 13);
		footBR.addBox(-1F, 0F, -2F, 2, 3, 2);
		footBR.setRotationPoint(4F, 21F, 5F);
		footBR.setTextureSize(64, 32);
		footBR.mirror = true;
		setRotation(footBR, 0F, 0F, 0F);
		head.addChild(hornL);
		head.addChild(hornR);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		bodyMain.render(f5);
		bodySideL.render(f5);
		bodySideB.render(f5);
		bodyCornerFL.render(f5);
		bodyCornerBL.render(f5);
		bodyCornerBR.render(f5);
		bodyCornerFR.render(f5);
		footFL.render(f5);
		head.render(f5);
		tailMid.render(f5);
		tailBase.render(f5);
		tailEnd.render(f5);
		bodySideF.render(f5);
		bodySideR.render(f5);
		footBL.render(f5);
		footFR.render(f5);
		footBR.render(f5);
	}

    @Override
    public void setLivingAnimations(EntityLivingBase entityliving, float f, float f1, float f2) {
        footFL.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.141592F) * 1.75F * f1;
        footFR.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.141592F) * 1.75F * f1;
        footBL.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.75F * f1;
        footBR.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.75F * f1;
    }

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        head.rotateAngleX = f4 / 57.29578F;
        head.rotateAngleY = f3 / 57.29578F;
	}

}
