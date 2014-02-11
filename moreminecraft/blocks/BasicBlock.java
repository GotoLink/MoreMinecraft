package moreminecraft.blocks;

import moreminecraft.IMultiNamed;
import moreminecraft.MoreMinecraft;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public abstract class BasicBlock extends Block implements IMultiNamed {
	public BasicBlock() {
		super(Material.field_151576_e);
		this.func_149711_c(3F);
		this.func_149752_b(0);
		this.func_149672_a(field_149780_i);
		this.func_149647_a(MoreMinecraft.tabMisc);
	}
}
