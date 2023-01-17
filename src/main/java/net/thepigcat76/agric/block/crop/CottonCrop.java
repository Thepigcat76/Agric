package net.thepigcat76.agric.block.crop;

import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.thepigcat76.agric.item.ModItems;

public class CottonCrop extends CropBlock {

    //Set min and max crop age
    public static final IntegerProperty AGE = IntegerProperty.create("age", 0, 4);

    //Properties for crop block
    public CottonCrop(Properties properties) {
        super(properties);
    }

    //Assign seed item
    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.COTTON_SEEDS.get();
    }

    @Override
    public IntegerProperty getAgeProperty() {
        return AGE;
    }

    //Get max age
    @Override
    public int getMaxAge() {
        return 4;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }
}
