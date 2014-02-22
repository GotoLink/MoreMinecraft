package moreminecraft.items;

import moreminecraft.entities.EntityBakedPotatoLaunched;
import moreminecraft.entities.EntityPoisonPotatoLaunched;
import moreminecraft.entities.EntityPotatoLaunched;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;

public class PotatoLauncher extends Item {
	public int thrownDamage = 6;

	public PotatoLauncher() {
		super();
		this.setMaxDamage(256);
		this.setMaxStackSize(1);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		if (getDamage(par1ItemStack) > 256) {
			par1ItemStack.stackSize--;
		}
		if (par3EntityPlayer.inventory.hasItem(Items.potato) && !par3EntityPlayer.capabilities.isCreativeMode) {
			par2World.spawnEntityInWorld(new EntityPotatoLaunched(par2World, par3EntityPlayer, thrownDamage, par3EntityPlayer));
			par3EntityPlayer.inventory.consumeInventoryItem(Items.potato);
			this.setDamage(par1ItemStack, getDamage(par1ItemStack) + 1);
			return par1ItemStack;
		} else if (par3EntityPlayer.capabilities.isCreativeMode) {
			par2World.spawnEntityInWorld(new EntityPotatoLaunched(par2World, par3EntityPlayer, thrownDamage, par3EntityPlayer));
			return par1ItemStack;
		}
		if (par3EntityPlayer.inventory.hasItem(Items.baked_potato) && !par3EntityPlayer.capabilities.isCreativeMode) {
			par2World.spawnEntityInWorld(new EntityBakedPotatoLaunched(par2World, par3EntityPlayer, thrownDamage, par3EntityPlayer));
			par3EntityPlayer.inventory.consumeInventoryItem(Items.baked_potato);
			this.setDamage(par1ItemStack, getDamage(par1ItemStack) + 1);
			return par1ItemStack;
		} else if (par3EntityPlayer.capabilities.isCreativeMode) {
			par2World.spawnEntityInWorld(new EntityBakedPotatoLaunched(par2World, par3EntityPlayer, thrownDamage, par3EntityPlayer));
			return par1ItemStack;
		}
		if (par3EntityPlayer.inventory.hasItem(Items.poisonous_potato) && !par3EntityPlayer.capabilities.isCreativeMode) {
			par2World.spawnEntityInWorld(new EntityPoisonPotatoLaunched(par2World, par3EntityPlayer, thrownDamage, par3EntityPlayer));
			par3EntityPlayer.inventory.consumeInventoryItem(Items.poisonous_potato);
			this.setDamage(par1ItemStack, getDamage(par1ItemStack) + 1);
			return par1ItemStack;
		} else if (par3EntityPlayer.capabilities.isCreativeMode) {
			par2World.spawnEntityInWorld(new EntityPoisonPotatoLaunched(par2World, par3EntityPlayer, thrownDamage, par3EntityPlayer));
			return par1ItemStack;
		}
		par3EntityPlayer.addChatComponentMessage(new ChatComponentTranslation("launcher.no.potato"));
		return par1ItemStack;
	}
}
