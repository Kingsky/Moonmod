package net.jlndk.moonmod;

import java.util.List;
import java.util.Random;

import net.minecraft.world.biome.BiomeGenBase;

public class WorldGenMoon extends BiomeGenBase
{
	   
    private boolean enableRain;

	public WorldGenMoon(int par1)
    {
        super(par1);
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        topBlock = (byte)Moonmod.MoonStone.blockID;
        fillerBlock = (byte)Moonmod.MoonStone.blockID;
    }
	public BiomeGenBase setDisableRain()
    {
        this.enableRain = false;
        return this;
    }
}
