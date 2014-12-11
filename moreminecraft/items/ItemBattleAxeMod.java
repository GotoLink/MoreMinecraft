package moreminecraft.items;

import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import moreminecraft.MoreMinecraft;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.world.World;

import java.util.Set;

public class ItemBattleAxeMod extends ItemTool {
	public static final Set<Block> blocksEffectiveAgainst = Sets.newHashSet(Blocks.planks, Blocks.bookshelf, Blocks.log, Blocks.chest, Blocks.double_stone_slab, Blocks.stone_slab, Blocks.pumpkin,
            Blocks.lit_pumpkin);
	private float weaponDamage;

	public ItemBattleAxeMod(ToolMaterial par2EnumToolMaterial) {
		super(3.0F, par2EnumToolMaterial, blocksEffectiveAgainst);
		this.setCreativeTab(MoreMinecraft.tabTools);
		this.weaponDamage = 6.0F + par2EnumToolMaterial.getDamageVsEntity();
        setHarvestLevel("axe", par2EnumToolMaterial.getHarvestLevel());
	}

	@Override
	public boolean canHarvestBlock(Block par1Block, ItemStack itemStack) {
		return par1Block == Blocks.web || par1Block.getMaterial() == Material.wood || par1Block.getMaterial() == Material.plants || par1Block.getMaterial() == Material.vine;
	}

	@SuppressWarnings("unchecked")
    @Override
	public Multimap getItemAttributeModifiers() {
		Multimap multimap = super.getItemAttributeModifiers();
		multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Weapon modifier", this.weaponDamage, 0));
		return multimap;
	}

	@Override
	public EnumAction getItemUseAction(ItemStack par1ItemStack) {
		return EnumAction.block;
	}

	@Override
	public int getMaxItemUseDuration(ItemStack par1ItemStack) {
		return 72000;
	}

	@Override
	public float func_150893_a(ItemStack par1ItemStack, Block par2Block) {
		return par2Block.getMaterial() != Material.wood && par2Block.getMaterial() != Material.plants && par2Block.getMaterial() != Material.vine ?
        super.func_150893_a(par1ItemStack, par2Block):  this.efficiencyOnProperMaterial;
	}

	@Override
	public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase) {
		par1ItemStack.damageItem(1, par3EntityLivingBase);
		return true;
	}

	@Override
	public boolean onBlockDestroyed(ItemStack par1ItemStack, World par2World, Block par3, int par4, int par5, int par6, EntityLivingBase par7EntityLivingBase) {
		if (par3.getBlockHardness(par2World, par4, par5, par6) != 0.0D) {
			par1ItemStack.damageItem(2, par7EntityLivingBase);
		}
		return true;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
		return par1ItemStack;
	}
}
