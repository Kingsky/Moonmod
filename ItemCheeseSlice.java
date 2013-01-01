package net.jlndk.moonmod;

import net.minecraft.item.ItemFood;

public class ItemCheeseSlice extends ItemFood {

	public ItemCheeseSlice(int par1, int par2, boolean par3) {
		super(par1, par2, par3);
		maxStackSize = 4;
	    this.setCreativeTab(Moonmod.tabMoon);
	}

}
