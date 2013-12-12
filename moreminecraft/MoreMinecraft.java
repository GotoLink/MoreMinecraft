package moreminecraft;

import java.lang.reflect.Field;

import moreminecraft.blocks.*;
import moreminecraft.entities.*;
import moreminecraft.generators.WorldGeneratorMoreMinecraft;
import moreminecraft.items.*;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemReed;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.EnumHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid = MoreMinecraft.modID, name = "More Minecraft!", version = "alpha")
@NetworkMod(clientSideRequired = true)
public class MoreMinecraft {
	@SidedProxy(clientSide = "moreminecraft.ClientProxy", serverSide = "moreminecraft.CommonProxy")
	public static CommonProxy proxy;
	public static final String modID = "moreminecraft";
	public static CreativeTabs tabMisc = new CreativeTabs("tabMoreMinecraftMisc") {
		@Override
		@SideOnly(Side.CLIENT)
		public int getTabIconItemIndex() {
			return beeHive.blockID;
		}
	};
	public static CreativeTabs tabTools = new CreativeTabs("tabMoreMinecraftTools") {
		@Override
		@SideOnly(Side.CLIENT)
		public int getTabIconItemIndex() {
			return MultitoolRuby.itemID;
		}
	};
	public static Block ores;
	public static Block storage;
	public static Block oreDimensional;
	public static Block beeHive;
	public static Block turnipCrop;
	public static Block cornCrop;
	public static Block chocolateCake;
	public static Block ironTrapDoor;
	public static Item materials;
	public static Item foods;
	public static Item helmetEmerald;
	public static Item plateEmerald;
	public static Item legsEmerald;
	public static Item bootsEmerald;
	public static Item helmetObsidian;
	public static Item plateObsidian;
	public static Item legsObsidian;
	public static Item bootsObsidian;
	public static Item helmetStone;
	public static Item plateStone;
	public static Item legsStone;
	public static Item bootsStone;
	public static Item helmetWood;
	public static Item plateWood;
	public static Item legsWood;
	public static Item bootsWood;
	public static Item pickaxeEmerald;
	public static Item axeEmerald;
	public static Item hoeEmerald;
	public static Item shovelEmerald;
	public static Item swordEmerald;
	public static Item pickaxeObsidian;
	public static Item axeObsidian;
	public static Item hoeObsidian;
	public static Item shovelObsidian;
	public static Item swordObsidian;
	public static Item helmetRuby;
	public static Item plateRuby;
	public static Item legsRuby;
	public static Item bootsRuby;
	public static Item helmetYellowSaph;
	public static Item plateYellowSaph;
	public static Item legsYellowSaph;
	public static Item bootsYellowSaph;
	public static Item helmetBlueSaph;
	public static Item plateBlueSaph;
	public static Item legsBlueSaph;
	public static Item bootsBlueSaph;
	public static Item helmetGreenSaph;
	public static Item plateGreenSaph;
	public static Item legsGreenSaph;
	public static Item bootsGreenSaph;
	public static Item pickaxeRuby;
	public static Item axeRuby;
	public static Item hoeRuby;
	public static Item shovelRuby;
	public static Item swordRuby;
	public static Item pickaxeYellowSaph;
	public static Item axeYellowSaph;
	public static Item hoeYellowSaph;
	public static Item shovelYellowSaph;
	public static Item swordYellowSaph;
	public static Item pickaxeBlueSaph;
	public static Item axeBlueSaph;
	public static Item hoeBlueSaph;
	public static Item shovelBlueSaph;
	public static Item swordBlueSaph;
	public static Item pickaxeGreenSaph;
	public static Item axeGreenSaph;
	public static Item hoeGreenSaph;
	public static Item shovelGreenSaph;
	public static Item swordGreenSaph;
	public static Item MultitoolWood;
	public static Item MultitoolStone;
	public static Item MultitoolIron;
	public static Item MultitoolGold;
	public static Item MultitoolDiamond;
	public static Item MultitoolEmerald;
	public static Item MultitoolObsidian;
	public static Item MultitoolRuby;
	public static Item MultitoolGreenSaph;
	public static Item MultitoolBlueSaph;
	public static Item MultitoolYellowSaph;
	public static Item MultitoolSteel;
	public static Item MultitoolTitanium;
	public static Item pickaxeSteel;
	public static Item axeSteel;
	public static Item hoeSteel;
	public static Item shovelSteel;
	public static Item swordSteel;
	public static Item pickaxeTitanium;
	public static Item axeTitanium;
	public static Item hoeTitanium;
	public static Item shovelTitanium;
	public static Item swordTitanium;
	public static Item helmetSteel;
	public static Item plateSteel;
	public static Item legsSteel;
	public static Item bootsSteel;
	public static Item helmetTitanium;
	public static Item plateTitanium;
	public static Item legsTitanium;
	public static Item bootsTitanium;
	public static Item helmetGogglesVision;
	public static Item turnip;
	public static Item corn;
	public static Item helmetEnd;
	public static Item plateEnd;
	public static Item legsEnd;
	public static Item bootsEnd;
	public static Item pickaxeEnd;
	public static Item axeEnd;
	public static Item shovelEnd;
	public static Item hoeEnd;
	public static Item swordEnd;
	public static Item MultitoolEnd;
	public static Item helmetWoodBirch;
	public static Item plateWoodBirch;
	public static Item legsWoodBirch;
	public static Item bootsWoodBirch;
	public static Item helmetWoodJungle;
	public static Item plateWoodJungle;
	public static Item legsWoodJungle;
	public static Item bootsWoodJungle;
	public static Item helmetWoodSpruce;
	public static Item plateWoodSpruce;
	public static Item legsWoodSpruce;
	public static Item bootsWoodSpruce;
	public static Item plateDualHearts;
	public static Item enderStaff;
	public static Item diamondEnderpearl;
	public static Item pickaxeQuartz;
	public static Item axeQuartz;
	public static Item hoeQuartz;
	public static Item shovelQuartz;
	public static Item swordQuartz;
	public static Item helmetQuartz;
	public static Item plateQuartz;
	public static Item legsQuartz;
	public static Item bootsQuartz;
	public static Item MultitoolQuartz;
	public static Item potatoLauncher;
	public static Item pickaxeCopper;
	public static Item axeCopper;
	public static Item hoeCopper;
	public static Item shovelCopper;
	public static Item swordCopper;
	public static Item MultitoolCopper;
	public static Item helmetCopper;
	public static Item plateCopper;
	public static Item legsCopper;
	public static Item bootsCopper;
	public static Item pickaxeTin;
	public static Item axeTin;
	public static Item hoeTin;
	public static Item shovelTin;
	public static Item swordTin;
	public static Item MultitoolTin;
	public static Item helmetTin;
	public static Item plateTin;
	public static Item legsTin;
	public static Item bootsTin;
	public static Item pickaxeBronze;
	public static Item axeBronze;
	public static Item hoeBronze;
	public static Item shovelBronze;
	public static Item swordBronze;
	public static Item MultitoolBronze;
	public static Item helmetBronze;
	public static Item plateBronze;
	public static Item legsBronze;
	public static Item bootsBronze;
	public static Item scubaHelmet;
	public static Item jumpBoots;
	public static Item unattunedLauncher;
	public static Item arrowLauncher;
	public static Item legsSwiftness;
	public static Item itemChocolateCake;
	public static Item battleaxeWood;
	public static Item battleaxeStone;
	public static Item battleaxeIron;
	public static Item battleaxeGold;
	public static Item battleaxeDiamond;
	public static Item battleaxeEmerald;
	public static Item battleaxeObsidian;
	public static Item battleaxeRuby;
	public static Item battleaxeBlueSaph;
	public static Item battleaxeGreenSaph;
	public static Item battleaxeYellowSaph;
	public static Item battleaxeSteel;
	public static Item battleaxeTitanium;
	public static Item battleaxeEnd;
	public static Item battleaxeQuartz;
	public static Item battleaxeCopper;
	public static Item battleaxeTin;
	public static Item battleaxeBronze;
	public static Item knifeWood;
	public static Item knifeStone;
	public static Item knifeIron;
	public static Item knifeGold;
	public static Item knifeDiamond;
	public static Item knifeEmerald;
	public static Item knifeObsidian;
	public static Item knifeRuby;
	public static Item knifeBlueSaph;
	public static Item knifeGreenSaph;
	public static Item knifeYellowSaph;
	public static Item knifeSteel;
	public static Item knifeTitanium;
	public static Item knifeEnd;
	public static Item knifeQuartz;
	public static Item knifeCopper;
	public static Item knifeTin;
	public static Item knifeBronze;
	private static int blockBaseID = 3000;
	private static int itemBaseID = 22222;
	// CLOTH(5, new int[]{1, 3, 2, 1}, 15),
	// CHAIN(15, new int[]{2, 5, 4, 1}, 12),
	// IRON(15, new int[]{2, 6, 5, 2}, 9),
	// GOLD(7, new int[]{2, 5, 3, 1}, 25),
	// DIAMOND(33, new int[]{3, 8, 6, 3}, 10);
	public static EnumArmorMaterial armorEmerald = EnumHelper.addArmorMaterial("EMERALD", 35, new int[] { 3, 10, 7, 4 }, 20);
	public static EnumArmorMaterial armorObsidian = EnumHelper.addArmorMaterial("OBSIDIAN", 39, new int[] { 5, 13, 10, 6 }, 3);
	public static EnumArmorMaterial armorStone = EnumHelper.addArmorMaterial("STONE", 9, new int[] { 2, 5, 4, 2 }, 4);
	public static EnumArmorMaterial armorWood = EnumHelper.addArmorMaterial("WOOD", 5, new int[] { 1, 2, 2, 1 }, 8);
	public static EnumArmorMaterial armorCrystal = EnumHelper.addArmorMaterial("CRYSTAL", 25, new int[] { 2, 6, 5, 2 }, 8);
	public static EnumArmorMaterial armorSteel = EnumHelper.addArmorMaterial("STEEL", 27, new int[] { 3, 7, 3, 2 }, 7);
	public static EnumArmorMaterial armorTitanium = EnumHelper.addArmorMaterial("TITANIUM", 15, new int[] { 2, 6, 5, 2 }, 17);
	public static EnumArmorMaterial armorInfinite = EnumHelper.addArmorMaterial("INFINITE", -10000, new int[] { -10000, -10000, -10000, -10000 }, -10000);
	public static EnumArmorMaterial armorEnd = EnumHelper.addArmorMaterial("END", 78, new int[] { 10, 26, 20, 12 }, 10);
	public static EnumArmorMaterial armorQuartz = EnumHelper.addArmorMaterial("QUARTZ", 25, new int[] { 2, 6, 5, 2 }, 22);
	public static EnumArmorMaterial armorMetal = EnumHelper.addArmorMaterial("METAL", 13, new int[] { 2, 5, 4, 2 }, 8);
	public static EnumArmorMaterial armorBronze = EnumHelper.addArmorMaterial("BRONZE", 17, new int[] { 3, 6, 4, 2 }, 8);
	//	STONE(1, 131, 4.0F, 1, 5),
	//	IRON(2, 250, 6.0F, 2, 14),
	//	EMERALD(3, 1561, 8.0F, 3, 10),
	//	GOLD(0, 32, 12.0F, 0, 22);
	public static EnumToolMaterial toolEmerald = EnumHelper.addToolMaterial("EMERALD_GEM", 3, 2341, 10.0F, 4, 18);
	public static EnumToolMaterial toolObsidian = EnumHelper.addToolMaterial("OBSIDIAN", 3, 3122, 12.5F, 8, 18);
	public static EnumToolMaterial toolCrystal = EnumHelper.addToolMaterial("CRYSTAL", 2, 780, 6.0F, 2, 14);
	public static EnumToolMaterial toolSteel = EnumHelper.addToolMaterial("STEEL", 3, 1170, 6.9F, 3, 17);
	public static EnumToolMaterial toolTitanium = EnumHelper.addToolMaterial("TITANIUM", 2, 250, 6.0F, 2, 18);
	public static EnumToolMaterial toolEnd = EnumHelper.addToolMaterial("END", 3, 6244, 14F, 16, 19);
	public static EnumToolMaterial toolQuartz = EnumHelper.addToolMaterial("QUARTZ", 2, 780, 6.0F, 2, 19);
	public static EnumToolMaterial toolMetal = EnumHelper.addToolMaterial("METAL", 2, 225, 5.5F, 2, 14);
	public static EnumToolMaterial toolBronze = EnumHelper.addToolMaterial("BRONZE", 2, 650, 6.5F, 2, 15);

