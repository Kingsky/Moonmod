package net.jlndk.Moonmod.world;

import net.jlndk.Moonmod.Moonmod;
import net.jlndk.Moonmod.mobs.EntityAlien;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;

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
			spawnableCreatureList.add(new SpawnListEntry(EntityAlien.class, 1, par1, par1));
			topBlock = (byte)Moonmod.MoonStone.blockID;
			fillerBlock = (byte)Moonmod.MoonStone.blockID;
	        this.enableRain = false;
}
}
