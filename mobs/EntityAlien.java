package net.jlndk.Moonmod.mobs;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIControlledByPlayer;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityAlien extends EntityAnimal{

	public EntityAlien(World par1World) {
		super(par1World);
		float var2 = 0.25F;
		this.setSize(1.0F, 1.0F);
		this.texture = "/jlndk/moonmod/mobs/Alien.png";
		this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 0.38F));
        this.tasks.addTask(4, new EntityAITempt(this, 0.3F, Item.carrotOnAStick.shiftedIndex, false));
        this.tasks.addTask(4, new EntityAITempt(this, 0.3F, Item.carrot.shiftedIndex, false));
        this.tasks.addTask(5, new EntityAIFollowParent(this, 0.28F));
        this.tasks.addTask(6, new EntityAIWander(this, var2));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
	}
	
	/**
     * Returns true if the newer Entity AI code should be run
     */
    public boolean isAIEnabled()
    {
        return true;
    }
	
	@Override
	public int getMaxHealth() {
		return 20;
	}
	
	//Sounds
	/**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
        return "mob.endermen.idle";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "mob.endermen.hit";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "mob.endermen.death";
    }
   
    protected void playStepSound(int par1, int par2, int par3, int par4)
    {
        this.func_85030_a("mob.pig.step", 0.15F, 1.0F);
    }

   //needed method
	@Override
	public EntityAgeable func_90011_a(EntityAgeable var1) {
		return null;
	}

}
