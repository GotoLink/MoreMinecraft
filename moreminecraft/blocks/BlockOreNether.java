package moreminecraft.blocks;

import java.util.Random;

public class BlockOreNether extends BasicBlock {
	int quanity;
	int typeID;
	int metadata;

	public BlockOreNether(int id, int par2, int par3, int par4) {
		super(id);
		typeID = par2;
		quanity = par3;
		metadata = par4;
	}

	@Override
	public int damageDropped(int i) {
		return metadata;
	}

	@Override
	public int idDropped(int i, Random rand, int j) {
		return typeID;
	}

	@Override
	public int quantityDropped(Random rand) {
		return rand.nextInt(quanity) + 1;
	}
}
