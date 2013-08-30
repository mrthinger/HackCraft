package mc.evan.client.interfaces;

import mc.evan.code.Code;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotZero extends Slot {

	public SlotZero(IInventory inventory, int id, int x, int y) {
		super(inventory, id, x, y);
	}
	
	@Override
	public boolean isItemValid(ItemStack stack) {
		return stack.itemID == Code.zero.itemID;
	}
}
