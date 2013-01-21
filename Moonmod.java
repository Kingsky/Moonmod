package net.jlndk.Moonmod;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.jlndk.Moonmod.blocks.*;
import net.jlndk.Moonmod.items.*;
import net.jlndk.Moonmod.mobs.EntityAlien;
import net.jlndk.Moonmod.world.BiomeGenMoon;
import net.jlndk.Moonmod.world.MoonFuelHandler;
import net.jlndk.Moonmod.world.Moongenerator;
import net.jlndk.Moonmod.world.WorldProviderMoon;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.EnumHelper;

@Mod(modid = "Moon", name = "Moon", version = "0.0.5")
@NetworkMod(versionBounds = "[0.0.5]", clientSideRequired = true, serverSideRequired = false)

public class Moonmod
{
    //Textures
    public static String textureFile = "/jlndk/moonmod/Blocks.png";

    //Creative Tab
	public static CreativeTabs tabMoon = new TabMoon(CreativeTabs.getNextID(),"Moon");
	
    //Armor
    public static Item MoonHelmet;
    public static Item MoonBody;
    public static Item MoonLegs;
    public static Item MoonBoots;

    //Armor Id's
    public static int idMoonHelmet;
    public static int idMoonBody;
    public static int idMoonLegs;
    public static int idMoonBoots;
    
    //Item's
    public static Item AluIngot;
	public static Item SonicScrew;
	public static Item CheeseSlice;
	public static Item Battery;
	
    //Item Id's
	public static int idAluIngot;
	public static int idSonicScrew;
	public static int idCheeseSlice;
	public static int idBattery;
	
    //Block's
    public static Block CheeseBlock;
	public static Block AluBlock;
	public static Block AluOre;
	public static Block MoonPortal;
    public static Block MoonStone;
    public static Block MoonCobblestone;
    public static Block ReinfCloth;
    public static Block MoonTent;
    public static Block MoonLampIdle;
    public static Block MoonLampActive;
    

    //Block Id's
    public static int idCheeseBlock;
	public static int idAluBlock;
	public static int idAluOre;
	public static int idMoonPortal;
    public static int idReinfCloth;
    public static int idMoonTent;
    public static int idMoonLampIdle;
    public static int idMoonLampActive;
    
    //Biomes
    public static BiomeGenBase biomemoon;
	

    @SidedProxy(clientSide = "net.jlndk.Moonmod.client.ClientProxyMoon", serverSide = "net.jlndk.Moonmod.CommonProxyMoon")
    public static CommonProxyMoon proxy;

    @Instance
    public static Moonmod instance;

    @PreInit
    public void preInit(FMLPreInitializationEvent event)
    {
        event.getModMetadata().version = "1.4.7";
        Configuration config = new Configuration(event.getSuggestedConfigurationFile());
        config.load();
        	//Armor
            idMoonHelmet = Integer.parseInt(config.getItem("idMoonHelmet", 4007).value);
            idMoonBody   = Integer.parseInt(config.getItem("idMoonBody", 4008).value);
            idMoonLegs   = Integer.parseInt(config.getItem("idMoonLegs", 4009).value);
            idMoonBoots  = Integer.parseInt(config.getItem("idMoonBoots", 4010).value);
            //Items
            idAluIngot = Integer.parseInt(config.getItem("idAluIngot", 550).value);
        	idSonicScrew = Integer.parseInt(config.getItem("idSonicScrew", 551).value);
        	idCheeseSlice = Integer.parseInt(config.getItem("idCheeseSlice", 552).value);
        	idBattery = Integer.parseInt(config.getItem("idBattery", 553).value);
            //Blocks
            idCheeseBlock = Integer.parseInt(config.getBlock("idCheeseBlock", 455).value);
        	idAluBlock = Integer.parseInt(config.getBlock("idAluBlock", 456).value);
        	idAluOre = Integer.parseInt(config.getBlock("idAluOre", 457).value);
        	idMoonPortal = Integer.parseInt(config.getBlock("idMoonPortal", 458).value);
            idReinfCloth = Integer.parseInt(config.getBlock("idReinfCloth", 459).value);
            idMoonTent = Integer.parseInt(config.getBlock("idMoonTent", 460).value);
            idMoonLampIdle = Integer.parseInt(config.getBlock("idMoonLampIdle", 461).value);
            idMoonLampActive = Integer.parseInt(config.getBlock("idMoonLampActive", 462).value);
        config.save();
    }

    @Init
    public void load(FMLInitializationEvent event)
    {
        proxy.registerRenderInformation();
        registerBlocks();
        registerItems();
        registerArmor();
        registerRecipes();
        registerDimension();
        registerMobs();
        
    }

