package moreminecraft.items;

import moreminecraft.MoreMinecraft;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.item.ItemSword;
import com.google.common.collect.Multimap;

public class ItemKnifeMod extends ItemSword {
	private float weaponDamage;
	private final ToolMaterial toolMaterial;

	public ItemKnifeMod(ToolMaterial par2EnumToolMaterial) {
		super(par2EnumToolMaterial);
		this.toolMaterial = par2EnumToolMaterial;
		this.weaponDamage = 2.0F + par2EnumToolMaterial.getDamageVsEntity() / 2;
		this.setCreativeTab(MoreMinecraft.tabTools);
	}

	@Override
	public float func_150931_i() {
		return (float) ((this.toolMaterial.getDamageVsEntity() / 2) - 1.5);
	}

	@SuppressWarnings("unchecked")
    @Override
	public Multimap getItemAttributeModifiers() {
		Multimap multimap = super.getItemAttributeModifiers();
		multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Weapon modifier", this.weaponDamage, 0));
		return multimap;
	}
}
