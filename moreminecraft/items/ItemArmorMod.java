package moreminecraft.items;

import moreminecraft.MoreMinecraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemArmorMod extends ItemArmor {
	String armorFile;

	public ItemArmorMod(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4, String armorFile) {
		super(par1, par2EnumArmorMaterial, par3, par4);
		this.armorFile = armorFile;
		this.setCreativeTab(MoreMinecraft.tabMisc);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer) {
		return "moreminecraft:" + armorFile + ".png";
	}
}