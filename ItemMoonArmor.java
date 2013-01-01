package net.jlndk.moonmod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;

public class ItemMoonArmor extends ItemArmor{

	public ItemMoonArmor(int par1, EnumArmorMaterial par2EnumArmorMaterial,
			int par3, int par4) {
		super(par1, par2EnumArmorMaterial, par3, par4);
	        this.setCreativeTab(CreativeTabs.tabCombat);
	}
	public String getTextureFile(){
		return "/jlndk/moonmod/Items.png";
	}
}
