package moreminecraft.items;

import moreminecraft.MoreMinecraft;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemArmorRedstoneMod extends ItemArmor {
	String armorFile;

	public ItemArmorRedstoneMod(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4, String armorFile) {
		super(par1, par2EnumArmorMaterial, par3, par4);
		this.armorFile = armorFile;
		setCreativeTab(MoreMinecraft.tabMisc);
	}

	public void addPotionWhenEquiped(Item item, EntityPlayer player, int type, int potID, int potTick, int potStrong) {
		if (player.getCurrentItemOrArmor(type) != null) {
			ItemStack itemPar1 = player.getCurrentItemOrArmor(type);
			if (itemPar1 != null && itemPar1.itemID == item.itemID) {
				player.addPotionEffect(new PotionEffect(potID, potTick, potStrong));
			}
		}
	}

	public void addPotionWhenJump(Item item, EntityPlayer player, int type, int potID, int potTick, int potStrong) {
		if (player.getCurrentItemOrArmor(type) != null) {
			ItemStack itemPar1 = player.getCurrentItemOrArmor(type);
			boolean isJumping = player.isJumping && !player.capabilities.isFlying;
			if (itemPar1 != null && itemPar1.itemID == item.itemID && isJumping) {
				player.addPotionEffect(new PotionEffect(potID, potTick, potStrong));
			}
		}
	}

	public void addPotionWhenSubmerged(Item item, EntityPlayer player, int type, int potID, int potTick, int potStrong) {
		if (player.getCurrentItemOrArmor(type) != null) {
			ItemStack itemPar1 = player.getCurrentItemOrArmor(type);
			boolean isSubmerged = player.isInsideOfMaterial(Material.water);
			if (itemPar1 != null && itemPar1.itemID == item.itemID && isSubmerged) {
				player.addPotionEffect(new PotionEffect(potID, potTick, potStrong));
			}
		}
	}

	public void addPotionWhenWalk(Item item, EntityPlayer player, int type, int potID, int potTick, int potStrong) {
		if (player.getCurrentItemOrArmor(type) != null) {
			ItemStack itemPar1 = player.getCurrentItemOrArmor(type);
			boolean Moving = player.moveForward != 0 || player.moveStrafing != 0;
			boolean isJumping = player.isJumping && !player.capabilities.isFlying;
			if (itemPar1 != null && itemPar1.itemID == item.itemID && ((Moving && isJumping) || Moving) && (player.onGround || isJumping)) {
				player.addPotionEffect(new PotionEffect(potID, potTick, potStrong));
			}
		}
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer) {
		return "moreminecraft:" + armorFile + ".png";
	}

	@Override
	public void onArmorTickUpdate(World par1World, EntityPlayer player, ItemStack par3ItemStack) {
		if (!par1World.isRemote) {
			addPotionWhenEquiped(MoreMinecraft.helmetGogglesVision, player, 4, Potion.nightVision.getId(), 210, 0);
			addPotionWhenEquiped(MoreMinecraft.plateDualHearts, player, 3, Potion.regeneration.getId(), 21, 2);
			addPotionWhenEquiped(MoreMinecraft.plateDualHearts, player, 3, Potion.field_76443_y.getId(), 21, 0);
			addPotionWhenJump(MoreMinecraft.jumpBoots, player, 1, Potion.jump.getId(), 1, 0);
			addPotionWhenSubmerged(MoreMinecraft.scubaHelmet, player, 4, Potion.waterBreathing.getId(), 21, 0);
			addPotionWhenWalk(MoreMinecraft.legsSwiftness, player, 2, Potion.moveSpeed.getId(), 10, 0);
		}
	}
}