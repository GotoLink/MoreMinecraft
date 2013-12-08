package moreminecraft;

import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CreativeTabMoreMinecraft extends CreativeTabs {
	CreativeTabMoreMinecraft(String name) {
		super(name);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getTabIconItemIndex() {
		return MoreMinecraft.beeHive.blockID;
	}
}