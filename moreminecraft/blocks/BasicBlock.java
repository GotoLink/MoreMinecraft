package moreminecraft.blocks;

import moreminecraft.MoreMinecraft;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BasicBlock extends Block {
	public BasicBlock(int id) {
		super(id, Material.rock);
		this.setHardness(3F);
		this.setResistance(0);
		this.setStepSound(soundStoneFootstep);
		this.setCreativeTab(MoreMinecraft.tabMisc);
	}
}
