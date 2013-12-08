package moreminecraft;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import moreminecraft.blocks.BasicBlock;
import moreminecraft.blocks.Beehive;
import moreminecraft.blocks.BlockChocolateCake;
import moreminecraft.blocks.BlockGem;
import moreminecraft.blocks.BlockIronTrapDoor;
import moreminecraft.blocks.BlockOreNether;
import moreminecraft.blocks.Crop;
import moreminecraft.entities.EntityBakedPotatoLaunched;
import moreminecraft.entities.EntityDiamondEnderpearl;
import moreminecraft.entities.EntityPoisonPotatoLaunched;
import moreminecraft.entities.EntityPotatoLaunched;
import moreminecraft.generators.WorldGeneratorMoreMinecraft;
import moreminecraft.items.ArrowLauncher;
import moreminecraft.items.EnderStaff;
import moreminecraft.items.ItemArmorMod;
import moreminecraft.items.ItemArmorRedstoneMod;
import moreminecraft.items.ItemBattleAxeMod;
import moreminecraft.items.ItemDiamondEnderPearl;
import moreminecraft.items.ItemFoodMod;
import moreminecraft.items.ItemKnifeMod;
import moreminecraft.items.ItemMultitoolMod;
import moreminecraft.items.ItemSeedFoodMod;
import moreminecraft.items.PotatoLauncher;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemFood;
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

@Mod(modid = MoreMinecraft.modID, name = "More Minecraft!", version = "2.0.0")
@NetworkMod(clientSideRequired = true)
public class MoreMinecraft {
	@SidedProxy(clientSide = "moreminecraft.ClientProxy", serverSide = "moreminecraft.CommonProxy")
	public static CommonProxy proxy;
	public static final String modID = "moreminecraft";
	public static CreativeTabs tabMisc = new CreativeTabMoreMinecraft("tabMoreMinecraftMisc");
	public static CreativeTabs tabTools = new CreativeTabMoreMinecraft("tabMoreMinecraftTools");
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
	public static Item MultitoolGSaph;
	public static Item MultitoolBSaph;
	public static Item MultitoolYSaph;
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
	public static Item Chain;
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
	public static Item leggingsEnd;
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
	public static Item EnderStaff;
	public static Item diamondEnderpearl;
	public static Item chipTeleportation;
	public static Item antiFood;
	public static Item pickaxeQuartz;
	public static Item axeQuartz;
	public static Item hoeQuartz;
	public static Item shovelQuartz;
	public static Item swordQuartz;
	public static Item helmetQuartz;
	public static Item plateQuartz;
	public static Item legsQuartz;
	public static Item bootsQuartz;
	public static Item MultiToolQuartz;
	public static Item QuartzIngot;
	public static Item PotatoLauncher;
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
	public static Item Cupcake;
	public static Item chipHeater;
	public static Item scubaHelmet;
	public static Item scubaTank;
	public static Item jumpBoots;
	public static Item UnattunedLauncher;
	public static Item ArrowLauncher;
	public static Item legsSwiftness;
	public static Item Motor;
	public static Item itemChocolateCake;
	public static Item battleaxeWood;
	public static Item battleaxeStone;
	public static Item battleaxeIron;
	public static Item battleaxeGold;
	public static Item battleaxeDiamond;
	public static Item battleaxeEmerald;
	public static Item battleaxeObsidian;
	public static Item battleaxeRuby;
	public static Item battleaxeBSaph;
	public static Item battleaxeGSaph;
	public static Item battleaxeYSaph;
	public static Item battleaxeSteel;
	public static Item battleaxeTitanium;
	public static Item battleaxeEndium;
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
	public static Item knifeBSaph;
	public static Item knifeGSaph;
	public static Item knifeYSaph;
	public static Item knifeSteel;
	public static Item knifeTitanium;
	public static Item knifeEndium;
	public static Item knifeQuartz;
	public static Item knifeCopper;
	public static Item knifeTin;
	public static Item knifeBronze;
	private static int blockBaseID = 3000;
	private static int itemBaseID = 11111;
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

	private void register() {
		for (Field f : this.getClass().getFields()) {
			if (Modifier.isStatic(f.getModifiers())) {
				Object obj;
				try {
					obj = f.get(this);
					if (obj instanceof Block) {
						GameRegistry.registerBlock((Block) obj, ((Block) obj).getUnlocalizedName());
					} else if (obj instanceof Item) {
						GameRegistry.registerItem((Item) obj, ((Item) obj).getUnlocalizedName());
					}
				} catch (IllegalArgumentException e) {
				} catch (IllegalAccessException e) {
				}
			}
		}
	}

	public static int ConfigBlock(Configuration config, String name) {
		return config.getBlock(name, blockBaseID++).getInt();
	}

	public static int ConfigItem(Configuration config, String name) {
		return config.getItem(name, itemBaseID++).getInt();
	}

