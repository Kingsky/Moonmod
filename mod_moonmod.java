package net.jlndk.moonmod;

/*
 * Importing
 */
import java.util.Random;


import net.minecraft.block.Block;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.event.world.WorldEvent;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.DimensionManager;

 
/*
 * Basic needed forge stuff
 */
@Mod(modid="Moonmod",name="Moonmod by Jlndk",version="0.0.3 for 1.4.5")
@NetworkMod(clientSideRequired=true,serverSideRequired=false)
public class mod_moonmod {
	public static int screwUses = 30;
	public static int reinfID = 461;
	public static int aluingotID = 550;
	{
		MinecraftForgeClient.preloadTexture("/jlndk/moonmod/Blocks.png");
	}

		//Block Declaring
	public static Block CheeseBlock = new BlockCheese(425, 1).setBlockName("CheeseBlock").setHardness(1F).setResistance(5F);;
	public static Block AluBlock = new BlockAluBlock(456, 2).setBlockName("AluBlock").setHardness(1F).setResistance(5F);
	public static Block AluOre = new BlockAluBlock(457, 3).setBlockName("AluOre").setHardness(1F).setResistance(5F);
	public static final Block MoonPortal = new BlockMoonPortal(458, 14).setStepSound(Block.soundGlassFootstep).setHardness(0.5F).setResistance(1F).setBlockName("MoonPortal");
    public static final Block MoonStone = new BlockMoonStone(146, 6).setBlockName("MoonStone").setHardness(1F).setResistance(5F);
    public static final Block MoonCobblestone = new BlockMoonCobblestone(147, 6).setBlockName("MoonCobblestone").setHardness(1F).setResistance(5F);
    public static final Block IgniteBlock = new BlockIgniteBlock(460, 0).setBlockName("IgniteBlock").setHardness(1F).setResistance(5F);
    public static Block ReinfCloth = new BlockReinforgedCloth(reinfID, 4).setBlockName("ReinfCloth").setHardness(1F).setResistance(2F);
    public static Block MoonTent = new BlockMoonTent(462, 7).setBlockName("MoonTent").setHardness(1F).setResistance(10F);
    
	//Item Declaring
	public static Item AluIngot = new ItemAluIngot(aluingotID).setIconIndex(1).setItemName("AluIngot");
	public static Item SonicScrew = new ItemSonicScrew(551).setIconIndex(2).setItemName("SonicScrew");
	public static Item CheeseSlice = new ItemCheeseSlice (552, 8, true).setIconIndex(3).setItemName("CheeseSlice");
	
	//Armor Declaring
	public static Item MoonHelmet = (new ItemMoonArmor(700, EnumArmorMaterial.IRON, ModLoader.addArmor("moonSuit"), 0).setIconIndex(4).setItemName("moonHelm"));
	public static Item MoonChest = (new ItemMoonArmor(701, EnumArmorMaterial.IRON, ModLoader.addArmor("moonSuit"), 1).setIconIndex(5).setItemName("moonChest"));
	public static Item MoonPants = (new ItemMoonArmor(702, EnumArmorMaterial.IRON, ModLoader.addArmor("moonSuit"), 2).setIconIndex(6).setItemName("moonPants"));
	public static Item MoonBoots = (new ItemMoonArmor(703, EnumArmorMaterial.IRON, ModLoader.addArmor("moonSuit"), 3).setIconIndex(7).setItemName("moonBoots"));
	
	@SidedProxy(clientSide = "net.jlndk.moonmod.ClientProxyTutorial", serverSide = "net.jlndk.moonmod.CommonProxyTutorial")
    public static CommonProxyTutorial proxy;
	
	
	
	//Biome Declaring
	public static BiomeGenBase moon = new BiomeGenMoon(14).setBiomeName("Moon").setDisableRain().setTemperatureRainfall(2.0F, 0.0F);
	
