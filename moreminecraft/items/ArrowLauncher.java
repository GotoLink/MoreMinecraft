package moreminecraft.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ArrowLauncher extends Item {
	public ArrowLauncher() {
		super();
		this.setMaxDamage(256);
		this.setMaxStackSize(1);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		if (getDamage(par1ItemStack) > this.getMaxDamage()) {
			par1ItemStack.stackSize--;
		}
		if (par3EntityPlayer.inventory.hasItem(Items.arrow) || par3EntityPlayer.capabilities.isCreativeMode) {
			EntityArrow entityarrow = new EntityArrow(par2World, par3EntityPlayer, 2);
			if (par3EntityPlayer.capabilities.isCreativeMode) {
				entityarrow.canBePickedUp = 0;
			} else
				entityarrow.canBePickedUp = 1;
			par2World.spawnEntityInWorld(entityarrow);
			if (!par3EntityPlayer.capabilities.isCreativeMode) {
				par3EntityPlayer.inventory.consumeInventoryItem(Items.arrow);
				this.setDamage(par1ItemStack, getDamage(par1ItemStack) + 1);
			}
		}
		return par1ItemStack;
	}
}
