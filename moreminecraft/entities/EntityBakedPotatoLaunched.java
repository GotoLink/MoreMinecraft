package moreminecraft.entities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityBakedPotatoLaunched extends EntityThrowable {
	int damage = 0;
	EntityPlayer thePlayer = null;

	public EntityBakedPotatoLaunched(World par1World) {
		super(par1World);
	}

	public EntityBakedPotatoLaunched(World par1World, double par2, double par4, double par6) {
		super(par1World, par2, par4, par6);
	}

	public EntityBakedPotatoLaunched(World par1World, EntityLivingBase par2EntityLivingBase, int par4, EntityPlayer player) {
		super(par1World, par2EntityLivingBase);
		damage = par4;
		thePlayer = player;
	}

	@Override
	protected void onImpact(MovingObjectPosition par1MovingObjectPosition) {
		if (par1MovingObjectPosition.entityHit != null) {
			byte b0 = 0;
			if (par1MovingObjectPosition.entityHit instanceof EntityBlaze) {
				b0 = 3;
			}
			par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), damage);
			par1MovingObjectPosition.entityHit.setFire(60);
		}
		if (!this.worldObj.isRemote) {
			this.setDead();
		}
		if (thePlayer != null && thePlayer.capabilities.isCreativeMode == false && !this.worldObj.isRemote) {
			EntityItem entityitem = new EntityItem(this.worldObj, this.posX, this.posY, this.posZ, new ItemStack(Items.baked_potato));
			entityitem.delayBeforeCanPickup = 10;
			this.worldObj.spawnEntityInWorld(entityitem);
		}
	}
}
