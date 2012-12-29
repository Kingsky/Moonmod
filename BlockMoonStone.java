package net.jlndk.moonmod;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockMoonStone extends Block{
	public BlockMoonStone(int par1, int par2){
		super(par1, par2, Material.rock);
		this.setCreativeTab(CreativeTabs.tabBlock);
			
	}
	public String getTextureFile(){
		return "/jlndk/moonmod/Blocks.png";
	}
	public int idDropped(int par1, Random par2Random, int par3)
    {
        return mod_moonmod.MoonCobblestone.blockID;
    }
}
