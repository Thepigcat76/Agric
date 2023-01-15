package net.thepigcat76.agric.block.entity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.thepigcat76.agric.Agric;
import net.thepigcat76.agric.block.ModBlocks;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Agric.MODID);

    public static final RegistryObject<BlockEntityType<DryingRackEntity>> DRYING_RACK_ENTITY =
            BLOCK_ENTITIES.register("drying_rack_entity", () ->
                    BlockEntityType.Builder.of(DryingRackEntity::new,
                            ModBlocks.DRYING_RACK_ENTITY.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
