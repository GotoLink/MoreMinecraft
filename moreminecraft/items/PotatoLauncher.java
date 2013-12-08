package moreminecraft.items;

import moreminecraft.entities.EntityBakedPotatoLaunched;
import moreminecraft.entities.EntityPoisonPotatoLaunched;
import moreminecraft.entities.EntityPotatoLaunched;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class PotatoLauncher extends Item {
	public int thrownDamage = 6;

	public PotatoLauncher(int id) {
		super(id);
		this.setMaxDamage(256);
		this.setMaxStackSize(1);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		if (getDamage(par1ItemStack) > 256) {
			par1ItemStack.stackSize--;
		}
		if (par3EntityPlayer.inventory.hasItem(Item.potato.itemID) && !par3EntityPlayer.capabilities.isCreativeMode) {
			par2World.spawnEntityInWorld(new EntityPotatoLaunched(par2World, par3EntityPlayer, thrownDamage, par3EntityPlayer));
			par3EntityPlayer.inventory.consumeInventoryItem(Item.potato.itemID);
			this.setDamage(par1ItemStack, getDamage(par1ItemStack) + 1);
			return par1ItemStack;
		} else if (par3EntityPlayer.capabilities.isCreativeMode) {
			par2World.spawnEntityInWorld(new EntityPotatoLaunched(par2World, par3EntityPlayer, thrownDamage, par3EntityPlayer));
			return par1ItemStack;
		}
		if (par3EntityPlayer.inventory.hasItem(Item.bakedPotato.itemID) && !par3EntityPlayer.capabilities.isCreativeMode) {
			par2World.spawnEntityInWorld(new EntityBakedPotatoLaunched(par2World, par3EntityPlayer, thrownDamage, par3EntityPlayer));
			par3EntityPlayer.inventory.consumeInventoryItem(Item.bakedPotato.itemID);
			this.setDamage(par1ItemStack, getDamage(par1ItemStack) + 1);
			return par1ItemStack;
		} else if (par3EntityPlayer.capabilities.isCreativeMode) {
			par2World.spawnEntityInWorld(new EntityBakedPotatoLaunched(par2World, par3EntityPlayer, thrownDamage, par3EntityPlayer));
			return par1ItemStack;
		}
		if (par3EntityPlayer.inventory.hasItem(Item.poisonousPotato.itemID) && !par3EntityPlayer.capabilities.isCreativeMode) {
			par2World.spawnEntityInWorld(new EntityPoisonPotatoLaunched(par2World, par3EntityPlayer, thrownDamage, par3EntityPlayer));
			par3EntityPlayer.inventory.consumeInventoryItem(Item.poisonousPotato.itemID);
			this.setDamage(par1ItemStack, getDamage(par1ItemStack) + 1);
			return par1ItemStack;
		} else if (par3EntityPlayer.capabilities.isCreativeMode) {
			par2World.spawnEntityInWorld(new EntityPoisonPotatoLaunched(par2World, par3EntityPlayer, thrownDamage, par3EntityPlayer));
			return par1ItemStack;
		}
		par3EntityPlayer.addChatMessage("You dont have any Potatoes!");
		return par1ItemStack;
	}
}
