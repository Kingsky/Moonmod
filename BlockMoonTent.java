package net.jlndk.moonmod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockMoonTent extends Block {
	
	public BlockMoonTent(int i, int j) {
		super(i, j, Material.cloth);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
	
	public static boolean inTent(World wd, int x, int y, int z) {
		return false;
	}
		public String getTextureFile(){
		return "/jlndk/moonmod/Blocks.png";
	}
	}

	