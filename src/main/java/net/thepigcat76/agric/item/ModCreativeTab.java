package net.thepigcat76.agric.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.thepigcat76.agric.block.ModBlocks;

public class ModCreativeTab {
    public static final CreativeModeTab AGRIC = new CreativeModeTab("agric") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModBlocks.RYE_BLOCK.get());
        }
    };
}