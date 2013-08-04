package net.progfish.arisen.entities;

import java.util.Random;

import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityLich extends EntityMob {

	private Random displayRand;
	public float floatOffset;
	
	public EntityLich(World par1World) {
		super(par1World);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAILookIdle(this));
        this.tasks.addTask(2, new EntityAIWander(this, 0.1D));
        this.tasks.addTask(3, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
        
        displayRand = new Random();
        floatOffset = displayRand.nextFloat() / 10F;
	}
	
	protected boolean isAIEnabled()
    {
        return true;
    }
	
	protected String getLivingSound()
    {
        return "mob.lich.speak";
    }

    protected String getHurtSound()
    {
        return "mob.lich.hurt";
    }

    protected String getDeathSound()
    {
        return "mob.zombie.death";
    }
    
    protected void playStepSound(int par1, int par2, int par3, int par4)
    {
        this.playSound("mob.lich.step", 0.15F, 1.0F);
    }

}
