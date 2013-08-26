package mc.evan.core;

import mc.evan.code.Code;
import mc.evan.creativetab.CreativeTab;
import mc.evan.item.Items;
import mc.evan.lib.ModInfo;
import mc.evan.machine.Machine;
import mc.evan.machine.MachineEvansComputer;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = ModInfo.ID, name = ModInfo.NAME, version = ModInfo.VERSION)

@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class EvanMCMain {

	
	
	@EventHandler
	public void Load(FMLPreInitializationEvent Event){
		//Creative Tab
		CreativeTab.init();

		//Machines
		Machine.init();
		Machine.addNames();
		Machine.addRecipes();
		
		//Items
		Items.init();
		Items.addNames();
		Items.addRecipies();
		
		//"Code" lol
		Code.init();
		Code.addNames();
		Code.addRecipes();
		

	}
	
}