	public static void crafting() {
		//MISC
		GameRegistry.addShapelessRecipe(new ItemStack(butter), new ItemStack(Item.bucketMilk));
		GameRegistry.addShapelessRecipe(new ItemStack(bread_butter), new ItemStack(butter), new ItemStack(Item.bread));
		GameRegistry.addShapelessRecipe(new ItemStack(bread_honey), new ItemStack(honey), new ItemStack(Item.bread));
		GameRegistry.addShapelessRecipe(new ItemStack(enderium, 9), new ItemStack(enderiumBlock));
		GameRegistry.addShapelessRecipe(new ItemStack(Ruby, 9), new ItemStack(rubyBlock));
		GameRegistry.addShapelessRecipe(new ItemStack(GSaph, 9), new ItemStack(GSaphBlock));
		GameRegistry.addShapelessRecipe(new ItemStack(YSaph, 9), new ItemStack(YSaphBlock));
		GameRegistry.addShapelessRecipe(new ItemStack(BSaph, 9), new ItemStack(BSaphBlock));
		GameRegistry.addShapelessRecipe(new ItemStack(Chain, 4), new ItemStack(Item.ingotIron));
		GameRegistry.addShapelessRecipe(new ItemStack(Chain, 8), new ItemStack(steel));
		GameRegistry.addShapelessRecipe(new ItemStack(enderiumPlate), new ItemStack(enderium), new ItemStack(obsidianPlate));
		GameRegistry.addRecipe(new ItemStack(obsidianPlate), "XXX", "XXX", "XXX", 'X', new ItemStack(Block.obsidian));
		GameRegistry.addRecipe(new ItemStack(YSaphBlock), "XXX", "XXX", "XXX", 'X', new ItemStack(YSaph));
		GameRegistry.addRecipe(new ItemStack(BSaphBlock), "XXX", "XXX", "XXX", 'X', new ItemStack(BSaph));
		GameRegistry.addRecipe(new ItemStack(GSaphBlock), "XXX", "XXX", "XXX", 'X', new ItemStack(GSaph));
		GameRegistry.addRecipe(new ItemStack(rubyBlock), "XXX", "XXX", "XXX", 'X', new ItemStack(Ruby));
		GameRegistry.addRecipe(new ItemStack(enderiumBlock), "XXX", "XXX", "XXX", 'X', new ItemStack(enderium));
		GameRegistry.addRecipe(new ItemStack(quartzBlock), "XXX", "XXX", "XXX", 'X', new ItemStack(QuartzIngot));
		GameRegistry.addRecipe(new ItemStack(tinBlock), "XXX", "XXX", "XXX", 'X', new ItemStack(tinIngot));
		GameRegistry.addRecipe(new ItemStack(copperBlock), "XXX", "XXX", "XXX", 'X', new ItemStack(copperIngot));
		GameRegistry.addRecipe(new ItemStack(bronzeBlock), "XXX", "XXX", "XXX", 'X', new ItemStack(bronzeIngot));
		GameRegistry.addShapelessRecipe(new ItemStack(copperIngot, 9), new ItemStack(copperBlock));
		GameRegistry.addShapelessRecipe(new ItemStack(tinIngot, 9), new ItemStack(tinBlock));
		GameRegistry.addShapelessRecipe(new ItemStack(bronzeIngot, 9), new ItemStack(bronzeBlock));
		GameRegistry.addShapelessRecipe(new ItemStack(bronzeIngot, 2), new ItemStack(tinIngot), new ItemStack(copperIngot));
		GameRegistry.addRecipe(new ItemStack(titaniumBlock), "XXX", "XXX", "XXX", 'X', new ItemStack(titanium));
		GameRegistry.addRecipe(new ItemStack(steelBlock), "XXX", "XXX", "XXX", 'X', new ItemStack(steel));
		GameRegistry.addRecipe(new ItemStack(carbonatedIronBlock), "XXX", "XXX", "XXX", 'X', new ItemStack(carbonatedIron));
		GameRegistry.addShapelessRecipe(new ItemStack(steel, 9), new ItemStack(steelBlock));
		GameRegistry.addShapelessRecipe(new ItemStack(titanium, 9), new ItemStack(titaniumBlock));
		GameRegistry.addShapelessRecipe(new ItemStack(carbonatedIron, 9), new ItemStack(carbonatedIronBlock));
		GameRegistry.addShapelessRecipe(new ItemStack(QuartzIngot, 9), new ItemStack(quartzBlock));
		GameRegistry.addShapelessRecipe(new ItemStack(Cupcake, 1), new ItemStack(Item.bucketMilk), new ItemStack(Item.sugar), new ItemStack(Item.egg), new ItemStack(Item.wheat));
		GameRegistry.addRecipe(new ItemStack(carbonatedIron), " C ", "CXC", " C ", 'X', new ItemStack(Item.ingotIron), 'C', new ItemStack(Item.coal));
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
		GameRegistry.addShapelessRecipe(new ItemStack(nuggetDiamond, 9), new ItemStack(Item.diamond));
		GameRegistry.addRecipe(new ItemStack(Item.diamond), "XXX", "XXX", "XXX", 'X', new ItemStack(nuggetDiamond));
		GameRegistry.addRecipe(new ItemStack(carrotDiamond), "XXX", "XCX", "XXX", 'X', new ItemStack(nuggetDiamond), 'C', new ItemStack(Item.goldenCarrot));
		GameRegistry.addRecipe(new ItemStack(goggleLens), " X ", "XCX", " X ", 'X', new ItemStack(Item.ingotIron), 'C', new ItemStack(Block.glass));
		GameRegistry.addRecipe(new ItemStack(chipVision), "CXC", "XVX", "CXC", 'X', new ItemStack(Item.redstone), 'C', new ItemStack(Item.ingotIron), 'V', new ItemStack(carrotDiamond));
		GameRegistry.addRecipe(new ItemStack(helmetGogglesVision, 1), "   ", "XCX", "   ", 'X', new ItemStack(goggleLens), 'C', new ItemStack(chipVision));
		GameRegistry.addRecipe(new ItemStack(chipDualHearts), "CXC", "XVX", "CXC", 'X', new ItemStack(Item.redstone), 'C', new ItemStack(Item.ingotIron), 'V', new ItemStack(Item.appleGold, 1, 1));
		GameRegistry.addRecipe(new ItemStack(plateDualHearts, 1), "C C", " X ", "C C", 'X', new ItemStack(chipDualHearts), 'C', new ItemStack(Chain));
		GameRegistry.addRecipe(new ItemStack(chipTeleportation), "CXC", "XVX", "CXC", 'X', new ItemStack(Item.redstone), 'C', new ItemStack(Item.ingotIron), 'V', new ItemStack(diamondEnderpearl, 1));
		GameRegistry.addRecipe(new ItemStack(diamondEnderpearl), "XXX", "XCX", "XXX", 'X', new ItemStack(nuggetDiamond), 'C', new ItemStack(Item.enderPearl));
		GameRegistry.addRecipe(new ItemStack(EnderStaff), " A ", " B ", " C ", 'A', new ItemStack(diamondEnderpearl), 'B', new ItemStack(chipTeleportation), 'C', new ItemStack(Item.stick));
		GameRegistry.addRecipe(new ItemStack(chipEject), "CXC", "XVX", "CXC", 'X', new ItemStack(Item.redstone), 'C', new ItemStack(Item.ingotIron), 'V', new ItemStack(Block.pistonBase, 1));
		GameRegistry.addRecipe(new ItemStack(UnattunedLauncher, 1), "CCC", "BXV", "CCC", 'X', new ItemStack(Item.redstone), 'C', new ItemStack(Item.ingotIron), 'V', new ItemStack(chipEject, 1), 'B',
				new ItemStack(Block.stoneButton));
		GameRegistry.addRecipe(new ItemStack(UnattunedLauncher, 1), "CCC", "VXB", "CCC", 'X', new ItemStack(Item.redstone), 'C', new ItemStack(Item.ingotIron), 'V', new ItemStack(chipEject, 1), 'B',
				new ItemStack(Block.stoneButton));
		GameRegistry.addRecipe(new ItemStack(QuartzIngot), " C ", "CXC", " C ", 'X', new ItemStack(Item.ingotIron), 'C', new ItemStack(Item.netherQuartz));
		GameRegistry.addRecipe(new ItemStack(chipHeater), "CXC", "XVX", "CXC", 'X', new ItemStack(Item.redstone), 'C', new ItemStack(Item.ingotIron), 'V', new ItemStack(Block.blockRedstone, 1));
		GameRegistry.addRecipe(new ItemStack(scubaHelmet, 1), "CXC", "CVC", "   ", 'X', new ItemStack(chipHeater), 'C', new ItemStack(Item.ingotIron), 'V', new ItemStack(Block.glass, 1));
		GameRegistry.addRecipe(new ItemStack(jumpBoots, 1), "   ", "V V", "C C", 'C', new ItemStack(chipEject), 'V', new ItemStack(Block.cobblestone, 1));
		GameRegistry.addRecipe(new ItemStack(legsSwiftness, 1), "VAV", "C C", "V V", 'A', new ItemStack(chipDualHearts), 'V', new ItemStack(Item.ingotIron, 1), 'C', new ItemStack(Motor));
		GameRegistry.addRecipe(new ItemStack(Motor, 1), "VV ", "AAV", "VV ", 'V', new ItemStack(Item.ingotIron, 1), 'A', new ItemStack(Item.redstone));
		GameRegistry.addRecipe(new ItemStack(Motor, 1), " VV", "VAA", " VV", 'V', new ItemStack(Item.ingotIron, 1), 'A', new ItemStack(Item.redstone));
		GameRegistry.addShapelessRecipe(new ItemStack(PotatoLauncher, 1), new ItemStack(Item.potato), new ItemStack(UnattunedLauncher));
		GameRegistry.addShapelessRecipe(new ItemStack(PotatoLauncher, 1), new ItemStack(Item.bakedPotato), new ItemStack(UnattunedLauncher));
		GameRegistry.addShapelessRecipe(new ItemStack(PotatoLauncher, 1), new ItemStack(Item.poisonousPotato), new ItemStack(UnattunedLauncher));
		GameRegistry.addShapelessRecipe(new ItemStack(ArrowLauncher, 1), new ItemStack(Item.arrow), new ItemStack(UnattunedLauncher));
		GameRegistry.addRecipe(new ItemStack(itemChocolateCake, 1), "AAA", "BCB", "DED", 'A', new ItemStack(Item.bucketMilk, 1), 'B', new ItemStack(Item.sugar), 'C', new ItemStack(Item.egg), 'D',
				new ItemStack(Item.wheat), 'E', new ItemStack(Item.dyePowder, 1, 3));
		GameRegistry.addRecipe(new ItemStack(battleaxeDiamond), "XXX", "XCX", " C ", 'X', new ItemStack(Item.diamond, 1, 0), 'C', new ItemStack(Item.stick, 1, 0));
		GameRegistry.addRecipe(new ItemStack(battleaxeGold), "XXX", "XCX", " C ", 'X', new ItemStack(Item.ingotGold, 1, 0), 'C', new ItemStack(Item.stick, 1, 0));
		GameRegistry.addRecipe(new ItemStack(battleaxeIron), "XXX", "XCX", " C ", 'X', new ItemStack(Item.ingotIron, 1, 0), 'C', new ItemStack(Item.stick, 1, 0));
		GameRegistry.addRecipe(new ItemStack(battleaxeStone), "XXX", "XCX", " C ", 'X', new ItemStack(Block.cobblestone, 1, 0), 'C', new ItemStack(Item.stick, 1, 0));
		GameRegistry.addRecipe(new ItemStack(battleaxeWood), "XXX", "XCX", " C ", 'X', new ItemStack(Block.planks, 1, 0), 'C', new ItemStack(Item.stick, 1, 0));
		GameRegistry.addRecipe(new ItemStack(knifeWood), " X ", " C ", 'X', new ItemStack(Block.planks, 1, 0), 'C', new ItemStack(Item.stick, 1, 0));
		GameRegistry.addRecipe(new ItemStack(knifeStone), " X ", " C ", 'X', new ItemStack(Block.cobblestone, 1, 0), 'C', new ItemStack(Item.stick, 1, 0));
		GameRegistry.addRecipe(new ItemStack(knifeIron), " X ", " C ", 'X', new ItemStack(Item.ingotIron, 1, 0), 'C', new ItemStack(Item.stick, 1, 0));
		GameRegistry.addRecipe(new ItemStack(knifeGold), " X ", " C ", 'X', new ItemStack(Item.ingotGold, 1, 0), 'C', new ItemStack(Item.stick, 1, 0));
		GameRegistry.addRecipe(new ItemStack(knifeDiamond), " X ", " C ", 'X', new ItemStack(Item.diamond, 1, 0), 'C', new ItemStack(Item.stick, 1, 0));
		GameRegistry.addRecipe(new ItemStack(ironTrapDoor, 2), "XXX", "XXX", 'X', new ItemStack(Item.ingotIron, 1, 0));
	}

