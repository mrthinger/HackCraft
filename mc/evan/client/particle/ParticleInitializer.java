package mc.evan.client.particle;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mc.evan.code.CodeZero;
import mc.evan.lib.ID;
import mc.evan.lib.ModInfo;
import mc.evan.lib.Names;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.Icon;

public class ParticleInitializer extends Item{
	
	public static Item initializerItem;
	
	public static void init(){
		initializerItem = new ParticleInitializer(-1);
		GameRegistry.registerItem(initializerItem, "initializerItem");
		
	}
	public ParticleInitializer(int par1) {super(par1);}
	
	
	
	//Put Particles Here
	@SideOnly(Side.CLIENT)
	public static Icon ioparticle, sixtynineparticle;
	
	
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
	this.ioparticle = icon
			.registerIcon(ModInfo.ID + ":" + Names.IOParticle);
	this.sixtynineparticle = icon
			.registerIcon(ModInfo.ID + ":" + Names.SixtyNineParticle);
	}

}

