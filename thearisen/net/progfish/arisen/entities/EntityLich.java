package net.progfish.arisen.entities;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityLich extends EntityMob {

	private Random displayRand;
	public float floatOffset;
	
	public EntityLich(World par1World) {
		super(par1World);
	}
	
	@Override
	protected void func_110147_ax() {
		super.func_110147_ax();
		this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(1.7D);
		this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(250D);
	}
	
	@Override
	protected Entity findPlayerToAttack() {
        EntityPlayer entityplayer = this.worldObj.getClosestVulnerablePlayerToEntity(this, 24.0D);
        return entityplayer != null && this.canEntityBeSeen(entityplayer) ? entityplayer : null;
    }
	
	@Override
	protected void attackEntity(Entity par1Entity, float par2) {
        if (this.attackTime <= 0 && par2 < 2.0F && par1Entity.boundingBox.maxY > this.boundingBox.minY && par1Entity.boundingBox.minY < this.boundingBox.maxY)
        {
            this.attackTime = 30;
            this.attackEntityAsMob(par1Entity);
            if(this.getRNG().nextInt(5) == 0)
            {
            	if(par1Entity instanceof EntityLivingBase)
            	{
            		EntityLivingBase entityLiving  = (EntityLivingBase)par1Entity;
            		int effect = this.getRNG().nextInt(4);
            		switch(effect) {
            			case 0:
            				entityLiving.addPotionEffect(new PotionEffect(15, 300, 2, true));
            				break;
            			case 1:
            				entityLiving.addPotionEffect(new PotionEffect(18, 300, 1, true));
            				break;
            			case 2:
            				entityLiving.addPotionEffect(new PotionEffect(9, 300, 1, true));
            				break;
            			case 3:
            				entityLiving.addPotionEffect(new PotionEffect(2, 200, 2, true));
            				break;
            		}
            		if(this.getRNG().nextInt(3) == 0)
            		{
            			this.addPotionEffect(new PotionEffect(14, 400, 2, true));
            		}
            		
            		for (int i = 0; i < 20; ++i)
                    {
                        double d0 = this.rand.nextGaussian() * 0.02D;
                        double d1 = this.rand.nextGaussian() * 0.02D;
                        double d2 = this.rand.nextGaussian() * 0.02D;
                        this.worldObj.spawnParticle("explode", this.posX + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width, this.posY + (double)(this.rand.nextFloat() * this.height), this.posZ + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width, d0, d1, d2);
                    }
            	}
            }
        }
    }
	
	@Override
	public void onDeath(DamageSource par1DamageSource) {
		super.onDeath(par1DamageSource);
		worldObj.setBlock((int)posX, (int)posY, (int)posZ, Block.chest.blockID);
		
		TileEntityChest chest = (TileEntityChest)worldObj.getBlockTileEntity((int)posX, (int)posY, (int)posZ);
		int amountOfLoot = this.getRNG().nextInt(5) + 10;
		for(int i = 0; i < amountOfLoot; i++) {
			chest.setInventorySlotContents(this.getRNG().nextInt(chest.getSizeInventory()), getLoot(this.getRNG()));
		}
    }
	
	private ItemStack getLoot(Random rand)
	{
		switch(rand.nextInt(16)) {
			case 0:
				return new ItemStack(Item.bow, 1, 0);
			case 1:
				return new ItemStack(Item.axeDiamond, 1, 0);
			case 2:
				return new ItemStack(Item.axeGold, 1, 0);
			case 3:
				return new ItemStack(Item.beefCooked, 10, 0);
			case 4:
				return new ItemStack(Item.pickaxeIron, 1, 0);
			case 5:
				return new ItemStack(Item.coal, 64, 0);
			case 6:
				return new ItemStack(Item.eyeOfEnder, 5, 0);
			case 7:
				return new ItemStack(Item.expBottle, 1, 100);
			case 8:
				return new ItemStack(Item.record13, 1, 0);
			case 9:
				return new ItemStack(Item.record11, 1, 0);
			case 10:
				return new ItemStack(Item.swordIron, 1, 0);
			case 11:
				return new ItemStack(Item.swordDiamond, 1, 0);
			case 12:
				return new ItemStack(Item.ingotGold, 20, 0);
			case 13:
				return new ItemStack(Item.ingotIron, 64, 0);
			case 14:
				return new ItemStack(Item.diamond, 3, 0);
			default:
				return new ItemStack(Item.bakedPotato, 64, 0);
		}
	}
	
	@Override
	protected boolean isAIEnabled() {
        return false;
    }

}
