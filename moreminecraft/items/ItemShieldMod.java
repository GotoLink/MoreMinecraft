package moreminecraft.items;

import net.minecraft.block.Block;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

import com.google.common.collect.Multimap;

@SuppressWarnings("UnusedDeclaration")
public class ItemShieldMod extends ItemSword {
	private float weaponDamage;

	public ItemShieldMod(ToolMaterial par2EnumToolMaterial) {
		super(par2EnumToolMaterial);
		this.weaponDamage = 1.0F;
	}

	@Override
	public boolean func_150897_b(Block par1Block) {
		return false;
	}

	@Override
	public float func_150931_i() {
		return 1.0F;
	}

	@SuppressWarnings("unchecked")
    @Override
	public Multimap getItemAttributeModifiers() {
		Multimap multimap = super.getItemAttributeModifiers();
		multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Weapon modifier", this.weaponDamage, 0));
		return multimap;
	}

	@Override
	public float func_150893_a(ItemStack par1ItemStack, Block par2Block) {
		return 0.0F;
	}
}
