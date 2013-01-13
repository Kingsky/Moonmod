package net.jlndk.Moonmod;

/*
 * Importing
 */
import java.util.Random;


import net.jlndk.Moonmod.blocks.BlockAluBlock;
import net.jlndk.Moonmod.blocks.BlockCheese;
import net.jlndk.Moonmod.blocks.BlockIgniteBlock;
import net.jlndk.Moonmod.blocks.BlockMoonCobblestone;
import net.jlndk.Moonmod.blocks.BlockMoonLamp;
import net.jlndk.Moonmod.blocks.BlockMoonPortal;
import net.jlndk.Moonmod.blocks.BlockMoonStone;
import net.jlndk.Moonmod.blocks.BlockMoonTent;
import net.jlndk.Moonmod.blocks.BlockReinforgedCloth;
import net.jlndk.Moonmod.items.ItemAluIngot;
import net.jlndk.Moonmod.items.ItemBattery;
import net.jlndk.Moonmod.items.ItemCheeseSlice;
import net.jlndk.Moonmod.items.ItemMoonArmor;
import net.jlndk.Moonmod.items.ItemSonicScrew;
import net.jlndk.Moonmod.world.BiomeGenMoon;
import net.jlndk.Moonmod.world.Moongenerator;
import net.jlndk.Moonmod.world.WorldProviderMoon;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.event.world.WorldEvent;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.DimensionManager;

 
/*
 * Basic needed forge stuff
 */
