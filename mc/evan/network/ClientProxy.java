package mc.evan.network;

import mc.evan.code.Code;
import mc.evan.core.EvanMCMain;
import mc.evan.item.Items;
import mc.evan.item.dynamic.PickProjectile;
import mc.evan.lib.Names;
import net.minecraft.client.renderer.entity.RenderPig;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.client.renderer.tileentity.RenderEnderCrystal;
import net.minecraft.item.Item;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;

public class ClientProxy extends CommonProxy {
	@Override
	public void registerRenderers() {
	int modEntityID = 0;
	EntityRegistry.registerModEntity(PickProjectile.class, Names.CPICK, ++modEntityID, EvanMCMain.instance, 64, 10, true);
	RenderingRegistry.registerEntityRenderingHandler(PickProjectile.class, new RenderSnowball(Item.enderPearl));
	}

}