    private void registerBlocks()
    {
    	CheeseBlock = new BlockCheese(idCheeseBlock, 1).setBlockName("CheeseBlock").setHardness(1F).setResistance(5F);;
    	AluBlock = new BlockAluBlock(idAluBlock, 2).setBlockName("AluBlock").setHardness(1F).setResistance(5F);
    	AluOre = new BlockAluBlock(idAluOre, 3).setBlockName("AluOre").setHardness(1F).setResistance(5F);
    	MoonPortal = new BlockMoonPortal(idMoonPortal, 205).setStepSound(Block.soundGlassFootstep).setHardness(0.5F).setResistance(1F).setBlockName("MoonPortal");
        MoonStone = new BlockMoonStone(146, 6).setBlockName("MoonStone").setHardness(1F).setResistance(5F);
        MoonCobblestone = new BlockMoonCobblestone(147, 6).setBlockName("MoonCobblestone").setHardness(1F).setResistance(5F);
        ReinfCloth = new BlockReinforgedCloth(idReinfCloth, 4).setBlockName("ReinfCloth").setHardness(1F).setResistance(2F);
        MoonTent = new BlockMoonTent(idMoonTent, 7).setBlockName("MoonTent").setHardness(1F).setResistance(10F);
        MoonLampIdle = (new BlockMoonLamp(idMoonLampIdle, false, 5)).setHardness(0.3F).setStepSound(Block.soundMetalFootstep).setBlockName("MoonLampIdle");
        MoonLampActive = (new BlockMoonLamp(idMoonLampActive, true, 5)).setHardness(0.3F).setStepSound(Block.soundMetalFootstep).setBlockName("MoonLampActive").setCreativeTab(Moonmod.tabMoon).setLightValue(1.0F);
        
        //Register
    	GameRegistry.registerBlock(CheeseBlock, "Cheese Block");
		GameRegistry.registerBlock(AluBlock, "Alu Block");
		GameRegistry.registerBlock(AluOre, "Alu Ore");
		GameRegistry.registerBlock(MoonPortal, "Moon Portal");
		GameRegistry.registerBlock(MoonStone, "Moon Stone");
		GameRegistry.registerBlock(MoonCobblestone, "Moon Cobblestone");
		GameRegistry.registerBlock(ReinfCloth, "Reinf Cloth");
		GameRegistry.registerBlock(MoonTent, "Moon Tent");
		GameRegistry.registerBlock(MoonLampActive, "Moon Lamp Active");
		GameRegistry.registerBlock(MoonLampIdle, "Moon Lamp Idle");
		
		//Names
		LanguageRegistry.addName(CheeseBlock, "Block of Cheese");
		LanguageRegistry.addName(AluBlock, "Aluminium Block");
		LanguageRegistry.addName(AluOre, "Aluminium Ore");
		LanguageRegistry.addName(MoonStone, "Moon Stone");
		LanguageRegistry.addName(MoonCobblestone, "Moon Cobblestone");
		LanguageRegistry.addName(MoonPortal, "Moon Portal Block");
		LanguageRegistry.addName(ReinfCloth, "Reinforged Cloth");
		LanguageRegistry.addName(MoonTent, "Moon Tent");
		LanguageRegistry.addName(MoonLampActive, "Moon Lamp");
    }

    private void registerItems()
    {
    	AluIngot = new ItemAluIngot(idAluIngot).setIconIndex(1).setItemName("AluIngot");
    	SonicScrew = new ItemSonicScrew(idSonicScrew).setIconIndex(2).setItemName("SonicScrew");
    	CheeseSlice = new ItemCheeseSlice (idCheeseSlice, 8, true).setIconIndex(7).setItemName("CheeseSlice");
    	Battery = new ItemBattery(idBattery).setIconIndex(1).setItemName("Battery");
    	
    	//Names
    	LanguageRegistry.addName(AluIngot, "Alumenium Ingot");
    	LanguageRegistry.addName(SonicScrew, "Sonic Screwdriver");
		LanguageRegistry.addName(CheeseSlice, "Cheese Slice");
		LanguageRegistry.addName(Battery, "Battery");
    }

