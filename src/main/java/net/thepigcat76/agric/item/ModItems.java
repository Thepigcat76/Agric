package net.thepigcat76.agric.item;


import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.thepigcat76.agric.Agric;
import net.thepigcat76.agric.block.ModBlocks;


public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Agric.MODID);

    public static final RegistryObject<Item> STRAW = ITEMS.register("straw", () -> new Item(new Item.Properties().tab(ModCreativeTab.AGRIC)));
    public static final RegistryObject<Item> RYE_SEEDS = ITEMS.register("rye_seeds", () -> new ItemNameBlockItem(ModBlocks.RYE_CROP.get(), new Item.Properties().tab(ModCreativeTab.AGRIC)));
    public static final RegistryObject<Item> COTTON_SEEDS = ITEMS.register("cotton_seeds", () -> new ItemNameBlockItem(ModBlocks.COTTON_CROP.get(), new Item.Properties().tab(ModCreativeTab.AGRIC)));
    public static final RegistryObject<Item> RYE = ITEMS.register("rye", () -> new Item(new Item.Properties().tab(ModCreativeTab.AGRIC).food(new FoodProperties.Builder().nutrition(1).build())));
    public static final RegistryObject<Item> BLUEBERRIES = ITEMS.register("blueberries", () -> new Item(new Item.Properties().tab(ModCreativeTab.AGRIC).food(new FoodProperties.Builder().nutrition(1).effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 60, 0), 1f).build())));
    public static final RegistryObject<Item> COTTON = ITEMS.register("cotton", () -> new Item(new Item.Properties().tab(ModCreativeTab.AGRIC)));
    public static final RegistryObject<Item> STRAWBERRY = ITEMS.register("strawberry", () -> new ItemNameBlockItem(ModBlocks.STRAWBERRY_BUSH.get(), new Item.Properties().tab(ModCreativeTab.AGRIC).food(new FoodProperties.Builder().nutrition(1).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 60, 0), 1f).build())));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}