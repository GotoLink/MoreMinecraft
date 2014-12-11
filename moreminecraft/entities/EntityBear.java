package moreminecraft.entities;

import net.minecraft.block.Block;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityBear extends EntityMob {
	public EntityBear(World par1World) {
		super(par1World);
		this.setSize(0.9F, 1.3F);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 12.0F, true));
		this.tasks.addTask(3, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
		this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 12.0F));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20D);
	}

	@Override
	protected String getDeathSound() {
		return "BearHurt";
	}

	@Override
	protected String getHurtSound() {
		return "BearHurt";
	}

	@Override
	protected String getLivingSound() {
		return "BearIdle";
	}

	@Override
	protected void func_145780_a(int par1, int par2, int par3, Block par4) {
		this.playSound("mob.cow.step", 0.15F, 1.0F);
	}
}