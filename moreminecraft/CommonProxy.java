package moreminecraft;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;

public class CommonProxy {
	@SubscribeEvent
	public void onJump(LivingJumpEvent event) {
		if (!event.entity.worldObj.isRemote && event.entityLiving instanceof EntityPlayer) {
			ItemStack stack1 = event.entityLiving.getEquipmentInSlot(1);
			if (stack1 != null && stack1.getItem() == MoreMinecraft.jumpBoots) {
				event.entityLiving.addPotionEffect(new PotionEffect(Potion.jump.getId(), 1, 0));
			}
		}
	}

	public void register() {
		MinecraftForge.EVENT_BUS.register(this);
	}
}
