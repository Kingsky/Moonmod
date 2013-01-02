package net.jlndk.moonmod;

import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;

public class MoonFuelHandler implements IFuelHandler {

	@Override
	public int getBurnTime(ItemStack fuel) {
		if(fuel.itemID==Moonmod.Battery.shiftedIndex){
			return 3200;
		}else
		return 0;
	}
}
