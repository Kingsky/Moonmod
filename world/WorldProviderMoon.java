package net.jlndk.Moonmod.world;

import java.util.Random;

import net.jlndk.Moonmod.Moonmod;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.IChunkProvider;


public class WorldProviderMoon extends WorldProvider
{
	 
//The WorldProvider covers all the basics of the dimension. Look in WorldProviderBase.java and
//WorldProvider.java for all the potential qualities you can assign to your dimension.

public WorldProviderMoon()
{
}

//The save file will be called DIM65 (DIM + id number).
public int getDimensionID()
	{
		
		return 37;
	
	}

public boolean renderClouds()
	{

		return false;

	}
public boolean renderEndSky()
{
    return false;
}
public boolean renderVoidFog()
{

	return true;
	
}



public float setMoonSize()
{
	return 2.1F;
}

public float setSunSize()
{
	
	return 1.0F;

}



public String getSunTexture()
{

	return null;

}


public String getMoonTexture()
{

	return "/jlndk/moonmod/misc/earth.png";

}

public int getRespawnDimension(EntityPlayerMP player)
{
    return 0;
}

public boolean renderStars()
{

	return true;

}


public boolean darkenSkyDuringRain()
{

	return false;

}
public boolean hasNoSky = false;

public String getWelcomeMessage()
{
return "Entering " + this.getDimensionName();
}

public String getDepartMessage()
{

	return " Leaving " + this.getDimensionName();

}

//You can use an existing WorldChunkManager, or create your own. You must create your own to
//add multiple unique biomes to a dimension.
public void registerWorldChunkManager()
{

	worldChunkMgr = new WorldChunkManagerMoon(Moonmod.biomemoon, 1.0F, 0.0F);

}

//This is where you define your terrain generator.
public IChunkProvider getChunkProvider()
{

	return new ChunkProviderMoon(worldObj, worldObj.getSeed());

}

//Note that, if you respawn in the dimension, you will end up at the coordinates of your
//overworld spawn point, not at the location of your first entrance to the dimension or
//something like that. Note also that beds don't work if you cannot respawn in the dimension.
public boolean canRespawnHere()
{

	return true;

}

public float calculateCelestialAngle(long par1, float par3)
{

	return 0.5F;

}

@Override
public String getDimensionName() {
	return Moonmod.getDimensionName();
}

}


