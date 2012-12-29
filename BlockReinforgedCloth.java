package net.jlndk.moonmod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockReinforgedCloth extends Block{
	public BlockReinforgedCloth(int par1, int par2){
		super(par1, par2, Material.cloth);
		this.setCreativeTab(CreativeTabs.tabBlock);
			
	}
	@Override
	public String getTextureFile(){
		return "/jlndk/moonmod/Blocks.png";
	}
}
