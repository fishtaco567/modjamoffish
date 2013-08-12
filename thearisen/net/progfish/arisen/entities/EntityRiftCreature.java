package net.progfish.arisen.entities;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.progfish.arisen.ArisenMod;

public class EntityRiftCreature extends EntityMob {

	public EntityRiftCreature(World par1World) {
		super(par1World);
        this.isImmuneToFire = true;
        this.setSize(0.9F, 0.4F);
	}
	
	@Override
	public void entityInit() {
		super.entityInit();
	}
	
	@Override
	protected void func_110147_ax() {
		super.func_110147_ax();
		this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(1.2D);
		this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(10D);
	}
	
	@Override
    protected void fall(float par1) {}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void onEntityUpdate() {
		super.onEntityUpdate();
		boolean flag = true;
		if(rand.nextInt(40) == 0) {
			for(Object obj : this.getActivePotionEffects()) {
				if(obj instanceof PotionEffect) {
					PotionEffect effect = (PotionEffect)obj;
					if(effect.getPotionID() == 14) {
						flag = false;
					}
				}
			}
    		for (int i = 0; i < 10; i++) {
                double d0 = this.rand.nextGaussian() * 0.02D;
                double d1 = this.rand.nextGaussian() * 0.02D;
                double d2 = this.rand.nextGaussian() * 0.02D;
                if(flag) {
                	ArisenMod.proxy.spawnParticle("riftsmall", this.posX + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width, this.posY + (double)(this.rand.nextFloat() * this.height), this.posZ + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width, d0, d1, d2);
                }
            }
		}
	}
	
	@Override
	protected Entity findPlayerToAttack() {
        EntityPlayer entityplayer = this.worldObj.getClosestVulnerablePlayerToEntity(this, 24.0D);
        return entityplayer != null && this.canEntityBeSeen(entityplayer) ? entityplayer : null;
    }

}
