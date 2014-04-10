package moreminecraft.items;

import moreminecraft.MoreMinecraft;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

public class ItemSeedFoodMod extends ItemFood implements IPlantable {
	/** Block ID of the crop this seed food should place. */
	private final Block cropId;
	/** Block ID of the soil this seed food should be planted on. */
	private final Block soilId;

	public ItemSeedFoodMod(int par2, float par3, Block par4, Block par5) {
		super(par2, par3, false);
		this.cropId = par4;
		this.soilId = par5;
		setCreativeTab(MoreMinecraft.tabMisc);
	}

	@Override
	public Block getPlant(IBlockAccess world, int x, int y, int z) {
		return cropId;
	}

	@Override
	public int getPlantMetadata(IBlockAccess world, int x, int y, int z) {
		return 0;
	}

	@Override
	public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z) {
		return EnumPlantType.Crop;
	}

	@Override
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
		if (par7 != 1) {
			return false;
		} else if (par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack) && par2EntityPlayer.canPlayerEdit(par4, par5 + 1, par6, par7, par1ItemStack)) {
			Block soil = par3World.getBlock(par4, par5, par6);
			if (soil == soilId && soil.canSustainPlant(par3World, par4, par5, par6, ForgeDirection.UP, this) && par3World.isAirBlock(par4, par5 + 1, par6)) {
				par3World.setBlock(par4, par5 + 1, par6, this.cropId);
				--par1ItemStack.stackSize;
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}
