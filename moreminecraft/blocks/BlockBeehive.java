package moreminecraft.blocks;

import java.util.Random;

import moreminecraft.MoreMinecraft;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class BlockBeehive extends Block {
	public BlockBeehive() {
		super(Material.field_151581_o);
		this.func_149711_c(0.1F);
		this.func_149752_b(0);
		this.func_149672_a(field_149779_h);
		this.func_149647_a(MoreMinecraft.tabMisc);
	}

	@Override
	public Item func_149650_a(int i, Random rand, int j) {
		return MoreMinecraft.materials;
	}

	@Override
	public int func_149745_a(Random rand) {
		return rand.nextInt(3) + 1;
	}
}
