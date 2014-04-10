package moreminecraft.items;

import moreminecraft.IMultiNamed;
import moreminecraft.blocks.BlockStorage;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

public class ItemBlockWithMetaNamed extends ItemBlockWithMetadata {
	private final Block block;

	public ItemBlockWithMetaNamed(Block block) {
		super(block, block);
		this.block = block;
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		if (block instanceof BlockStorage) {
			return "tile." + ((BlockStorage) block).getNames()[stack.getItemDamage()];
		} else if (block instanceof IMultiNamed) {
			return "tile.ore" + ((IMultiNamed) block).getNames()[stack.getItemDamage()];
		}
		return super.getUnlocalizedName(stack);
	}
}
