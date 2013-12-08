package moreminecraft.items;

import moreminecraft.MoreMinecraft;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.world.World;

import com.google.common.collect.Multimap;

public class ItemBattleAxeMod extends ItemTool {
	public static final Block[] blocksEffectiveAgainst = new Block[] { Block.planks, Block.bookShelf, Block.wood, Block.chest, Block.stoneDoubleSlab, Block.stoneSingleSlab, Block.pumpkin,
			Block.pumpkinLantern };
	private float weaponDamage;

	public ItemBattleAxeMod(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1, 3.0F, par2EnumToolMaterial, blocksEffectiveAgainst);
		this.setCreativeTab(MoreMinecraft.tabMisc);
		this.weaponDamage = 4.0F + par2EnumToolMaterial.getDamageVsEntity() + 2;
	}

	@Override
	public boolean canHarvestBlock(Block par1Block) {
		return par1Block.blockID == Block.web.blockID || par1Block.blockMaterial == Material.wood || par1Block.blockMaterial == Material.plants || par1Block.blockMaterial == Material.vine;
	}

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
	public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block) {
		return par2Block != null && (par2Block.blockMaterial == Material.wood || par2Block.blockMaterial == Material.plants || par2Block.blockMaterial == Material.vine) ? this.efficiencyOnProperMaterial
				: super.getStrVsBlock(par1ItemStack, par2Block);
	}

	@Override
	public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase) {
		par1ItemStack.damageItem(1, par3EntityLivingBase);
		return true;
	}

	@Override
	public boolean onBlockDestroyed(ItemStack par1ItemStack, World par2World, int par3, int par4, int par5, int par6, EntityLivingBase par7EntityLivingBase) {
		if (Block.blocksList[par3].getBlockHardness(par2World, par4, par5, par6) != 0.0D) {
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
