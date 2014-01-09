package moreminecraft.blocks;

import java.util.List;

import cpw.mods.fml.common.registry.GameRegistry;
import moreminecraft.items.ItemBlockWithMetaNamed;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockStorage extends BasicBlock {
	private Icon[] icon;
	private String[] names;

	public BlockStorage(int id, String... names) {
		super(id);
		this.names = names;
        GameRegistry.registerBlock(this, ItemBlockWithMetaNamed.class, "Storages");
	}

	@Override
	public int damageDropped(int meta) {
		return meta;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int meta) {
		return this.icon[meta];
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
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {
		this.icon = new Icon[names.length];
		for (int i = 0; i < names.length; i++) {
			this.icon[i] = par1IconRegister.registerIcon(this.getTextureName() + names[i]);
		}
	}
}