	public static void items(Configuration config) {
		honey = new Item(ConfigItem(config, "Honey")).setUnlocalizedName("honey_item").setCreativeTab(tabMisc);
		butter = new Item(ConfigItem(config, "Butter")).setUnlocalizedName("butter").setCreativeTab(tabMisc);
		bread_butter = new ItemFoodMod(ConfigItem(config, "Butter Bread"), 8, 13F, false).setUnlocalizedName("bread_butter");
		bread_honey = new ItemFoodMod(ConfigItem(config, "Honey Bread"), 8, 13F, false).setUnlocalizedName("bread_honey");
		obsidianPlate = new Item(ConfigItem(config, "Obsidian Plate")).setUnlocalizedName("Obsidian_Plate").setCreativeTab(tabMisc);
		Ruby = new Item(ConfigItem(config, "Ruby")).setUnlocalizedName("SaphR").setCreativeTab(tabMisc);
		BSaph = new Item(ConfigItem(config, "Blue Sapphire")).setUnlocalizedName("SaphB").setCreativeTab(tabMisc);
		GSaph = new Item(ConfigItem(config, "Green Sapphire")).setUnlocalizedName("SaphG").setCreativeTab(tabMisc);
		YSaph = new Item(ConfigItem(config, "Yellow Sapphire")).setUnlocalizedName("SaphY").setCreativeTab(tabMisc);
		steel = new Item(ConfigItem(config, "Steel")).setUnlocalizedName("ingotSteel").setCreativeTab(tabMisc);
		titanium = new Item(ConfigItem(config, "Titanium")).setUnlocalizedName("ingotTitanium").setCreativeTab(tabMisc);
		carbonatedIron = new Item(ConfigItem(config, "Carbonated Iron")).setUnlocalizedName("ingotCarbonatedIron").setCreativeTab(tabMisc);
		Chain = new Item(ConfigItem(config, "Chain")).setUnlocalizedName("chain").setCreativeTab(tabMisc);
		helmetGogglesVision = new ItemArmorRedstoneMod(ConfigItem(config, "Goggles of Vision"), armorInfinite, proxy.addArmor("goggles"), 0, "goggles_1").setUnlocalizedName("gogglesVision");
		carrotDiamond = new ItemFoodMod(ConfigItem(config, "Diamond Carrot"), 12, 16.7F, false).setUnlocalizedName("carrotDiamond");
		nuggetDiamond = new Item(ConfigItem(config, "Diamond Nugget")).setUnlocalizedName("diamondNugget").setCreativeTab(tabMisc);
		goggleLens = new Item(ConfigItem(config, "Goggle Lens")).setUnlocalizedName("lens").setCreativeTab(tabMisc);
		chipVision = new Item(ConfigItem(config, "Chipset of Vision")).setUnlocalizedName("chipVision").setCreativeTab(tabMisc);
		turnipCrop = new Crop(ConfigBlock(config, "Turnip Crop"), true).setUnlocalizedName("turnips");
		cornCrop = new Crop(ConfigBlock(config, "Corn Crop"), false).setUnlocalizedName("corn");
		turnip = new ItemSeedFoodMod(ConfigItem(config, "Turnip"), 2, 0.5F, turnipCrop.blockID, Block.tilledField.blockID).setUnlocalizedName("turnip");
		turnipCooked = new ItemFoodMod(ConfigItem(config, "Cooked Turnip"), 4, 2F, false).setUnlocalizedName("turnipCooked").setCreativeTab(tabMisc);
		corn = new ItemSeedFoodMod(ConfigItem(config, "Corn"), 4, 0.9F, cornCrop.blockID, Block.tilledField.blockID).setUnlocalizedName("corn");
		enderium = new Item(ConfigItem(config, "Enderium")).setUnlocalizedName("enderium").setCreativeTab(tabMisc);
		enderiumPlate = new Item(ConfigItem(config, "Enderium Plate")).setUnlocalizedName("enderiumPlate").setCreativeTab(tabMisc);
		chipDualHearts = new Item(ConfigItem(config, "Chipset of Better Health")).setUnlocalizedName("chipMoreHealth").setCreativeTab(tabMisc);
		plateDualHearts = new ItemArmorRedstoneMod(ConfigItem(config, "Plating of Dual rts"), armorInfinite, proxy.addArmor("moreHealth"), 1, "moreHealth_1").setUnlocalizedName("plateMoreHealth")
				.setMaxDamage(72000);
		antiFood = new ItemFood(ConfigItem(config, "antiFood"), -20, -20F, false).setAlwaysEdible().setUnlocalizedName(null).setCreativeTab(null);
		EnderStaff = new EnderStaff(ConfigItem(config, "Ender Staff")).setUnlocalizedName("enderStaff").setCreativeTab(tabMisc).setFull3D();
		diamondEnderpearl = new ItemDiamondEnderPearl(ConfigItem(config, "Diamond Enderpearl")).setUnlocalizedName("diamondEnderpearl").setCreativeTab(tabMisc);
		chipTeleportation = new Item(ConfigItem(config, "Chipset of Teleportation")).setUnlocalizedName("chipTeleportation").setCreativeTab(tabMisc);
		PotatoLauncher = new PotatoLauncher(ConfigItem(config, "Potato Launcher")).setCreativeTab(tabMisc).setUnlocalizedName("PotatoLauncher").setFull3D();
		chipEject = new Item(ConfigItem(config, "Chipset of Ejection")).setUnlocalizedName("chipEject").setCreativeTab(tabMisc);
		QuartzIngot = new Item(ConfigItem(config, "Quartz Ingot")).setUnlocalizedName("quartzIngot").setCreativeTab(tabMisc);
		Cupcake = new ItemFoodMod(ConfigItem(config, "Cupcake"), 6, 0.9F, false).setUnlocalizedName("Cupcake");
		chipHeater = new Item(ConfigItem(config, "Chipset of Electrolyzing")).setUnlocalizedName("chipHeater").setCreativeTab(tabMisc);
		scubaHelmet = new ItemArmorRedstoneMod(ConfigItem(config, "Scuba Helmet"), armorInfinite, proxy.addArmor("scuba"), 0, "scuba_1").setUnlocalizedName("scubaHelmet");
		jumpBoots = new ItemArmorRedstoneMod(ConfigItem(config, "Jump Boots"), armorInfinite, proxy.addArmor("jumpAssist"), 3, "jumpAssist_1").setUnlocalizedName("jumpBoots");
		ArrowLauncher = new ArrowLauncher(ConfigItem(config, "Arrow Launcher")).setCreativeTab(tabMisc).setUnlocalizedName("ArrowLauncher").setFull3D();
		legsSwiftness = new ItemArmorRedstoneMod(ConfigItem(config, "Leggings of Swiftness"), armorInfinite, proxy.addArmor("swiftness"), 2, "swiftness_2").setUnlocalizedName("legsSwiftness");
		Motor = new Item(ConfigItem(config, "Motor")).setCreativeTab(tabMisc).setUnlocalizedName("Motor");
		MultitoolWood = new ItemMultitoolMod(ConfigItem(config, "Wood Multitool"), EnumToolMaterial.WOOD).setUnlocalizedName("WPaxle");
		MultitoolStone = new ItemMultitoolMod(ConfigItem(config, "Stone Multitool"), EnumToolMaterial.STONE).setUnlocalizedName("SPaxle");
		MultitoolIron = new ItemMultitoolMod(ConfigItem(config, "Iron Multitool"), EnumToolMaterial.IRON).setUnlocalizedName("IPaxle");
		MultitoolGold = new ItemMultitoolMod(ConfigItem(config, "Gold Multitool"), EnumToolMaterial.GOLD).setUnlocalizedName("GPaxle");
		MultitoolDiamond = new ItemMultitoolMod(ConfigItem(config, "Diamond Multitool"), EnumToolMaterial.EMERALD).setUnlocalizedName("DPaxle");
		battleaxeWood = new ItemBattleAxeMod(ConfigItem(config, "Wood Battleaxe"), EnumToolMaterial.WOOD).setUnlocalizedName("battleaxeWood");
		battleaxeStone = new ItemBattleAxeMod(ConfigItem(config, "Stone Battleaxe"), EnumToolMaterial.STONE).setUnlocalizedName("battleaxeStone");
		battleaxeIron = new ItemBattleAxeMod(ConfigItem(config, "Iron Battleaxe"), EnumToolMaterial.IRON).setUnlocalizedName("battleaxeIron");
		battleaxeGold = new ItemBattleAxeMod(ConfigItem(config, "Gold Battleaxe"), EnumToolMaterial.GOLD).setUnlocalizedName("battleaxeGold");
		battleaxeDiamond = new ItemBattleAxeMod(ConfigItem(config, "Diamond Battleaxe"), EnumToolMaterial.EMERALD).setUnlocalizedName("battleaxeDiamond");
		knifeWood = new ItemKnifeMod(ConfigItem(config, "Wood Knife"), EnumToolMaterial.WOOD).setUnlocalizedName("knifeWood");
		knifeStone = new ItemKnifeMod(ConfigItem(config, "Stone Knife"), EnumToolMaterial.STONE).setUnlocalizedName("knifeStone");
		knifeIron = new ItemKnifeMod(ConfigItem(config, "Iron Knife"), EnumToolMaterial.IRON).setUnlocalizedName("knifeIron");
		knifeGold = new ItemKnifeMod(ConfigItem(config, "Gold Knife"), EnumToolMaterial.GOLD).setUnlocalizedName("knifeGold");
		knifeDiamond = new ItemKnifeMod(ConfigItem(config, "Diamond Knife"), EnumToolMaterial.EMERALD).setUnlocalizedName("knifeDiamond");
		copperIngot = new Item(ConfigItem(config, "Copper Ingot")).setUnlocalizedName("copperIngot").setCreativeTab(tabMisc);
		tinIngot = new Item(ConfigItem(config, "Tin Ingot")).setUnlocalizedName("tinIngot").setCreativeTab(tabMisc);
		bronzeIngot = new Item(ConfigItem(config, "Bronze Ingot")).setUnlocalizedName("ingotBronze").setCreativeTab(tabMisc);
		rubyBlock = new BasicBlock(ConfigBlock(config, "Ruby Block")).setUnlocalizedName("RSaphBlock");
		BSaphBlock = new BasicBlock(ConfigBlock(config, "Blue Sapphire Block")).setUnlocalizedName("BSaphBlock");
		GSaphBlock = new BasicBlock(ConfigBlock(config, "Green Sapphire Block")).setUnlocalizedName("GSaphBlock");
		YSaphBlock = new BasicBlock(ConfigBlock(config, "Yellow Sapphire Block")).setUnlocalizedName("YSaphBlock");
		steelBlock = new BasicBlock(ConfigBlock(config, "Steel Block")).setUnlocalizedName("blockSteel");
		titaniumBlock = new BasicBlock(ConfigBlock(config, "Titanium Block")).setUnlocalizedName("blockTitanium");
		oreTitanium = new BasicBlock(ConfigBlock(config, "Titanium Ore")).setUnlocalizedName("oreTitanium");
		carbonatedIronBlock = new BasicBlock(ConfigBlock(config, "Carbonated Iron Block")).setUnlocalizedName("carbonatedIronBlock");
		oreEnderium = new BlockGem(ConfigBlock(config, "Enderium Ore"), enderium.itemID).setUnlocalizedName("endiumOre");
		enderiumBlock = new BlockGem(ConfigBlock(config, "Enderium Block"), enderium.itemID).setUnlocalizedName("blockEnderium");
		oreDiamondNether = new BlockGem(ConfigBlock(config, "Nether Diamond Ore"), Item.diamond.itemID, 2).setUnlocalizedName("oreDiamondNether");
		oreDiamondEnd = new BlockGem(ConfigBlock(config, "End Diamond Ore"), 4, Item.diamond.itemID).setUnlocalizedName("oreDiamondEnd");
		oreCoalNether = new BlockGem(ConfigBlock(config, "Nether Coal Ore"), 2, Item.coal.itemID).setUnlocalizedName("oreCoalNether");
		oreCoalEnd = new BlockGem(ConfigBlock(config, "End Coal Ore"), 4, Item.coal.itemID).setUnlocalizedName("oreCoalEnd");
		oreIronNether = new BasicBlock(ConfigBlock(config, "Nether Iron Ore")).setUnlocalizedName("oreIronNether");
		oreIronEnd = new BasicBlock(ConfigBlock(config, "End Iron Ore")).setUnlocalizedName("oreIronEnd");
		oreGoldNether = new BasicBlock(ConfigBlock(config, "Nether Gold Ore")).setUnlocalizedName("oreGoldNether");
		oreGoldEnd = new BasicBlock(ConfigBlock(config, "End Gold Ore")).setUnlocalizedName("oreGoldEnd");
		oreRedstoneNether = new BlockGem(ConfigBlock(config, "Nether Redstone Ore"), 12, Item.redstone.itemID).setUnlocalizedName("oreRedstoneNether");
		oreRedstoneEnd = new BlockGem(ConfigBlock(config, "End Redstone Ore"), 24, Item.redstone.itemID).setUnlocalizedName("oreRedstoneEnd");
		oreLapisNether = new BlockOreNether(ConfigBlock(config, "Nether Lapis Ore"), Item.dyePowder.itemID, 12, 4).setUnlocalizedName("oreLapisNether");
		oreLapisEnd = new BlockOreNether(ConfigBlock(config, "End Lapis Ore"), Item.dyePowder.itemID, 24, 4).setUnlocalizedName("oreLapisEnd");
		oreTitaniumNether = new BasicBlock(ConfigBlock(config, "Nether Titanium Ore")).setUnlocalizedName("oreTitaniumNether");
		oreTitaniumEnd = new BasicBlock(ConfigBlock(config, "End Titanium Ore")).setUnlocalizedName("oreTitaniumEnd");
		beeHive = new Beehive(ConfigBlock(config, "BeeHive")).setUnlocalizedName("beeHive");
		oreRuby = new BlockGem(ConfigBlock(config, "Ruby Ore"), 1, 1, Ruby.itemID).setUnlocalizedName("oreRuby");
		oreBSaph = new BlockGem(ConfigBlock(config, "Blue Sapphire Ore"), 1, BSaph.itemID).setUnlocalizedName("oreBSaph");
		oreGSaph = new BlockGem(ConfigBlock(config, "Green Sapphire Ore"), 1, 1, GSaph.itemID).setUnlocalizedName("oreGSaph");
		oreYSaph = new BlockGem(ConfigBlock(config, "Yellow Sapphire Ore"), 1, 1, YSaph.itemID).setUnlocalizedName("oreYSaph");
		oreRubyNether = new BlockGem(ConfigBlock(config, "Nether Ruby Ore"), 1, 2, Ruby.itemID).setUnlocalizedName("oreRubyNether");
		oreRubyEnd = new BlockGem(ConfigBlock(config, "End Ruby Ore"), 1, 4, Ruby.itemID).setUnlocalizedName("oreRubyEnd");
		oreGSaphNether = new BlockGem(ConfigBlock(config, "Nether Green Sapphire Ore"), 1, 1, GSaph.itemID).setUnlocalizedName("oreGSaphNether");
		oreGSaphEnd = new BlockGem(ConfigBlock(config, "End Green Sapphire Ore"), 1, 4, GSaph.itemID).setUnlocalizedName("oreGSaphEnd");
		oreBSaphNether = new BlockGem(ConfigBlock(config, "Nether Blue Sapphire Ore"), 2, BSaph.itemID).setUnlocalizedName("oreBSaphNether");
		oreBSaphEnd = new BlockGem(ConfigBlock(config, "End Blue Sapphire Ore"), 4, BSaph.itemID).setUnlocalizedName("oreBSaphEnd");
		oreYSaphNether = new BlockGem(ConfigBlock(config, "Nether Yellow Sapphire Ore"), 1, 2, YSaph.itemID).setUnlocalizedName("oreYSaphNether");
		oreYSaphEnd = new BlockGem(ConfigBlock(config, "End Yellow Sapphire Ore"), 1, 4, YSaph.itemID).setUnlocalizedName("oreYSaphEnd");
		quartzBlock = new BasicBlock(ConfigBlock(config, "Quartz Block")).setUnlocalizedName("blockQuartz");
		copperBlock = new BasicBlock(ConfigBlock(config, "Copper Block")).setUnlocalizedName("blockCopper");
		tinBlock = new BasicBlock(ConfigBlock(config, "Tin Block")).setUnlocalizedName("blockTin");
		bronzeBlock = new BasicBlock(ConfigBlock(config, "Bronze Block")).setUnlocalizedName("blockBronze");
		copperOre = new BasicBlock(ConfigBlock(config, "Copper Ore")).setUnlocalizedName("oreCopper");
		tinOre = new BasicBlock(ConfigBlock(config, "Tin Ore")).setUnlocalizedName("oreTin");
		copperOreEnd = new BasicBlock(ConfigBlock(config, "End Copper Ore")).setUnlocalizedName("oreCopperEnd");
		tinOreEnd = new BasicBlock(ConfigBlock(config, "End Tin Ore")).setUnlocalizedName("oreTinEnd");
		copperOreNether = new BasicBlock(ConfigBlock(config, "Nether Copper Ore")).setUnlocalizedName("oreCopperNether");
		tinOreNether = new BasicBlock(ConfigBlock(config, "Nether Tin Ore")).setUnlocalizedName("oreTinNether");
		chocolateCake = new BlockChocolateCake(ConfigBlock(config, "Chocolate Cake Block")).setHardness(0.5F).setStepSound(Block.soundClothFootstep).setUnlocalizedName("choccake");
		itemChocolateCake = new ItemReed(ConfigItem(config, "Chocolate Cake Item"), chocolateCake).setCreativeTab(tabMisc).setUnlocalizedName("choccake");
		ironTrapDoor = new BlockIronTrapDoor(ConfigBlock(config, "Iron Trapdoor"), Material.iron).setUnlocalizedName("irontrapdoor").setCreativeTab(tabMisc);
		UnattunedLauncher = new Item(ConfigItem(config, "Unattuned Launcher")).setCreativeTab(tabMisc).setUnlocalizedName("UnattunedLauncher").setFull3D().setMaxStackSize(1);
	}

