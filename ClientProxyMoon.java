package net.jlndk.moonmod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;
import net.jlndk.moonmod.CommonProxyMoon;

public class ClientProxyMoon extends CommonProxyMoon{
	@Override
	public void registerRenderThings(){
		MinecraftForgeClient.preloadTexture("/jlndk/moonmod/Blocks.png");
		MinecraftForgeClient.preloadTexture("/jlndk/moonmod/Items.png");
	}
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
	TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
	if (tileEntity != null)
	{
	switch(ID)
	{
	case 0: /* your GUIs go here */
	}
	}
	return tileEntity;
}
}
