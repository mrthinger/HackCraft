package mc.evan.item;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import mc.evan.lib.ID;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.EnumHelper;

public class Items{
	
	
	public static Item cpick;
	
	
	public static EnumToolMaterial CODE = EnumHelper.addToolMaterial("Code", 5, -1, 255.0F, 20.0F, 10);
	
	
	public static void init(){
		cpick = new ItemsCPick(ID.CPICK, CODE);
		GameRegistry.registerItem(cpick, "cpick");
		
	}
	
	public static void addNames(){
		LanguageRegistry.addName(cpick, "Code Pickaxe");
		
		
	}
	
	public static void addRecipies(){
		GameRegistry.addShapedRecipe(new ItemStack(cpick), "iii"," i "," i ", 'i', Item.stick);
		
	}
	
}