	private static void createArmorSet(Configuration config, Item hpar1, Item cpar1, Item lpar1, Item bpar1, EnumArmorMaterial par1Enum, String layer, String name, Object madeOf, int madeOfMeta) {
		hpar1 = new ItemArmorMod(ConfigItem(config, name + " Helmet"), par1Enum, proxy.addArmor(layer), 0, layer + "_1").setUnlocalizedName("helmet" + layer);
		cpar1 = new ItemArmorMod(ConfigItem(config, name + " Chestplate"), par1Enum, proxy.addArmor(layer), 1, layer + "_1").setUnlocalizedName("chestplate" + layer);
		lpar1 = new ItemArmorMod(ConfigItem(config, name + " Leggings"), par1Enum, proxy.addArmor(layer), 2, layer + "_2").setUnlocalizedName("leggings" + layer);
		bpar1 = new ItemArmorMod(ConfigItem(config, name + " Boots"), par1Enum, proxy.addArmor(layer), 3, layer + "_1").setUnlocalizedName("boots" + layer);
		int made = -1;
		if (madeOf instanceof Block) {
			made = ((Block) madeOf).blockID;
		} else if (madeOf instanceof Item) {
			made = ((Item) madeOf).itemID;
		}
		if (made > 0) {
			GameRegistry.addRecipe(new ItemStack(hpar1), "XXX", "X X", "   ", 'X', new ItemStack(made, 1, madeOfMeta));
			GameRegistry.addRecipe(new ItemStack(cpar1), "X X", "XXX", "XXX", 'X', new ItemStack(made, 1, madeOfMeta));
			GameRegistry.addRecipe(new ItemStack(lpar1), "XXX", "X X", "X X", 'X', new ItemStack(made, 1, madeOfMeta));
			GameRegistry.addRecipe(new ItemStack(bpar1), "   ", "X X", "X X", 'X', new ItemStack(made, 1, madeOfMeta));
		}
	}

