package moreminecraft;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLMissingMappingsEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import moreminecraft.blocks.*;
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

import java.lang.reflect.Field;

@Mod(modid = MoreMinecraft.modID, name = "More Minecraft!", useMetadata = true)
public final class MoreMinecraft {
    public static final String modID = "moreminecraft";
    @Mod.Instance(modID)
    public static MoreMinecraft INSTANCE;
	@SidedProxy(clientSide = "moreminecraft.ClientProxy", serverSide = "moreminecraft.CommonProxy")
	public static CommonProxy proxy;

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
            return GameData.getItemRegistry().getObject(modID+":paxleRSaph");
        }
    };

	public static Block ores;
	public static Block storage;
	public static Block oreDimensional;
	public static Block beeHive;
	public static Block turnipCrop;
	public static Block cornCrop;
	public static Block ironTrapDoor;

	public static Item materials;
	public static Item foods;
    public static Item itemChocolateCake;
	public static Item helmetGogglesVision;
    public static Item plateDualHearts;
    public static Item scubaHelmet;
    public static Item legsSwiftness;
    public static Item jumpBoots;
	public static Item turnip;
	public static Item corn;
	public static Item enderStaff;
	public static Item diamondEnderpearl;
	public static Item potatoLauncher;
	public static Item unattunedLauncher;
	public static Item arrowLauncher;
    public static Item MultitoolWood;
    public static Item MultitoolStone;
    public static Item MultitoolIron;
    public static Item MultitoolGold;
    public static Item MultitoolDiamond;
	public static Item battleaxeWood;
	public static Item battleaxeStone;
	public static Item battleaxeIron;
	public static Item battleaxeGold;
	public static Item battleaxeDiamond;
	public static Item knifeWood;
	public static Item knifeStone;
	public static Item knifeIron;
	public static Item knifeGold;
	public static Item knifeDiamond;
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

	@EventHandler
	public void preInitialization(FMLPreInitializationEvent event) {
		items();
        register();
		sets();
		crafting();
        proxy.register();
        MinecraftForge.EVENT_BUS.register(proxy);
        MinecraftForge.EVENT_BUS.register(new WorldGeneratorMoreMinecraft());
        if(event.getSourceFile().getName().endsWith(".jar") && event.getSide().isClient()){
            try {
                Class.forName("mods.mud.ModUpdateDetector").getDeclaredMethod("registerMod", ModContainer.class, String.class, String.class).invoke(null,
                        FMLCommonHandler.instance().findContainerFor(this),
                        "https://raw.github.com/GotoLink/MoreMinecraft/master/update.xml",
                        "https://raw.github.com/GotoLink/MoreMinecraft/master/changelog.md"
                );
            } catch (Throwable ignored) {
            }
        }
	}

    @EventHandler
    public void onRemap(FMLMissingMappingsEvent event){
        for(FMLMissingMappingsEvent.MissingMapping missingMapping : event.get()){
            switch(missingMapping.type) {
                case ITEM:
                    missingMapping.remap(GameData.getItemRegistry().getObject(missingMapping.name.replace("item.", "").replace("tile.", "")));
                    break;
                case BLOCK:
                    missingMapping.remap(GameData.getBlockRegistry().getObject(missingMapping.name.replace("tile.", "")));
                    break;
            }
        }
    }

	private void createArmorSet(String name, ItemArmor.ArmorMaterial par1Enum, String layer, Object madeOf, int madeOfMeta) {
		Item hpar1 = new ItemArmorMod(par1Enum, 0, layer).setUnlocalizedName("helmet" + name).setTextureName(modID + ":armors/helmet" + layer);
		Item cpar1 = new ItemArmorMod(par1Enum, 1, layer).setUnlocalizedName("chestplate" + name).setTextureName(modID + ":armors/chestplate" + layer);
		Item lpar1 = new ItemArmorMod(par1Enum, 2, layer).setUnlocalizedName("leggings" + name).setTextureName(modID + ":armors/leggings" + layer);
		Item bpar1 = new ItemArmorMod(par1Enum, 3, layer).setUnlocalizedName("boots" + name).setTextureName(modID + ":armors/boots" + layer);

        GameRegistry.registerItem(hpar1, "helmet" + name);
        GameRegistry.registerItem(cpar1, "chestplate" + name);
        GameRegistry.registerItem(lpar1, "leggings" + name);
        GameRegistry.registerItem(bpar1, "boots" + name);

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
	}

	private void createToolSet(Item.ToolMaterial par1Enum, String material, Object madeOf, int madeOfMeta) {
		Item pick = new ItemPick(par1Enum).setUnlocalizedName("pickaxe" + material).setCreativeTab(tabTools)
				.setTextureName(modID + ":tools/pickaxe" + material);
		Item axe = new ItemHatchet(par1Enum).setUnlocalizedName("axe" + material).setCreativeTab(tabTools).setTextureName(modID + ":tools/axe" + material);
		Item shovel = new ItemSpade(par1Enum).setUnlocalizedName("shovel" + material).setCreativeTab(tabTools).setTextureName(modID + ":tools/shovel" + material);
		Item hoe = new ItemHoe(par1Enum).setUnlocalizedName("hoe" + material).setCreativeTab(tabTools).setTextureName(modID + ":tools/hoe" + material);
		Item sword = new ItemSword(par1Enum).setUnlocalizedName("sword" + material).setCreativeTab(tabTools).setTextureName(modID + ":tools/sword" + material);
		Item multitool = new ItemMultitoolMod(par1Enum).setUnlocalizedName("paxle" + material).setTextureName(modID + ":tools/paxle" + material);
		Item BAxe = new ItemBattleAxeMod(par1Enum).setUnlocalizedName("battleaxe" + material).setTextureName(modID + ":tools/battleaxe" + material);
		Item knife = new ItemKnifeMod(par1Enum).setUnlocalizedName("knife" + material).setTextureName(modID + ":tools/knife" + material);

        GameRegistry.registerItem(pick, "pickaxe" + material);
        GameRegistry.registerItem(axe, "axe" + material);
        GameRegistry.registerItem(shovel, "shovel" + material);
        GameRegistry.registerItem(hoe, "hoe" + material);
        GameRegistry.registerItem(sword, "sword" + material);
        GameRegistry.registerItem(multitool, "paxle" + material);
        GameRegistry.registerItem(BAxe, "battleaxe" + material);
        GameRegistry.registerItem(knife, "knife" + material);

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
	}

	private void register() {
		for (Field f : this.getClass().getFields()) {
			try {
                Object obj = f.get(this);
				if (obj == null) {
					continue;
				}
                if (obj instanceof Item) {
                    GameRegistry.registerItem((Item) obj, ((Item) obj).getUnlocalizedName().substring(5));
                }else if (obj instanceof Block && !(obj instanceof BasicBlock)) {
                    GameRegistry.registerBlock((Block) obj, ((Block) obj).getUnlocalizedName().substring(5));
                }
			} catch (Exception ignored) {
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
		createToolSet(toolEmerald, "Emerald", Items.emerald, 0);
		createToolSet(toolObsidian, "Obsidian", materials, 2);
		createToolSet(toolCrystal, "RSaph", materials, 20);
		createToolSet(toolCrystal, "YSaph", materials, 23);
		createToolSet(toolCrystal, "BSaph", materials, 21);
		createToolSet(toolCrystal, "GSaph", materials, 22);
		createToolSet(toolSteel, "Steel", materials, 3);
		createToolSet(toolTitanium, "Titanium", materials, 4);
		createToolSet(toolEnd, "End", materials, 24);
		createToolSet(toolQuartz, "Quartz", materials, 14);
		createToolSet(toolMetal, "Copper", materials, 17);
		createToolSet(toolMetal, "Tin", materials, 18);
		createToolSet(toolBronze, "Bronze", materials, 19);
	}

	private void crafting() {
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

	private void items() {
		materials = new ItemMaterials("honey", "butter", "obsidianPlate", "ingotSteel", "ingotTitanium", "ingotCarbonatedIron", "chain", "diamondNugget", "lens",
				"chipVision", "enderiumPlate", "chipMoreHealth", "chipTeleportation", "chipEject", "ingotQuartz", "chipHeater", "Motor", "ingotCopper", "ingotTin", "ingotBronze", "SaphR", "SaphB",
				"SaphG", "SaphY", "enderium").setUnlocalizedName("materials.").setTextureName(modID + ":");
		foods = new ItemFoodMod(new String[] { "bread_butter", "bread_honey", "carrotDiamond", "turnipCooked", "CupCake" }, new int[] { 8, 8, 12, 4, 6 }, new float[] {
				13F, 13F, 16.7F, 2F, 0.9F }).setUnlocalizedName("foods.").setTextureName(modID + ":");
		helmetGogglesVision = new ItemArmorRedstoneMod(armorInfinite, 0, "goggles").setUnlocalizedName("gogglesVision").setTextureName(modID + ":gogglesVision");
		turnipCrop = new BlockEdibleCrops(true).setBlockName("turnips").setBlockTextureName("turnips");
		cornCrop = new BlockEdibleCrops(false).setBlockName("corn").setBlockTextureName("corn");
		turnip = new ItemSeedFoodMod(2, 0.5F, turnipCrop, Blocks.farmland).setUnlocalizedName("turnip").setTextureName(modID + ":turnip");
		corn = new ItemSeedFoodMod(4, 0.9F, cornCrop, Blocks.farmland).setUnlocalizedName("corn").setTextureName(modID + ":corn");
		plateDualHearts = new ItemArmorRedstoneMod(armorInfinite, 1, "moreHealth").setUnlocalizedName("plateMoreHealth").setMaxDamage(72000).setTextureName(modID + ":plateMoreHealth");
		enderStaff = new EnderStaff().setUnlocalizedName("enderStaff").setCreativeTab(tabMisc).setFull3D().setTextureName(modID + ":enderStaff");
		diamondEnderpearl = new ItemDiamondEnderPearl().setUnlocalizedName("diamondEnderpearl").setCreativeTab(tabMisc).setTextureName(modID + ":diamondEnderpearl");
		potatoLauncher = new PotatoLauncher().setCreativeTab(tabMisc).setUnlocalizedName("PotatoLauncher").setFull3D().setTextureName(modID + ":PotatoLauncher");
		scubaHelmet = new ItemArmorRedstoneMod(armorInfinite, 0, "scuba").setUnlocalizedName("scubaHelmet").setTextureName(modID + ":scubaHelmet");
		jumpBoots = new ItemArmorRedstoneMod(armorInfinite, 3, "jumpAssist").setUnlocalizedName("jumpBoots").setTextureName(modID + ":jumpBoots");
		arrowLauncher = new ArrowLauncher().setCreativeTab(tabMisc).setUnlocalizedName("ArrowLauncher").setFull3D().setTextureName(modID + ":ArrowLauncher");
		legsSwiftness = new ItemArmorRedstoneMod(armorInfinite, 2, "swiftness").setUnlocalizedName("legsSwiftness").setTextureName(modID + ":legsSwiftness");
		MultitoolWood = new ItemMultitoolMod(Item.ToolMaterial.WOOD).setUnlocalizedName("paxleWood").setTextureName(modID + ":tools/paxleWood");
		MultitoolStone = new ItemMultitoolMod(Item.ToolMaterial.STONE).setUnlocalizedName("paxleStone").setTextureName(modID + ":tools/paxleStone");
		MultitoolIron = new ItemMultitoolMod(Item.ToolMaterial.IRON).setUnlocalizedName("paxleIron").setTextureName(modID + ":tools/paxleIron");
		MultitoolGold = new ItemMultitoolMod(Item.ToolMaterial.GOLD).setUnlocalizedName("paxleGold").setTextureName(modID + ":tools/paxleGold");
		MultitoolDiamond = new ItemMultitoolMod(Item.ToolMaterial.EMERALD).setUnlocalizedName("paxleDiamond").setTextureName(modID + ":tools/paxleDiamond");
		battleaxeWood = new ItemBattleAxeMod(Item.ToolMaterial.WOOD).setUnlocalizedName("battleaxeWood").setTextureName(modID + ":tools/battleaxeWood");
		battleaxeStone = new ItemBattleAxeMod(Item.ToolMaterial.STONE).setUnlocalizedName("battleaxeStone").setTextureName(modID + ":tools/battleaxeStone");
		battleaxeIron = new ItemBattleAxeMod(Item.ToolMaterial.IRON).setUnlocalizedName("battleaxeIron").setTextureName(modID + ":tools/battleaxeIron");
		battleaxeGold = new ItemBattleAxeMod(Item.ToolMaterial.GOLD).setUnlocalizedName("battleaxeGold").setTextureName(modID + ":tools/battleaxeGold");
		battleaxeDiamond = new ItemBattleAxeMod(Item.ToolMaterial.EMERALD).setUnlocalizedName("battleaxeDiamond").setTextureName(modID + ":tools/battleaxeDiamond");
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
		Block chocolateCake = GameRegistry.registerBlock(new BlockChocolateCake().setHardness(0.5F).setStepSound(Block.soundTypeCloth).setBlockName("choccake").setBlockTextureName(modID + ":choccake"), null, "choccake");
		itemChocolateCake = new ItemReed(chocolateCake).setCreativeTab(tabMisc).setUnlocalizedName("choccake").setTextureName(modID + ":choccake");
		ironTrapDoor = new BlockIronTrapDoor().setBlockName("irontrapdoor").setCreativeTab(tabMisc).setBlockTextureName(modID + ":irontrapdoor");
		unattunedLauncher = new Item().setCreativeTab(tabMisc).setUnlocalizedName("UnattunedLauncher").setFull3D().setMaxStackSize(1).setTextureName(modID + ":UnattunedLauncher");
	}
}
