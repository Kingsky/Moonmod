package net.jlndk.moonmod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
 
public class ItemAluIngot extends Item
{
    public ItemAluIngot(int i)
    {
        super(i);
        maxStackSize = 64;
        this.setCreativeTab(CreativeTabs.tabMaterials);
    }
 
 
public String getTextureFile(){
               
                return "/jlndk/moonmod/Items.png";
               
        }
}