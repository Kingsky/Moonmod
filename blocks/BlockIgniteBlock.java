package net.jlndk.Moonmod.blocks;

import net.jlndk.Moonmod.Moonmod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

public class BlockIgniteBlock extends Block{
	public BlockIgniteBlock(int par1, int par2){
		super(par1, par2, Material.ground);
		//this.setCreativeTab(CreativeTabs.tabBlock);
			
	}
	public String getTextureFile(){
		return "/jlndk/moonmod/Blocks.png";
	}
	
	public void onBlockAdded(World par1World, int par2, int par3, int par4)
	{

	if (par1World.getBlockId(par2, par3 - 1, par4) != Moonmod.CheeseBlock.blockID || ! BlockMoonPortal.tryToCreatePortal(par1World, par2, par3, par4))
	{
	if (par3 - 1 != Moonmod.CheeseBlock.blockID)
	{
	par1World.setBlockWithNotify(par2, par3, par4, 0);

	}
	else
	{
	par1World.scheduleBlockUpdate(par2, par3, par4, this.blockID, this.tickRate() + par1World.rand.nextInt(10));

	}
	}
}
}