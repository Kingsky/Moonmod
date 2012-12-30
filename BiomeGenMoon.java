package net.jlndk.moonmod;

import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenMoon extends BiomeGenBase
{
	private boolean enableRain;
	BiomeDecoratorMoon biomedec; 
	public BiomeGenMoon(int par1)
	{
		super(par1);
			biomedec = new BiomeDecoratorMoon(this); 
			spawnableMonsterList.clear();
			spawnableCreatureList.clear();
			topBlock = (byte)Moonmod.MoonStone.blockID;
			fillerBlock = (byte)Moonmod.MoonStone.blockID;
}
	public BiomeGenBase setDisableRain()
	{
		this.enableRain = false;
		return this;
	}
}
