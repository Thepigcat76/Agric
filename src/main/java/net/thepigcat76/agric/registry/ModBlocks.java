package net.thepigcat76.agric.registry;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.thepigcat76.agric.Agric;
import net.thepigcat76.agric.blocks.StrawBedBlock;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> MOD_BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Agric.MODID);

    public static final RegistryObject<Block> STRAW_BLOCK = registerBlock("straw_block", () -> new Block(BlockBehaviour.Properties.of(Material.LEAVES).strength(2f)), ModCreativeModeTab.AGRIC);

    public static final RegistryObject<Block> STRAW_BED = registerBlock("straw_bed", () -> new StrawBedBlock(BlockBehaviour.Properties.of(Material.LEAVES).strength(2f)), ModCreativeModeTab.AGRIC);
    public static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = MOD_BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ModItems.MOD_ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }


    public static void register(IEventBus eventBus) {
        MOD_BLOCKS.register(eventBus);
    }

}

