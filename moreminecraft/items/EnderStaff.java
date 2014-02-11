package moreminecraft.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EnderStaff extends Item {
	public EnderStaff() {
		super();
		this.maxStackSize = 1;
		this.setMaxDamage(64);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
		if (!par2World.isRemote) {
			// par2World.spawnEntityInWorld(new EntityDiamondEnderpearl(par2World, par3EntityPlayer))
			//par2World.spawnEntityInWorld(new EntityGrenade(par2World, par3EntityPlayer.posX, par3EntityPlayer.posY,par3EntityPlayer.posZ,par3EntityPlayer));
			this.setDamage(par1ItemStack, this.getDamage(par1ItemStack) + 1);
		}
		if (this.getDamage(par1ItemStack) >= 64) {
			--par1ItemStack.stackSize;
		}
		return par1ItemStack;
	}
}
