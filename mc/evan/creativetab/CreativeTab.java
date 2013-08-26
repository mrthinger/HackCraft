package mc.evan.creativetab;

import mc.evan.lib.ModInfo;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class CreativeTab {

	public static CreativeTabs hackcraft;
	
	public static void init(){
		
		hackcraft = new CreativeTabHackCraft(12, "hackcraft");
		LanguageRegistry.instance().addStringLocalization("itemGroup.hackcraft", "en_US", ModInfo.CTAB_NAME);
		
	}
	
	
}
