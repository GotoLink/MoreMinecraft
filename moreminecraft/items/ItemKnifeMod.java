package moreminecraft.items;

import moreminecraft.MoreMinecraft;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSword;
import com.google.common.collect.Multimap;

public class ItemKnifeMod extends ItemSword {
	private float weaponDamage;
	private final EnumToolMaterial toolMaterial;

	public ItemKnifeMod(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		this.toolMaterial = par2EnumToolMaterial;
		this.weaponDamage = 4.0F + par2EnumToolMaterial.getDamageVsEntity() / 2 - 2;
		this.setCreativeTab(MoreMinecraft.tabTools);
	}

	@Override
	public float func_82803_g() {
		return (float) ((this.toolMaterial.getDamageVsEntity() / 2) - 1.5);
	}

	@Override
	public Multimap getItemAttributeModifiers() {
		Multimap multimap = super.getItemAttributeModifiers();
		multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Weapon modifier", this.weaponDamage, 0));
		return multimap;
	}
}
