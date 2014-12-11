package moreminecraft;

import cpw.mods.fml.client.registry.RenderingRegistry;
import moreminecraft.entities.EntityBakedPotatoLaunched;
import moreminecraft.entities.EntityDiamondEnderpearl;
import moreminecraft.entities.EntityPoisonPotatoLaunched;
import moreminecraft.entities.EntityPotatoLaunched;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.init.Items;

public class ClientProxy extends CommonProxy {
	@Override
	public void register() {
        super.register();
		RenderingRegistry.registerEntityRenderingHandler(EntityPoisonPotatoLaunched.class, new RenderSnowball(Items.poisonous_potato));
		RenderingRegistry.registerEntityRenderingHandler(EntityBakedPotatoLaunched.class, new RenderSnowball(Items.baked_potato));
		RenderingRegistry.registerEntityRenderingHandler(EntityPotatoLaunched.class, new RenderSnowball(Items.potato));
		RenderingRegistry.registerEntityRenderingHandler(EntityDiamondEnderpearl.class, new RenderSnowball(MoreMinecraft.diamondEnderpearl));
		//RenderingRegistry.registerEntityRenderingHandler(EntityBear.class,...);
	}
}
