package moreminecraft.blocks;

import java.util.Random;

import moreminecraft.MoreMinecraft;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockBeehive extends Block {
	public BlockBeehive(int id) {
		super(id, Material.air);
		this.setHardness(0.1F);
		this.setResistance(0);
		this.setStepSound(soundGrassFootstep);
		this.setCreativeTab(MoreMinecraft.tabMisc);
	}

	@Override
	public int idDropped(int i, Random rand, int j) {
		return MoreMinecraft.materials.itemID;
	}

	@Override
	public int quantityDropped(Random rand) {
		return rand.nextInt(3) + 1;
	}
}
