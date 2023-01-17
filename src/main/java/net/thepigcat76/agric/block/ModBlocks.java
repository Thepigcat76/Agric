package net.thepigcat76.agric.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.thepigcat76.agric.block.bush.BlueberryBush;
import net.thepigcat76.agric.block.bush.RaspberryBush;
import net.thepigcat76.agric.block.crop.CottonCrop;
import net.thepigcat76.agric.block.crop.ReedCrop;
import net.thepigcat76.agric.block.bush.StrawberryBush;
import net.thepigcat76.agric.block.functional.Crate;
import net.thepigcat76.agric.block.functional.DryingRack;
import net.thepigcat76.agric.item.ModCreativeTab;
import net.thepigcat76.agric.item.ModItems;
import net.thepigcat76.agric.block.crop.RyeCrop;

import java.util.function.Supplier;

import static net.thepigcat76.agric.Agric.MODID;

public class ModBlocks {
    public static final DeferredRegister<Block> MOD_BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);

    //Block registry
    public static final RegistryObject<Block> STRAW_BLOCK = registerBlock("straw_block", () -> new Block(BlockBehaviour.Properties.of(Material.LEAVES)
            .strength(2f)), ModCreativeTab.AGRIC);

    public static final RegistryObject<Block> RYE_BLOCK = registerBlock("rye_block", () -> new Block(BlockBehaviour.Properties.of(Material.LEAVES)
            .strength(2f)), ModCreativeTab.AGRIC);

    public static final RegistryObject<Block> RYE_CROP= MOD_BLOCKS.register("rye_crop", () -> new RyeCrop(BlockBehaviour.Properties.copy(Blocks.WHEAT)
            .strength(0f)));

    public static final RegistryObject<Block> COTTON_CROP= MOD_BLOCKS.register("cotton_crop", () -> new CottonCrop(BlockBehaviour.Properties.copy(Blocks.WHEAT)
            .strength(0f)));

    public static final RegistryObject<Block> REED_CROP = MOD_BLOCKS.register("reed_crop", () -> new ReedCrop(BlockBehaviour.Properties.copy(Blocks.WHEAT)
            .strength(0f)));

    public static final RegistryObject<Block> STRAWBERRY_BUSH= MOD_BLOCKS.register("strawberry_bush", () -> new StrawberryBush(BlockBehaviour.Properties.copy(Blocks.SWEET_BERRY_BUSH)
            .strength(0f)));

    public static final RegistryObject<Block> BLUEBERRY_BUSH= MOD_BLOCKS.register("blueberry_bush", () -> new BlueberryBush(BlockBehaviour.Properties.copy(Blocks.SWEET_BERRY_BUSH)
            .strength(0f)));

    public static final RegistryObject<Block> RASPBERRY_BUSH= MOD_BLOCKS.register("raspberry_bush", () -> new RaspberryBush(BlockBehaviour.Properties.copy(Blocks.SWEET_BERRY_BUSH)
            .strength(0f)));

    public static final RegistryObject<Block> DRYING_RACK_ENTITY = registerBlock("drying_rack",
            () -> new DryingRack(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(4f).noOcclusion()), ModCreativeTab.AGRIC);

    public static final RegistryObject<Block> CRATE_ENTIY = registerBlock("crate",
            () -> new Crate(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(4f).noOcclusion()), ModCreativeTab.AGRIC);

    public static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = MOD_BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }


    //creating items for blocks
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ModItems.MOD_ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }



    public static void register (IEventBus eventBus) {
        MOD_BLOCKS.register(eventBus);
    }
}