package net.jlndk.moonmod;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.MapGenBase;
import net.minecraft.world.gen.MapGenCaves;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class ChunkProviderMoon implements IChunkProvider {

	private MapGenBase caveGen;
	private Random moonRand;
	private World worldObj;
	private int param = 512;
	private float f = 3;
	private int fill = mod_moonmod.MoonStone.blockID;
	Block top = mod_moonmod.MoonStone;

	/**
	 * Block coordniates. Start of chunk.
	 */
	private int chunkX, chunkZ;

	public ChunkProviderMoon(World worldObj, long randomSeed) {
		caveGen = new MapGenCaves();
		this.worldObj = worldObj;
		moonRand = new Random(randomSeed);
	}

	@Override
	public boolean chunkExists(int i, int j) {
		return true;
	}

	public Chunk provideChunk(int i, int j) {
		moonRand.setSeed(i * 341873128712L + j * 132897987541L);
		short[] ashort0 = new short[32768];
		Chunk chunk = new Chunk(worldObj, i, j);
		generateTerrain(i, j, ashort0);
		chunk.generateSkylightMap();
		return chunk;
	}

	public Chunk prepareChunk(int i, int j) {
		return provideChunk(i, j);
	}

	@Override
	public void populate(IChunkProvider ichunkprovider, int i, int j) {
		int chunkStartX = i * 16;
		int chunkStartZ = j * 16;
		int tmp, x, y, z;

		for (tmp = 0; tmp < 5; ++tmp) {
			x = chunkStartX + this.moonRand.nextInt(16);
			y = this.moonRand.nextInt(30);
			z = chunkStartZ + this.moonRand.nextInt(16);
			(new WorldGenMinable(Block.oreIron.blockID, 4)).generate(
					this.worldObj, this.moonRand, x, y, z);
		}
		
		for (tmp = 0; tmp < 5; ++tmp) {
			x = chunkStartX + this.moonRand.nextInt(16);
			y = this.moonRand.nextInt(30);
			z = chunkStartZ + this.moonRand.nextInt(16);
			(new WorldGenMinable(mod_moonmod.AluOre.blockID, 4)).generate(
					this.worldObj, this.moonRand, x, y, z);
		}

		for (tmp = 0; tmp < 20; ++tmp) {
			x = i + this.moonRand.nextInt(16);
			y = this.moonRand.nextInt(128);
			z = j + this.moonRand.nextInt(16);
			(new WorldGenMinable(mod_moonmod.MoonStone.blockID, 32)).generate(
					this.worldObj, this.moonRand, x, y, z);
		}
	}

	@Override
	public boolean saveChunks(boolean flag, IProgressUpdate iprogressupdate) {
		return true;
	}

	@Override
	public boolean unload100OldestChunks() {
		return false;
	}

	@Override
	public boolean canSave() {
		return true;
	}

	@Override
	public String makeString() {
		return "MoonRandomLevelSource";
	}

	public void generateTerrain(int i, int j, short ashort0[]) {
		int surface, surfaceDust, xx, zz;

		computeCraters(i, j, ashort0);
	}

	/**
	 * Kdy�� jsou ob�� sou��adnice chunku sud��, nach��z�� se na n��m st��ed. Ze
	 * sou��adnic st��edu spo����t��m n��hodn�� ����slo <-1;1>. N��hodn�� ����slo pou��iju na
	 * propo��et hloubky a pr��m��ru kr��teru a posun st��edu. Potom vytvo��im
	 * kr��tery.
	 * 
	 * kdy�� jsou ob�� sou��. sud��. jsem na st��edu brnka��ka.
	 * 
	 * kdy�� je sud�� x a z lich�� po����t��m: z+1,x; z-1,x;z+1,x+2; z+2,x-1; z+1,x-2;
	 * z-1,x-2;
	 * 
	 * kdy�� je sud�� z a x lich�� po����t��m: z,x+1; z,x-1;z+2,x+1; z-1,x+2; z-2,x+1;
	 * z-2,x-1;
	 * 
	 * kdy�� lich�� ob�� po����t��m: z+1,x+1;z+1,x-1;z-1,x+1;z-1;x-1
	 */
	private void computeCraters(int x, int z, short[] chunkArr) {
		// sud�� x a z
		boolean evenX, evenZ;
		evenX = x % 2 == 0 ? true : false;
		evenZ = z % 2 == 0 ? true : false;
		chunkX = x * 16;
		chunkZ = z * 16;

		if (evenX && evenZ) {
			createCrater(x, z, chunkArr);
		} else if (evenX) {
			createCrater(x, z + 1, chunkArr);
			createCrater(x, z - 1, chunkArr);
			createCrater(x + 2, z + 1, chunkArr);
			createCrater(x + 2, z - 1, chunkArr);
			createCrater(x - 2, z + 1, chunkArr);
			createCrater(x - 2, z - 1, chunkArr);
		} else if (evenZ) {
			createCrater(x + 1, z, chunkArr);
			createCrater(x - 1, z, chunkArr);
			createCrater(x + 1, z + 2, chunkArr);
			createCrater(x - 1, z + 2, chunkArr);
			createCrater(x + 1, z + 2, chunkArr);
			createCrater(x - 1, z + 2, chunkArr);
		} else {
			createCrater(x + 1, z + 1, chunkArr);
			createCrater(x - 1, z + 1, chunkArr);
			createCrater(x + 1, z - 1, chunkArr);
			createCrater(x - 1, z - 1, chunkArr);
		}

	}

	private void createCrater(int chnkX, int chnkZ, short[] chunkArr) {

		double centerRand = randFromPoint(chnkX, chnkZ);
		int maxCenterDelta = 6;
		int centerX, centerZ, radius;

		centerX = chnkX * 16 + 8 + (int) (maxCenterDelta * centerRand);
		centerZ = chnkZ * 16 + 8 + (int) (maxCenterDelta * centerRand);
		radius = (int) ((centerRand + 1) * 8) + 8;

		int distance, sphereY = 0, index = 0;
		boolean inSphere;
		for (int z = 0; z < 16; z++) {
			for (int x = 0; x < 16; x++) {
				distance = -1 * centerX * centerX + 2 * (x + chunkX) * centerX
						- centerZ * centerZ + 2 * centerZ * (z + chunkZ)
						+ radius * radius - (x + chunkX) * (x + chunkX)
						- (z + chunkZ) * (z + chunkZ);

				if (distance > 0) {
					sphereY = (int) (Math.sqrt(distance) / 2.5);
				} else {
					continue;
				}

				inSphere = false;

				for (int y = 90; y > 0; y--) {
					index = getIndex(x, y, z);

					if (sphereY == 0) {
						break;
					}

					if (inSphere) {
						chunkArr[index] = 0;
						sphereY--;
						continue;
					}

					if (chunkArr[index] == 0) {
						continue;
					} else {
						y++;
						inSphere = true;
					}
				}
			}
		}

	}

	private int getIndex(int x, int y, int z) {
		return (x * 16 + z) * 128 + y;
	}

	/**
	 * Returns pseudo random value for given point.
	 */
	private double randFromPoint(int x, int z) {
		int n;
		n = x + z * 57;
		n = (n << 13) ^ n;
		return (1.0 - ((n * (n * n * 15731 + 789221) + 1376312589) & 0x7fffffff) / 1073741824.0);
	}

	@Override
	public Chunk loadChunk(int var1, int var2) {
		return null;
	}

	@Override
	public List getPossibleCreatures(EnumCreatureType var1, int var2, int var3,
			int var4) {
		return null;
	}

	@Override
	public ChunkPosition findClosestStructure(World var1, String var2,
			int var3, int var4, int var5) {
		return null;
	}

	@Override
	public int getLoadedChunkCount() {
		return 0;
	}

	@Override
	public void recreateStructures(int var1, int var2) {
		
	}
}
