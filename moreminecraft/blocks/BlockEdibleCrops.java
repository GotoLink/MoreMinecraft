package moreminecraft.blocks;

import moreminecraft.MoreMinecraft;
import net.minecraft.block.BlockCrops;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockEdibleCrops extends BlockCrops {
	@SideOnly(Side.CLIENT)
	private IIcon[] iconArray;
	private final boolean isTurnip;

	public BlockEdibleCrops(boolean isTurnip) {
		super();
		this.isTurnip = isTurnip;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int par1, int par2) {
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
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		this.iconArray = new IIcon[4];
		for (int i = 0; i < this.iconArray.length; ++i) {
			this.iconArray[i] = par1IconRegister.registerIcon(MoreMinecraft.modID + ":" + this.getTextureName() + "_" + i);
		}
	}

	@Override
	protected Item func_149865_P() {
		return isTurnip ? MoreMinecraft.turnip : MoreMinecraft.corn;
	}

	@Override
	protected Item func_149866_i() {
		return isTurnip ? MoreMinecraft.turnip : MoreMinecraft.corn;
	}
}
