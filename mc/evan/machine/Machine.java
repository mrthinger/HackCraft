package mc.evan.machine;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Machine {

	public static Block hcomp;

	public static void init() {
		hcomp = new MachineEvansComputer(1580, Material.iron);
		GameRegistry.registerBlock(hcomp);

	}

	public static void addNames() {
		LanguageRegistry.addName(hcomp, "Evan's Computer");

	}

	public static void addRecipes() {
		GameRegistry.addRecipe(new ItemStack(hcomp), "iii","irr","iii", 'i', Item.ingotIron, 'r', Item.redstone);
	}

}
