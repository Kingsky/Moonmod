package net.jlndk.Moonmod;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.EntityRegistry;
import net.jlndk.Moonmod.mobs.EntityAlien;
import net.jlndk.Moonmod.mobs.ModelAlien;
import net.jlndk.Moonmod.mobs.RenderAlien;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxyMoon extends CommonProxyMoon{
	
	public void registerRenderInformation(){
	RenderingRegistry.registerEntityRenderingHandler(EntityAlien.class, new RenderAlien(new ModelAlien(), 1.0F));	
	}

	public void registerRenderThings(){
		MinecraftForgeClient.preloadTexture("/jlndk/moonmod/Blocks.png");
		MinecraftForgeClient.preloadTexture("/jlndk/moonmod/Items.png");
	}
}
