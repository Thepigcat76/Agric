package net.thepigcat76.agric.registry;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.thepigcat76.agric.Agric;
import net.thepigcat76.agric.items.MudballItem;

public class ModItems {
    public static final DeferredRegister<Item> MOD_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Agric.MODID);


    public static final RegistryObject<Item> STRAW = MOD_ITEMS.register("straw",
            () -> new Item(basic_item(64)));

    public static final RegistryObject<Item> RYE = MOD_ITEMS.register("rye",
            () -> new Item(basic_item(64)));

    public static final RegistryObject<Item> MUDBALL = MOD_ITEMS.register("mudball",
            () -> new MudballItem(basic_item(64)));

    //Berries
    public static final RegistryObject<Item> BLUEBERRY = MOD_ITEMS.register("blueberry",
            () -> new Item(effect_food_item(64, 1, 60,0)));

    public static final RegistryObject<Item> STRAWBERRY = MOD_ITEMS.register("strawberry",
            () -> new Item(effect_food_item(64, 1, 60,0)));

    public static final RegistryObject<Item> RASPBERRY = MOD_ITEMS.register("raspberry",
            () -> new Item(effect_food_item(64, 1, 60,0)));

    public static void register(IEventBus eventBus) {
        MOD_ITEMS.register(eventBus);
    }

    public static Item.Properties basic_item(int maxStackSize) {
        return new Item.Properties().tab(ModCreativeModeTab.AGRIC).stacksTo(maxStackSize);
    }

    public static Item.Properties effect_food_item(int maxStackSize, int nutrition, int ticks, int level) {
        return new Item.Properties().tab(ModCreativeModeTab.AGRIC).stacksTo(maxStackSize).food(new FoodProperties.Builder().nutrition(nutrition).effect(
                () -> new MobEffectInstance(MobEffects.NIGHT_VISION, ticks, level), 1f).build());
    }

    public static Item.Properties food_item(int maxStackSize, int nutrition) {
        return new Item.Properties().tab(ModCreativeModeTab.AGRIC).stacksTo(maxStackSize).food(new FoodProperties.Builder().nutrition(nutrition).build());
    }

}
