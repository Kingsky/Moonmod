package net.jlndk.Moonmod.items;

import net.jlndk.Moonmod.Moonmod;
import net.jlndk.Moonmod.blocks.BlockMoonPortal;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSonicScrew extends Item {

	public ItemSonicScrew(int i) {
		super(i);
		setMaxStackSize(1);
		setMaxDamage(Moonmod.screwUses);
		this.setCreativeTab(Moonmod.tabMoon);
	}

	public boolean canHarvestBlock(Block block) {
		return false;
	}
	public String getTextureFile(){
		return "/jlndk/moonmod/Items.png";
	}
	
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
        if (par7 == 0)
        {
            --par5;
        }

        if (par7 == 1)
        {
            ++par5;
        }

        if (par7 == 2)
        {
            --par6;
        }

        if (par7 == 3)
        {
            ++par6;
        }

        if (par7 == 4)
        {
            --par4;
        }

        if (par7 == 5)
        {
            ++par4;
        }

        if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack))
        {
            return false;
        }
        else
        {
            int var11 = par3World.getBlockId(par4, par5, par6);

            if (var11 == 0)
            {
                par3World.playSoundEffect((double)par4 + 0.5D, (double)par5 + 0.5D, (double)par6 + 0.5D, "fire.ignite", 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
                BlockMoonPortal.tryToCreatePortal(par3World, par4, par5, par6);
            }

            par1ItemStack.damageItem(1, par2EntityPlayer);
            return true;
        }
    }

//	@Override
//	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer) {
//		System.out.println("ufon");
//		world.entityJoinedWorld(new EntityMoonUfo(world, entityplayer));
//		return itemstack;
//	}
}
