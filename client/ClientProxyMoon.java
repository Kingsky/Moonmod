package net.jlndk.Moonmod.client;

import cpw.mods.fml.client.registry.RenderingRegistry;
import net.jlndk.Moonmod.CommonProxyMoon;
import net.jlndk.Moonmod.Moonmod;
import net.jlndk.Moonmod.mobs.EntityAlien;
import net.jlndk.Moonmod.mobs.ModelAlien;
import net.jlndk.Moonmod.mobs.RenderAlien;
import net.minecraftforge.client.MinecraftForgeClient;
 
public class ClientProxyMoon extends CommonProxyMoon
{
    @Override
    public void registerRenderInformation()
    {
        MinecraftForgeClient.preloadTexture(Moonmod.textureFile);
        RenderingRegistry.registerEntityRenderingHandler(EntityAlien.class, new RenderAlien(new ModelAlien(), 1.0F));
    }
 
    @Override
    public int addArmor(String armor)
    {
        return RenderingRegistry.addNewArmourRendererPrefix(armor);
    }
}