	public void entity() {
		EntityRegistry.registerModEntity(EntityDiamondEnderpearl.class, "Diamond_EnderPearl", 0, this, 8, 1, true);
		EntityRegistry.registerModEntity(EntityPotatoLaunched.class, "PotatoThrown", 1, this, 8, 1, true);
		EntityRegistry.registerModEntity(EntityBakedPotatoLaunched.class, "PotatoThrownBaked", 2, this, 8, 1, true);
		EntityRegistry.registerModEntity(EntityPoisonPotatoLaunched.class, "PotatoThrownPoison", 3, this, 8, 1, true);
	}

	@EventHandler
	public void Initialization(FMLInitializationEvent event) {
		proxy.registerRenders();
	}

	@EventHandler
	public void PreInitialization(FMLPreInitializationEvent event) {
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		items(config);
		sets(config);
		config.save();
		register();
		crafting();
		entity();
		GameRegistry.registerWorldGenerator(new WorldGeneratorMoreMinecraft());
	}

	private void createArmorSet(Configuration config, String field, EnumArmorMaterial par1Enum, String layer, String name, Object madeOf, int madeOfMeta) {
		Item hpar1 = new ItemArmorMod(ConfigItem(config, name + " Helmet"), par1Enum, 0, layer).setUnlocalizedName("helmet" + layer).setTextureName(modID + ":armors/helmet" + layer);
		Item cpar1 = new ItemArmorMod(ConfigItem(config, name + " Chestplate"), par1Enum, 1, layer).setUnlocalizedName("chestplate" + layer).setTextureName(modID + ":armors/chestplate" + layer);
		Item lpar1 = new ItemArmorMod(ConfigItem(config, name + " Leggings"), par1Enum, 2, layer).setUnlocalizedName("leggings" + layer).setTextureName(modID + ":armors/leggings" + layer);
		Item bpar1 = new ItemArmorMod(ConfigItem(config, name + " Boots"), par1Enum, 3, layer).setUnlocalizedName("boots" + layer).setTextureName(modID + ":armors/boots" + layer);
		int made = -1;
		if (madeOf instanceof Block) {
			made = ((Block) madeOf).blockID;
		} else if (madeOf instanceof Item) {
			made = ((Item) madeOf).itemID;
		}
		if (made > 0) {
			GameRegistry.addRecipe(new ItemStack(hpar1), "XXX", "X X", 'X', new ItemStack(made, 1, madeOfMeta));
			GameRegistry.addRecipe(new ItemStack(cpar1), "X X", "XXX", "XXX", 'X', new ItemStack(made, 1, madeOfMeta));
			GameRegistry.addRecipe(new ItemStack(lpar1), "XXX", "X X", "X X", 'X', new ItemStack(made, 1, madeOfMeta));
			GameRegistry.addRecipe(new ItemStack(bpar1), "X X", "X X", 'X', new ItemStack(made, 1, madeOfMeta));
		}
		try {
			this.getClass().getField("helmet" + field).set(this, hpar1);
			this.getClass().getField("plate" + field).set(this, cpar1);
			this.getClass().getField("legs" + field).set(this, lpar1);
			this.getClass().getField("boots" + field).set(this, bpar1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void createToolSet(Configuration config, String field, EnumToolMaterial par1Enum, String material, String name, Object madeOf, int madeOfMeta) {
		Item pick = new ItemPickaxe(ConfigItem(config, name + " Pickaxe"), par1Enum).setUnlocalizedName("pickaxe" + material).setCreativeTab(tabTools)
				.setTextureName(modID + ":tools/pickaxe" + material);
		Item axe = new ItemAxe(ConfigItem(config, name + " Axe"), par1Enum).setUnlocalizedName("axe" + material).setCreativeTab(tabTools).setTextureName(modID + ":tools/axe" + material);
		Item shovel = new ItemSpade(ConfigItem(config, name + " Shovel"), par1Enum).setUnlocalizedName("shovel" + material).setCreativeTab(tabTools).setTextureName(modID + ":tools/shovel" + material);
		Item hoe = new ItemHoe(ConfigItem(config, name + " Hoe"), par1Enum).setUnlocalizedName("hoe" + material).setCreativeTab(tabTools).setTextureName(modID + ":tools/hoe" + material);
		Item sword = new ItemSword(ConfigItem(config, name + " Sword"), par1Enum).setUnlocalizedName("sword" + material).setCreativeTab(tabTools).setTextureName(modID + ":tools/sword" + material);
		Item multitool = new ItemMultitoolMod(ConfigItem(config, name + " Multitool"), par1Enum).setUnlocalizedName("paxle" + material).setTextureName(modID + ":tools/paxle" + material);
		Item BAxe = new ItemBattleAxeMod(ConfigItem(config, name + " Battleaxe"), par1Enum).setUnlocalizedName("battleaxe" + material).setTextureName(modID + ":tools/battleaxe" + material);
		Item knife = new ItemKnifeMod(ConfigItem(config, name + " Knife"), par1Enum).setUnlocalizedName("knife" + material).setTextureName(modID + ":tools/knife" + material);
		int made = -1;
		if (madeOf instanceof Block) {
			made = ((Block) madeOf).blockID;
		} else if (madeOf instanceof Item) {
			made = ((Item) madeOf).itemID;
		}
		if (made > 0) {
			GameRegistry.addRecipe(new ItemStack(pick), "XXX", " C ", " C ", 'X', new ItemStack(made, 1, madeOfMeta), 'C', Item.stick);
			GameRegistry.addRecipe(new ItemStack(axe), "XX ", "XC ", " C ", 'X', new ItemStack(made, 1, madeOfMeta), 'C', Item.stick);
			GameRegistry.addRecipe(new ItemStack(hoe), "XX ", " C ", " C ", 'X', new ItemStack(made, 1, madeOfMeta), 'C', Item.stick);
			GameRegistry.addRecipe(new ItemStack(shovel), " X ", " C ", " C ", 'X', new ItemStack(made, 1, madeOfMeta), 'C', Item.stick);
			GameRegistry.addRecipe(new ItemStack(sword), " X ", " X ", " C ", 'X', new ItemStack(made, 1, madeOfMeta), 'C', Item.stick);
			GameRegistry.addRecipe(new ItemStack(multitool), "ABC", " D ", " D ", 'A', axe, 'B', shovel, 'C', pick, 'D', Item.stick);
			GameRegistry.addRecipe(new ItemStack(BAxe), "XXX", "XCX", " C ", 'X', new ItemStack(made, 1, madeOfMeta), 'C', Item.stick);
			GameRegistry.addRecipe(new ItemStack(knife), " X ", " C ", 'X', new ItemStack(made, 1, madeOfMeta), 'C', Item.stick);
		}
		try {
			this.getClass().getField("pickaxe" + field).set(this, pick);
			this.getClass().getField("axe" + field).set(this, axe);
			this.getClass().getField("shovel" + field).set(this, shovel);
			this.getClass().getField("hoe" + field).set(this, hoe);
			this.getClass().getField("sword" + field).set(this, sword);
			this.getClass().getField("Multitool" + field).set(this, multitool);
			this.getClass().getField("battleaxe" + field).set(this, BAxe);
			this.getClass().getField("knife" + field).set(this, knife);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void register() {
		for (Field f : this.getClass().getFields()) {
			Object obj = null;
			try {
				obj = f.get(this);
				if (obj == null) {
					System.out.println(f + " field is null");
					continue;
				}
			} catch (IllegalArgumentException e) {
			} catch (IllegalAccessException e) {
			}
			if (obj instanceof Block) {
				if (Item.itemsList[((Block) obj).blockID] == null)
					GameRegistry.registerBlock((Block) obj, ((Block) obj).getUnlocalizedName());
			} else if (obj instanceof Item) {
				GameRegistry.registerItem((Item) obj, ((Item) obj).getUnlocalizedName());
			}
		}
	}

	private void sets(Configuration config) {
		createArmorSet(config, "Emerald", armorEmerald, "emerald", "Emerald", Item.emerald, 0);
		createArmorSet(config, "Obsidian", armorObsidian, "obsidian", "Obsidian", materials, 2);
		createArmorSet(config, "Ruby", armorCrystal, "ruby", "Ruby", materials, 20);
		createArmorSet(config, "YellowSaph", armorCrystal, "saphY", "Yellow Sapphire", materials, 23);
		createArmorSet(config, "GreenSaph", armorCrystal, "saphG", "Green Sapphire", materials, 22);
		createArmorSet(config, "BlueSaph", armorCrystal, "saphB", "Blue Sapphire", materials, 21);
		createArmorSet(config, "Stone", armorStone, "stone", "Stone", Block.stone, 0);
		createArmorSet(config, "Wood", armorWood, "wood", "Wooden", Block.planks, 0);
		createArmorSet(config, "WoodJungle", armorWood, "wood_jungle", "Wooden", Block.planks, 3);
		createArmorSet(config, "WoodSpruce", armorWood, "wood_spruce", "Wooden", Block.planks, 1);
		createArmorSet(config, "WoodBirch", armorWood, "wood_birch", "Wooden", Block.planks, 2);
		createArmorSet(config, "Steel", armorSteel, "steel", "Steel", materials, 3);
		createArmorSet(config, "Titanium", armorTitanium, "titanium", "Titanium", materials, 4);
		createArmorSet(config, "End", armorEnd, "end", "Endium", materials, 24);
		createArmorSet(config, "Quartz", armorQuartz, "quarts", "Quartz", materials, 14);
		createArmorSet(config, "Copper", armorMetal, "copper", "Copper", materials, 17);
		createArmorSet(config, "Tin", armorMetal, "tin", "Tin", materials, 18);
		createArmorSet(config, "Bronze", armorBronze, "bronze", "Bronze", materials, 19);
		createToolSet(config, "Emerald", toolEmerald, "Emerald", "Emerald", Item.emerald, 0);
		createToolSet(config, "Obsidian", toolObsidian, "Obsidian", "Obsidian", materials, 2);
		createToolSet(config, "Ruby", toolCrystal, "RSaph", "Ruby", materials, 20);
		createToolSet(config, "YellowSaph", toolCrystal, "YSaph", "Yellow Sapphire", materials, 23);
		createToolSet(config, "BlueSaph", toolCrystal, "BSaph", "Blue Sapphire", materials, 21);
		createToolSet(config, "GreenSaph", toolCrystal, "GSaph", "Green Sapphire", materials, 22);
		createToolSet(config, "Steel", toolSteel, "Steel", "Steel", materials, 3);
		createToolSet(config, "Titanium", toolTitanium, "Titanium", "Titanium", materials, 4);
		createToolSet(config, "End", toolEnd, "End", "Endium", materials, 24);
		createToolSet(config, "Quartz", toolQuartz, "Quartz", "Quartz", materials, 14);
		createToolSet(config, "Copper", toolMetal, "Copper", "Copper", materials, 17);
		createToolSet(config, "Tin", toolMetal, "Tin", "Tin", materials, 18);
		createToolSet(config, "Bronze", toolBronze, "Bronze", "Bronze", materials, 19);
	}

	public static int ConfigBlock(Configuration config, String name) {
		int id = config.getBlock(name, blockBaseID).getInt();
		if (id == blockBaseID) {
			blockBaseID += 1;
		}
		return id;
	}

	public static int ConfigItem(Configuration config, String name) {
		int id = config.getItem(name, itemBaseID).getInt();
		if (id == itemBaseID) {
			itemBaseID += 1;
		}
		return id;
	}

	public static void crafting() {
		//MISC
		GameRegistry.addShapelessRecipe(new ItemStack(materials, 1, 1), Item.bucketMilk);
		GameRegistry.addShapelessRecipe(new ItemStack(foods), new ItemStack(materials, 1, 1), Item.bread);
		GameRegistry.addShapelessRecipe(new ItemStack(foods, 1, 1), materials, Item.bread);
		GameRegistry.addShapelessRecipe(new ItemStack(materials, 9, 24), oreDimensional);
		GameRegistry.addShapelessRecipe(new ItemStack(materials, 9, 20), storage);
		GameRegistry.addShapelessRecipe(new ItemStack(materials, 9, 22), new ItemStack(storage, 1, 2));
		GameRegistry.addShapelessRecipe(new ItemStack(materials, 9, 23), new ItemStack(storage, 1, 3));
		GameRegistry.addShapelessRecipe(new ItemStack(materials, 9, 21), new ItemStack(storage, 1, 1));
		GameRegistry.addShapelessRecipe(new ItemStack(materials, 4, 6), Item.ingotIron);
		GameRegistry.addShapelessRecipe(new ItemStack(materials, 8, 6), new ItemStack(materials, 1, 3));
		GameRegistry.addShapelessRecipe(new ItemStack(materials, 1, 10), new ItemStack(materials, 1, 24), new ItemStack(materials, 1, 2));
		GameRegistry.addRecipe(new ItemStack(materials, 1, 2), "XXX", "XXX", "XXX", 'X', Block.obsidian);
		GameRegistry.addRecipe(new ItemStack(storage, 1, 3), "XXX", "XXX", "XXX", 'X', new ItemStack(materials, 1, 23));
		GameRegistry.addRecipe(new ItemStack(storage, 1, 1), "XXX", "XXX", "XXX", 'X', new ItemStack(materials, 1, 21));
		GameRegistry.addRecipe(new ItemStack(storage, 1, 2), "XXX", "XXX", "XXX", 'X', new ItemStack(materials, 1, 22));
		GameRegistry.addRecipe(new ItemStack(storage), "XXX", "XXX", "XXX", 'X', new ItemStack(materials, 1, 20));
		GameRegistry.addRecipe(new ItemStack(oreDimensional), "XXX", "XXX", "XXX", 'X', new ItemStack(materials, 1, 24));
		GameRegistry.addRecipe(new ItemStack(storage, 1, 7), "XXX", "XXX", "XXX", 'X', new ItemStack(materials, 1, 14));
		GameRegistry.addRecipe(new ItemStack(storage, 1, 9), "XXX", "XXX", "XXX", 'X', new ItemStack(materials, 1, 18));
		GameRegistry.addRecipe(new ItemStack(storage, 1, 8), "XXX", "XXX", "XXX", 'X', new ItemStack(materials, 1, 17));
		GameRegistry.addRecipe(new ItemStack(storage, 1, 10), "XXX", "XXX", "XXX", 'X', new ItemStack(materials, 1, 19));
		GameRegistry.addShapelessRecipe(new ItemStack(materials, 9, 17), new ItemStack(storage, 1, 8));
		GameRegistry.addShapelessRecipe(new ItemStack(materials, 9, 18), new ItemStack(storage, 1, 9));
		GameRegistry.addShapelessRecipe(new ItemStack(materials, 9, 19), new ItemStack(storage, 1, 10));
		GameRegistry.addShapelessRecipe(new ItemStack(materials, 2, 19), new ItemStack(materials, 1, 18), new ItemStack(materials, 1, 17));
		GameRegistry.addRecipe(new ItemStack(storage, 1, 5), "XXX", "XXX", "XXX", 'X', new ItemStack(materials, 1, 4));
		GameRegistry.addRecipe(new ItemStack(storage, 1, 4), "XXX", "XXX", "XXX", 'X', new ItemStack(materials, 1, 3));
		GameRegistry.addRecipe(new ItemStack(storage, 1, 6), "XXX", "XXX", "XXX", 'X', new ItemStack(materials, 1, 5));
		GameRegistry.addShapelessRecipe(new ItemStack(materials, 9, 3), new ItemStack(storage, 1, 4));
		GameRegistry.addShapelessRecipe(new ItemStack(materials, 9, 4), new ItemStack(storage, 1, 5));
		GameRegistry.addShapelessRecipe(new ItemStack(materials, 9, 5), new ItemStack(storage, 1, 6));
		GameRegistry.addShapelessRecipe(new ItemStack(materials, 9, 14), new ItemStack(storage, 1, 7));
		GameRegistry.addShapelessRecipe(new ItemStack(foods, 1, 4), Item.bucketMilk, Item.sugar, Item.egg, Item.wheat);
		GameRegistry.addRecipe(new ItemStack(materials, 1, 5), " C ", "CXC", " C ", 'X', Item.ingotIron, 'C', Item.coal);
		//FURNACE
		FurnaceRecipes.smelting().addSmelting(materials.itemID, 5, new ItemStack(materials, 1, 3), 3.5F);
		FurnaceRecipes.smelting().addSmelting(turnip.itemID, new ItemStack(foods, 1, 3), 1.5F);
		FurnaceRecipes.smelting().addSmelting(oreDimensional.blockID, 2, new ItemStack(Item.ingotIron, 2), 3F);
		FurnaceRecipes.smelting().addSmelting(oreDimensional.blockID, 3, new ItemStack(Item.ingotIron, 4), 6F);
		FurnaceRecipes.smelting().addSmelting(oreDimensional.blockID, 4, new ItemStack(Item.ingotGold, 2), 3F);
		FurnaceRecipes.smelting().addSmelting(oreDimensional.blockID, 5, new ItemStack(Item.ingotGold, 4), 6F);
		FurnaceRecipes.smelting().addSmelting(oreDimensional.blockID, 6, new ItemStack(materials, 1, 4), 0.5F);
		FurnaceRecipes.smelting().addSmelting(oreDimensional.blockID, 7, new ItemStack(materials, 2, 4), 3F);
		FurnaceRecipes.smelting().addSmelting(oreDimensional.blockID, 8, new ItemStack(materials, 4, 4), 6F);
		FurnaceRecipes.smelting().addSmelting(oreDimensional.blockID, 9, new ItemStack(materials, 1, 17), 0.5F);
		FurnaceRecipes.smelting().addSmelting(oreDimensional.blockID, 10, new ItemStack(materials, 2, 17), 3F);
		FurnaceRecipes.smelting().addSmelting(oreDimensional.blockID, 11, new ItemStack(materials, 4, 17), 6F);
		FurnaceRecipes.smelting().addSmelting(oreDimensional.blockID, 12, new ItemStack(materials, 1, 18), 0.5F);
		FurnaceRecipes.smelting().addSmelting(oreDimensional.blockID, 13, new ItemStack(materials, 2, 18), 3F);
		FurnaceRecipes.smelting().addSmelting(oreDimensional.blockID, 14, new ItemStack(materials, 4, 18), 6F);
		//PAXLES
		GameRegistry.addRecipe(new ItemStack(MultitoolWood), "ABC", " # ", " # ", '#', new ItemStack(Item.stick), 'A', new ItemStack(Item.axeWood), 'B', new ItemStack(Item.shovelWood), 'C',
				new ItemStack(Item.pickaxeWood));
		GameRegistry.addRecipe(new ItemStack(MultitoolStone), "ABC", " # ", " # ", '#', new ItemStack(Item.stick), 'A', new ItemStack(Item.axeStone), 'B', new ItemStack(Item.shovelStone), 'C',
				new ItemStack(Item.pickaxeStone));
		GameRegistry.addRecipe(new ItemStack(MultitoolIron), "ABC", " # ", " # ", '#', new ItemStack(Item.stick), 'A', new ItemStack(Item.axeIron), 'B', new ItemStack(Item.shovelIron), 'C',
				new ItemStack(Item.pickaxeIron));
		GameRegistry.addRecipe(new ItemStack(MultitoolGold), "ABC", " # ", " # ", '#', new ItemStack(Item.stick), 'A', new ItemStack(Item.axeGold), 'B', new ItemStack(Item.shovelGold), 'C',
				new ItemStack(Item.pickaxeGold));
		GameRegistry.addRecipe(new ItemStack(MultitoolDiamond), "ABC", " # ", " # ", '#', new ItemStack(Item.stick), 'A', new ItemStack(Item.axeDiamond), 'B', new ItemStack(Item.shovelDiamond), 'C',
				new ItemStack(Item.pickaxeDiamond));
		//Goggles and fancy gadgets
		GameRegistry.addShapelessRecipe(new ItemStack(materials, 9, 7), Item.diamond);
		GameRegistry.addRecipe(new ItemStack(Item.diamond), "XXX", "XXX", "XXX", 'X', new ItemStack(materials, 1, 7));
		GameRegistry.addRecipe(new ItemStack(foods, 1, 2), "XXX", "XCX", "XXX", 'X', new ItemStack(materials, 1, 7), 'C', Item.goldenCarrot);
		GameRegistry.addRecipe(new ItemStack(materials, 1, 8), " X ", "XCX", " X ", 'X', Item.ingotIron, 'C', Block.glass);
		GameRegistry.addRecipe(new ItemStack(materials, 1, 9), "CXC", "XVX", "CXC", 'X', Item.redstone, 'C', Item.ingotIron, 'V', new ItemStack(foods, 1, 2));
		GameRegistry.addRecipe(new ItemStack(helmetGogglesVision, 1), "XCX", 'X', new ItemStack(materials, 1, 8), 'C', new ItemStack(materials, 1, 9));
		GameRegistry.addRecipe(new ItemStack(materials, 1, 11), "CXC", "XVX", "CXC", 'X', Item.redstone, 'C', Item.ingotIron, 'V', Item.appleGold);
		GameRegistry.addRecipe(new ItemStack(plateDualHearts, 1), "C C", " X ", "C C", 'X', new ItemStack(materials, 1, 11), 'C', new ItemStack(materials, 1, 6));
		GameRegistry.addRecipe(new ItemStack(materials, 1, 12), "CXC", "XVX", "CXC", 'X', Item.redstone, 'C', Item.ingotIron, 'V', diamondEnderpearl);
		GameRegistry.addRecipe(new ItemStack(diamondEnderpearl), "XXX", "XCX", "XXX", 'X', new ItemStack(materials, 1, 7), 'C', Item.enderPearl);
		GameRegistry.addRecipe(new ItemStack(enderStaff), " A ", " B ", " C ", 'A', diamondEnderpearl, 'B', new ItemStack(materials, 1, 12), 'C', Item.stick);
		GameRegistry.addRecipe(new ItemStack(materials, 1, 13), "CXC", "XVX", "CXC", 'X', Item.redstone, 'C', Item.ingotIron, 'V', Block.pistonBase);
		GameRegistry.addRecipe(new ItemStack(unattunedLauncher, 1), "CCC", "BXV", "CCC", 'X', Item.redstone, 'C', Item.ingotIron, 'V', new ItemStack(materials, 1, 13), 'B', Block.stoneButton);
		GameRegistry.addRecipe(new ItemStack(unattunedLauncher, 1), "CCC", "VXB", "CCC", 'X', Item.redstone, 'C', Item.ingotIron, 'V', new ItemStack(materials, 1, 13), 'B', Block.stoneButton);
		GameRegistry.addRecipe(new ItemStack(materials, 1, 14), " C ", "CXC", " C ", 'X', Item.ingotIron, 'C', Item.netherQuartz);
		GameRegistry.addRecipe(new ItemStack(materials, 1, 15), "CXC", "XVX", "CXC", 'X', Item.redstone, 'C', Item.ingotIron, 'V', Block.blockRedstone);
		GameRegistry.addRecipe(new ItemStack(scubaHelmet), "CXC", "CVC", 'X', new ItemStack(materials, 1, 15), 'C', Item.ingotIron, 'V', Block.glass);
		GameRegistry.addRecipe(new ItemStack(jumpBoots), "V V", "C C", 'C', new ItemStack(materials, 1, 13), 'V', Block.cobblestone);
		GameRegistry.addRecipe(new ItemStack(legsSwiftness), "VAV", "C C", "V V", 'A', new ItemStack(materials, 1, 11), 'V', Item.ingotIron, 'C', new ItemStack(materials, 1, 16));
		GameRegistry.addRecipe(new ItemStack(materials, 1, 16), "VV ", "AAV", "VV ", 'V', Item.ingotIron, 'A', Item.redstone);
		GameRegistry.addRecipe(new ItemStack(materials, 1, 16), " VV", "VAA", " VV", 'V', Item.ingotIron, 'A', Item.redstone);
		GameRegistry.addShapelessRecipe(new ItemStack(potatoLauncher), Item.potato, unattunedLauncher);
		GameRegistry.addShapelessRecipe(new ItemStack(potatoLauncher), Item.bakedPotato, unattunedLauncher);
		GameRegistry.addShapelessRecipe(new ItemStack(potatoLauncher), Item.poisonousPotato, unattunedLauncher);
		GameRegistry.addShapelessRecipe(new ItemStack(arrowLauncher), Item.arrow, unattunedLauncher);
		GameRegistry.addRecipe(new ItemStack(itemChocolateCake), "AAA", "BCB", "DED", 'A', Item.bucketMilk, 'B', Item.sugar, 'C', Item.egg, 'D', Item.wheat, 'E', new ItemStack(Item.dyePowder, 1, 3));
		GameRegistry.addRecipe(new ItemStack(battleaxeDiamond), "XXX", "XCX", " C ", 'X', Item.diamond, 'C', Item.stick);
		GameRegistry.addRecipe(new ItemStack(battleaxeGold), "XXX", "XCX", " C ", 'X', Item.ingotGold, 'C', Item.stick);
		GameRegistry.addRecipe(new ItemStack(battleaxeIron), "XXX", "XCX", " C ", 'X', Item.ingotIron, 'C', Item.stick);
		GameRegistry.addRecipe(new ItemStack(battleaxeStone), "XXX", "XCX", " C ", 'X', Block.cobblestone, 'C', Item.stick);
		GameRegistry.addRecipe(new ItemStack(battleaxeWood), "XXX", "XCX", " C ", 'X', Block.planks, 'C', Item.stick);
		GameRegistry.addRecipe(new ItemStack(knifeWood), " X ", " C ", 'X', Block.planks, 'C', Item.stick);
		GameRegistry.addRecipe(new ItemStack(knifeStone), " X ", " C ", 'X', Block.cobblestone, 'C', Item.stick);
		GameRegistry.addRecipe(new ItemStack(knifeIron), " X ", " C ", 'X', Item.ingotIron, 'C', Item.stick);
		GameRegistry.addRecipe(new ItemStack(knifeGold), " X ", " C ", 'X', Item.ingotGold, 'C', Item.stick);
		GameRegistry.addRecipe(new ItemStack(knifeDiamond), " X ", " C ", 'X', Item.diamond, 'C', Item.stick);
		GameRegistry.addRecipe(new ItemStack(ironTrapDoor, 2), "XXX", "XXX", 'X', Item.ingotIron);
	}

	public static void items(Configuration config) {
		materials = new ItemMaterials(ConfigItem(config, "Materials"), "honey", "butter", "obsidianPlate", "ingotSteel", "ingotTitanium", "ingotCarbonatedIron", "chain", "diamondNugget", "lens",
				"chipVision", "enderiumPlate", "chipMoreHealth", "chipTeleportation", "chipEject", "ingotQuartz", "chipHeater", "Motor", "ingotCopper", "ingotTin", "ingotBronze", "SaphR", "SaphB",
				"SaphG", "SaphY", "enderium").setUnlocalizedName("materials.").setTextureName(modID + ":");
		foods = new ItemFoodMod(ConfigItem(config, "Foods"), new String[] { "bread_butter", "bread_honey", "carrotDiamond", "turnipCooked", "CupCake" }, new int[] { 8, 8, 12, 4, 6 }, new float[] {
				13F, 13F, 16.7F, 2F, 0.9F }).setUnlocalizedName("foods.").setTextureName(modID + ":");
		helmetGogglesVision = new ItemArmorRedstoneMod(ConfigItem(config, "Goggles of Vision"), armorInfinite, 0, "goggles").setUnlocalizedName("gogglesVision").setTextureName(
				modID + ":gogglesVision");
		turnipCrop = new BlockEdibleCrops(ConfigBlock(config, "Turnip Crop"), true).setUnlocalizedName("turnips").setTextureName("turnips").setTextureName("turnips");
		cornCrop = new BlockEdibleCrops(ConfigBlock(config, "Corn Crop"), false).setUnlocalizedName("corn").setTextureName("corn").setTextureName("corn");
		turnip = new ItemSeedFoodMod(ConfigItem(config, "Turnip"), 2, 0.5F, turnipCrop.blockID, Block.tilledField.blockID).setUnlocalizedName("turnip").setTextureName(modID + ":turnip");
		corn = new ItemSeedFoodMod(ConfigItem(config, "Corn"), 4, 0.9F, cornCrop.blockID, Block.tilledField.blockID).setUnlocalizedName("corn").setTextureName(modID + ":corn");
		plateDualHearts = new ItemArmorRedstoneMod(ConfigItem(config, "Plating of Dual rts"), armorInfinite, 1, "moreHealth").setUnlocalizedName("plateMoreHealth").setMaxDamage(72000)
				.setTextureName(modID + ":plateMoreHealth");
		enderStaff = new EnderStaff(ConfigItem(config, "Ender Staff")).setUnlocalizedName("enderStaff").setCreativeTab(tabMisc).setFull3D().setTextureName(modID + ":enderStaff");
		diamondEnderpearl = new ItemDiamondEnderPearl(ConfigItem(config, "Diamond Enderpearl")).setUnlocalizedName("diamondEnderpearl").setCreativeTab(tabMisc)
				.setTextureName(modID + ":diamondEnderpearl");
		potatoLauncher = new PotatoLauncher(ConfigItem(config, "Potato Launcher")).setCreativeTab(tabMisc).setUnlocalizedName("PotatoLauncher").setFull3D().setTextureName(modID + ":PotatoLauncher");
		scubaHelmet = new ItemArmorRedstoneMod(ConfigItem(config, "Scuba Helmet"), armorInfinite, 0, "scuba").setUnlocalizedName("scubaHelmet").setTextureName(modID + ":scubaHelmet");
		jumpBoots = new ItemArmorRedstoneMod(ConfigItem(config, "Jump Boots"), armorInfinite, 3, "jumpAssist").setUnlocalizedName("jumpBoots").setTextureName(modID + ":jumpBoots");
		arrowLauncher = new ArrowLauncher(ConfigItem(config, "Arrow Launcher")).setCreativeTab(tabMisc).setUnlocalizedName("ArrowLauncher").setFull3D().setTextureName(modID + ":ArrowLauncher");
		legsSwiftness = new ItemArmorRedstoneMod(ConfigItem(config, "Leggings of Swiftness"), armorInfinite, 2, "swiftness").setUnlocalizedName("legsSwiftness").setTextureName(
				modID + ":legsSwiftness");
		MultitoolWood = new ItemMultitoolMod(ConfigItem(config, "Wood Multitool"), EnumToolMaterial.WOOD).setUnlocalizedName("WPaxle").setTextureName(modID + ":tools/paxleWood");
		MultitoolStone = new ItemMultitoolMod(ConfigItem(config, "Stone Multitool"), EnumToolMaterial.STONE).setUnlocalizedName("SPaxle").setTextureName(modID + ":tools/paxleStone");
		MultitoolIron = new ItemMultitoolMod(ConfigItem(config, "Iron Multitool"), EnumToolMaterial.IRON).setUnlocalizedName("IPaxle").setTextureName(modID + ":tools/paxleIron");
		MultitoolGold = new ItemMultitoolMod(ConfigItem(config, "Gold Multitool"), EnumToolMaterial.GOLD).setUnlocalizedName("GPaxle").setTextureName(modID + ":tools/paxleGold");
		MultitoolDiamond = new ItemMultitoolMod(ConfigItem(config, "Diamond Multitool"), EnumToolMaterial.EMERALD).setUnlocalizedName("DPaxle").setTextureName(modID + ":tools/paxleDiamond");
		battleaxeWood = new ItemBattleAxeMod(ConfigItem(config, "Wood Battleaxe"), EnumToolMaterial.WOOD).setUnlocalizedName("battleaxeWood").setTextureName(modID + ":tools/battleaxeWood");
		battleaxeStone = new ItemBattleAxeMod(ConfigItem(config, "Stone Battleaxe"), EnumToolMaterial.STONE).setUnlocalizedName("battleaxeStone").setTextureName(modID + ":tools/battleaxeStone");
		battleaxeIron = new ItemBattleAxeMod(ConfigItem(config, "Iron Battleaxe"), EnumToolMaterial.IRON).setUnlocalizedName("battleaxeIron").setTextureName(modID + ":tools/battleaxeIron");
		battleaxeGold = new ItemBattleAxeMod(ConfigItem(config, "Gold Battleaxe"), EnumToolMaterial.GOLD).setUnlocalizedName("battleaxeGold").setTextureName(modID + ":tools/battleaxeGold");
		battleaxeDiamond = new ItemBattleAxeMod(ConfigItem(config, "Diamond Battleaxe"), EnumToolMaterial.EMERALD).setUnlocalizedName("battleaxeDiamond").setTextureName(
				modID + ":tools/battleaxeDiamond");
		knifeWood = new ItemKnifeMod(ConfigItem(config, "Wood Knife"), EnumToolMaterial.WOOD).setUnlocalizedName("knifeWood").setTextureName(modID + ":tools/knifeWood");
		knifeStone = new ItemKnifeMod(ConfigItem(config, "Stone Knife"), EnumToolMaterial.STONE).setUnlocalizedName("knifeStone").setTextureName(modID + ":tools/knifeStone");
		knifeIron = new ItemKnifeMod(ConfigItem(config, "Iron Knife"), EnumToolMaterial.IRON).setUnlocalizedName("knifeIron").setTextureName(modID + ":tools/knifeIron");
		knifeGold = new ItemKnifeMod(ConfigItem(config, "Gold Knife"), EnumToolMaterial.GOLD).setUnlocalizedName("knifeGold").setTextureName(modID + ":tools/knifeGold");
		knifeDiamond = new ItemKnifeMod(ConfigItem(config, "Diamond Knife"), EnumToolMaterial.EMERALD).setUnlocalizedName("knifeDiamond").setTextureName(modID + ":tools/knifeDiamond");
		storage = new BlockStorage(ConfigBlock(config, "Storage Block"), "RSaphBlock", "BSaphBlock", "GSaphBlock", "YSaphBlock", "blockSteel", "blockTitanium", "carbonatedIronBlock", "blockQuartz",
				"blockCopper", "blockTin", "blockBronze").setTextureName(modID + ":");
		oreDimensional = new BlockOreDimensional(ConfigBlock(config, "Dimension Ores"), "blockEnderium", "Endium", "IronNether", "IronEnd", "GoldNether", "GoldEnd", "Titanium", "TitaniumNether",
				"TitaniumEnd", "Copper", "CopperNether", "CopperEnd", "Tin", "TinNether", "TinEnd");
		beeHive = new BlockBeehive(ConfigBlock(config, "BeeHive")).setUnlocalizedName("beeHive").setTextureName(modID + ":beehive");
		ores = new BlockGem(ConfigBlock(config, "Ores"));
		chocolateCake = new BlockChocolateCake(ConfigBlock(config, "Chocolate Cake Block")).setHardness(0.5F).setStepSound(Block.soundClothFootstep).setUnlocalizedName("choccake")
				.setTextureName(modID + ":choccake");
		itemChocolateCake = new ItemReed(ConfigItem(config, "Chocolate Cake Item"), chocolateCake).setCreativeTab(tabMisc).setUnlocalizedName("choccake").setTextureName(modID + ":choccake");
		ironTrapDoor = new BlockIronTrapDoor(ConfigBlock(config, "Iron Trapdoor")).setUnlocalizedName("irontrapdoor").setCreativeTab(tabMisc).setTextureName(modID + ":irontrapdoor");
		unattunedLauncher = new Item(ConfigItem(config, "Unattuned Launcher")).setCreativeTab(tabMisc).setUnlocalizedName("UnattunedLauncher").setFull3D().setMaxStackSize(1)
				.setTextureName(modID + ":UnattunedLauncher");
	}
}
