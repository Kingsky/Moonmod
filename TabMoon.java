package net.jlndk.Moonmod;

import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.*;


public class TabMoon extends CreativeTabs {
public TabMoon(int position, String tabID) {
super(position, tabID); //The constructor for your tab
}
@SideOnly(Side.CLIENT)
public int getTabIconItemIndex() //The item it displays for your tab
{
return Moonmod.SonicScrew.itemID; //For this we'll use the ruby
}
public String getTranslatedTabLabel()
{
return "Moon"; //The name of the tab ingame
}
}