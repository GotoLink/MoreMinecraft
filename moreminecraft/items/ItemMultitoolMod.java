package moreminecraft.items;

import moreminecraft.MoreMinecraft;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

public class ItemMultitoolMod extends ItemTool {
	/** an array of the blocks this pickaxe is effective against */
	public static final Block[] blocksEffectiveAgainst = Block.blocksList;

	public ItemMultitoolMod(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1, 2, par2EnumToolMaterial, blocksEffectiveAgainst);
		setCreativeTab(MoreMinecraft.tabTools);
	}

	@Override
	public boolean canHarvestBlock(Block par1Block) {
		return par1Block == Block.obsidian ? this.toolMaterial.getHarvestLevel() == 3
				: (par1Block != Block.blockDiamond && par1Block != Block.oreDiamond ? (par1Block != Block.oreEmerald && par1Block != Block.blockEmerald ? (par1Block != Block.blockGold
						&& par1Block != Block.oreGold ? (par1Block != Block.blockIron && par1Block != Block.oreIron ? (par1Block != Block.blockLapis && par1Block != Block.oreLapis ? (par1Block != Block.oreRedstone
						&& par1Block != Block.oreRedstoneGlowing ? (par1Block.blockMaterial == Material.rock ? true : (par1Block.blockMaterial == Material.iron ? true
						: par1Block.blockMaterial == Material.anvil)) : this.toolMaterial.getHarvestLevel() >= 2) : this.toolMaterial.getHarvestLevel() >= 1)
						: this.toolMaterial.getHarvestLevel() >= 1)
						: this.toolMaterial.getHarvestLevel() >= 2)
						: this.toolMaterial.getHarvestLevel() >= 2)
						: this.toolMaterial.getHarvestLevel() >= 2);
	}

	@Override
	public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block) {
		return par2Block != null && (par2Block.blockMaterial == Material.iron || par2Block.blockMaterial == Material.anvil || par2Block.blockMaterial == Material.rock) ? this.efficiencyOnProperMaterial
				: super.getStrVsBlock(par1ItemStack, par2Block);
	}
}
