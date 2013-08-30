package mc.evan.client.interfaces;

import mc.evan.block.machine.tileentity.TileEntityHComp;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerHComp extends Container {

	public TileEntityHComp zero;
	
	public ContainerHComp(InventoryPlayer invPlayer, TileEntityHComp zero) {
		this.zero = zero;
		
		
		for (int x = 0; x < 9; x++) {
			addSlotToContainer(new Slot(invPlayer, x, 8 + 18 * x, 130));
		}
		
		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 9; x++) {
				addSlotToContainer(new Slot(invPlayer, x + y * 9 + 9, 8 + 18 * x, 72 + y * 18));
			}
		}
		
	
			addSlotToContainer(new SlotZero(zero, 0, 62, 20));
		
		
			addSlotToContainer(new SlotOne(zero, 1, 98, 20));
		
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return zero.isUseableByPlayer(entityplayer);
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int i) {
		return null;
	}

}
