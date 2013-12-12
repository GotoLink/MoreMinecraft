package moreminecraft;

import moreminecraft.entities.EntityBakedPotatoLaunched;
import moreminecraft.entities.EntityDiamondEnderpearl;
import moreminecraft.entities.EntityPoisonPotatoLaunched;
import moreminecraft.entities.EntityPotatoLaunched;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.item.Item;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
	@Override
	public void register() {
		RenderingRegistry.registerEntityRenderingHandler(EntityPoisonPotatoLaunched.class, new RenderSnowball(Item.poisonousPotato));
		RenderingRegistry.registerEntityRenderingHandler(EntityBakedPotatoLaunched.class, new RenderSnowball(Item.bakedPotato));
		RenderingRegistry.registerEntityRenderingHandler(EntityPotatoLaunched.class, new RenderSnowball(Item.potato));
		RenderingRegistry.registerEntityRenderingHandler(EntityDiamondEnderpearl.class, new RenderSnowball(MoreMinecraft.diamondEnderpearl));
		//RenderingRegistry.registerEntityRenderingHandler(EntityBear.class,...);
	}
}
