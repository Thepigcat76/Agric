package net.thepigcat76.agric.block.entity.storage;

import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.core.Vec3i;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.Containers;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BarrelBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.ContainerOpenersCounter;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.thepigcat76.agric.block.entity.ModBlockEntities;
import net.thepigcat76.agric.block.entity.processing.DryingRackEntity;
import org.jetbrains.annotations.NotNull;

public class CrateEntity extends RandomizableContainerBlockEntity {
    private NonNullList<ItemStack> items = NonNullList.withSize(27, ItemStack.EMPTY);

    public CrateEntity(BlockPos p_155052_, BlockState p_155053_) {
        super(ModBlockEntities.CRATE_ENTITY.get(), p_155052_, p_155053_);
    }

    protected void saveAdditional(CompoundTag p_187459_) {
        super.saveAdditional(p_187459_);
        if (!this.trySaveLootTable(p_187459_)) {
            ContainerHelper.saveAllItems(p_187459_, this.items);
        }

    }

    public void load(CompoundTag p_155055_) {
        super.load(p_155055_);
        this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        if (!this.tryLoadLootTable(p_155055_)) {
            ContainerHelper.loadAllItems(p_155055_, this.items);
        }

    }

    public int getContainerSize() {
        return 27;
    }

    protected NonNullList<ItemStack> getItems() {
        return this.items;
    }

    protected void setItems(NonNullList<ItemStack> p_58610_) {
        this.items = p_58610_;
    }

    protected Component getDefaultName() {
        return Component.translatable("container.crate");
    }

    protected AbstractContainerMenu createMenu(int p_58598_,Inventory p_58599_) {
        return ChestMenu.fourRows(p_58598_, p_58599_);
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer();
        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, CrateEntity pEntity) {
        if (level.isClientSide()) {
            return;
        }
    }
}