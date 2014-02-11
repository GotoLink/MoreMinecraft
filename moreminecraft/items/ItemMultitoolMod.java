package moreminecraft.items;

import cpw.mods.fml.common.registry.GameData;
import moreminecraft.MoreMinecraft;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

public class ItemMultitoolMod extends ItemTool {
	public ItemMultitoolMod(ToolMaterial par2EnumToolMaterial) {
		super(2, par2EnumToolMaterial, GameData.blockRegistry.func_148742_b());
		setCreativeTab(MoreMinecraft.tabTools);
	}

	@Override
	public boolean func_150897_b(Block par1Block) {
		return par1Block == Blocks.obsidian ? this.toolMaterial.getHarvestLevel() == 3
				: (par1Block != Blocks.diamond_block && par1Block != Blocks.diamond_ore ? (par1Block != Blocks.emerald_ore && par1Block != Blocks.emerald_block ? (par1Block != Blocks.gold_block
						&& par1Block != Blocks.gold_ore ? (par1Block != Blocks.iron_block && par1Block != Blocks.iron_ore ? (par1Block != Blocks.lapis_block && par1Block != Blocks.lapis_ore ? (par1Block != Blocks.redstone_ore
						&& par1Block != Blocks.lit_redstone_ore ? (par1Block.func_149688_o() == Material.field_151576_e ? true : (par1Block.func_149688_o() == Material.field_151573_f ? true
						: par1Block.func_149688_o() == Material.field_151574_g)) : this.toolMaterial.getHarvestLevel() >= 2) : this.toolMaterial.getHarvestLevel() >= 1)
						: this.toolMaterial.getHarvestLevel() >= 1)
						: this.toolMaterial.getHarvestLevel() >= 2)
						: this.toolMaterial.getHarvestLevel() >= 2)
						: this.toolMaterial.getHarvestLevel() >= 2);
	}

	@Override
	public float func_150893_a(ItemStack par1ItemStack, Block par2Block) {
		return par2Block != null && (par2Block.func_149688_o() == Material.field_151573_f || par2Block.func_149688_o() == Material.field_151574_g || par2Block.func_149688_o() == Material.field_151576_e) ? this.efficiencyOnProperMaterial
				: super.func_150893_a(par1ItemStack, par2Block);
	}
}
