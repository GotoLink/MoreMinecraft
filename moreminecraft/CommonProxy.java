package moreminecraft;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import moreminecraft.entities.EntityBakedPotatoLaunched;
import moreminecraft.entities.EntityDiamondEnderpearl;
import moreminecraft.entities.EntityPoisonPotatoLaunched;
import moreminecraft.entities.EntityPotatoLaunched;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
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
        EntityRegistry.registerModEntity(EntityDiamondEnderpearl.class, "Diamond_EnderPearl", 0, MoreMinecraft.INSTANCE, 64, 10, true);
        EntityRegistry.registerModEntity(EntityPotatoLaunched.class, "PotatoThrown", 1, MoreMinecraft.INSTANCE, 64, 20, true);
        EntityRegistry.registerModEntity(EntityBakedPotatoLaunched.class, "PotatoThrownBaked", 2, MoreMinecraft.INSTANCE, 64, 20, true);
        EntityRegistry.registerModEntity(EntityPoisonPotatoLaunched.class, "PotatoThrownPoison", 3, MoreMinecraft.INSTANCE, 64, 20, true);
        //EntityRegistry.registerModEntity(EntityBear.class, "Bear", 4, this, 80, 3, true);
	}
}
