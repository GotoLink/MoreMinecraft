package moreminecraft.items;

import java.util.List;

import moreminecraft.MoreMinecraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemMaterials extends Item {
	public String[] names;
	private Icon[] icons;

	public ItemMaterials(int par1, String... names) {
		super(par1);
		setHasSubtypes(true);
		this.names = names;
		setCreativeTab(MoreMinecraft.tabMisc);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int par1) {
		return icons[par1];
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List) {
		for (int index = 0; index < names.length; index++) {
			par3List.add(new ItemStack(this, 1, index));
		}
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return getUnlocalizedName() + names[stack.getItemDamage()];
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {
		icons = new Icon[names.length];
		for (int index = 0; index < names.length; index++) {
			icons[index] = par1IconRegister.registerIcon(getIconString() + names[index]);
		}
	}
}