	private static void createToolSet(Configuration config, Item pickPar1, Item axePar1, Item shovelPar1, Item hoePar1, Item swordPar1, Item MultitoolPar1, Item BAxePar1, Item knifePar1,
			EnumToolMaterial par1Enum, String material, String name, Object madeOf, int madeOfMeta) {
		pickPar1 = new ItemPickaxe(ConfigItem(config, name + " Pickaxe"), par1Enum).setUnlocalizedName("pickaxe" + material).setCreativeTab(tabTools);
		axePar1 = new ItemAxe(ConfigItem(config, name + " Axe"), par1Enum).setUnlocalizedName("axe" + material).setCreativeTab(tabTools);
		shovelPar1 = new ItemSpade(ConfigItem(config, name + " Shovel"), par1Enum).setUnlocalizedName("shovel" + material).setCreativeTab(tabTools);
		hoePar1 = new ItemHoe(ConfigItem(config, name + " Hoe"), par1Enum).setUnlocalizedName("hoe" + material).setCreativeTab(tabTools);
		swordPar1 = new ItemSword(ConfigItem(config, name + " Sword"), par1Enum).setUnlocalizedName("sword" + material).setCreativeTab(tabTools);
		MultitoolPar1 = new ItemMultitoolMod(ConfigItem(config, name + " Multitool"), par1Enum).setUnlocalizedName("paxle" + material);
		BAxePar1 = new ItemBattleAxeMod(ConfigItem(config, name + " Battleaxe"), par1Enum).setUnlocalizedName("battleaxe" + material);
		knifePar1 = new ItemKnifeMod(ConfigItem(config, name + " Knife"), par1Enum).setUnlocalizedName("knife" + material);
		int made = -1;
		if (madeOf instanceof Block) {
			made = ((Block) madeOf).blockID;
		} else if (madeOf instanceof Item) {
			made = ((Item) madeOf).itemID;
		}
		if (made > 0) {
			GameRegistry.addRecipe(new ItemStack(pickPar1), "XXX", " C ", " C ", 'X', new ItemStack(made, 1, madeOfMeta), 'C', new ItemStack(Item.stick, 1, 0));
			GameRegistry.addRecipe(new ItemStack(axePar1), "XX ", "XC ", " C ", 'X', new ItemStack(made, 1, madeOfMeta), 'C', new ItemStack(Item.stick, 1, 0));
			GameRegistry.addRecipe(new ItemStack(hoePar1), "XX ", " C ", " C ", 'X', new ItemStack(made, 1, madeOfMeta), 'C', new ItemStack(Item.stick, 1, 0));
			GameRegistry.addRecipe(new ItemStack(shovelPar1), " X ", " C ", " C ", 'X', new ItemStack(made, 1, madeOfMeta), 'C', new ItemStack(Item.stick, 1, 0));
			GameRegistry.addRecipe(new ItemStack(swordPar1), " X ", " X ", " C ", 'X', new ItemStack(made, 1, madeOfMeta), 'C', new ItemStack(Item.stick, 1, 0));
			GameRegistry.addRecipe(new ItemStack(MultitoolPar1), "ABC", " D ", " D ", 'A', new ItemStack(axePar1, 1, 0), 'B', new ItemStack(shovelPar1, 1, 0), 'C', new ItemStack(pickPar1, 1, 0), 'D',
					new ItemStack(Item.stick, 1, 0));
			GameRegistry.addRecipe(new ItemStack(BAxePar1), "XXX", "XCX", " C ", 'X', new ItemStack(made, 1, madeOfMeta), 'C', new ItemStack(Item.stick, 1, 0));
			GameRegistry.addRecipe(new ItemStack(knifePar1), "   ", " X ", " C ", 'X', new ItemStack(made, 1, madeOfMeta), 'C', new ItemStack(Item.stick, 1, 0));
		}
	}

