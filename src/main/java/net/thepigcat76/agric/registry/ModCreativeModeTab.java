package net.thepigcat76.agric.registry;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;

public class ModCreativeModeTab {
    public static final CreativeModeTab AGRIC = new CreativeModeTab("agric") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Blocks.ACACIA_BUTTON);
        }
    };
}
