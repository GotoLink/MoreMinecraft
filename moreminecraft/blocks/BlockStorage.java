package moreminecraft.blocks;

import java.util.List;

import cpw.mods.fml.common.registry.GameRegistry;
import moreminecraft.items.ItemBlockWithMetaNamed;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockStorage extends BasicBlock {
	private IIcon[] icon;
	private String[] names;

	public BlockStorage(String... names) {
		super();
		this.names = names;
        GameRegistry.registerBlock(this, ItemBlockWithMetaNamed.class, "Storages");
	}

	@Override
	public int func_149692_a(int meta) {
		return meta;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon func_149691_a(int side, int meta) {
		return this.icon[meta];
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
	@SideOnly(Side.CLIENT)
	public void func_149651_a(IIconRegister par1IconRegister) {
		this.icon = new IIcon[names.length];
		for (int i = 0; i < names.length; i++) {
			this.icon[i] = par1IconRegister.registerIcon(this.func_149641_N() + names[i]);
		}
	}
}
