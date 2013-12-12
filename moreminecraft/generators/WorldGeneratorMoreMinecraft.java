package moreminecraft.generators;

import java.util.Random;

import moreminecraft.MoreMinecraft;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGeneratorMoreMinecraft implements IWorldGenerator {
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.dimensionId) {
		case -1:
			generateNether(world, random, chunkX * 16, chunkZ * 16);
			break;
		case 0:
			generateSurface(world, random, chunkX * 16, chunkZ * 16);
			break;
		case 1:
			generateEnd(world, random, chunkX * 16, chunkZ * 16);
			break;
		}
	}

	//ENDDDD
	private void generateEnd(World world, Random random, int chunkX, int chunkZ) {
		for (int i = 0; i < 10; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(31);
			int Z = chunkZ + random.nextInt(16);
			new WorldGenReplace(MoreMinecraft.oreDimensional.blockID, 1, 4, Block.whiteStone.blockID).generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 11; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(48);
			int Z = chunkZ + random.nextInt(16);
			new WorldGenReplace(MoreMinecraft.ores.blockID, 1, 10, Block.whiteStone.blockID).generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 11; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(48);
			int Z = chunkZ + random.nextInt(16);
			new WorldGenReplace(MoreMinecraft.ores.blockID, 3, 6, Block.whiteStone.blockID).generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 11; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(48);
			int Z = chunkZ + random.nextInt(16);
			new WorldGenReplace(MoreMinecraft.ores.blockID, 2, 6, Block.whiteStone.blockID).generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 9; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(41);
			int Z = chunkZ + random.nextInt(16);
			new WorldGenReplace(MoreMinecraft.oreDimensional.blockID, 8, 10, Block.whiteStone.blockID).generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 7; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(41);
			int Z = chunkZ + random.nextInt(16);
			new WorldGenReplace(MoreMinecraft.oreDimensional.blockID, 14, 9, Block.whiteStone.blockID).generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 7; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(41);
			int Z = chunkZ + random.nextInt(16);
			new WorldGenReplace(MoreMinecraft.oreDimensional.blockID, 11, 10, Block.whiteStone.blockID).generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 11; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(52);
			int Z = chunkZ + random.nextInt(16);
			new WorldGenReplace(MoreMinecraft.ores.blockID, 5, 16, Block.whiteStone.blockID).generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 8; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(39);
			int Z = chunkZ + random.nextInt(16);
			new WorldGenReplace(MoreMinecraft.oreDimensional.blockID, 3, 16, Block.whiteStone.blockID).generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 7; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(32);
			int Z = chunkZ + random.nextInt(16);
			new WorldGenReplace(MoreMinecraft.oreDimensional.blockID, 5, 16, Block.whiteStone.blockID).generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 8; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(44);
			int Z = chunkZ + random.nextInt(16);
			new WorldGenReplace(MoreMinecraft.ores.blockID, 6, 16, Block.whiteStone.blockID).generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 8; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(44);
			int Z = chunkZ + random.nextInt(16);
			new WorldGenReplace(MoreMinecraft.ores.blockID, 4, 16, Block.whiteStone.blockID).generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 3; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(28);
			int Z = chunkZ + random.nextInt(16);
			new WorldGenReplace(MoreMinecraft.ores.blockID, 7, 16, Block.whiteStone.blockID).generate(world, random, X, Y, Z);
		}
	}

	//NETHERR!!!
	private void generateNether(World world, Random random, int chunkX, int chunkZ) {
		for (int i = 0; i < 23; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(256);
			int Z = chunkZ + random.nextInt(16);
			new WorldGenReplace(MoreMinecraft.ores.blockID, 1, 5, Block.netherrack.blockID).generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 23; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(256);
			int Z = chunkZ + random.nextInt(16);
			new WorldGenReplace(MoreMinecraft.ores.blockID, 3, 3, Block.netherrack.blockID).generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 23; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(256);
			int Z = chunkZ + random.nextInt(16);
			new WorldGenReplace(MoreMinecraft.ores.blockID, 2, 3, Block.netherrack.blockID).generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 19; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(256);
			int Z = chunkZ + random.nextInt(16);
			new WorldGenReplace(MoreMinecraft.oreDimensional.blockID, 7, 5, Block.netherrack.blockID).generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 17; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(256);
			int Z = chunkZ + random.nextInt(16);
			new WorldGenReplace(MoreMinecraft.oreDimensional.blockID, 13, 4, Block.netherrack.blockID).generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 17; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(256);
			int Z = chunkZ + random.nextInt(16);
			new WorldGenReplace(MoreMinecraft.oreDimensional.blockID, 10, 5, Block.netherrack.blockID).generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 21; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(256);
			int Z = chunkZ + random.nextInt(16);
			new WorldGenReplace(MoreMinecraft.ores.blockID, 5, 8, Block.netherrack.blockID).generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 17; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(256);
			int Z = chunkZ + random.nextInt(16);
			new WorldGenReplace(MoreMinecraft.oreDimensional.blockID, 2, 8, Block.netherrack.blockID).generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 14; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(64);
			int Z = chunkZ + random.nextInt(16);
			new WorldGenReplace(MoreMinecraft.oreDimensional.blockID, 4, 8, Block.netherrack.blockID).generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 17; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(256);
			int Z = chunkZ + random.nextInt(16);
			new WorldGenReplace(MoreMinecraft.ores.blockID, 6, 8, Block.netherrack.blockID).generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 17; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(256);
			int Z = chunkZ + random.nextInt(16);
			new WorldGenReplace(MoreMinecraft.ores.blockID, 4, 8, Block.netherrack.blockID).generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 6; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(256);
			int Z = chunkZ + random.nextInt(16);
			new WorldGenReplace(MoreMinecraft.ores.blockID, 7, 8, Block.netherrack.blockID).generate(world, random, X, Y, Z);
		}
	}

	//SURFACE!!!
	private void generateSurface(World world, Random random, int chunkX, int chunkZ) {
		for (int i = 0; i < 10; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(128);
			int Z = chunkZ + random.nextInt(16);
			new WorldGenReplace(MoreMinecraft.beeHive.blockID, 0, 3, Block.leaves.blockID).generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 23; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(49);
			int Z = chunkZ + random.nextInt(16);
			new WorldGenMinable(MoreMinecraft.ores.blockID, 3).generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 23; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(49);
			int Z = chunkZ + random.nextInt(16);
			new WorldGenMinable(MoreMinecraft.ores.blockID, 1, 5, Block.stone.blockID).generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 23; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(49);
			int Z = chunkZ + random.nextInt(16);
			new WorldGenMinable(MoreMinecraft.ores.blockID, 3, 3, Block.stone.blockID).generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 23; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(49);
			int Z = chunkZ + random.nextInt(16);
			new WorldGenMinable(MoreMinecraft.ores.blockID, 2, 3, Block.stone.blockID).generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 19; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(36);
			int Z = chunkZ + random.nextInt(16);
			new WorldGenMinable(MoreMinecraft.oreDimensional.blockID, 6, 5, Block.stone.blockID).generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 17; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(45);
			int Z = chunkZ + random.nextInt(16);
			new WorldGenMinable(MoreMinecraft.oreDimensional.blockID, 12, 4, Block.stone.blockID).generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 17; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(45);
			int Z = chunkZ + random.nextInt(16);
			new WorldGenMinable(MoreMinecraft.oreDimensional.blockID, 9, 5, Block.stone.blockID).generate(world, random, X, Y, Z);
		}
	}
}
