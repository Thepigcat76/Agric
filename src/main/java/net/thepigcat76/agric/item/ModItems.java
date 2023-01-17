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
import net.thepigcat76.agric.block.ModBlocks;

import static net.thepigcat76.agric.Agric.MODID;


public class ModItems {
    public static final DeferredRegister<Item> MOD_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public static final RegistryObject<Item> STRAW = MOD_ITEMS.register("straw",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.AGRIC)));

    public static final RegistryObject<Item> RYE_SEEDS = MOD_ITEMS.register("rye_seeds",
            () -> new ItemNameBlockItem(ModBlocks.RYE_CROP.get(),
                    new Item.Properties().tab(ModCreativeTab.AGRIC)));

    public static final RegistryObject<Item> COTTON_SEEDS = MOD_ITEMS.register("cotton_seeds",
            () -> new ItemNameBlockItem(ModBlocks.COTTON_CROP.get(),
                    new Item.Properties().tab(ModCreativeTab.AGRIC)));

    public static final RegistryObject<Item> RYE = MOD_ITEMS.register("rye",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.AGRIC)
                    .food(new FoodProperties.Builder().nutrition(1).build())));

    public static final RegistryObject<Item> BLUEBERRY = MOD_ITEMS.register("blueberry",
            () -> new ItemNameBlockItem(ModBlocks.BLUEBERRY_BUSH.get(), new Item.Properties()
                    .tab(ModCreativeTab.AGRIC).food(new FoodProperties.Builder().nutrition(1) .effect(
                            () -> new MobEffectInstance(MobEffects.NIGHT_VISION, 60, 0), 1f).build())));

    public static final RegistryObject<Item> COTTON = MOD_ITEMS.register("cotton",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.AGRIC)));

    public static final RegistryObject<Item> STRAWBERRY = MOD_ITEMS.register("strawberry",
            () -> new ItemNameBlockItem(ModBlocks.STRAWBERRY_BUSH.get(), new Item.Properties()
                    .tab(ModCreativeTab.AGRIC).food(new FoodProperties.Builder().nutrition(1) .effect(
                            () -> new MobEffectInstance(MobEffects.REGENERATION, 60, 0), 1f).build())));

    public static final RegistryObject<Item> RASPBERRY = MOD_ITEMS.register("raspberry",
            () -> new ItemNameBlockItem(ModBlocks.RASPBERRY_BUSH.get(), new Item.Properties()
                    .tab(ModCreativeTab.AGRIC).food(new FoodProperties.Builder().nutrition(1) .effect(
                            () -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 60, 0), 1f).build())));

    public static final RegistryObject<Item> REED_SEEDS = MOD_ITEMS.register("reed_seeds",
            () -> new ItemNameBlockItem(ModBlocks.REED_CROP.get(), new Item.Properties()
                    .tab(ModCreativeTab.AGRIC)));

    public static void register(IEventBus eventBus) {
        MOD_ITEMS.register(eventBus);
    }
}