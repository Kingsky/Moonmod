package net.jlndk.moonmod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;


public class BlockAluBlock extends Block{
	public BlockAluBlock(int par1, int par2){
		super(par1, par2, Material.iron);
		this.setCreativeTab(Moonmod.tabMoon);
			
	}
	public String getTextureFile(){
		return "/jlndk/moonmod/Blocks.png";
	}
}
