package moreminecraft;

import java.lang.reflect.Field;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.ModContainer;
import moreminecraft.blocks.*;
import moreminecraft.entities.*;
import moreminecraft.generators.WorldGeneratorMoreMinecraft;
import moreminecraft.items.*;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.*;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid = MoreMinecraft.modID, name = "More Minecraft!", useMetadata = true)
public class MoreMinecraft {
	@SidedProxy(clientSide = "moreminecraft.ClientProxy", serverSide = "moreminecraft.CommonProxy")
	public static CommonProxy proxy;
	public static final String modID = "moreminecraft";
	public static CreativeTabs tabMisc = new CreativeTabs("tabMoreMinecraftMisc") {
		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {
			return Item.getItemFromBlock(beeHive);
		}
	};
	public static CreativeTabs tabTools = new CreativeTabs("tabMoreMinecraftTools") {
        @Override
        @SideOnly(Side.CLIENT)
        public Item getTabIconItem() {
            return MultitoolRuby;
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
	// CLOTH(5, new int[]{1, 3, 2, 1}, 15),
	// CHAIN(15, new int[]{2, 5, 4, 1}, 12),
	// IRON(15, new int[]{2, 6, 5, 2}, 9),
	// GOLD(7, new int[]{2, 5, 3, 1}, 25),
	// DIAMOND(33, new int[]{3, 8, 6, 3}, 10);
	public static ItemArmor.ArmorMaterial armorEmerald = EnumHelper.addArmorMaterial("EMERALD", 35, new int[] { 3, 10, 7, 4 }, 20);
	public static ItemArmor.ArmorMaterial armorObsidian = EnumHelper.addArmorMaterial("OBSIDIAN", 39, new int[] { 5, 13, 10, 6 }, 3);
	public static ItemArmor.ArmorMaterial armorStone = EnumHelper.addArmorMaterial("STONE", 9, new int[] { 2, 5, 4, 2 }, 4);
	public static ItemArmor.ArmorMaterial armorWood = EnumHelper.addArmorMaterial("WOOD", 5, new int[] { 1, 2, 2, 1 }, 8);
	public static ItemArmor.ArmorMaterial armorCrystal = EnumHelper.addArmorMaterial("CRYSTAL", 25, new int[] { 2, 6, 5, 2 }, 8);
	public static ItemArmor.ArmorMaterial armorSteel = EnumHelper.addArmorMaterial("STEEL", 27, new int[] { 3, 7, 3, 2 }, 7);
	public static ItemArmor.ArmorMaterial armorTitanium = EnumHelper.addArmorMaterial("TITANIUM", 15, new int[] { 2, 6, 5, 2 }, 17);
	public static ItemArmor.ArmorMaterial armorInfinite = EnumHelper.addArmorMaterial("INFINITE", -10000, new int[] { -10000, -10000, -10000, -10000 }, -10000);
	public static ItemArmor.ArmorMaterial armorEnd = EnumHelper.addArmorMaterial("END", 78, new int[] { 10, 26, 20, 12 }, 10);
	public static ItemArmor.ArmorMaterial armorQuartz = EnumHelper.addArmorMaterial("QUARTZ", 25, new int[] { 2, 6, 5, 2 }, 22);
	public static ItemArmor.ArmorMaterial armorMetal = EnumHelper.addArmorMaterial("METAL", 13, new int[] { 2, 5, 4, 2 }, 8);
	public static ItemArmor.ArmorMaterial armorBronze = EnumHelper.addArmorMaterial("BRONZE", 17, new int[] { 3, 6, 4, 2 }, 8);
	//	STONE(1, 131, 4.0F, 1, 5),
	//	IRON(2, 250, 6.0F, 2, 14),
	//	EMERALD(3, 1561, 8.0F, 3, 10),
	//	GOLD(0, 32, 12.0F, 0, 22);
	public static Item.ToolMaterial toolEmerald = EnumHelper.addToolMaterial("EMERALD_GEM", 3, 2341, 10.0F, 4, 18);
	public static Item.ToolMaterial toolObsidian = EnumHelper.addToolMaterial("OBSIDIAN", 3, 3122, 12.5F, 8, 18);
	public static Item.ToolMaterial toolCrystal = EnumHelper.addToolMaterial("CRYSTAL", 2, 780, 6.0F, 2, 14);
	public static Item.ToolMaterial toolSteel = EnumHelper.addToolMaterial("STEEL", 3, 1170, 6.9F, 3, 17);
	public static Item.ToolMaterial toolTitanium = EnumHelper.addToolMaterial("TITANIUM", 2, 250, 6.0F, 2, 18);
	public static Item.ToolMaterial toolEnd = EnumHelper.addToolMaterial("END", 3, 6244, 14F, 16, 19);
	public static Item.ToolMaterial toolQuartz = EnumHelper.addToolMaterial("QUARTZ", 2, 780, 6.0F, 2, 19);
	public static Item.ToolMaterial toolMetal = EnumHelper.addToolMaterial("METAL", 2, 225, 5.5F, 2, 14);
	public static Item.ToolMaterial toolBronze = EnumHelper.addToolMaterial("BRONZE", 2, 650, 6.5F, 2, 15);

	public void entity() {
		EntityRegistry.registerModEntity(EntityDiamondEnderpearl.class, "Diamond_EnderPearl", 0, this, 64, 10, true);
		EntityRegistry.registerModEntity(EntityPotatoLaunched.class, "PotatoThrown", 1, this, 64, 20, true);
		EntityRegistry.registerModEntity(EntityBakedPotatoLaunched.class, "PotatoThrownBaked", 2, this, 64, 20, true);
		EntityRegistry.registerModEntity(EntityPoisonPotatoLaunched.class, "PotatoThrownPoison", 3, this, 64, 20, true);
		//EntityRegistry.registerModEntity(EntityBear.class, "Bear", 4, this, 80, 3, true);
	}

	@EventHandler
	public void Initialization(FMLInitializationEvent event) {
		proxy.register();
	}

	@EventHandler
	public void PreInitialization(FMLPreInitializationEvent event) {
		items();
		sets();
		register();
		crafting();
		entity();
		MinecraftForge.EVENT_BUS.register(new WorldGeneratorMoreMinecraft());
        if(event.getSourceFile().getName().endsWith(".jar") && event.getSide().isClient()){
            try {
                Class.forName("mods.mud.ModUpdateDetector").getDeclaredMethod("registerMod", ModContainer.class, String.class, String.class).invoke(null,
                        FMLCommonHandler.instance().findContainerFor(this),
                        "https://raw.github.com/GotoLink/MoreMinecraft/master/update.xml",
                        "https://raw.github.com/GotoLink/MoreMinecraft/master/changelog.md"
                );
            } catch (Throwable e) {
            }
        }
	}

	private void createArmorSet(String name, ItemArmor.ArmorMaterial par1Enum, String layer, Object madeOf, int madeOfMeta) {
		Item hpar1 = new ItemArmorMod(par1Enum, 0, layer).setUnlocalizedName("helmet" + name).setTextureName(modID + ":armors/helmet" + layer);
		Item cpar1 = new ItemArmorMod(par1Enum, 1, layer).setUnlocalizedName("chestplate" + name).setTextureName(modID + ":armors/chestplate" + layer);
		Item lpar1 = new ItemArmorMod(par1Enum, 2, layer).setUnlocalizedName("leggings" + name).setTextureName(modID + ":armors/leggings" + layer);
		Item bpar1 = new ItemArmorMod(par1Enum, 3, layer).setUnlocalizedName("boots" + name).setTextureName(modID + ":armors/boots" + layer);
		Item made = null;
		if (madeOf instanceof Block) {
			made = Item.getItemFromBlock((Block) madeOf);
		} else if (madeOf instanceof Item) {
			made = (Item) madeOf;
		}
		if (made != null) {
			GameRegistry.addRecipe(new ItemStack(hpar1), "XXX", "X X", 'X', new ItemStack(made, 1, madeOfMeta));
			GameRegistry.addRecipe(new ItemStack(cpar1), "X X", "XXX", "XXX", 'X', new ItemStack(made, 1, madeOfMeta));
			GameRegistry.addRecipe(new ItemStack(lpar1), "XXX", "X X", "X X", 'X', new ItemStack(made, 1, madeOfMeta));
			GameRegistry.addRecipe(new ItemStack(bpar1), "X X", "X X", 'X', new ItemStack(made, 1, madeOfMeta));
		}
		try {
			this.getClass().getField("helmet" + name).set(this, hpar1);
			this.getClass().getField("plate" + name).set(this, cpar1);
			this.getClass().getField("legs" + name).set(this, lpar1);
			this.getClass().getField("boots" + name).set(this, bpar1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void createToolSet(String field, Item.ToolMaterial par1Enum, String material, String name, Object madeOf, int madeOfMeta) {
		Item pick = new ItemPick(par1Enum).setUnlocalizedName("pickaxe" + material).setCreativeTab(tabTools)
				.setTextureName(modID + ":tools/pickaxe" + material);
		Item axe = new ItemHatchet(par1Enum).setUnlocalizedName("axe" + material).setCreativeTab(tabTools).setTextureName(modID + ":tools/axe" + material);
		Item shovel = new ItemSpade(par1Enum).setUnlocalizedName("shovel" + material).setCreativeTab(tabTools).setTextureName(modID + ":tools/shovel" + material);
		Item hoe = new ItemHoe(par1Enum).setUnlocalizedName("hoe" + material).setCreativeTab(tabTools).setTextureName(modID + ":tools/hoe" + material);
		Item sword = new ItemSword(par1Enum).setUnlocalizedName("sword" + material).setCreativeTab(tabTools).setTextureName(modID + ":tools/sword" + material);
		Item multitool = new ItemMultitoolMod(par1Enum).setUnlocalizedName("paxle" + material).setTextureName(modID + ":tools/paxle" + material);
		Item BAxe = new ItemBattleAxeMod(par1Enum).setUnlocalizedName("battleaxe" + material).setTextureName(modID + ":tools/battleaxe" + material);
		Item knife = new ItemKnifeMod(par1Enum).setUnlocalizedName("knife" + material).setTextureName(modID + ":tools/knife" + material);
		Item made = null;
		if (madeOf instanceof Block) {
			made = Item.getItemFromBlock((Block) madeOf);
		} else if (madeOf instanceof Item) {
			made = ((Item) madeOf);
		}
		if (made != null) {
			GameRegistry.addRecipe(new ItemStack(pick), "XXX", " C ", " C ", 'X', new ItemStack(made, 1, madeOfMeta), 'C', Items.stick);
			GameRegistry.addRecipe(new ItemStack(axe), "XX ", "XC ", " C ", 'X', new ItemStack(made, 1, madeOfMeta), 'C', Items.stick);
			GameRegistry.addRecipe(new ItemStack(hoe), "XX ", " C ", " C ", 'X', new ItemStack(made, 1, madeOfMeta), 'C', Items.stick);
			GameRegistry.addRecipe(new ItemStack(shovel), " X ", " C ", " C ", 'X', new ItemStack(made, 1, madeOfMeta), 'C', Items.stick);
			GameRegistry.addRecipe(new ItemStack(sword), " X ", " X ", " C ", 'X', new ItemStack(made, 1, madeOfMeta), 'C', Items.stick);
			GameRegistry.addRecipe(new ItemStack(multitool), "ABC", " D ", " D ", 'A', axe, 'B', shovel, 'C', pick, 'D', Items.stick);
			GameRegistry.addRecipe(new ItemStack(BAxe), "XXX", "XCX", " C ", 'X', new ItemStack(made, 1, madeOfMeta), 'C', Items.stick);
			GameRegistry.addRecipe(new ItemStack(knife), " X ", " C ", 'X', new ItemStack(made, 1, madeOfMeta), 'C', Items.stick);
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
            if (obj instanceof Item) {
                GameRegistry.registerItem((Item) obj, ((Item) obj).getUnlocalizedName());
            }else if (obj instanceof Block && !(obj instanceof BasicBlock)) {
                GameRegistry.registerBlock((Block) obj, ((Block) obj).getUnlocalizedName());
            }
		}
	}

	private void sets() {
		createArmorSet("Emerald", armorEmerald, "emerald", Items.emerald, 0);
		createArmorSet("Obsidian", armorObsidian, "obsidian", materials, 2);
		createArmorSet("Ruby", armorCrystal, "ruby", materials, 20);
		createArmorSet("YellowSaph", armorCrystal, "saphY", materials, 23);
		createArmorSet("GreenSaph", armorCrystal, "saphG", materials, 22);
		createArmorSet("BlueSaph", armorCrystal, "saphB", materials, 21);
		createArmorSet("Stone", armorStone, "stone", Blocks.stone, 0);
		createArmorSet("Wood", armorWood, "wood", Blocks.planks, 0);
		createArmorSet("WoodJungle", armorWood, "wood_jungle", Blocks.planks, 3);
		createArmorSet("WoodSpruce", armorWood, "wood_spruce", Blocks.planks, 1);
		createArmorSet("WoodBirch", armorWood, "wood_birch", Blocks.planks, 2);
		createArmorSet("Steel", armorSteel, "steel", materials, 3);
		createArmorSet("Titanium", armorTitanium, "titanium", materials, 4);
		createArmorSet("End", armorEnd, "end", materials, 24);
		createArmorSet("Quartz", armorQuartz, "quarts", materials, 14);
		createArmorSet("Copper", armorMetal, "copper", materials, 17);
		createArmorSet("Tin", armorMetal, "tin", materials, 18);
		createArmorSet("Bronze", armorBronze, "bronze", materials, 19);
		createToolSet("Emerald", toolEmerald, "Emerald", "Emerald", Items.emerald, 0);
		createToolSet("Obsidian", toolObsidian, "Obsidian", "Obsidian", materials, 2);
		createToolSet("Ruby", toolCrystal, "RSaph", "Ruby", materials, 20);
		createToolSet("YellowSaph", toolCrystal, "YSaph", "Yellow Sapphire", materials, 23);
		createToolSet("BlueSaph", toolCrystal, "BSaph", "Blue Sapphire", materials, 21);
		createToolSet("GreenSaph", toolCrystal, "GSaph", "Green Sapphire", materials, 22);
		createToolSet("Steel", toolSteel, "Steel", "Steel", materials, 3);
		createToolSet("Titanium", toolTitanium, "Titanium", "Titanium", materials, 4);
		createToolSet("End", toolEnd, "End", "Endium", materials, 24);
		createToolSet("Quartz", toolQuartz, "Quartz", "Quartz", materials, 14);
		createToolSet("Copper", toolMetal, "Copper", "Copper", materials, 17);
		createToolSet("Tin", toolMetal, "Tin", "Tin", materials, 18);
		createToolSet("Bronze", toolBronze, "Bronze", "Bronze", materials, 19);
	}

	public static void crafting() {
		//MISC
		GameRegistry.addShapelessRecipe(new ItemStack(materials, 1, 1), Items.milk_bucket);
		GameRegistry.addShapelessRecipe(new ItemStack(foods), new ItemStack(materials, 1, 1), Items.bread);
		GameRegistry.addShapelessRecipe(new ItemStack(foods, 1, 1), materials, Items.bread);
		GameRegistry.addShapelessRecipe(new ItemStack(materials, 9, 24), oreDimensional);
		GameRegistry.addShapelessRecipe(new ItemStack(materials, 9, 20), storage);
		GameRegistry.addShapelessRecipe(new ItemStack(materials, 9, 22), new ItemStack(storage, 1, 2));
		GameRegistry.addShapelessRecipe(new ItemStack(materials, 9, 23), new ItemStack(storage, 1, 3));
		GameRegistry.addShapelessRecipe(new ItemStack(materials, 9, 21), new ItemStack(storage, 1, 1));
		GameRegistry.addShapelessRecipe(new ItemStack(materials, 4, 6), Items.iron_ingot);
		GameRegistry.addShapelessRecipe(new ItemStack(materials, 8, 6), new ItemStack(materials, 1, 3));
		GameRegistry.addShapelessRecipe(new ItemStack(materials, 1, 10), new ItemStack(materials, 1, 24), new ItemStack(materials, 1, 2));
		GameRegistry.addRecipe(new ItemStack(materials, 1, 2), "XXX", "XXX", "XXX", 'X', Blocks.obsidian);
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
		GameRegistry.addShapelessRecipe(new ItemStack(foods, 1, 4), Items.milk_bucket, Items.sugar, Items.egg, Items.wheat);
		GameRegistry.addRecipe(new ItemStack(materials, 1, 5), " C ", "CXC", " C ", 'X', Items.iron_ingot, 'C', Items.coal);
		//FURNACE
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(materials, 1, 5), new ItemStack(materials, 1, 3), 3.5F);
		FurnaceRecipes.smelting().func_151396_a(turnip, new ItemStack(foods, 1, 3), 1.5F);
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(oreDimensional, 1, 2), new ItemStack(Items.iron_ingot, 2), 3F);
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(oreDimensional, 1, 3), new ItemStack(Items.iron_ingot, 4), 6F);
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(oreDimensional, 1, 4), new ItemStack(Items.iron_ingot, 2), 3F);
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(oreDimensional, 1, 5), new ItemStack(Items.iron_ingot, 4), 6F);
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(oreDimensional, 1, 6), new ItemStack(materials, 1, 4), 0.5F);
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(oreDimensional, 1, 7), new ItemStack(materials, 2, 4), 3F);
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(oreDimensional, 1, 8), new ItemStack(materials, 4, 4), 6F);
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(oreDimensional, 1, 9), new ItemStack(materials, 1, 17), 0.5F);
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(oreDimensional, 1, 10), new ItemStack(materials, 2, 17), 3F);
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(oreDimensional, 1, 11), new ItemStack(materials, 4, 17), 6F);
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(oreDimensional, 1, 12), new ItemStack(materials, 1, 18), 0.5F);
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(oreDimensional, 1, 13), new ItemStack(materials, 2, 18), 3F);
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(oreDimensional, 1, 14), new ItemStack(materials, 4, 18), 6F);
		//PAXLES
		GameRegistry.addRecipe(new ItemStack(MultitoolWood), "ABC", " # ", " # ", '#', Items.stick, 'A', Items.wooden_axe, 'B', Items.wooden_shovel, 'C', Items.wooden_pickaxe);
		GameRegistry.addRecipe(new ItemStack(MultitoolStone), "ABC", " # ", " # ", '#', Items.stick, 'A', Items.stone_axe, 'B', Items.stone_shovel, 'C', Items.stone_pickaxe);
		GameRegistry.addRecipe(new ItemStack(MultitoolIron), "ABC", " # ", " # ", '#', Items.stick, 'A', Items.iron_axe, 'B', Items.iron_shovel, 'C', Items.iron_pickaxe);
		GameRegistry.addRecipe(new ItemStack(MultitoolGold), "ABC", " # ", " # ", '#', Items.stick, 'A', Items.golden_axe, 'B', Items.golden_shovel, 'C', Items.golden_pickaxe);
		GameRegistry.addRecipe(new ItemStack(MultitoolDiamond), "ABC", " # ", " # ", '#', Items.stick, 'A', Items.diamond_axe, 'B', Items.diamond_shovel, 'C', Items.diamond_pickaxe);
		//Goggles and fancy gadgets
		GameRegistry.addRecipe(new ItemStack(Items.diamond), "XXX", "XXX", "XXX", 'X', new ItemStack(materials, 1, 7));
		GameRegistry.addRecipe(new ItemStack(foods, 1, 2), "XXX", "XCX", "XXX", 'X', new ItemStack(materials, 1, 7), 'C', Items.golden_carrot);
		GameRegistry.addShapelessRecipe(new ItemStack(materials, 9, 7), Items.diamond);
		GameRegistry.addRecipe(new ItemStack(materials, 1, 8), " X ", "XCX", " X ", 'X', Items.iron_ingot, 'C', Blocks.glass);
		GameRegistry.addRecipe(new ItemStack(materials, 1, 9), "CXC", "XVX", "CXC", 'X', Items.redstone, 'C', Items.iron_ingot, 'V', new ItemStack(foods, 1, 2));
		GameRegistry.addRecipe(new ItemStack(materials, 1, 11), "CXC", "XVX", "CXC", 'X', Items.redstone, 'C', Items.iron_ingot, 'V', Items.golden_apple);
		GameRegistry.addRecipe(new ItemStack(materials, 1, 12), "CXC", "XVX", "CXC", 'X', Items.redstone, 'C', Items.iron_ingot, 'V', diamondEnderpearl);
		GameRegistry.addRecipe(new ItemStack(materials, 1, 13), "CXC", "XVX", "CXC", 'X', Items.redstone, 'C', Items.iron_ingot, 'V', Blocks.piston);
		GameRegistry.addRecipe(new ItemStack(materials, 1, 14), " C ", "CXC", " C ", 'X', Items.iron_ingot, 'C', Items.quartz);
		GameRegistry.addRecipe(new ItemStack(materials, 1, 15), "CXC", "XVX", "CXC", 'X', Items.redstone, 'C', Items.iron_ingot, 'V', Blocks.redstone_block);
		GameRegistry.addRecipe(new ItemStack(materials, 1, 16), "VV ", "AAV", "VV ", 'V', Items.iron_ingot, 'A', Items.redstone);
		GameRegistry.addRecipe(new ItemStack(materials, 1, 16), " VV", "VAA", " VV", 'V', Items.iron_ingot, 'A', Items.redstone);
		GameRegistry.addRecipe(new ItemStack(helmetGogglesVision), "XCX", 'X', new ItemStack(materials, 1, 8), 'C', new ItemStack(materials, 1, 9));
		GameRegistry.addRecipe(new ItemStack(plateDualHearts), "C C", " X ", "C C", 'X', new ItemStack(materials, 1, 11), 'C', new ItemStack(materials, 1, 6));
		GameRegistry.addRecipe(new ItemStack(diamondEnderpearl), "XXX", "XCX", "XXX", 'X', new ItemStack(materials, 1, 7), 'C', Items.ender_pearl);
		GameRegistry.addRecipe(new ItemStack(enderStaff), " A ", " B ", " C ", 'A', diamondEnderpearl, 'B', new ItemStack(materials, 1, 12), 'C', Items.stick);
		GameRegistry.addRecipe(new ItemStack(unattunedLauncher), "CCC", "BXV", "CCC", 'X', Items.redstone, 'C', Items.iron_ingot, 'V', new ItemStack(materials, 1, 13), 'B', Blocks.stone_button);
		GameRegistry.addRecipe(new ItemStack(unattunedLauncher), "CCC", "VXB", "CCC", 'X', Items.redstone, 'C', Items.iron_ingot, 'V', new ItemStack(materials, 1, 13), 'B', Blocks.stone_button);
		GameRegistry.addRecipe(new ItemStack(scubaHelmet), "CXC", "CVC", 'X', new ItemStack(materials, 1, 15), 'C', Items.iron_ingot, 'V', Blocks.glass);
		GameRegistry.addRecipe(new ItemStack(jumpBoots), "V V", "C C", 'C', new ItemStack(materials, 1, 13), 'V', Blocks.cobblestone);
		GameRegistry.addRecipe(new ItemStack(legsSwiftness), "VAV", "C C", "V V", 'A', new ItemStack(materials, 1, 11), 'V', Items.iron_ingot, 'C', new ItemStack(materials, 1, 16));
		GameRegistry.addShapelessRecipe(new ItemStack(potatoLauncher), Items.potato, unattunedLauncher);
		GameRegistry.addShapelessRecipe(new ItemStack(potatoLauncher), Items.baked_potato, unattunedLauncher);
		GameRegistry.addShapelessRecipe(new ItemStack(potatoLauncher), Items.poisonous_potato, unattunedLauncher);
		GameRegistry.addShapelessRecipe(new ItemStack(arrowLauncher), Items.arrow, unattunedLauncher);
		GameRegistry.addRecipe(new ItemStack(itemChocolateCake), "AAA", "BCB", "DED", 'A', Items.milk_bucket, 'B', Items.sugar, 'C', Items.egg, 'D', Items.wheat, 'E', new ItemStack(Items.dye, 1, 3));
		GameRegistry.addRecipe(new ItemStack(battleaxeDiamond), "XXX", "XCX", " C ", 'X', Items.diamond, 'C', Items.stick);
		GameRegistry.addRecipe(new ItemStack(battleaxeGold), "XXX", "XCX", " C ", 'X', Items.gold_ingot, 'C', Items.stick);
		GameRegistry.addRecipe(new ItemStack(battleaxeIron), "XXX", "XCX", " C ", 'X', Items.iron_ingot, 'C', Items.stick);
		GameRegistry.addRecipe(new ItemStack(battleaxeStone), "XXX", "XCX", " C ", 'X', Blocks.cobblestone, 'C', Items.stick);
		GameRegistry.addRecipe(new ItemStack(battleaxeWood), "XXX", "XCX", " C ", 'X', Blocks.planks, 'C', Items.stick);
		GameRegistry.addRecipe(new ItemStack(knifeWood), " X ", " C ", 'X', Blocks.planks, 'C', Items.stick);
		GameRegistry.addRecipe(new ItemStack(knifeStone), " X ", " C ", 'X', Blocks.cobblestone, 'C', Items.stick);
		GameRegistry.addRecipe(new ItemStack(knifeIron), " X ", " C ", 'X', Items.iron_ingot, 'C', Items.stick);
		GameRegistry.addRecipe(new ItemStack(knifeGold), " X ", " C ", 'X', Items.gold_ingot, 'C', Items.stick);
		GameRegistry.addRecipe(new ItemStack(knifeDiamond), " X ", " C ", 'X', Items.diamond, 'C', Items.stick);
		GameRegistry.addRecipe(new ItemStack(ironTrapDoor, 2), "XXX", "XXX", 'X', Items.iron_ingot);
	}

	public static void items() {
		materials = new ItemMaterials("honey", "butter", "obsidianPlate", "ingotSteel", "ingotTitanium", "ingotCarbonatedIron", "chain", "diamondNugget", "lens",
				"chipVision", "enderiumPlate", "chipMoreHealth", "chipTeleportation", "chipEject", "ingotQuartz", "chipHeater", "Motor", "ingotCopper", "ingotTin", "ingotBronze", "SaphR", "SaphB",
				"SaphG", "SaphY", "enderium").setUnlocalizedName("materials.").setTextureName(modID + ":");
		foods = new ItemFoodMod(new String[] { "bread_butter", "bread_honey", "carrotDiamond", "turnipCooked", "CupCake" }, new int[] { 8, 8, 12, 4, 6 }, new float[] {
				13F, 13F, 16.7F, 2F, 0.9F }).setUnlocalizedName("foods.").setTextureName(modID + ":");
		helmetGogglesVision = new ItemArmorRedstoneMod(armorInfinite, 0, "goggles").setUnlocalizedName("gogglesVision").setTextureName(
				modID + ":gogglesVision");
		turnipCrop = new BlockEdibleCrops(true).setBlockName("turnips").setBlockTextureName("turnips");
		cornCrop = new BlockEdibleCrops(false).setBlockName("corn").setBlockTextureName("corn");
		turnip = new ItemSeedFoodMod(2, 0.5F, turnipCrop, Blocks.farmland).setUnlocalizedName("turnip").setTextureName(modID + ":turnip");
		corn = new ItemSeedFoodMod(4, 0.9F, cornCrop, Blocks.farmland).setUnlocalizedName("corn").setTextureName(modID + ":corn");
		plateDualHearts = new ItemArmorRedstoneMod(armorInfinite, 1, "moreHealth").setUnlocalizedName("plateMoreHealth").setMaxDamage(72000)
				.setTextureName(modID + ":plateMoreHealth");
		enderStaff = new EnderStaff().setUnlocalizedName("enderStaff").setCreativeTab(tabMisc).setFull3D().setTextureName(modID + ":enderStaff");
		diamondEnderpearl = new ItemDiamondEnderPearl().setUnlocalizedName("diamondEnderpearl").setCreativeTab(tabMisc)
				.setTextureName(modID + ":diamondEnderpearl");
		potatoLauncher = new PotatoLauncher().setCreativeTab(tabMisc).setUnlocalizedName("PotatoLauncher").setFull3D().setTextureName(modID + ":PotatoLauncher");
		scubaHelmet = new ItemArmorRedstoneMod(armorInfinite, 0, "scuba").setUnlocalizedName("scubaHelmet").setTextureName(modID + ":scubaHelmet");
		jumpBoots = new ItemArmorRedstoneMod(armorInfinite, 3, "jumpAssist").setUnlocalizedName("jumpBoots").setTextureName(modID + ":jumpBoots");
		arrowLauncher = new ArrowLauncher().setCreativeTab(tabMisc).setUnlocalizedName("ArrowLauncher").setFull3D().setTextureName(modID + ":ArrowLauncher");
		legsSwiftness = new ItemArmorRedstoneMod(armorInfinite, 2, "swiftness").setUnlocalizedName("legsSwiftness").setTextureName(
				modID + ":legsSwiftness");
		MultitoolWood = new ItemMultitoolMod(Item.ToolMaterial.WOOD).setUnlocalizedName("paxleWood").setTextureName(modID + ":tools/paxleWood");
		MultitoolStone = new ItemMultitoolMod(Item.ToolMaterial.STONE).setUnlocalizedName("paxleStone").setTextureName(modID + ":tools/paxleStone");
		MultitoolIron = new ItemMultitoolMod(Item.ToolMaterial.IRON).setUnlocalizedName("paxleIron").setTextureName(modID + ":tools/paxleIron");
		MultitoolGold = new ItemMultitoolMod(Item.ToolMaterial.GOLD).setUnlocalizedName("paxleGold").setTextureName(modID + ":tools/paxleGold");
		MultitoolDiamond = new ItemMultitoolMod(Item.ToolMaterial.EMERALD).setUnlocalizedName("paxleDiamond").setTextureName(modID + ":tools/paxleDiamond");
		battleaxeWood = new ItemBattleAxeMod(Item.ToolMaterial.WOOD).setUnlocalizedName("battleaxeWood").setTextureName(modID + ":tools/battleaxeWood");
		battleaxeStone = new ItemBattleAxeMod(Item.ToolMaterial.STONE).setUnlocalizedName("battleaxeStone").setTextureName(modID + ":tools/battleaxeStone");
		battleaxeIron = new ItemBattleAxeMod(Item.ToolMaterial.IRON).setUnlocalizedName("battleaxeIron").setTextureName(modID + ":tools/battleaxeIron");
		battleaxeGold = new ItemBattleAxeMod(Item.ToolMaterial.GOLD).setUnlocalizedName("battleaxeGold").setTextureName(modID + ":tools/battleaxeGold");
		battleaxeDiamond = new ItemBattleAxeMod(Item.ToolMaterial.EMERALD).setUnlocalizedName("battleaxeDiamond").setTextureName(
				modID + ":tools/battleaxeDiamond");
		knifeWood = new ItemKnifeMod(Item.ToolMaterial.WOOD).setUnlocalizedName("knifeWood").setTextureName(modID + ":tools/knifeWood");
		knifeStone = new ItemKnifeMod(Item.ToolMaterial.STONE).setUnlocalizedName("knifeStone").setTextureName(modID + ":tools/knifeStone");
		knifeIron = new ItemKnifeMod(Item.ToolMaterial.IRON).setUnlocalizedName("knifeIron").setTextureName(modID + ":tools/knifeIron");
		knifeGold = new ItemKnifeMod(Item.ToolMaterial.GOLD).setUnlocalizedName("knifeGold").setTextureName(modID + ":tools/knifeGold");
		knifeDiamond = new ItemKnifeMod(Item.ToolMaterial.EMERALD).setUnlocalizedName("knifeDiamond").setTextureName(modID + ":tools/knifeDiamond");
		storage = new BlockStorage("RSaphBlock", "BSaphBlock", "GSaphBlock", "YSaphBlock", "blockSteel", "blockTitanium", "carbonatedIronBlock", "blockQuartz",
				"blockCopper", "blockTin", "blockBronze").setBlockTextureName(modID + ":");
		oreDimensional = new BlockOreDimensional("blockEnderium", "Endium", "IronNether", "IronEnd", "GoldNether", "GoldEnd", "Titanium", "TitaniumNether",
				"TitaniumEnd", "Copper", "CopperNether", "CopperEnd", "Tin", "TinNether", "TinEnd");
		beeHive = new BlockBeehive().setBlockName("beeHive").setBlockTextureName(modID + ":beeHive");
		ores = new BlockGem();
		chocolateCake = new BlockChocolateCake().setHardness(0.5F).setStepSound(Block.soundTypeCloth).setBlockName("choccake")
				.setBlockTextureName(modID + ":choccake");
		itemChocolateCake = new ItemReed(chocolateCake).setCreativeTab(tabMisc).setUnlocalizedName("choccake").setTextureName(modID + ":choccake");
		ironTrapDoor = new BlockIronTrapDoor().setBlockName("irontrapdoor").setCreativeTab(tabMisc).setBlockTextureName(modID + ":irontrapdoor");
		unattunedLauncher = new Item().setCreativeTab(tabMisc).setUnlocalizedName("UnattunedLauncher").setFull3D().setMaxStackSize(1)
				.setTextureName(modID + ":UnattunedLauncher");
	}
}
