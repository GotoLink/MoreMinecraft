package moreminecraft.generators;

import java.util.Random;

import moreminecraft.MoreMinecraft;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGeneratorMoreMinecraft implements IWorldGenerator {
	public static WorldGenerator enderiumEnd = new WorldGenReplace(MoreMinecraft.oreDimensional.blockID, 1, 4, Block.whiteStone.blockID);
	public static WorldGenerator oreBSaphEnd = new WorldGenReplace(MoreMinecraft.ores.blockID, 1, 10, Block.whiteStone.blockID);
	public static WorldGenerator oreYSaphEnd = new WorldGenReplace(MoreMinecraft.ores.blockID, 3, 6, Block.whiteStone.blockID);
	public static WorldGenerator oreGSaphEnd = new WorldGenReplace(MoreMinecraft.ores.blockID, 2, 6, Block.whiteStone.blockID);
	public static WorldGenerator oreTitaniumEnd = new WorldGenReplace(MoreMinecraft.oreDimensional.blockID, 8, 10, Block.whiteStone.blockID);
	public static WorldGenerator oreTinEnd = new WorldGenReplace(MoreMinecraft.oreDimensional.blockID, 14, 9, Block.whiteStone.blockID);
	public static WorldGenerator oreCopperEnd = new WorldGenReplace(MoreMinecraft.oreDimensional.blockID, 11, 10, Block.whiteStone.blockID);
	public static WorldGenerator oreCoalEnd = new WorldGenReplace(MoreMinecraft.ores.blockID, 5, 16, Block.whiteStone.blockID);
	public static WorldGenerator oreIronEnd = new WorldGenReplace(MoreMinecraft.oreDimensional.blockID, 3, 16, Block.whiteStone.blockID);
	public static WorldGenerator oreGoldEnd = new WorldGenReplace(MoreMinecraft.oreDimensional.blockID, 5, 16, Block.whiteStone.blockID);
	public static WorldGenerator oreRedstoneEnd = new WorldGenReplace(MoreMinecraft.ores.blockID, 6, 16, Block.whiteStone.blockID);
	public static WorldGenerator oreLapisEnd = new WorldGenReplace(MoreMinecraft.ores.blockID, 4, 16, Block.whiteStone.blockID);
	public static WorldGenerator oreDiamondEnd = new WorldGenReplace(MoreMinecraft.ores.blockID, 7, 16, Block.whiteStone.blockID);
	public static WorldGenerator oreBSaphNether = new WorldGenReplace(MoreMinecraft.ores.blockID, 1, 5, Block.netherrack.blockID);
	public static WorldGenerator oreYSaphNether = new WorldGenReplace(MoreMinecraft.ores.blockID, 3, 3, Block.netherrack.blockID);
	public static WorldGenerator oreGSaphNether = new WorldGenReplace(MoreMinecraft.ores.blockID, 2, 3, Block.netherrack.blockID);
	public static WorldGenerator oreTitaniumNether = new WorldGenReplace(MoreMinecraft.oreDimensional.blockID, 7, 5, Block.netherrack.blockID);
	public static WorldGenerator oreTinNether = new WorldGenReplace(MoreMinecraft.oreDimensional.blockID, 13, 4, Block.netherrack.blockID);
	public static WorldGenerator oreCopperNether = new WorldGenReplace(MoreMinecraft.oreDimensional.blockID, 10, 5, Block.netherrack.blockID);
	public static WorldGenerator oreCoalNether = new WorldGenReplace(MoreMinecraft.ores.blockID, 5, 8, Block.netherrack.blockID);
	public static WorldGenerator oreIronNether = new WorldGenReplace(MoreMinecraft.oreDimensional.blockID, 2, 8, Block.netherrack.blockID);
	public static WorldGenerator oreGoldNether = new WorldGenReplace(MoreMinecraft.oreDimensional.blockID, 4, 8, Block.netherrack.blockID);
	public static WorldGenerator oreRedstoneNether = new WorldGenReplace(MoreMinecraft.ores.blockID, 6, 8, Block.netherrack.blockID);
	public static WorldGenerator oreLapisNether = new WorldGenReplace(MoreMinecraft.ores.blockID, 4, 8, Block.netherrack.blockID);
	public static WorldGenerator oreDiamondNether = new WorldGenReplace(MoreMinecraft.ores.blockID, 7, 8, Block.netherrack.blockID);
	public static WorldGenerator beeHive = new WorldGenReplace(MoreMinecraft.beeHive.blockID, 0, 3, Block.leaves.blockID);
	public static WorldGenerator oreRuby = new WorldGenMinable(MoreMinecraft.ores.blockID, 3);
	public static WorldGenerator oreBSaph = new WorldGenMinable(MoreMinecraft.ores.blockID, 1, 5, Block.stone.blockID);
	public static WorldGenerator oreYSaph = new WorldGenMinable(MoreMinecraft.ores.blockID, 3, 3, Block.stone.blockID);
	public static WorldGenerator oreGSaph = new WorldGenMinable(MoreMinecraft.ores.blockID, 2, 3, Block.stone.blockID);
	public static WorldGenerator oreTitanium = new WorldGenMinable(MoreMinecraft.oreDimensional.blockID, 6, 5, Block.stone.blockID);
	public static WorldGenerator oreTin = new WorldGenMinable(MoreMinecraft.oreDimensional.blockID, 12, 4, Block.stone.blockID);
	public static WorldGenerator oreCopper = new WorldGenMinable(MoreMinecraft.oreDimensional.blockID, 9, 5, Block.stone.blockID);

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
			enderiumEnd.generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 11; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(48);
			int Z = chunkZ + random.nextInt(16);
			oreBSaphEnd.generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 11; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(48);
			int Z = chunkZ + random.nextInt(16);
			oreYSaphEnd.generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 11; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(48);
			int Z = chunkZ + random.nextInt(16);
			oreGSaphEnd.generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 9; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(41);
			int Z = chunkZ + random.nextInt(16);
			oreTitaniumEnd.generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 7; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(41);
			int Z = chunkZ + random.nextInt(16);
			oreTinEnd.generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 7; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(41);
			int Z = chunkZ + random.nextInt(16);
			oreCopperEnd.generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 11; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(52);
			int Z = chunkZ + random.nextInt(16);
			oreCoalEnd.generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 8; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(39);
			int Z = chunkZ + random.nextInt(16);
			oreIronEnd.generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 7; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(32);
			int Z = chunkZ + random.nextInt(16);
			oreGoldEnd.generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 8; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(44);
			int Z = chunkZ + random.nextInt(16);
			oreRedstoneEnd.generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 8; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(44);
			int Z = chunkZ + random.nextInt(16);
			oreLapisEnd.generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 3; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(28);
			int Z = chunkZ + random.nextInt(16);
			oreDiamondEnd.generate(world, random, X, Y, Z);
		}
	}

	//NETHERR!!!
	private void generateNether(World world, Random random, int chunkX, int chunkZ) {
		for (int i = 0; i < 23; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(256);
			int Z = chunkZ + random.nextInt(16);
			oreBSaphNether.generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 23; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(256);
			int Z = chunkZ + random.nextInt(16);
			oreYSaphNether.generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 23; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(256);
			int Z = chunkZ + random.nextInt(16);
			oreGSaphNether.generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 19; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(256);
			int Z = chunkZ + random.nextInt(16);
			oreTitaniumNether.generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 17; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(256);
			int Z = chunkZ + random.nextInt(16);
			oreTinNether.generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 17; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(256);
			int Z = chunkZ + random.nextInt(16);
			oreCopperNether.generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 21; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(256);
			int Z = chunkZ + random.nextInt(16);
			oreCoalNether.generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 17; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(256);
			int Z = chunkZ + random.nextInt(16);
			oreIronNether.generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 14; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(64);
			int Z = chunkZ + random.nextInt(16);
			oreGoldNether.generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 17; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(256);
			int Z = chunkZ + random.nextInt(16);
			oreRedstoneNether.generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 17; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(256);
			int Z = chunkZ + random.nextInt(16);
			oreLapisNether.generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 6; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(256);
			int Z = chunkZ + random.nextInt(16);
			oreDiamondNether.generate(world, random, X, Y, Z);
		}
	}

	//SURFACE!!!
	private void generateSurface(World world, Random random, int chunkX, int chunkZ) {
		for (int i = 0; i < 10; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(128);
			int Z = chunkZ + random.nextInt(16);
			beeHive.generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 23; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(49);
			int Z = chunkZ + random.nextInt(16);
			oreRuby.generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 23; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(49);
			int Z = chunkZ + random.nextInt(16);
			oreBSaph.generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 23; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(49);
			int Z = chunkZ + random.nextInt(16);
			oreYSaph.generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 23; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(49);
			int Z = chunkZ + random.nextInt(16);
			oreGSaph.generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 19; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(36);
			int Z = chunkZ + random.nextInt(16);
			oreTitanium.generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 17; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(45);
			int Z = chunkZ + random.nextInt(16);
			oreTin.generate(world, random, X, Y, Z);
		}
		for (int i = 0; i < 17; i++) {
			int X = chunkX + random.nextInt(16);
			int Y = random.nextInt(45);
			int Z = chunkZ + random.nextInt(16);
			oreCopper.generate(world, random, X, Y, Z);
		}
	}
}
