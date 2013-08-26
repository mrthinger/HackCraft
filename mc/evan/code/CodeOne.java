package mc.evan.code;

import mc.evan.lib.ModInfo;
import mc.evan.lib.Names;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CodeOne extends Item{

	public CodeOne(int par1) {
		super(par1);
		// TODO Auto-generated constructor stub
	}
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon){
		this.itemIcon = icon.registerIcon(ModInfo.ID + ":" + Names.ONE);
	}
}
