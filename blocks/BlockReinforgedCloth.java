package net.jlndk.Moonmod.blocks;

import net.jlndk.Moonmod.Moonmod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockReinforgedCloth extends Block{
	public BlockReinforgedCloth(int par1, int par2){
		super(par1, par2, Material.cloth);
		this.setCreativeTab(Moonmod.tabMoon);
			
	}
	@Override
	public String getTextureFile(){
		return "/jlndk/moonmod/Blocks.png";
	}
}