	private static void sets(Configuration config) {
		createArmorSet(config, helmetEmerald, plateEmerald, legsEmerald, bootsEmerald, armorEmerald, "emerald", "Emerald", Item.emerald, 0);
		createArmorSet(config, helmetObsidian, plateObsidian, legsObsidian, bootsObsidian, armorObsidian, "obsidian", "Obsidian", obsidianPlate, 0);
		createArmorSet(config, helmetRuby, plateRuby, legsRuby, bootsRuby, armorCrystal, "ruby", "Ruby", Ruby, 0);
		createArmorSet(config, helmetYellowSaph, plateYellowSaph, legsYellowSaph, bootsYellowSaph, armorCrystal, "saphY", "Yellow Sapphire", YSaph, 0);
		createArmorSet(config, helmetGreenSaph, plateGreenSaph, legsGreenSaph, bootsGreenSaph, armorCrystal, "saphG", "Green Sapphire", GSaph, 0);
		createArmorSet(config, helmetBlueSaph, plateBlueSaph, legsBlueSaph, bootsBlueSaph, armorCrystal, "saphB", "Blue Sapphire", BSaph, 0);
		createArmorSet(config, helmetStone, plateStone, legsStone, bootsStone, armorStone, "stone", "Stone", Block.stone, 0);
		createArmorSet(config, helmetWood, plateWood, legsWood, bootsWood, armorWood, "wood", "Wooden", Block.planks, 0);
		createArmorSet(config, helmetWoodJungle, plateWoodJungle, legsWoodJungle, bootsWoodJungle, armorWood, "wood_jungle", "Wooden", Block.planks, 3);
		createArmorSet(config, helmetWoodSpruce, plateWoodSpruce, legsWoodSpruce, bootsWoodSpruce, armorWood, "wood_spruce", "Wooden", Block.planks, 1);
		createArmorSet(config, helmetWoodBirch, plateWoodBirch, legsWoodBirch, bootsWoodBirch, armorWood, "wood_birch", "Wooden", Block.planks, 2);
		createArmorSet(config, helmetSteel, plateSteel, legsSteel, bootsSteel, armorSteel, "steel", "Steel", steel, 0);
		createArmorSet(config, helmetTitanium, plateTitanium, legsTitanium, bootsTitanium, armorTitanium, "titanium", "Titanium", titanium, 0);
		createArmorSet(config, helmetEnd, plateEnd, leggingsEnd, bootsEnd, armorEnd, "end", "Endium", enderium, 0);
		createArmorSet(config, helmetQuartz, plateQuartz, legsQuartz, bootsQuartz, armorQuartz, "quarts", "Quartz", QuartzIngot, 0);
		createArmorSet(config, helmetCopper, plateCopper, legsCopper, bootsCopper, armorMetal, "copper", "Copper", copperIngot, 0);
		createArmorSet(config, helmetTin, plateTin, legsTin, bootsTin, armorMetal, "tin", "Tin", tinIngot, 0);
		createArmorSet(config, helmetBronze, plateBronze, legsBronze, bootsBronze, armorBronze, "bronze", "Bronze", bronzeIngot, 0);
		createToolSet(config, pickaxeEmerald, axeEmerald, shovelEmerald, hoeEmerald, swordEmerald, MultitoolEmerald, battleaxeEmerald, knifeEmerald, toolEmerald, "Emerald", "Emerald", Item.emerald, 0);
		createToolSet(config, pickaxeObsidian, axeObsidian, shovelObsidian, hoeObsidian, swordObsidian, MultitoolObsidian, battleaxeObsidian, knifeObsidian, toolObsidian, "Obsidian", "Obsidian",
				obsidianPlate, 0);
		createToolSet(config, pickaxeRuby, axeRuby, shovelRuby, hoeRuby, swordRuby, MultitoolRuby, battleaxeRuby, knifeRuby, toolCrystal, "RSaph", "Ruby", Ruby, 0);
		createToolSet(config, pickaxeYellowSaph, axeYellowSaph, shovelYellowSaph, hoeYellowSaph, swordYellowSaph, MultitoolYSaph, battleaxeYSaph, knifeYSaph, toolCrystal, "YSaph", "Yellow Sapphire",
				YSaph, 0);
		createToolSet(config, pickaxeBlueSaph, axeBlueSaph, shovelBlueSaph, hoeBlueSaph, swordBlueSaph, MultitoolBSaph, battleaxeBSaph, knifeBSaph, toolCrystal, "BSaph", "Blue Sapphire", BSaph, 0);
		createToolSet(config, pickaxeGreenSaph, axeGreenSaph, shovelGreenSaph, hoeGreenSaph, swordGreenSaph, MultitoolGSaph, battleaxeGSaph, knifeGSaph, toolCrystal, "GSaph", "Green Sapphire", GSaph,
				0);
		createToolSet(config, pickaxeSteel, axeSteel, shovelSteel, hoeSteel, swordSteel, MultitoolSteel, battleaxeSteel, knifeSteel, toolSteel, "Steel", "Steel", steel, 0);
		createToolSet(config, pickaxeTitanium, axeTitanium, shovelTitanium, hoeTitanium, swordTitanium, MultitoolTitanium, battleaxeTitanium, knifeTitanium, toolTitanium, "Titanium", "Titanium",
				titanium, 0);
		createToolSet(config, pickaxeEnd, axeEnd, shovelEnd, hoeEnd, swordEnd, MultitoolEnd, battleaxeEndium, knifeEndium, toolEnd, "End", "Endium", enderium, 0);
		createToolSet(config, pickaxeQuartz, axeQuartz, shovelQuartz, hoeQuartz, swordQuartz, MultiToolQuartz, battleaxeQuartz, knifeQuartz, toolQuartz, "Quartz", "Quartz", QuartzIngot, 0);
		createToolSet(config, pickaxeCopper, axeCopper, shovelCopper, hoeCopper, swordCopper, MultitoolCopper, battleaxeCopper, knifeCopper, toolMetal, "Copper", "Copper", copperIngot, 0);
		createToolSet(config, pickaxeTin, axeTin, shovelTin, hoeTin, swordTin, MultitoolTin, battleaxeTin, knifeTin, toolMetal, "Tin", "Tin", tinIngot, 0);
		createToolSet(config, pickaxeBronze, axeBronze, shovelBronze, hoeBronze, swordBronze, MultitoolBronze, battleaxeBronze, knifeBronze, toolBronze, "Bronze", "Bronze", bronzeIngot, 0);
	}
}
