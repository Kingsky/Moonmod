package net.jlndk.Moonmod.client;

import cpw.mods.fml.client.registry.RenderingRegistry;
import net.jlndk.Moonmod.CommonProxyMoon;
import net.jlndk.Moonmod.Moonmod;
import net.minecraftforge.client.MinecraftForgeClient;
 
public class ClientProxyMoon extends CommonProxyMoon
{
    @Override
    public void registerRenderInformation()
    {
        MinecraftForgeClient.preloadTexture(Moonmod.textureFile);
    }
 
    @Override
    public int addArmor(String armor)
    {
        return RenderingRegistry.addNewArmourRendererPrefix(armor);
    }
}