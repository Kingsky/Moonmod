package net.jlndk.Moonmod.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.jlndk.Moonmod.Moonmod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;


public class BlockAluBlock extends Block{
	public BlockAluBlock(int par1, int par2){
		super(par1, par2, Material.iron);
		this.setCreativeTab(Moonmod.tabMoon);
			
	}
	@SideOnly(Side.CLIENT)
	public String getTextureFile(){
		return "/jlndk/moonmod/Blocks.png";
	}
}
