package moreminecraft.items;

import moreminecraft.MoreMinecraft;
import net.minecraft.item.ItemFood;

public class ItemFoodMod extends ItemFood {
	public ItemFoodMod(int par1, int par2, float par3, boolean par4) {
		super(par1, par2, par3, par4);
		this.setCreativeTab(MoreMinecraft.tabMisc);
	}
}
