package moreminecraft.blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cpw.mods.fml.common.registry.GameRegistry;
import moreminecraft.MoreMinecraft;
import moreminecraft.items.ItemBlockWithMetaNamed;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockGem extends BasicBlock {
	private static final int[] chances = { 2, 1, 4 };//dimensions:(-1/0/1),
	private static final int[] dropMeta = { 20, 21, 22, 23, 4 };
	protected static final Item[] drops = { Items.dye, Items.coal, Items.redstone, Items.diamond};
	private final String[] names = { "Ruby", "BSaph", "GSaph", "YSaph", "Lapis", "Coal", "Redstone", "Diamond" };
	private IIcon[] icons;

	public BlockGem() {
		super();
        GameRegistry.registerBlock(this, ItemBlockWithMetaNamed.class, "Gems");
	}

	@Override
	public int func_149692_a(int meta) {
		return meta < dropMeta.length ? dropMeta[meta] : 0;
	}

    @Override
    public int func_149643_k(World par1World, int par2, int par3, int par4){
        return par1World.getBlockMetadata(par2, par3, par4);
    }

	@Override
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
		if (Math.abs(world.provider.dimensionId) < 2) {
			int count = 1 + world.rand.nextInt(getChance(world.provider.dimensionId, metadata));
			for (int i = 0; i < count; i++) {
				Item id = func_149650_a(metadata, world.rand, fortune);
				if (id != null) {
					ret.add(new ItemStack(id, 1, func_149692_a(metadata)));
				}
			}
		}
		return ret;
	}

	@Override
	public float func_149712_f(World world, int x, int y, int z) {
		int meta = world.getBlockMetadata(x, y, z);
		if (meta < 5) {
			return 1F;
		}
		return super.func_149712_f(world, x, y, z);
	}

	@Override
	public IIcon func_149673_e(IBlockAccess blockAccess, int par2, int par3, int par4, int par5) {
		int meta = blockAccess.getBlockMetadata(par2, par3, par4);
		int dimensionID = 0;
		BiomeGenBase biome = blockAccess.getBiomeGenForCoords(par2, par4);
		if (biome == BiomeGenBase.hell) {
			dimensionID = -1;
		} else if (biome == BiomeGenBase.sky) {
			dimensionID = 1;
		}
		return getTexture(dimensionID, meta);
	}

	@Override
	public float getExplosionResistance(Entity par1Entity, World world, int x, int y, int z, double explosionX, double explosionY, double explosionZ) {
		int meta = world.getBlockMetadata(x, y, z);
		if (meta < 5) {
			return 1F / 5.0F;
		}
		return super.getExplosionResistance(par1Entity, world, x, y, z, explosionX, explosionY, explosionZ);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon func_149691_a(int side, int meta) {
		return icons[meta * 3];
	}

	@Override
	public String[] getNames() {
		return names;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void func_149666_a(Item par1, CreativeTabs par2CreativeTabs, List par3List) {
		for (int i = 0; i < names.length; i++) {
			par3List.add(new ItemStack(par1, 1, i));
		}
	}

	@Override
	public Item func_149650_a(int i, Random rand, int j) {
		return i < dropMeta.length - 1 ? MoreMinecraft.materials : drops[i - dropMeta.length + 1];
	}

	@Override
	public void func_149651_a(IIconRegister par1IconRegister) {
		icons = new IIcon[names.length * 3];
		for (int i = 0; i < names.length; i++) {
			if (i < 4) {
				for (int j = 0; j < 3; j++) {
					icons[i * 3 + j] = par1IconRegister.registerIcon(MoreMinecraft.modID + ":ore" + names[i] + (j == 1 ? "Nether" : j == 2 ? "End" : ""));
				}
			} else {
				for (int j = 1; j < 3; j++) {
					icons[i * 3 + j] = par1IconRegister.registerIcon(MoreMinecraft.modID + ":ore" + names[i] + (j == 1 ? "Nether" : j == 2 ? "End" : ""));
				}
				icons[i * 3] = par1IconRegister.registerIcon(names[i].toLowerCase() + "_ore");
			}
		}
	}

	private int getChance(int dimensionId, int metadata) {
		int luck = chances[1 + dimensionId];
		if (metadata == 4 || metadata == 6) {
			luck += dimensionId == -1 ? 10 : dimensionId == 1 ? 20 : 0;
		}
		return luck;
	}

	private IIcon getTexture(int dimID, int meta) {
		switch (dimID) {
		case -1:
			return icons[meta * 3 + 1];
		case 1:
			return icons[meta * 3 + 2];
		default:
			return icons[meta * 3];
		}
	}
}
