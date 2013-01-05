package net.jlndk.Moonmod;

import net.jlndk.Moonmod.mobs.EntityAlien;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.EntityRegistry;

public class CommonProxyMoon implements IGuiHandler
{

	public void registerRenderInformation(){}
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		return null;
	}

	public void init(){
		EntityRegistry.registerGlobalEntityID(EntityAlien.class, "Alien", EntityRegistry.findGlobalUniqueEntityId(), 124679, 126458);
	}
}