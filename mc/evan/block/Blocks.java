package mc.evan.block;

import mc.evan.block.machine.MachineEvansComputer;
import mc.evan.block.machine.tileentity.TileEntityHComp;
import mc.evan.lib.Names;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Blocks {

	public static Block hcomp;

	public static void init() {
		hcomp = new MachineEvansComputer(1580, Material.iron);
		GameRegistry.registerBlock(hcomp, Names.HCOMP);
		GameRegistry.registerTileEntity(TileEntityHComp.class, Names.HCOMP_TE);

	}

	public static void addNames() {
		LanguageRegistry.addName(hcomp, Names.HCOMP_IG);

	}

	public static void addRecipes() {
		GameRegistry.addRecipe(new ItemStack(hcomp), "iii","idi","iii", 'i', Item.ingotIron, 'd', Block.blockDiamond);
	}

}