    private void registerArmor()
    {
        EnumArmorMaterial armorMoon = EnumHelper.addArmorMaterial("MoonArmor", 100, new int[] {0, 0, 0, 0}, 0); //Whatever you added to EnumArmorMaterial.java goes here
        int rendererMoon = proxy.addArmor("MoonArmor");
        MoonHelmet = new ItemMoonArmor(idMoonHelmet, armorMoon, rendererMoon, 0).setItemName("armorMoonHelmet").setIconIndex(15);;
        MoonBody   = new ItemMoonArmor(idMoonBody,   armorMoon, rendererMoon, 1).setItemName("armorMoonBody").setIconIndex(14);;
        MoonLegs   = new ItemMoonArmor(idMoonLegs,   armorMoon, rendererMoon, 2).setItemName("armorMoonLegs").setIconIndex(12);;
        MoonBoots  = new ItemMoonArmor(idMoonBoots,  armorMoon, rendererMoon, 3).setItemName("armorMoonBoots").setIconIndex(13);;

        //Names
        LanguageRegistry.addName(MoonHelmet, "Moon Helmet");
        LanguageRegistry.addName(MoonBody, "Moon Chestplate");
        LanguageRegistry.addName(MoonLegs, "Moon Leggings");
        LanguageRegistry.addName(MoonBoots, "Moon Boots");
    }

    private void registerRecipes()
    {
  			//crafting
    			GameRegistry.addRecipe(new ItemStack(Moonmod.CheeseBlock, 2), new Object[] {"###", "###", "###", '#', Item.bucketMilk});
    			GameRegistry.addRecipe(new ItemStack(Moonmod.AluBlock, 2), new Object[] {"###", "###", "###", '#', Moonmod.AluIngot});
    			GameRegistry.addRecipe(new ItemStack(ReinfCloth, 1), new Object[] {"AAA", "ABA", "AAA", 'A', Block.cloth, 'B', Item.ingotGold});
    			GameRegistry.addRecipe(new ItemStack(SonicScrew, 1), new Object[] { "  R"," I ", "I  ", Character.valueOf('R'), Item.redstone,Character.valueOf('I'), Item.ingotIron });
    			GameRegistry.addRecipe(new ItemStack(SonicScrew, 1),new Object[] { "   ", " S ", " R ", Character.valueOf('R'),Item.redstone, Character.valueOf('S'),new ItemStack(SonicScrew, 1, ItemSonicScrew.screwUses) });
    			GameRegistry.addRecipe(new ItemStack(SonicScrew, 1),new Object[] { "   ", " OO", " OO", Character.valueOf('O'), CheeseSlice});
    			GameRegistry.addShapelessRecipe(new ItemStack(CheeseSlice, 4), new Object[] {CheeseBlock});
    			GameRegistry.addRecipe(new ItemStack(MoonTent, 1), new Object [] {" # ", "#G#", Character.valueOf('#'), ReinfCloth, Character.valueOf('G'), Block.glass});
    				//armor
    			GameRegistry.addRecipe(new ItemStack(MoonHelmet, 1), new Object [] {"###", "#G#", Character.valueOf('#'), ReinfCloth, Character.valueOf('G'), Block.glass});
    			GameRegistry.addRecipe(new ItemStack(MoonBody, 1), new Object [] {"# #", "###", "#A#", Character.valueOf('#'), ReinfCloth, Character.valueOf('A'), AluIngot});
    			GameRegistry.addRecipe(new ItemStack(MoonLegs, 1), new Object [] {"#A#", "# #", "A A", Character.valueOf('#'), ReinfCloth, Character.valueOf('A'), AluIngot});
    			GameRegistry.addRecipe(new ItemStack(MoonBoots, 1), new Object [] {"A A", "# #", Character.valueOf('#'), ReinfCloth, Character.valueOf('A'), AluIngot});
    			//smelting
    			GameRegistry.addSmelting(Moonmod.AluOre.blockID, new ItemStack(Moonmod.AluIngot), 0.8F);
    			GameRegistry.addSmelting(Moonmod.MoonCobblestone.blockID, new ItemStack(Moonmod.MoonStone), 0.8F);
    		}
    
    private void registerDimension()
    {
    	//Dimension Registering
    	DimensionManager.registerProviderType(37, WorldProviderMoon.class, true);
		DimensionManager.registerDimension(37, 37);
		
		//Biomes
		biomemoon = new BiomeGenMoon(14).setBiomeName("Moon").setDisableRain().setTemperatureRainfall(2.0F, 0.0F);
		
		//Generators
		GameRegistry.registerWorldGenerator(new Moongenerator());
	
		//Fuel handler
		GameRegistry.registerFuelHandler(new MoonFuelHandler());
    }
    
    private void registerMobs()
    {
    	EntityRegistry.registerGlobalEntityID(EntityAlien.class, "Alien", EntityRegistry.findGlobalUniqueEntityId(), 124679, 126458);
    }
    
    public static String getDimensionName() {
		return "The Moon";
	}
}