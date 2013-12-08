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
			new WorldGenReplace(MoreMinecraft.oreEnderium.blockID, 4, Block.whiteStone.blockID).generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 11; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(48);
			int Z = chunkZ + random.nextInt(16);
			new WorldGenReplace(MoreMinecraft.oreBSaphEnd.blockID, 10, Block.whiteStone.blockID).generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 11; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(48);
			int Z = chunkZ + random.nextInt(16);
			new WorldGenReplace(MoreMinecraft.oreYSaphEnd.blockID, 6, Block.whiteStone.blockID).generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 11; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(48);
			int Z = chunkZ + random.nextInt(16);
			new WorldGenReplace(MoreMinecraft.oreGSaphEnd.blockID, 6, Block.whiteStone.blockID).generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 9; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(41);
			int Z = chunkZ + random.nextInt(16);
			new WorldGenReplace(MoreMinecraft.oreTitaniumEnd.blockID, 10, Block.whiteStone.blockID).generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 7; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(41);
			int Z = chunkZ + random.nextInt(16);
			new WorldGenReplace(MoreMinecraft.tinOreEnd.blockID, 9, Block.whiteStone.blockID).generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 7; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(41);
			int Z = chunkZ + random.nextInt(16);
			new WorldGenReplace(MoreMinecraft.copperOreEnd.blockID, 10, Block.whiteStone.blockID).generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 11; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(52);
			int Z = chunkZ + random.nextInt(16);
			new WorldGenReplace(MoreMinecraft.oreCoalEnd.blockID, 16, Block.whiteStone.blockID).generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 8; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(39);
			int Z = chunkZ + random.nextInt(16);
			new WorldGenReplace(MoreMinecraft.oreIronEnd.blockID, 16, Block.whiteStone.blockID).generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 7; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(32);
			int Z = chunkZ + random.nextInt(16);
			new WorldGenReplace(MoreMinecraft.oreGoldEnd.blockID, 16, Block.whiteStone.blockID).generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 8; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(44);
			int Z = chunkZ + random.nextInt(16);
			new WorldGenReplace(MoreMinecraft.oreRedstoneEnd.blockID, 16, Block.whiteStone.blockID).generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 8; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(44);
			int Z = chunkZ + random.nextInt(16);
			new WorldGenReplace(MoreMinecraft.oreLapisEnd.blockID, 16, Block.whiteStone.blockID).generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 3; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(28);
			int Z = chunkZ + random.nextInt(16);
			new WorldGenReplace(MoreMinecraft.oreDiamondEnd.blockID, 16, Block.whiteStone.blockID).generate(world, random, X, Y, Z);
		}
	}

	//NETHERR!!!
	private void generateNether(World world, Random random, int chunkX, int chunkZ) {
		for (int i = 0; i < 23; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(256);
			int Z = chunkZ + random.nextInt(16);
			new WorldGenReplace(MoreMinecraft.oreBSaphNether.blockID, 5, Block.netherrack.blockID).generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 23; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(256);
			int Z = chunkZ + random.nextInt(16);
			new WorldGenReplace(MoreMinecraft.oreYSaphNether.blockID, 3, Block.netherrack.blockID).generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 23; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(256);
			int Z = chunkZ + random.nextInt(16);
			new WorldGenReplace(MoreMinecraft.oreGSaphNether.blockID, 3, Block.netherrack.blockID).generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 19; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(256);
			int Z = chunkZ + random.nextInt(16);
			new WorldGenReplace(MoreMinecraft.oreTitaniumNether.blockID, 5, Block.netherrack.blockID).generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 17; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(256);
			int Z = chunkZ + random.nextInt(16);
			new WorldGenReplace(MoreMinecraft.tinOreNether.blockID, 4, Block.netherrack.blockID).generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 17; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(256);
			int Z = chunkZ + random.nextInt(16);
			new WorldGenReplace(MoreMinecraft.copperOreNether.blockID, 5, Block.netherrack.blockID).generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 21; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(256);
			int Z = chunkZ + random.nextInt(16);
			new WorldGenReplace(MoreMinecraft.oreCoalNether.blockID, 8, Block.netherrack.blockID).generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 17; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(256);
			int Z = chunkZ + random.nextInt(16);
			new WorldGenReplace(MoreMinecraft.oreIronNether.blockID, 8, Block.netherrack.blockID).generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 14; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(64);
			int Z = chunkZ + random.nextInt(16);
			new WorldGenReplace(MoreMinecraft.oreGoldNether.blockID, 8, Block.netherrack.blockID).generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 17; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(256);
			int Z = chunkZ + random.nextInt(16);
			new WorldGenReplace(MoreMinecraft.oreRedstoneNether.blockID, 8, Block.netherrack.blockID).generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 17; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(256);
			int Z = chunkZ + random.nextInt(16);
			new WorldGenReplace(MoreMinecraft.oreLapisNether.blockID, 8, Block.netherrack.blockID).generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 6; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(256);
			int Z = chunkZ + random.nextInt(16);
			new WorldGenReplace(MoreMinecraft.oreDiamondNether.blockID, 8, Block.netherrack.blockID).generate(world, random, X, Y, Z);
		}
	}

	//SURFACE!!!
	private void generateSurface(World world, Random random, int chunkX, int chunkZ) {
		for (int i = 0; i < 10; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(128);
			int Z = chunkZ + random.nextInt(16);
			new WorldGenReplace(MoreMinecraft.beeHive.blockID, 3, Block.leaves.blockID).generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 23; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(49);
			int Z = chunkZ + random.nextInt(16);
			new WorldGenMinable(MoreMinecraft.oreRuby.blockID, 3).generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 23; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(49);
			int Z = chunkZ + random.nextInt(16);
			new WorldGenMinable(MoreMinecraft.oreBSaph.blockID, 5).generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 23; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(49);
			int Z = chunkZ + random.nextInt(16);
			new WorldGenMinable(MoreMinecraft.oreYSaph.blockID, 3).generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 23; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(49);
			int Z = chunkZ + random.nextInt(16);
			new WorldGenMinable(MoreMinecraft.oreGSaph.blockID, 3).generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 19; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(36);
			int Z = chunkZ + random.nextInt(16);
			new WorldGenMinable(MoreMinecraft.oreTitanium.blockID, 5).generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 17; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(45);
			int Z = chunkZ + random.nextInt(16);
			new WorldGenMinable(MoreMinecraft.tinOre.blockID, 4).generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 17; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(45);
			int Z = chunkZ + random.nextInt(16);
			new WorldGenMinable(MoreMinecraft.copperOre.blockID, 5).generate(world, random, X, Y, Z);
		}
	}
}
