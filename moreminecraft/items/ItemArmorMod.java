package moreminecraft.items;

import moreminecraft.MoreMinecraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemArmorMod extends ItemArmor {
	final String armorFile;

	public ItemArmorMod(ArmorMaterial par2EnumArmorMaterial, int par4, String armorFile) {
		super(par2EnumArmorMaterial, 0, par4);
		this.armorFile = armorFile;
		this.setCreativeTab(MoreMinecraft.tabMisc);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String layer) {
		return "moreminecraft:" + armorFile + (slot == 2 ? "_2" : "_1") + ".png";
	}
}