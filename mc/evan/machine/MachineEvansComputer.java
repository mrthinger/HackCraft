package mc.evan.machine;

import mc.evan.creativetab.CreativeTab;
import mc.evan.lib.ModInfo;
import mc.evan.lib.Names;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MachineEvansComputer extends Block {

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


	public void onBlockAdded(World par1World, int par2, int par3, int par4) {
		super.onBlockAdded(par1World, par2, par3, par4);
		this.setDefaultDirection(par1World, par2, par3, par4);
	}

	/**
	 * set a blocks direction
	 */
	private void setDefaultDirection(World par1World, int par2, int par3,
			int par4) {
		if (!par1World.isRemote) {
			int l = par1World.getBlockId(par2, par3, par4 - 1);
			int i1 = par1World.getBlockId(par2, par3, par4 + 1);
			int j1 = par1World.getBlockId(par2 - 1, par3, par4);
			int k1 = par1World.getBlockId(par2 + 1, par3, par4);
			byte b0 = 3;

			if (Block.opaqueCubeLookup[l] && !Block.opaqueCubeLookup[i1]) {
				b0 = 3;
			}

			if (Block.opaqueCubeLookup[i1] && !Block.opaqueCubeLookup[l]) {
				b0 = 2;
			}

			if (Block.opaqueCubeLookup[j1] && !Block.opaqueCubeLookup[k1]) {
				b0 = 5;
			}

			if (Block.opaqueCubeLookup[k1] && !Block.opaqueCubeLookup[j1]) {
				b0 = 4;
			}

			par1World.setBlockMetadataWithNotify(par2, par3, par4, b0, 2);
		}
	}


	@SideOnly(Side.CLIENT)
	/**
	 * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
	 */
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
}