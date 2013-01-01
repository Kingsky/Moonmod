package net.jlndk.moonmod;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

public class BlockMoonLamp extends Block
{
        private final boolean powered;

        public BlockMoonLamp(int i, Boolean par1, int j)
        {
                super(i, j, Material.redstoneLight);
                powered = par1;
        }

        public void onBlockAdded(World par1World, int par2, int par3, int par4)
        {
                if (!par1World.isRemote)
                {
                        if (powered && !par1World.isBlockIndirectlyGettingPowered(par2, par3, par4))
                        {
                                par1World.scheduleBlockUpdate(par2, par3, par4, blockID, 4);
                        }
                        else if (!powered && par1World.isBlockIndirectlyGettingPowered(par2, par3, par4))
                        {
                                par1World.setBlockWithNotify(par2, par3, par4, Moonmod.MoonLampActive.blockID);
                        }
                }
        }

        public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
        {
                if (!par1World.isRemote)
                {
                        if (powered && !par1World.isBlockIndirectlyGettingPowered(par2, par3, par4))
                        {
                                par1World.scheduleBlockUpdate(par2, par3, par4, blockID, 4);
                        }
                        else if (!powered && par1World.isBlockIndirectlyGettingPowered(par2, par3, par4))
                        {
                                par1World.setBlockWithNotify(par2, par3, par4, Moonmod.MoonLampActive.blockID);
                        }
                }
        }

        public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
        {
                if (!par1World.isRemote && powered && !par1World.isBlockIndirectlyGettingPowered(par2, par3, par4))
                {
                        par1World.setBlockWithNotify(par2, par3, par4, Moonmod.MoonLampIdle.blockID);
                }
        }


        public int quantityDropped(Random random)
        {
                return 1;
        }
        public int idDropped (int i,Random random, int j)
        {
                return Moonmod.MoonLampIdle.blockID;
        }
        public String getTextureFile(){
    		return "/jlndk/moonmod/Blocks.png";
    	}
    }