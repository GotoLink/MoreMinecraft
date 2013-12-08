package moreminecraft.blocks;

import moreminecraft.MoreMinecraft;
import net.minecraft.block.BlockCrops;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Crop extends BlockCrops {
	@SideOnly(Side.CLIENT)
	private Icon[] iconArray;
	private boolean isTurnip;

	public Crop(int id, boolean isTurnip) {
		super(id);
		this.isTurnip = isTurnip;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int par1, int par2) {
		if (par2 < 7) {
			if (par2 == 6) {
				par2 = 5;
			}
			return this.iconArray[par2 >> 1];
		} else {
			return this.iconArray[3];
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {
		this.iconArray = new Icon[4];
		for (int i = 0; i < this.iconArray.length; ++i) {
			this.iconArray[i] = par1IconRegister.registerIcon(MoreMinecraft.modID + ":" + this.getUnlocalizedName() + "_" + i);
		}
	}

	@Override
	protected int getCropItem() {
		return isTurnip ? MoreMinecraft.turnip.itemID : MoreMinecraft.corn.itemID;
	}

	@Override
	protected int getSeedItem() {
		return isTurnip ? MoreMinecraft.turnip.itemID : MoreMinecraft.corn.itemID;
	}
}
