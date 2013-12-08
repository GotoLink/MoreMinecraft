package moreminecraft.blocks;

import java.util.Random;

public class BlockGem extends BasicBlock {
	private int chance;
	private int drop;

	public BlockGem(int id, float hard, int chance, int drop) {
		super(id);
		this.setHardness(hard);
		this.chance = chance;
		this.drop = drop;
	}

	public BlockGem(int id, int drop) {
		super(id);
		this.drop = drop;
	}

	public BlockGem(int id, int chance, int drop) {
		super(id);
		this.chance = chance;
		this.drop = drop;
	}

	@Override
	public int idDropped(int i, Random rand, int j) {
		return drop;
	}

	@Override
	public int quantityDropped(Random rand) {
		return 1 + chance > 0 ? rand.nextInt(chance) : 0;
	}
}
