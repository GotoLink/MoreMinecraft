package moreminecraft.blocks;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import moreminecraft.MoreMinecraft;
import moreminecraft.items.ItemBlockWithMetaNamed;

public class BlockOreDimensional extends BasicBlock {
	private String[] names;
	private Icon[] icons;

	public BlockOreDimensional(int id, String... names) {
		super(id);
		this.names = names;
        GameRegistry.registerBlock(this, ItemBlockWithMetaNamed.class, "OreDimensional");
	}

	@Override
	public int damageDropped(int i) {
		return i == 0 || i == 1 ? 24 : i;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int meta) {
		return icons[meta];
	}

	@Override
	public String[] getNames() {
		return names;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List) {
		for (int i = 0; i < names.length; i++) {
			par3List.add(new ItemStack(par1, 1, i));
		}
	}

	@Override
	public int idDropped(int i, Random rand, int j) {
		return i == 0 || i == 1 ? MoreMinecraft.materials.itemID : this.blockID;
	}

	@Override
	public void registerIcons(IconRegister par1IconRegister) {
		icons = new Icon[names.length];
		icons[0] = par1IconRegister.registerIcon(MoreMinecraft.modID + ":" + names[0]);
		for (int i = 1; i < names.length; i++) {
			icons[i] = par1IconRegister.registerIcon(MoreMinecraft.modID + ":ore" + names[i]);
		}
	}
}
