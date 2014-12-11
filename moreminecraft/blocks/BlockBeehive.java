package moreminecraft.blocks;

import moreminecraft.MoreMinecraft;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

import java.util.Random;

public class BlockBeehive extends Block {
	public BlockBeehive() {
		super(Material.fire);
		this.setHardness(0.1F);
		this.setResistance(0);
		this.setStepSound(soundTypeGrass);
		this.setCreativeTab(MoreMinecraft.tabMisc);
	}

	@Override
	public Item getItemDropped(int i, Random rand, int j) {
		return MoreMinecraft.materials;
	}

	@Override
	public int quantityDropped(Random rand) {
		return rand.nextInt(3) + 1;
	}
}
