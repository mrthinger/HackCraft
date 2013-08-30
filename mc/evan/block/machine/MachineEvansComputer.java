package mc.evan.block.machine;

import java.util.Random;

import mc.evan.block.machine.tileentity.TileEntityHComp;
import mc.evan.client.particle.Particle;
import mc.evan.core.EvanMCMain;
import mc.evan.creativetab.CreativeTab;
import mc.evan.lib.ModInfo;
import mc.evan.lib.Names;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MachineEvansComputer extends BlockContainer {

	@SideOnly(Side.CLIENT)
	private static Icon hcomp_front, hcomp_side, hcomp_top, hcomp_bottom;

	public MachineEvansComputer(int par1, Material par2Material) {
		super(par1, par2Material);

		setHardness(2.0F);
		setResistance(10.0F);
		setStepSound(Block.soundMetalFootstep);
		setUnlocalizedName(Names.HCOMP);
		setCreativeTab(CreativeTab.hackcraft);

	}
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
		this.hcomp_front = icon.registerIcon(ModInfo.ID + ":" + Names.HCOMP
				+ "_front");
		this.blockIcon = icon.registerIcon(ModInfo.ID + ":" + Names.HCOMP
				+ "_side");
		this.hcomp_top = icon.registerIcon(ModInfo.ID + ":" + Names.HCOMP
				+ "_top");
		this.hcomp_bottom = icon.registerIcon(ModInfo.ID + ":" + Names.HCOMP
				+ "_bottom");
	}

	@SideOnly(Side.CLIENT)
	public Icon getIcon(int par1, int par2) {

		return par1 == 1 ? this.hcomp_top : (par1 == 0 ? this.hcomp_bottom
				: (par1 != par2 ? this.blockIcon : this.hcomp_front));

	}

	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4,
			EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack) {
		int l = MathHelper
				.floor_double((double) (par5EntityLivingBase.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

		if (l == 0) {
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 2, 2);
		}

		if (l == 1) {
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 5, 2);
		}

		if (l == 2) {
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 3, 2);
		}

		if (l == 3) {
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 4, 2);
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random rand) {
		for (int i = 0; i <= 32; i++) {

			float ptX = x + rand.nextFloat();
			float ptY = y + rand.nextFloat();
			float ptZ = z + rand.nextFloat();

			float MptX = 0.5F - rand.nextFloat();
			float MptY = 0.5F - rand.nextFloat();
			float MptZ = 0.5F - rand.nextFloat();

			Particle.IOPARTICLE.spawnParticle(world, ptX, ptY, ptZ, MptX, MptY, MptZ);
		}

	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		if (!world.isRemote) {
			FMLNetworkHandler.openGui(player, EvanMCMain.instance, 0, world, x, y, z);
		}
	
		return true;
	}
	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityHComp();
	}
	
	@Override
	public void breakBlock(World world, int x, int y, int z, int id, int meta) {
		TileEntity te = world.getBlockTileEntity(x, y, z);
		if (te != null && te instanceof IInventory) {
			IInventory inventory = (IInventory)te;
			
			for (int i = 0; i < inventory.getSizeInventory(); i++) {
				ItemStack stack = inventory.getStackInSlotOnClosing(i);
				
				if (stack != null) {
					float spawnX = x + world.rand.nextFloat();
					float spawnY = y + world.rand.nextFloat();
					float spawnZ = z + world.rand.nextFloat();
					
					EntityItem droppedItem = new EntityItem(world, spawnX, spawnY, spawnZ, stack);
					
					float mult = 0.05F;
					
					droppedItem.motionX = (-0.5F + world.rand.nextFloat()) * mult;
					droppedItem.motionY = (4 + world.rand.nextFloat()) * mult;
					droppedItem.motionZ = (-0.5F + world.rand.nextFloat()) * mult;
					
					world.spawnEntityInWorld(droppedItem);
				}
			}
		}
		
		super.breakBlock(world, x, y, z, id, meta);
	}
}