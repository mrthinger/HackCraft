package mc.evan.client.interfaces;

import mc.evan.block.machine.tileentity.TileEntityHComp;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiHComp extends GuiContainer {

	public GuiHComp(InventoryPlayer invPlayer, TileEntityHComp zero) {
		super(new ContainerHComp(invPlayer, zero));
		
		xSize = 176;
		ySize = 154;
	}

	private static final ResourceLocation texture = new ResourceLocation("evanmc", "textures/gui/hcompgui.png");
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int x, int y) {
		GL11.glColor4f(1, 1, 1, 1);
		
		Minecraft.getMinecraft().func_110434_K().func_110577_a(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		fontRenderer.drawString( "Zero", guiLeft + 60, guiTop + 40, 0x000000);
		fontRenderer.drawString( "One", guiLeft + 98, guiTop + 40, 0x000000);
	}

}
