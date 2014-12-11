package moreminecraft.items;

import moreminecraft.MoreMinecraft;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

public class ItemMultitoolMod extends ItemTool {
	public ItemMultitoolMod(ToolMaterial par2EnumToolMaterial) {
		super(2, par2EnumToolMaterial, null);
		setCreativeTab(MoreMinecraft.tabTools);
        setHarvestLevel("axe", par2EnumToolMaterial.getHarvestLevel());
        setHarvestLevel("pickaxe", par2EnumToolMaterial.getHarvestLevel());
        setHarvestLevel("shovel", par2EnumToolMaterial.getHarvestLevel());
	}

	@Override
	public boolean canHarvestBlock(Block block, ItemStack itemStack) {
        if(block == Blocks.obsidian){
            return this.toolMaterial.getHarvestLevel() >= 3;
        }
        else if(block == Blocks.diamond_block || block == Blocks.diamond_ore || block == Blocks.emerald_ore || block == Blocks.emerald_block || block == Blocks.gold_block || block == Blocks.gold_ore){
            return this.toolMaterial.getHarvestLevel() >= 2;
        }
        else if(block == Blocks.iron_block || block == Blocks.iron_ore || block == Blocks.lapis_block || block == Blocks.lapis_ore){
            return this.toolMaterial.getHarvestLevel() >= 1;
        }
        else if(block == Blocks.redstone_ore || block == Blocks.lit_redstone_ore){
            return this.toolMaterial.getHarvestLevel() >= 2;
        }
        else
            return isPickableMaterial(block.getMaterial());
	}

	@Override
	public float func_150893_a(ItemStack par1ItemStack, Block par2Block) {
		return this.efficiencyOnProperMaterial;
	}

    public boolean isPickableMaterial(Material material){
        return material == Material.ground || material == Material.rock || material == Material.iron || material == Material.anvil;
    }
}
