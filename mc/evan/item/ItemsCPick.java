package mc.evan.item;

import java.util.Random;

import mc.evan.client.particle.Particle;
import mc.evan.creativetab.CreativeTab;
import mc.evan.lib.ModInfo;
import mc.evan.lib.Names;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemsCPick extends ToolCode {

	public ItemsCPick(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		setUnlocalizedName(ModInfo.ID + ":" + Names.CPICK);
		setCreativeTab(CreativeTab.hackcraft);
	}

	@Override
	public boolean onBlockDestroyed(ItemStack par1ItemStack, World world,
			int id, int x, int y, int z, EntityLivingBase par7EntityLivingBase) {

		Random rand = new Random();
		for (int i = 0; i <= 1000; i++) {

			float ptX = x + rand.nextFloat();
			float ptY = y + rand.nextFloat();
			float ptZ = z + rand.nextFloat();

			float MptX = 0.5F - rand.nextFloat();
			float MptY = 0.5F - rand.nextFloat();
			float MptZ = 0.5F - rand.nextFloat();
			if(world.isRemote == true){
			Particle.IOPARTICLE.spawnParticle(world, ptX, ptY, ptZ, MptX, MptY, MptZ);
			}
		}

		return super.onBlockDestroyed(par1ItemStack, world, id, x, y, z,
				par7EntityLivingBase);
	}

	@SideOnly(Side.CLIENT)
	public static Icon ioparticle;

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
		this.itemIcon = icon.registerIcon(ModInfo.ID + ":" + Names.CPICK);
		this.ioparticle = icon
				.registerIcon(ModInfo.ID + ":" + Names.IOParticle);
	}

}
