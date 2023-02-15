package net.thepigcat76.agric.items;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Snowball;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.thepigcat76.agric.registry.ModItems;

import javax.annotation.Nonnull;
import java.security.SecureRandom;

import static net.minecraft.world.level.block.Block.popResource;

public class MudballItem extends SnowballItem {

    public MudballItem(Item.Properties properties) {
        super(properties);
    }

    @Override
    @Nonnull
    public InteractionResultHolder<ItemStack> use(
            @Nonnull final Level world,
            @Nonnull final Player player,
            @Nonnull final InteractionHand hand) {
        @Nonnull final ItemStack itemstack = player.getItemInHand(hand);
        world.playSound(
                null,
                player.getX(),
                player.getY(),
                player.getZ(),
                SoundEvents.SNOWBALL_THROW,
                SoundSource.NEUTRAL,
                0.5F,
                0.4F / (new SecureRandom().nextFloat() * 0.4F + 0.8F));
        if (!world.isClientSide) {
            @Nonnull
            final Snowball snowball =
                    new Snowball(world, player) {
                        @Override
                        public void onHitEntity(EntityHitResult entityRayTraceResult) {
                            @Nonnull final Entity entity = entityRayTraceResult.getEntity();
                            entity.hurt(DamageSource.thrown(this, this.getOwner()), (float)0);
                        }

                        protected void onHit(Level level, BlockPos blockPos, ItemStack itemStack, HitResult hitResult) {
                            super.onHit(hitResult);
                            if (!this.level.isClientSide) {
                                popResource(level, blockPos, new ItemStack(ModItems.MUDBALL.get()));
                                this.level.broadcastEntityEvent(this, (byte)3);
                                this.discard();
                            }

                        }
                    };
            snowball.setItem(itemstack);
            snowball.shootFromRotation(player, player.xRotO, player.yRotO, 0.0F, 1.5F, 1.0F);
            world.addFreshEntity(snowball);
        }

        player.awardStat(Stats.ITEM_USED.get(this));
        if (!player.getAbilities().instabuild) {
            itemstack.shrink(1);
        }

        return InteractionResultHolder.sidedSuccess(itemstack, world.isClientSide());
    }
}
