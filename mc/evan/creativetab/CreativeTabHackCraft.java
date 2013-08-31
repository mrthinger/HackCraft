package mc.evan.creativetab;

import mc.evan.lib.ModInfo;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CreativeTabHackCraft extends CreativeTabs {

	public CreativeTabHackCraft(String par2Str) {
		super(par2Str);
		// TODO Auto-generated constructor stub
	}
	public ItemStack getIconItemStack()
    {
        return ModInfo.CTAB_IMG;
    }
}
