package net.jlndk.moonmod;

import net.minecraft.item.Item;
 
public class ItemBattery extends Item
{
    public ItemBattery(int i)
    {
        super(i);
        maxStackSize = 64;
        this.setCreativeTab(Moonmod.tabMoon);
    }
 
 
public String getTextureFile(){
               
                return "/jlndk/moonmod/Items.png";
               
        }
}