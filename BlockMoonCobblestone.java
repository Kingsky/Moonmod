package net.jlndk.moonmod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockMoonCobblestone extends Block{
	public BlockMoonCobblestone(int par1, int par2){
		super(par1, par2, Material.rock);
		this.setCreativeTab(Moonmod.tabMoon);
			
	}
	public String getTextureFile(){
		return "/jlndk/moonmod/Blocks.png";
	}
}
