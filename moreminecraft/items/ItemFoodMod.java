package moreminecraft.items;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import moreminecraft.MoreMinecraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class ItemFoodMod extends ItemFood {
	public final String[] names;
	private Icon[] icons;
	private final int[] heal;
	private final float[] saturation;

	public ItemFoodMod(int par1, String[] names, int[] heal, float[] sat) {
		super(par1, 0, 0, false);
		this.setHasSubtypes(true);
		this.names = names;
		this.heal = heal;
		this.saturation = sat;
		this.setCreativeTab(MoreMinecraft.tabMisc);
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
	public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		--par1ItemStack.stackSize;
		par3EntityPlayer.getFoodStats().addStats(getHealing(par1ItemStack), getSaturation(par1ItemStack));
		par2World.playSoundAtEntity(par3EntityPlayer, "random.burp", 0.5F, par2World.rand.nextFloat() * 0.1F + 0.9F);
		this.onFoodEaten(par1ItemStack, par2World, par3EntityPlayer);
		return par1ItemStack;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {
		icons = new Icon[names.length];
		for (int index = 0; index < names.length; index++) {
			icons[index] = par1IconRegister.registerIcon(getIconString() + names[index]);
		}
	}

	protected int getHealing(ItemStack stack) {
		return heal[stack.getItemDamage()];
	}

	protected float getSaturation(ItemStack stack) {
		return saturation[stack.getItemDamage()];
	}
}
