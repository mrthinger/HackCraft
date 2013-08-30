package mc.evan.code;

import mc.evan.creativetab.CreativeTab;
import mc.evan.lib.ID;
import mc.evan.lib.ModInfo;
import mc.evan.lib.Names;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Code {

	public static Item zero;
	public static Item one;
	public static Item two;
	public static Item four;
	public static Item eight;
	
	public static void init(){
		
		zero = new CodeZero(ID.ZERO).setUnlocalizedName(ModInfo.ID + ":" + Names.ZERO).setCreativeTab(CreativeTab.hackcraft);
		GameRegistry.registerItem(zero, "zero");
		
		one = new CodeOne(ID.ONE).setUnlocalizedName(ModInfo.ID + ":" + Names.ONE).setCreativeTab(CreativeTab.hackcraft);
		GameRegistry.registerItem(one, "one");
		
		two = new CodeTwo(ID.TWO).setUnlocalizedName(ModInfo.ID + ":" + Names.TWO).setCreativeTab(CreativeTab.hackcraft);
		GameRegistry.registerItem(two, "two");
		
		four = new CodeFour(ID.FOUR).setUnlocalizedName(ModInfo.ID + ":" + Names.FOUR).setCreativeTab(CreativeTab.hackcraft);
		GameRegistry.registerItem(four, "four");
		
		eight = new CodeEight(ID.EIGHT).setUnlocalizedName(ModInfo.ID + ":" + Names.EIGHT).setCreativeTab(CreativeTab.hackcraft);
		GameRegistry.registerItem(eight, "eight");
		
	}
	public static void addNames(){
		LanguageRegistry.addName(zero, Names.ZERO_IG);
		LanguageRegistry.addName(one, Names.ONE_IG);
		LanguageRegistry.addName(two, Names.TWO_IG);
		LanguageRegistry.addName(four, Names.FOUR_IG);
		LanguageRegistry.addName(eight, Names.EIGHT_IG);
		
	}
	public static void addRecipes(){
		GameRegistry.addShapedRecipe(new ItemStack(two), "ooi","ioo","io ", 'i', Code.one, 'o', Code.zero);
		GameRegistry.addShapedRecipe(new ItemStack(four), "ooi","ioi","oo ", 'i', Code.two, 'o', Code.zero);
		GameRegistry.addShapedRecipe(new ItemStack(eight), "ooi","iio","oo ", 'i', Code.four, 'o', Code.zero);
	}
	
	
}
