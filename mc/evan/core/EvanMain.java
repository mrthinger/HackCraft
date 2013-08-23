package mc.evan.core;

import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.EnumHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "evanmc", name = "EvanMC", version = "0.1")

@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class EvanMain {

	//Define Items
	public static Item cpick;
	
	//Define Materials
	public static EnumToolMaterial CODE = EnumHelper.addToolMaterial("Code", 3, -1, 255.0F, 20.0F, 10);
	
	@EventHandler
	public void Load(FMLPreInitializationEvent Event){
		
		cpick = new ToolCPick(1337, CODE).setUnlocalizedName("evanmc:cpick");
		GameRegistry.registerItem(cpick, "cpick");
		LanguageRegistry.addName(cpick, "Code Pickaxe");
		GameRegistry.addShapedRecipe(new ItemStack(cpick), "iii"," i "," i ", 'i', Item.stick);
	}
	
}
