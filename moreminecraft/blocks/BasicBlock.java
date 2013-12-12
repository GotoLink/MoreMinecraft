package moreminecraft.blocks;

import moreminecraft.IMultiNamed;
import moreminecraft.MoreMinecraft;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public abstract class BasicBlock extends Block implements IMultiNamed {
	public BasicBlock(int id) {
		super(id, Material.rock);
		this.setHardness(3F);
		this.setResistance(0);
		this.setStepSound(soundStoneFootstep);
		this.setCreativeTab(MoreMinecraft.tabMisc);
	}
}
