package moreminecraft.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import moreminecraft.MoreMinecraft;
import net.minecraft.block.BlockCake;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class BlockChocolateCake extends BlockCake {
	public BlockChocolateCake() {
		super();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Item getItem(World par1World, int par2, int par3, int par4) {
		return MoreMinecraft.itemChocolateCake;
	}

	@Override
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
		this.eatCakeSlice(par1World, par2, par3, par4, par5EntityPlayer);
		return true;
	}

	@Override
	public void onBlockClicked(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer) {
		this.eatCakeSlice(par1World, par2, par3, par4, par5EntityPlayer);
	}

	/**
	 * Heals the player and removes a slice from the cake.
	 */
	private void eatCakeSlice(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer) {
		if (par5EntityPlayer.canEat(false)) {
			par5EntityPlayer.getFoodStats().addStats(3, 0.2F);
			int l = par1World.getBlockMetadata(par2, par3, par4) + 1;
			if (l >= 6) {
				par1World.setBlockToAir(par2, par3, par4);
			} else {
				par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);
			}
		}
	}
}
