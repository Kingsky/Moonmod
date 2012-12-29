package net.jlndk.moonmod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockMoonCobblestone extends Block{
	public BlockMoonCobblestone(int par1, int par2){
		super(par1, par2, Material.rock);
		this.setCreativeTab(CreativeTabs.tabBlock);
			
	}
	public String getTextureFile(){
		return "/jlndk/moonmod/Blocks.png";
	}
}
