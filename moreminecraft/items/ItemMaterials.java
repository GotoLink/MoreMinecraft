package moreminecraft.items;

import java.util.List;

import moreminecraft.MoreMinecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemMaterials extends Item {
	public final String[] names;
	private IIcon[] icons;

	public ItemMaterials(String... names) {
		super();
		setHasSubtypes(true);
		this.names = names;
		setCreativeTab(MoreMinecraft.tabMisc);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int par1) {
		return icons[par1];
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List par3List) {
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
	public void registerIcons(IIconRegister par1IconRegister) {
		icons = new IIcon[names.length];
		for (int index = 0; index < names.length; index++) {
			icons[index] = par1IconRegister.registerIcon(getIconString() + names[index]);
		}
	}
}