	//tent
	

	
	//Declaring Init
	@Init
	public void load(FMLInitializationEvent event){
		  {
			//Dimension
			DimensionManager.registerProviderType(37, WorldProviderMoon.class, true);
			DimensionManager.registerDimension(37, 37);
		  }	

	//Registering Block
		GameRegistry.registerBlock(CheeseBlock);
		GameRegistry.registerBlock(AluBlock);
		GameRegistry.registerBlock(AluOre);
		GameRegistry.registerBlock(MoonPortal);
		GameRegistry.registerBlock(MoonStone);
		GameRegistry.registerBlock(MoonCobblestone);
		GameRegistry.registerBlock(IgniteBlock);
		GameRegistry.registerBlock(ReinfCloth);
		GameRegistry.registerBlock(MoonTent);
		
	//Generators
		GameRegistry.registerWorldGenerator(new Moongenerator());
	//Adding ItemName 
		//English
			//blocks
			LanguageRegistry.addName(CheeseBlock, "Block of Cheese");
			LanguageRegistry.addName(AluBlock, "Aluminium Block");
			LanguageRegistry.addName(AluOre, "Aluminium Ore");
			LanguageRegistry.addName(AluIngot, "Aluminium Ingot");
			LanguageRegistry.addName(MoonStone, "Moon Stone");
			LanguageRegistry.addName(MoonCobblestone, "Moon Cobblestone");
			LanguageRegistry.addName(MoonPortal, "Moon Portal Block");
			LanguageRegistry.addName(IgniteBlock, "Ignition Block");
			LanguageRegistry.addName(ReinfCloth, "Reinforged Cloth");
			LanguageRegistry.addName(MoonTent, "Moon Tent");
			//Items
			LanguageRegistry.addName(SonicScrew, "Sonic Screwdriver");
			LanguageRegistry.addName(MoonHelmet, "Moon Helmet");
			LanguageRegistry.addName(MoonChest, "Moon Chestplate");
			LanguageRegistry.addName(MoonPants, "Moon Leggings");
			LanguageRegistry.addName(MoonBoots, "Moon Boots");
			LanguageRegistry.addName(MoonBoots, "Cheese Slice");
		//Danish
			//Blocks
			LanguageRegistry.instance().addStringLocalization("tile.CheeseBlock.name", "da_DK", "Oste Blok");
			LanguageRegistry.instance().addStringLocalization("tile.AluBlock.name", "da_DK", "Alumenium Blok");
			LanguageRegistry.instance().addStringLocalization("tile.AluOre.name", "da_DK", "Alumenium Malm");
			LanguageRegistry.instance().addStringLocalization("tile.MoonStone.name", "da_DK", "M��ne Sten");
			LanguageRegistry.instance().addStringLocalization("tile.MoonCobblestone.name", "da_DK", "M��ne Brosten");
			LanguageRegistry.instance().addStringLocalization("tile.MoonPortal.name", "da_DK", "M��ne Portal Block");
			LanguageRegistry.instance().addStringLocalization("tile.ReinfCloth.name", "da_DK", "Forst��rket Stof");
			LanguageRegistry.instance().addStringLocalization("tile.MoonTent.name", "da_DK", "M��ne Telt");
			//Items
			LanguageRegistry.instance().addStringLocalization(SonicScrew.getItemName() + ".name", "da_DK", "Sonisk Skruetr��kker");
			LanguageRegistry.instance().addStringLocalization(AluIngot.getItemName() + ".name", "da_DK", "Alumenium Barre");
			LanguageRegistry.instance().addStringLocalization(MoonHelmet.getItemName() + ".name", "da_DK", "M��ne Hjelm");
			LanguageRegistry.instance().addStringLocalization(MoonChest.getItemName() + ".name", "da_DK", "M��ne Jakke");
			LanguageRegistry.instance().addStringLocalization(MoonPants.getItemName() + ".name", "da_DK", "M��ne Bukser");
			LanguageRegistry.instance().addStringLocalization(MoonBoots.getItemName() + ".name", "da_DK", "M��ne St��vler");
			LanguageRegistry.instance().addStringLocalization(CheeseSlice.getItemName() + ".name", "da_DK", "Oste Stykke");
	//Recipes
		//crafting
		GameRegistry.addRecipe(new ItemStack(mod_moonmod.CheeseBlock, 2), new Object[] {"###", "###", "###", '#', Item.bucketMilk});
		GameRegistry.addRecipe(new ItemStack(mod_moonmod.AluBlock, 2), new Object[] {"###", "###", "###", '#', mod_moonmod.AluIngot});
		GameRegistry.addRecipe(new ItemStack(ReinfCloth, 1), new Object[] {"AAA", "ABA", "AAA", 'A', Block.cloth, 'B', Item.ingotGold});
		GameRegistry.addRecipe(new ItemStack(SonicScrew, 1), new Object[] { "  R"," I ", "I  ", Character.valueOf('R'), Item.redstone,Character.valueOf('I'), Item.ingotIron });
		GameRegistry.addRecipe(new ItemStack(SonicScrew, 1),new Object[] { "   ", " S ", " R ", Character.valueOf('R'),Item.redstone, Character.valueOf('S'),new ItemStack(SonicScrew, 1, screwUses) });
		GameRegistry.addRecipe(new ItemStack(SonicScrew, 1),new Object[] { "   ", " OO", " OO", Character.valueOf('O'), CheeseSlice});
		GameRegistry.addShapelessRecipe(new ItemStack(CheeseSlice, 4), new Object[] {CheeseBlock});
			//armor
		GameRegistry.addRecipe(new ItemStack(MoonHelmet, 1), new Object [] {"###", "#G#", Character.valueOf('#'), ReinfCloth, Character.valueOf('G'), Block.glass});
		GameRegistry.addRecipe(new ItemStack(MoonChest, 1), new Object [] {"# #", "###", "#A#", Character.valueOf('#'), ReinfCloth, Character.valueOf('A'), AluIngot});
		GameRegistry.addRecipe(new ItemStack(MoonPants, 1), new Object [] {"#A#", "# #", "A A", Character.valueOf('#'), ReinfCloth, Character.valueOf('A'), AluIngot});
		GameRegistry.addRecipe(new ItemStack(MoonBoots, 1), new Object [] {"A A", "# #", Character.valueOf('#'), ReinfCloth, Character.valueOf('A'), AluIngot});
		GameRegistry.addRecipe(new ItemStack(MoonTent, 1), new Object [] {" # ", "#G#", Character.valueOf('#'), ReinfCloth, Character.valueOf('G'), Block.glass});
		//smelting
		GameRegistry.addSmelting(mod_moonmod.AluOre.blockID, new ItemStack(mod_moonmod.AluIngot), 0.8F);
		GameRegistry.addSmelting(mod_moonmod.MoonCobblestone.blockID, new ItemStack(mod_moonmod.MoonStone), 0.8F);
		//other
		GameRegistry.addBiome(moon);
	}
		
		public static String getDimensionName() {
			return "The Moon";
		}
	}
