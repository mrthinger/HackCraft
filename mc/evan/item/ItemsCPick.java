package mc.evan.item;

import mc.evan.creativetab.CreativeTab;
import mc.evan.lib.ModInfo;
import mc.evan.lib.Names;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemsCPick extends ToolCodePickaxe{

	public ItemsCPick(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		setUnlocalizedName(ModInfo.ID + ":" + Names.CPICK);
		setCreativeTab(CreativeTab.hackcraft);
	}

	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon){
		this.itemIcon = icon.registerIcon(ModInfo.ID + ":" + Names.CPICK);
	}
}
