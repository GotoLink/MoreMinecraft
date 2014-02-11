package moreminecraft.items;

import moreminecraft.MoreMinecraft;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemArmorRedstoneMod extends ItemArmorMod {
	public ItemArmorRedstoneMod(ArmorMaterial par2EnumArmorMaterial, int par4, String armorFile) {
		super(par2EnumArmorMaterial, par4, armorFile);
	}

	public void addPotionWhenEquiped(Item item, EntityPlayer player, int type, int potID, int potTick, int potStrong) {
		ItemStack itemPar1 = player.getCurrentItemOrArmor(type);
		if (itemPar1 != null && itemPar1.getItem() == item) {
			player.addPotionEffect(new PotionEffect(potID, potTick, potStrong));
		}
	}

	public void addPotionWhenSubmerged(Item item, EntityPlayer player, int type, int potID, int potTick, int potStrong) {
		ItemStack itemPar1 = player.getCurrentItemOrArmor(type);
		if (itemPar1 != null && itemPar1.getItem() == item && player.isInsideOfMaterial(Material.field_151586_h)) {
			player.addPotionEffect(new PotionEffect(potID, potTick, potStrong));
		}
	}

	public void addPotionWhenWalk(Item item, EntityPlayer player, int type, int potID, int potTick, int potStrong) {
		if (player.getCurrentItemOrArmor(type) != null) {
			ItemStack itemPar1 = player.getCurrentItemOrArmor(type);
			boolean Moving = player.moveForward != 0 || player.moveStrafing != 0;
			if (itemPar1 != null && itemPar1.getItem() == item && Moving && player.onGround) {
				player.addPotionEffect(new PotionEffect(potID, potTick, potStrong));
			}
		}
	}

	@Override
	public void onArmorTick(World par1World, EntityPlayer player, ItemStack par3ItemStack) {
		if (!par1World.isRemote) {
			addPotionWhenEquiped(MoreMinecraft.helmetGogglesVision, player, 4, Potion.nightVision.getId(), 210, 0);
			addPotionWhenEquiped(MoreMinecraft.plateDualHearts, player, 3, Potion.regeneration.getId(), 21, 2);
			addPotionWhenEquiped(MoreMinecraft.plateDualHearts, player, 3, Potion.field_76443_y.getId(), 21, 0);
			addPotionWhenSubmerged(MoreMinecraft.scubaHelmet, player, 4, Potion.waterBreathing.getId(), 21, 0);
			addPotionWhenWalk(MoreMinecraft.legsSwiftness, player, 2, Potion.moveSpeed.getId(), 10, 0);
		}
	}
}