@Mod(modid="Moonmod",name="Moonmod by Jlndk",version="0.0.4.1 for 1.4.7")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class Moonmod {
	public static int screwUses = 30;
	{
	
	}
		//Creative tab Declaring
	public static CreativeTabs tabMoon = new TabMoon(CreativeTabs.getNextID(),"Moon");
	
		//Block Declaring
	public static Block CheeseBlock = new BlockCheese(425, 1).setBlockName("CheeseBlock").setHardness(1F).setResistance(5F);;
	public static Block AluBlock = new BlockAluBlock(456, 2).setBlockName("AluBlock").setHardness(1F).setResistance(5F);
	public static Block AluOre = new BlockAluBlock(457, 3).setBlockName("AluOre").setHardness(1F).setResistance(5F);
	public static Block MoonPortal = new BlockMoonPortal(458, 14).setStepSound(Block.soundGlassFootstep).setHardness(0.5F).setResistance(1F).setBlockName("MoonPortal");
    public static Block MoonStone = new BlockMoonStone(146, 6).setBlockName("MoonStone").setHardness(1F).setResistance(5F);
    public static Block MoonCobblestone = new BlockMoonCobblestone(147, 6).setBlockName("MoonCobblestone").setHardness(1F).setResistance(5F);
    public static Block IgniteBlock = new BlockIgniteBlock(460, 0).setBlockName("IgniteBlock").setHardness(1F).setResistance(5F);
    public static Block ReinfCloth = new BlockReinforgedCloth(461, 4).setBlockName("ReinfCloth").setHardness(1F).setResistance(2F);
    public static Block MoonTent = new BlockMoonTent(462, 7).setBlockName("MoonTent").setHardness(1F).setResistance(10F);
    public static Block MoonLampIdle = (new BlockMoonLamp(463, false, 5)).setHardness(0.3F).setStepSound(Block.soundMetalFootstep).setBlockName("MoonLampIdle");
    public static Block MoonLampActive = (new BlockMoonLamp(464, true, 5)).setHardness(0.3F).setStepSound(Block.soundMetalFootstep).setBlockName("MoonLampActive").setCreativeTab(Moonmod.tabMoon).setLightValue(1.0F);
    
	//Item Declaring
	public static Item AluIngot = new ItemAluIngot(550).setIconIndex(1).setItemName("AluIngot");
	public static Item SonicScrew = new ItemSonicScrew(551).setIconIndex(2).setItemName("SonicScrew");
	public static Item CheeseSlice = new ItemCheeseSlice (552, 8, true).setIconIndex(8).setItemName("CheeseSlice");
	public static Item Battery = new ItemBattery(553).setIconIndex(1).setItemName("Battery");

	//Armor Declaring
	public static Item MoonHelmet = (new ItemMoonArmor(700, EnumArmorMaterial.IRON, ModLoader.addArmor("moonSuit"), 0).setIconIndex(3).setItemName("moonHelm"));
	public static Item MoonChest = (new ItemMoonArmor(701, EnumArmorMaterial.IRON, ModLoader.addArmor("moonSuit"), 1).setIconIndex(4).setItemName("moonChest"));
	public static Item MoonPants = (new ItemMoonArmor(702, EnumArmorMaterial.IRON, ModLoader.addArmor("moonSuit"), 2).setIconIndex(5).setItemName("moonPants"));
	public static Item MoonBoots = (new ItemMoonArmor(703, EnumArmorMaterial.IRON, ModLoader.addArmor("moonSuit"), 3).setIconIndex(6).setItemName("moonBoots"));

	@SidedProxy(clientSide = "net.jlndk.Moonmod.ClientProxyMoon", serverSide = "net.jlndk.Moonmod.CommonProxyMoon")
    public static CommonProxyMoon proxy;



	//Biome Declaring
	public static BiomeGenBase moon = new BiomeGenMoon(14).setBiomeName("Moon").setDisableRain().setTemperatureRainfall(2.0F, 0.0F);
	

	@PreInit
	public void preload (FMLPreInitializationEvent event){
		MinecraftForgeClient.preloadTexture("/jlndk/moonmod/Blocks.png");
		MinecraftForgeClient.preloadTexture("/jlndk/moonmod/Items.png");
	}
	//Declaring Init
	@Init
	public void load(FMLInitializationEvent event){
		  {
			//Dimension
			DimensionManager.registerProviderType(37, WorldProviderMoon.class, true);
			DimensionManager.registerDimension(37, 37);
			//Proxy
			  proxy.init();
		  }	
	//Registering 
	 //Block
		GameRegistry.registerBlock(CheeseBlock);
		GameRegistry.registerBlock(AluBlock);
		GameRegistry.registerBlock(AluOre);
		GameRegistry.registerBlock(MoonPortal);
		GameRegistry.registerBlock(MoonStone);
		GameRegistry.registerBlock(MoonCobblestone);
		GameRegistry.registerBlock(IgniteBlock);
		GameRegistry.registerBlock(ReinfCloth);
		GameRegistry.registerBlock(MoonTent);
		GameRegistry.registerBlock(MoonLampActive);
		GameRegistry.registerBlock(MoonLampIdle);

	//Generators
		GameRegistry.registerWorldGenerator(new Moongenerator());
	
	//Fuel handler
		GameRegistry.registerFuelHandler(new MoonFuelHandler());
	//Adding ItemName 
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
			LanguageRegistry.addName(MoonLampActive, "Moon Lamp");
		//Items
			LanguageRegistry.addName(SonicScrew, "Sonic Screwdriver");
			LanguageRegistry.addName(MoonHelmet, "Moon Helmet");
			LanguageRegistry.addName(MoonChest, "Moon Chestplate");
			LanguageRegistry.addName(MoonPants, "Moon Leggings");
			LanguageRegistry.addName(MoonBoots, "Moon Boots");
			LanguageRegistry.addName(CheeseSlice, "Cheese Slice");
			LanguageRegistry.addName(Battery, "Battery");
		//Mobs
			ModLoader.addLocalization("entity.Alien.name", "Alien");
		
	//Recipes
		//crafting
		GameRegistry.addRecipe(new ItemStack(Moonmod.CheeseBlock, 2), new Object[] {"###", "###", "###", '#', Item.bucketMilk});
		GameRegistry.addRecipe(new ItemStack(Moonmod.AluBlock, 2), new Object[] {"###", "###", "###", '#', Moonmod.AluIngot});
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
		GameRegistry.addSmelting(Moonmod.AluOre.blockID, new ItemStack(Moonmod.AluIngot), 0.8F);
		GameRegistry.addSmelting(Moonmod.MoonCobblestone.blockID, new ItemStack(Moonmod.MoonStone), 0.8F);
	}

		public static String getDimensionName() {
			return "The Moon";
		}
	}