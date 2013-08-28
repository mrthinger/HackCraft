package mc.evan.core;

import mc.evan.code.Code;
import mc.evan.creativetab.CreativeTab;
import mc.evan.item.Items;
import mc.evan.lib.ConfigHandler;
import mc.evan.lib.ModInfo;
import mc.evan.machine.Machine;
import mc.evan.network.CommonProxy;
import mc.evan.network.PacketHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = ModInfo.ID, name = ModInfo.NAME, version = ModInfo.VERSION)

@NetworkMod(channels = {ModInfo.ID},clientSideRequired=true, serverSideRequired=false, packetHandler = PacketHandler.class)
public class EvanMCMain {

	@Instance(ModInfo.ID)
	public static EvanMCMain instance;
	@SidedProxy(clientSide="mc.evan.network.ClientProxy", serverSide="mc.evan.network.CommonProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void preinit(FMLPreInitializationEvent event){
		//Config
		ConfigHandler.init(event.getSuggestedConfigurationFile());
		
		
		
		//Creative Tab
		CreativeTab.init();

		//Machines
		Machine.init();

		
		//Items
		Items.init();

		
		//"Code" lol
		Code.init();

		

	}
	
	@EventHandler
	public void load(FMLInitializationEvent event){
		
		
		Machine.addNames();
		Machine.addRecipes();
		
		Items.addNames();
		Items.addRecipies();
		
		Code.addNames();
		Code.addRecipes();
		
		
	}
	
}
