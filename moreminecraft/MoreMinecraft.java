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
	public static Block oreRuby;
	public static Block oreGSaph;
	public static Block oreBSaph;
	public static Block oreYSaph;
	public static Block BSaphBlock;
	public static Block YSaphBlock;
	public static Block GSaphBlock;
	public static Block rubyBlock;
	public static Block steelBlock;
	public static Block titaniumBlock;
	public static Block carbonatedIronBlock;
	public static Block oreTitanium;
	public static Block oreEnderium;
	public static Block enderiumBlock;
	public static Block oreDiamondNether;
	public static Block oreDiamondEnd;
	public static Block oreCoalNether;
	public static Block oreCoalEnd;
	public static Block oreIronNether;
	public static Block oreIronEnd;
	public static Block oreGoldNether;
	public static Block oreGoldEnd;
	public static Block oreRedstoneNether;
	public static Block oreRedstoneEnd;
	public static Block oreLapisNether;
	public static Block oreLapisEnd;
	public static Block oreTitaniumNether;
	public static Block oreTitaniumEnd;
	public static Block oreRubyNether;
	public static Block oreRubyEnd;
	public static Block oreGSaphNether;
	public static Block oreGSaphEnd;
	public static Block oreBSaphNether;
	public static Block oreBSaphEnd;
	public static Block oreYSaphNether;
	public static Block oreYSaphEnd;
	public static Block quartzBlock;
	public static Block copperBlock;
	public static Block tinBlock;
	public static Block bronzeBlock;
	public static Block copperOre;
	public static Block tinOre;
	public static Block copperOreNether;
	public static Block tinOreNether;
	public static Block copperOreEnd;
	public static Block tinOreEnd;
	public static Block beeHive;
	public static Block turnipCrop;
	public static Block cornCrop;
	public static Block chocolateCake;
	public static Block ironTrapDoor;
	public static Item honey;
	public static Item butter;
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
	public static Item bread_butter;
	public static Item bread_honey;
	public static Item obsidianPlate;
	public static Item Ruby;
	public static Item GSaph;
	public static Item BSaph;
	public static Item YSaph;
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
	public static Item steel;
	public static Item titanium;
	public static Item carbonatedIron;
	public static Item chain;
	public static Item helmetGogglesVision;
	public static Item chipVision;
	public static Item carrotDiamond;
	public static Item goggleLens;
	public static Item nuggetDiamond;
	public static Item turnip;
	public static Item turnipCooked;
	public static Item corn;
	public static Item enderium;
	public static Item enderiumPlate;
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
	public static Item chipDualHearts;
	public static Item plateDualHearts;
	public static Item enderStaff;
	public static Item diamondEnderpearl;
	public static Item chipTeleportation;
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
	public static Item quartzIngot;
	public static Item potatoLauncher;
	public static Item chipEject;
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
	public static Item copperIngot;
	public static Item tinIngot;
	public static Item bronzeIngot;
	public static Item cupcake;
	public static Item chipHeater;
	public static Item scubaHelmet;
	public static Item jumpBoots;
	public static Item unattunedLauncher;
	public static Item arrowLauncher;
	public static Item legsSwiftness;
	public static Item motor;
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
				GameRegistry.registerBlock((Block) obj, ((Block) obj).getUnlocalizedName());
			} else if (obj instanceof Item) {
				GameRegistry.registerItem((Item) obj, ((Item) obj).getUnlocalizedName());
			}
		}
	}

	private void sets(Configuration config) {
		createArmorSet(config, "Emerald", armorEmerald, "emerald", "Emerald", Item.emerald, 0);
		createArmorSet(config, "Obsidian", armorObsidian, "obsidian", "Obsidian", obsidianPlate, 0);
		createArmorSet(config, "Ruby", armorCrystal, "ruby", "Ruby", Ruby, 0);
		createArmorSet(config, "YellowSaph", armorCrystal, "saphY", "Yellow Sapphire", YSaph, 0);
		createArmorSet(config, "GreenSaph", armorCrystal, "saphG", "Green Sapphire", GSaph, 0);
		createArmorSet(config, "BlueSaph", armorCrystal, "saphB", "Blue Sapphire", BSaph, 0);
		createArmorSet(config, "Stone", armorStone, "stone", "Stone", Block.stone, 0);
		createArmorSet(config, "Wood", armorWood, "wood", "Wooden", Block.planks, 0);
		createArmorSet(config, "WoodJungle", armorWood, "wood_jungle", "Wooden", Block.planks, 3);
		createArmorSet(config, "WoodSpruce", armorWood, "wood_spruce", "Wooden", Block.planks, 1);
		createArmorSet(config, "WoodBirch", armorWood, "wood_birch", "Wooden", Block.planks, 2);
		createArmorSet(config, "Steel", armorSteel, "steel", "Steel", steel, 0);
		createArmorSet(config, "Titanium", armorTitanium, "titanium", "Titanium", titanium, 0);
		createArmorSet(config, "End", armorEnd, "end", "Endium", enderium, 0);
		createArmorSet(config, "Quartz", armorQuartz, "quarts", "Quartz", quartzIngot, 0);
		createArmorSet(config, "Copper", armorMetal, "copper", "Copper", copperIngot, 0);
		createArmorSet(config, "Tin", armorMetal, "tin", "Tin", tinIngot, 0);
		createArmorSet(config, "Bronze", armorBronze, "bronze", "Bronze", bronzeIngot, 0);
		createToolSet(config, "Emerald", toolEmerald, "Emerald", "Emerald", Item.emerald, 0);
		createToolSet(config, "Obsidian", toolObsidian, "Obsidian", "Obsidian", obsidianPlate, 0);
		createToolSet(config, "Ruby", toolCrystal, "RSaph", "Ruby", Ruby, 0);
		createToolSet(config, "YellowSaph", toolCrystal, "YSaph", "Yellow Sapphire", YSaph, 0);
		createToolSet(config, "BlueSaph", toolCrystal, "BSaph", "Blue Sapphire", BSaph, 0);
		createToolSet(config, "GreenSaph", toolCrystal, "GSaph", "Green Sapphire", GSaph, 0);
		createToolSet(config, "Steel", toolSteel, "Steel", "Steel", steel, 0);
		createToolSet(config, "Titanium", toolTitanium, "Titanium", "Titanium", titanium, 0);
		createToolSet(config, "End", toolEnd, "End", "Endium", enderium, 0);
		createToolSet(config, "Quartz", toolQuartz, "Quartz", "Quartz", quartzIngot, 0);
		createToolSet(config, "Copper", toolMetal, "Copper", "Copper", copperIngot, 0);
		createToolSet(config, "Tin", toolMetal, "Tin", "Tin", tinIngot, 0);
		createToolSet(config, "Bronze", toolBronze, "Bronze", "Bronze", bronzeIngot, 0);
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
		GameRegistry.addShapelessRecipe(new ItemStack(butter), Item.bucketMilk);
		GameRegistry.addShapelessRecipe(new ItemStack(bread_butter), butter, Item.bread);
		GameRegistry.addShapelessRecipe(new ItemStack(bread_honey), honey, Item.bread);
		GameRegistry.addShapelessRecipe(new ItemStack(enderium, 9), enderiumBlock);
		GameRegistry.addShapelessRecipe(new ItemStack(Ruby, 9), rubyBlock);
		GameRegistry.addShapelessRecipe(new ItemStack(GSaph, 9), GSaphBlock);
		GameRegistry.addShapelessRecipe(new ItemStack(YSaph, 9), YSaphBlock);
		GameRegistry.addShapelessRecipe(new ItemStack(BSaph, 9), BSaphBlock);
		GameRegistry.addShapelessRecipe(new ItemStack(chain, 4), Item.ingotIron);
		GameRegistry.addShapelessRecipe(new ItemStack(chain, 8), steel);
		GameRegistry.addShapelessRecipe(new ItemStack(enderiumPlate), enderium, obsidianPlate);
		GameRegistry.addRecipe(new ItemStack(obsidianPlate), "XXX", "XXX", "XXX", 'X', Block.obsidian);
		GameRegistry.addRecipe(new ItemStack(YSaphBlock), "XXX", "XXX", "XXX", 'X', YSaph);
		GameRegistry.addRecipe(new ItemStack(BSaphBlock), "XXX", "XXX", "XXX", 'X', BSaph);
		GameRegistry.addRecipe(new ItemStack(GSaphBlock), "XXX", "XXX", "XXX", 'X', GSaph);
		GameRegistry.addRecipe(new ItemStack(rubyBlock), "XXX", "XXX", "XXX", 'X', Ruby);
		GameRegistry.addRecipe(new ItemStack(enderiumBlock), "XXX", "XXX", "XXX", 'X', enderium);
		GameRegistry.addRecipe(new ItemStack(quartzBlock), "XXX", "XXX", "XXX", 'X', quartzIngot);
		GameRegistry.addRecipe(new ItemStack(tinBlock), "XXX", "XXX", "XXX", 'X', tinIngot);
		GameRegistry.addRecipe(new ItemStack(copperBlock), "XXX", "XXX", "XXX", 'X', copperIngot);
		GameRegistry.addRecipe(new ItemStack(bronzeBlock), "XXX", "XXX", "XXX", 'X', bronzeIngot);
		GameRegistry.addShapelessRecipe(new ItemStack(copperIngot, 9), copperBlock);
		GameRegistry.addShapelessRecipe(new ItemStack(tinIngot, 9), tinBlock);
		GameRegistry.addShapelessRecipe(new ItemStack(bronzeIngot, 9), bronzeBlock);
		GameRegistry.addShapelessRecipe(new ItemStack(bronzeIngot, 2), tinIngot, copperIngot);
		GameRegistry.addRecipe(new ItemStack(titaniumBlock), "XXX", "XXX", "XXX", 'X', titanium);
		GameRegistry.addRecipe(new ItemStack(steelBlock), "XXX", "XXX", "XXX", 'X', steel);
		GameRegistry.addRecipe(new ItemStack(carbonatedIronBlock), "XXX", "XXX", "XXX", 'X', carbonatedIron);
		GameRegistry.addShapelessRecipe(new ItemStack(steel, 9), steelBlock);
		GameRegistry.addShapelessRecipe(new ItemStack(titanium, 9), titaniumBlock);
		GameRegistry.addShapelessRecipe(new ItemStack(carbonatedIron, 9), carbonatedIronBlock);
		GameRegistry.addShapelessRecipe(new ItemStack(quartzIngot, 9), quartzBlock);
		GameRegistry.addShapelessRecipe(new ItemStack(cupcake, 1), Item.bucketMilk, Item.sugar, Item.egg, Item.wheat);
		GameRegistry.addRecipe(new ItemStack(carbonatedIron), " C ", "CXC", " C ", 'X', Item.ingotIron, 'C', Item.coal);
		//FURNACE
		GameRegistry.addSmelting(oreTitanium.blockID, new ItemStack(titanium), 0.5F);
		GameRegistry.addSmelting(carbonatedIron.itemID, new ItemStack(steel), 3.5F);
		GameRegistry.addSmelting(turnip.itemID, new ItemStack(turnipCooked), 1.5F);
		GameRegistry.addSmelting(oreTitaniumNether.blockID, new ItemStack(titanium, 2), 3F);
		GameRegistry.addSmelting(oreIronNether.blockID, new ItemStack(Item.ingotIron, 2), 3F);
		GameRegistry.addSmelting(oreGoldNether.blockID, new ItemStack(Item.ingotGold, 2), 3F);
		GameRegistry.addSmelting(oreTitaniumEnd.blockID, new ItemStack(titanium, 4), 6F);
		GameRegistry.addSmelting(oreIronEnd.blockID, new ItemStack(Item.ingotIron, 4), 6F);
		GameRegistry.addSmelting(oreGoldEnd.blockID, new ItemStack(Item.ingotGold, 4), 6F);
		GameRegistry.addSmelting(tinOre.blockID, new ItemStack(tinIngot), 0.5F);
		GameRegistry.addSmelting(copperOre.blockID, new ItemStack(copperIngot), 0.5F);
		GameRegistry.addSmelting(copperOreNether.blockID, new ItemStack(copperIngot, 2), 3F);
		GameRegistry.addSmelting(tinOreNether.blockID, new ItemStack(tinIngot, 2), 3F);
		GameRegistry.addSmelting(copperOreEnd.blockID, new ItemStack(copperIngot, 4), 6F);
		GameRegistry.addSmelting(tinOreEnd.blockID, new ItemStack(tinIngot, 4), 6F);
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
		GameRegistry.addShapelessRecipe(new ItemStack(nuggetDiamond, 9), Item.diamond);
		GameRegistry.addRecipe(new ItemStack(Item.diamond), "XXX", "XXX", "XXX", 'X', nuggetDiamond);
		GameRegistry.addRecipe(new ItemStack(carrotDiamond), "XXX", "XCX", "XXX", 'X', nuggetDiamond, 'C', Item.goldenCarrot);
		GameRegistry.addRecipe(new ItemStack(goggleLens), " X ", "XCX", " X ", 'X', Item.ingotIron, 'C', Block.glass);
		GameRegistry.addRecipe(new ItemStack(chipVision), "CXC", "XVX", "CXC", 'X', Item.redstone, 'C', Item.ingotIron, 'V', carrotDiamond);
		GameRegistry.addRecipe(new ItemStack(helmetGogglesVision, 1), "XCX", 'X', goggleLens, 'C', chipVision);
		GameRegistry.addRecipe(new ItemStack(chipDualHearts), "CXC", "XVX", "CXC", 'X', Item.redstone, 'C', Item.ingotIron, 'V', Item.appleGold);
		GameRegistry.addRecipe(new ItemStack(plateDualHearts, 1), "C C", " X ", "C C", 'X', chipDualHearts, 'C', chain);
		GameRegistry.addRecipe(new ItemStack(chipTeleportation), "CXC", "XVX", "CXC", 'X', Item.redstone, 'C', Item.ingotIron, 'V', diamondEnderpearl);
		GameRegistry.addRecipe(new ItemStack(diamondEnderpearl), "XXX", "XCX", "XXX", 'X', nuggetDiamond, 'C', Item.enderPearl);
		GameRegistry.addRecipe(new ItemStack(enderStaff), " A ", " B ", " C ", 'A', diamondEnderpearl, 'B', chipTeleportation, 'C', Item.stick);
		GameRegistry.addRecipe(new ItemStack(chipEject), "CXC", "XVX", "CXC", 'X', Item.redstone, 'C', Item.ingotIron, 'V', Block.pistonBase);
		GameRegistry.addRecipe(new ItemStack(unattunedLauncher, 1), "CCC", "BXV", "CCC", 'X', Item.redstone, 'C', Item.ingotIron, 'V', chipEject, 'B', Block.stoneButton);
		GameRegistry.addRecipe(new ItemStack(unattunedLauncher, 1), "CCC", "VXB", "CCC", 'X', Item.redstone, 'C', Item.ingotIron, 'V', chipEject, 'B', Block.stoneButton);
		GameRegistry.addRecipe(new ItemStack(quartzIngot), " C ", "CXC", " C ", 'X', Item.ingotIron, 'C', Item.netherQuartz);
		GameRegistry.addRecipe(new ItemStack(chipHeater), "CXC", "XVX", "CXC", 'X', Item.redstone, 'C', Item.ingotIron, 'V', Block.blockRedstone);
		GameRegistry.addRecipe(new ItemStack(scubaHelmet, 1), "CXC", "CVC", 'X', chipHeater, 'C', Item.ingotIron, 'V', Block.glass);
		GameRegistry.addRecipe(new ItemStack(jumpBoots, 1), "V V", "C C", 'C', chipEject, 'V', Block.cobblestone);
		GameRegistry.addRecipe(new ItemStack(legsSwiftness, 1), "VAV", "C C", "V V", 'A', chipDualHearts, 'V', Item.ingotIron, 'C', motor);
		GameRegistry.addRecipe(new ItemStack(motor, 1), "VV ", "AAV", "VV ", 'V', Item.ingotIron, 'A', Item.redstone);
		GameRegistry.addRecipe(new ItemStack(motor, 1), " VV", "VAA", " VV", 'V', Item.ingotIron, 'A', Item.redstone);
		GameRegistry.addShapelessRecipe(new ItemStack(potatoLauncher, 1), Item.potato, unattunedLauncher);
		GameRegistry.addShapelessRecipe(new ItemStack(potatoLauncher, 1), Item.bakedPotato, unattunedLauncher);
		GameRegistry.addShapelessRecipe(new ItemStack(potatoLauncher, 1), Item.poisonousPotato, unattunedLauncher);
		GameRegistry.addShapelessRecipe(new ItemStack(arrowLauncher, 1), Item.arrow, unattunedLauncher);
		GameRegistry.addRecipe(new ItemStack(itemChocolateCake, 1), "AAA", "BCB", "DED", 'A', Item.bucketMilk, 'B', Item.sugar, 'C', Item.egg, 'D', Item.wheat, 'E',
				new ItemStack(Item.dyePowder, 1, 3));
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
		honey = new Item(ConfigItem(config, "Honey")).setUnlocalizedName("honey_item").setCreativeTab(tabMisc).setTextureName(modID + ":honey_item");
		butter = new Item(ConfigItem(config, "Butter")).setUnlocalizedName("butter").setCreativeTab(tabMisc).setTextureName(modID + ":butter");
		bread_butter = new ItemFoodMod(ConfigItem(config, "Butter Bread"), 8, 13F, false).setUnlocalizedName("bread_butter").setTextureName(modID + ":bread_butter");
		bread_honey = new ItemFoodMod(ConfigItem(config, "Honey Bread"), 8, 13F, false).setUnlocalizedName("bread_honey").setTextureName(modID + ":bread_honey");
		obsidianPlate = new Item(ConfigItem(config, "Obsidian Plate")).setUnlocalizedName("Obsidian_Plate").setCreativeTab(tabMisc).setTextureName(modID + ":Obsidian_Plate");
		Ruby = new Item(ConfigItem(config, "Ruby")).setUnlocalizedName("SaphR").setCreativeTab(tabMisc).setTextureName(modID + ":SaphR");
		BSaph = new Item(ConfigItem(config, "Blue Sapphire")).setUnlocalizedName("SaphB").setCreativeTab(tabMisc).setTextureName(modID + ":SaphB");
		GSaph = new Item(ConfigItem(config, "Green Sapphire")).setUnlocalizedName("SaphG").setCreativeTab(tabMisc).setTextureName(modID + ":SaphG");
		YSaph = new Item(ConfigItem(config, "Yellow Sapphire")).setUnlocalizedName("SaphY").setCreativeTab(tabMisc).setTextureName(modID + ":SaphY");
		steel = new Item(ConfigItem(config, "Steel")).setUnlocalizedName("ingotSteel").setCreativeTab(tabMisc).setTextureName(modID + ":ingotSteel");
		titanium = new Item(ConfigItem(config, "Titanium")).setUnlocalizedName("ingotTitanium").setCreativeTab(tabMisc).setTextureName(modID + ":ingotTitanium");
		carbonatedIron = new Item(ConfigItem(config, "Carbonated Iron")).setUnlocalizedName("ingotCarbonatedIron").setCreativeTab(tabMisc).setTextureName(modID + ":ingotCarbonatedIron");
		chain = new Item(ConfigItem(config, "Chain")).setUnlocalizedName("chain").setCreativeTab(tabMisc).setTextureName(modID + ":chain");
		helmetGogglesVision = new ItemArmorRedstoneMod(ConfigItem(config, "Goggles of Vision"), armorInfinite, 0, "goggles").setUnlocalizedName("gogglesVision").setTextureName(
				modID + ":gogglesVision");
		carrotDiamond = new ItemFoodMod(ConfigItem(config, "Diamond Carrot"), 12, 16.7F, false).setUnlocalizedName("carrotDiamond").setTextureName(modID + ":carrotDiamond");
		nuggetDiamond = new Item(ConfigItem(config, "Diamond Nugget")).setUnlocalizedName("diamondNugget").setCreativeTab(tabMisc).setTextureName(modID + ":diamondNugget");
		goggleLens = new Item(ConfigItem(config, "Goggle Lens")).setUnlocalizedName("lens").setCreativeTab(tabMisc).setTextureName(modID + ":lens");
		chipVision = new Item(ConfigItem(config, "Chipset of Vision")).setUnlocalizedName("chipVision").setCreativeTab(tabMisc).setTextureName(modID + ":chipVision");
		turnipCrop = new BlockEdibleCrops(ConfigBlock(config, "Turnip Crop"), true).setUnlocalizedName("turnips").setTextureName("turnips").setTextureName("turnips");
		cornCrop = new BlockEdibleCrops(ConfigBlock(config, "Corn Crop"), false).setUnlocalizedName("corn").setTextureName("corn").setTextureName("corn");
		turnip = new ItemSeedFoodMod(ConfigItem(config, "Turnip"), 2, 0.5F, turnipCrop.blockID, Block.tilledField.blockID).setUnlocalizedName("turnip").setTextureName(modID + ":turnip");
		turnipCooked = new ItemFoodMod(ConfigItem(config, "Cooked Turnip"), 4, 2F, false).setUnlocalizedName("turnipCooked").setCreativeTab(tabMisc).setTextureName(modID + ":turnipCooked");
		corn = new ItemSeedFoodMod(ConfigItem(config, "Corn"), 4, 0.9F, cornCrop.blockID, Block.tilledField.blockID).setUnlocalizedName("corn").setTextureName(modID + ":corn");
		enderium = new Item(ConfigItem(config, "Enderium")).setUnlocalizedName("enderium").setCreativeTab(tabMisc).setTextureName(modID + ":enderium");
		enderiumPlate = new Item(ConfigItem(config, "Enderium Plate")).setUnlocalizedName("enderiumPlate").setCreativeTab(tabMisc).setTextureName(modID + ":enderiumPlate");
		chipDualHearts = new Item(ConfigItem(config, "Chipset of Better Health")).setUnlocalizedName("chipMoreHealth").setCreativeTab(tabMisc).setTextureName(modID + ":chipMoreHealth");
		plateDualHearts = new ItemArmorRedstoneMod(ConfigItem(config, "Plating of Dual rts"), armorInfinite, 1, "moreHealth").setUnlocalizedName("plateMoreHealth").setMaxDamage(72000)
				.setTextureName(modID + ":plateMoreHealth");
		enderStaff = new EnderStaff(ConfigItem(config, "Ender Staff")).setUnlocalizedName("enderStaff").setCreativeTab(tabMisc).setFull3D().setTextureName(modID + ":enderStaff");
		diamondEnderpearl = new ItemDiamondEnderPearl(ConfigItem(config, "Diamond Enderpearl")).setUnlocalizedName("diamondEnderpearl").setCreativeTab(tabMisc)
				.setTextureName(modID + ":diamondEnderpearl");
		chipTeleportation = new Item(ConfigItem(config, "Chipset of Teleportation")).setUnlocalizedName("chipTeleportation").setCreativeTab(tabMisc).setTextureName(modID + ":chipTeleportation");
		potatoLauncher = new PotatoLauncher(ConfigItem(config, "Potato Launcher")).setCreativeTab(tabMisc).setUnlocalizedName("PotatoLauncher").setFull3D().setTextureName(modID + ":PotatoLauncher");
		chipEject = new Item(ConfigItem(config, "Chipset of Ejection")).setUnlocalizedName("chipEject").setCreativeTab(tabMisc).setTextureName(modID + ":chipEject");
		quartzIngot = new Item(ConfigItem(config, "Quartz Ingot")).setUnlocalizedName("quartzIngot").setCreativeTab(tabMisc).setTextureName(modID + ":quartzIngot");
		cupcake = new ItemFoodMod(ConfigItem(config, "Cupcake"), 6, 0.9F, false).setUnlocalizedName("Cupcake").setTextureName(modID + ":CupCake");
		chipHeater = new Item(ConfigItem(config, "Chipset of Electrolyzing")).setUnlocalizedName("chipHeater").setCreativeTab(tabMisc).setTextureName(modID + ":chipHeater");
		scubaHelmet = new ItemArmorRedstoneMod(ConfigItem(config, "Scuba Helmet"), armorInfinite, 0, "scuba").setUnlocalizedName("scubaHelmet").setTextureName(modID + ":scubaHelmet");
		jumpBoots = new ItemArmorRedstoneMod(ConfigItem(config, "Jump Boots"), armorInfinite, 3, "jumpAssist").setUnlocalizedName("jumpBoots").setTextureName(modID + ":jumpBoots");
		arrowLauncher = new ArrowLauncher(ConfigItem(config, "Arrow Launcher")).setCreativeTab(tabMisc).setUnlocalizedName("ArrowLauncher").setFull3D().setTextureName(modID + ":ArrowLauncher");
		legsSwiftness = new ItemArmorRedstoneMod(ConfigItem(config, "Leggings of Swiftness"), armorInfinite, 2, "swiftness").setUnlocalizedName("legsSwiftness").setTextureName(
				modID + ":legsSwiftness");
		motor = new Item(ConfigItem(config, "Motor")).setCreativeTab(tabMisc).setUnlocalizedName("Motor").setTextureName(modID + ":Motor");
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
		copperIngot = new Item(ConfigItem(config, "Copper Ingot")).setUnlocalizedName("copperIngot").setCreativeTab(tabMisc).setTextureName(modID + ":copperIngot");
		tinIngot = new Item(ConfigItem(config, "Tin Ingot")).setUnlocalizedName("tinIngot").setCreativeTab(tabMisc).setTextureName(modID + ":tinIngot");
		bronzeIngot = new Item(ConfigItem(config, "Bronze Ingot")).setUnlocalizedName("ingotBronze").setCreativeTab(tabMisc).setTextureName(modID + ":ingotBronze");
		rubyBlock = new BasicBlock(ConfigBlock(config, "Ruby Block")).setUnlocalizedName("RSaphBlock").setTextureName(modID + ":RSaphBlock");
		BSaphBlock = new BasicBlock(ConfigBlock(config, "Blue Sapphire Block")).setUnlocalizedName("BSaphBlock").setTextureName(modID + ":BSaphBlock");
		GSaphBlock = new BasicBlock(ConfigBlock(config, "Green Sapphire Block")).setUnlocalizedName("GSaphBlock").setTextureName(modID + ":GSaphBlock");
		YSaphBlock = new BasicBlock(ConfigBlock(config, "Yellow Sapphire Block")).setUnlocalizedName("YSaphBlock").setTextureName(modID + ":YSaphBlock");
		steelBlock = new BasicBlock(ConfigBlock(config, "Steel Block")).setUnlocalizedName("blockSteel").setTextureName(modID + ":blockSteel");
		titaniumBlock = new BasicBlock(ConfigBlock(config, "Titanium Block")).setUnlocalizedName("blockTitanium").setTextureName(modID + ":blockTitanium");
		oreTitanium = new BasicBlock(ConfigBlock(config, "Titanium Ore")).setUnlocalizedName("oreTitanium").setTextureName(modID + ":oreTitanium");
		carbonatedIronBlock = new BasicBlock(ConfigBlock(config, "Carbonated Iron Block")).setUnlocalizedName("carbonatedIronBlock").setTextureName(modID + ":carbonatedIronBlock");
		oreEnderium = new BlockGem(ConfigBlock(config, "Enderium Ore"), enderium.itemID).setUnlocalizedName("endiumOre").setTextureName(modID + ":endiumOre");
		enderiumBlock = new BlockGem(ConfigBlock(config, "Enderium Block"), enderium.itemID).setUnlocalizedName("blockEnderium").setTextureName(modID + ":blockEnderium");
		oreDiamondNether = new BlockGem(ConfigBlock(config, "Nether Diamond Ore"), Item.diamond.itemID, 2).setUnlocalizedName("oreDiamondNether").setTextureName(modID + ":oreDiamondNether");
		oreDiamondEnd = new BlockGem(ConfigBlock(config, "End Diamond Ore"), 4, Item.diamond.itemID).setUnlocalizedName("oreDiamondEnd").setTextureName(modID + ":oreDiamondEnd");
		oreCoalNether = new BlockGem(ConfigBlock(config, "Nether Coal Ore"), 2, Item.coal.itemID).setUnlocalizedName("oreCoalNether").setTextureName(modID + ":oreCoalNether");
		oreCoalEnd = new BlockGem(ConfigBlock(config, "End Coal Ore"), 4, Item.coal.itemID).setUnlocalizedName("oreCoalEnd").setTextureName(modID + ":oreCoalEnd");
		oreIronNether = new BasicBlock(ConfigBlock(config, "Nether Iron Ore")).setUnlocalizedName("oreIronNether").setTextureName(modID + ":oreIronNether");
		oreIronEnd = new BasicBlock(ConfigBlock(config, "End Iron Ore")).setUnlocalizedName("oreIronEnd").setTextureName(modID + ":oreIronEnd");
		oreGoldNether = new BasicBlock(ConfigBlock(config, "Nether Gold Ore")).setUnlocalizedName("oreGoldNether").setTextureName(modID + ":oreGoldNether");
		oreGoldEnd = new BasicBlock(ConfigBlock(config, "End Gold Ore")).setUnlocalizedName("oreGoldEnd").setTextureName(modID + ":oreGoldEnd");
		oreRedstoneNether = new BlockGem(ConfigBlock(config, "Nether Redstone Ore"), 12, Item.redstone.itemID).setUnlocalizedName("oreRedstoneNether").setTextureName(modID + ":oreRedstoneNether");
		oreRedstoneEnd = new BlockGem(ConfigBlock(config, "End Redstone Ore"), 24, Item.redstone.itemID).setUnlocalizedName("oreRedstoneEnd").setTextureName(modID + ":oreRedstoneEnd");
		oreLapisNether = new BlockOreDimensional(ConfigBlock(config, "Nether Lapis Ore"), Item.dyePowder.itemID, 12, 4).setUnlocalizedName("oreLapisNether").setTextureName(modID + ":oreLapisNether");
		oreLapisEnd = new BlockOreDimensional(ConfigBlock(config, "End Lapis Ore"), Item.dyePowder.itemID, 24, 4).setUnlocalizedName("oreLapisEnd").setTextureName(modID + ":oreLapisEnd");
		oreTitaniumNether = new BasicBlock(ConfigBlock(config, "Nether Titanium Ore")).setUnlocalizedName("oreTitaniumNether").setTextureName(modID + ":oreTitaniumNether");
		oreTitaniumEnd = new BasicBlock(ConfigBlock(config, "End Titanium Ore")).setUnlocalizedName("oreTitaniumEnd").setTextureName(modID + ":oreTitaniumEnd");
		beeHive = new BlockBeehive(ConfigBlock(config, "BeeHive")).setUnlocalizedName("beeHive").setTextureName(modID + ":beehive");
		oreRuby = new BlockGem(ConfigBlock(config, "Ruby Ore"), 1, 1, Ruby.itemID).setUnlocalizedName("oreRuby").setTextureName(modID + ":oreRuby");
		oreBSaph = new BlockGem(ConfigBlock(config, "Blue Sapphire Ore"), 1, BSaph.itemID).setUnlocalizedName("oreBSaph").setTextureName(modID + ":oreBSaph");
		oreGSaph = new BlockGem(ConfigBlock(config, "Green Sapphire Ore"), 1, 1, GSaph.itemID).setUnlocalizedName("oreGSaph").setTextureName(modID + ":oreGSaph");
		oreYSaph = new BlockGem(ConfigBlock(config, "Yellow Sapphire Ore"), 1, 1, YSaph.itemID).setUnlocalizedName("oreYSaph").setTextureName(modID + ":oreYSaph");
		oreRubyNether = new BlockGem(ConfigBlock(config, "Nether Ruby Ore"), 1, 2, Ruby.itemID).setUnlocalizedName("oreRubyNether").setTextureName(modID + ":oreRubyNether");
		oreRubyEnd = new BlockGem(ConfigBlock(config, "End Ruby Ore"), 1, 4, Ruby.itemID).setUnlocalizedName("oreRubyEnd").setTextureName(modID + ":oreRubyEnd");
		oreGSaphNether = new BlockGem(ConfigBlock(config, "Nether Green Sapphire Ore"), 1, 1, GSaph.itemID).setUnlocalizedName("oreGSaphNether").setTextureName(modID + ":oreGSaphNether");
		oreGSaphEnd = new BlockGem(ConfigBlock(config, "End Green Sapphire Ore"), 1, 4, GSaph.itemID).setUnlocalizedName("oreGSaphEnd").setTextureName(modID + ":oreGSaphEnd");
		oreBSaphNether = new BlockGem(ConfigBlock(config, "Nether Blue Sapphire Ore"), 2, BSaph.itemID).setUnlocalizedName("oreBSaphNether").setTextureName(modID + ":oreBSaphNether");
		oreBSaphEnd = new BlockGem(ConfigBlock(config, "End Blue Sapphire Ore"), 4, BSaph.itemID).setUnlocalizedName("oreBSaphEnd").setTextureName(modID + ":oreBSaphEnd");
		oreYSaphNether = new BlockGem(ConfigBlock(config, "Nether Yellow Sapphire Ore"), 1, 2, YSaph.itemID).setUnlocalizedName("oreYSaphNether").setTextureName(modID + ":oreYSaphNether");
		oreYSaphEnd = new BlockGem(ConfigBlock(config, "End Yellow Sapphire Ore"), 1, 4, YSaph.itemID).setUnlocalizedName("oreYSaphEnd").setTextureName(modID + ":oreYSaphEnd");
		quartzBlock = new BasicBlock(ConfigBlock(config, "Quartz Block")).setUnlocalizedName("blockQuartz").setTextureName(modID + ":blockQuartz");
		copperBlock = new BasicBlock(ConfigBlock(config, "Copper Block")).setUnlocalizedName("blockCopper").setTextureName(modID + ":blockCopper");
		tinBlock = new BasicBlock(ConfigBlock(config, "Tin Block")).setUnlocalizedName("blockTin").setTextureName(modID + ":blockTin");
		bronzeBlock = new BasicBlock(ConfigBlock(config, "Bronze Block")).setUnlocalizedName("blockBronze").setTextureName(modID + ":blockBronze");
		copperOre = new BasicBlock(ConfigBlock(config, "Copper Ore")).setUnlocalizedName("oreCopper").setTextureName(modID + ":oreCopper");
		tinOre = new BasicBlock(ConfigBlock(config, "Tin Ore")).setUnlocalizedName("oreTin").setTextureName(modID + ":oreTin");
		copperOreEnd = new BasicBlock(ConfigBlock(config, "End Copper Ore")).setUnlocalizedName("oreCopperEnd").setTextureName(modID + ":oreCopperEnd");
		tinOreEnd = new BasicBlock(ConfigBlock(config, "End Tin Ore")).setUnlocalizedName("oreTinEnd").setTextureName(modID + ":oreTinEnd");
		copperOreNether = new BasicBlock(ConfigBlock(config, "Nether Copper Ore")).setUnlocalizedName("oreCopperNether").setTextureName(modID + ":oreCopperNether");
		tinOreNether = new BasicBlock(ConfigBlock(config, "Nether Tin Ore")).setUnlocalizedName("oreTinNether").setTextureName(modID + ":oreTinNether");
		chocolateCake = new BlockChocolateCake(ConfigBlock(config, "Chocolate Cake Block")).setHardness(0.5F).setStepSound(Block.soundClothFootstep).setUnlocalizedName("choccake")
				.setTextureName(modID + ":choccake");
		itemChocolateCake = new ItemReed(ConfigItem(config, "Chocolate Cake Item"), chocolateCake).setCreativeTab(tabMisc).setUnlocalizedName("choccake").setTextureName(modID + ":choccake");
		ironTrapDoor = new BlockIronTrapDoor(ConfigBlock(config, "Iron Trapdoor")).setUnlocalizedName("irontrapdoor").setCreativeTab(tabMisc).setTextureName(modID + ":irontrapdoor");
		unattunedLauncher = new Item(ConfigItem(config, "Unattuned Launcher")).setCreativeTab(tabMisc).setUnlocalizedName("UnattunedLauncher").setFull3D().setMaxStackSize(1)
				.setTextureName(modID + ":UnattunedLauncher");
	}
}
