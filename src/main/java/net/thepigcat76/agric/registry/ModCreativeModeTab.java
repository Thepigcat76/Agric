package net.thepigcat76.agric.registry;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab AGRIC = new CreativeModeTab("agric") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModBlocks.STRAW_BLOCK.get());
        }
    };
}
