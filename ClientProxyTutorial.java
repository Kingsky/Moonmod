package net.jlndk.moonmod;

import net.minecraftforge.client.MinecraftForgeClient;
import net.jlndk.moonmod.CommonProxyTutorial;

public class ClientProxyTutorial extends CommonProxyTutorial{
	@Override
	public void registerRenderThings(){
		MinecraftForgeClient.preloadTexture("/jlndk/moonmod/Blocks.png");
		MinecraftForgeClient.preloadTexture("/jlndk/moonmod/Items.png");
	}

}
