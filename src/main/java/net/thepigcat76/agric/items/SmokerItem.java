package net.thepigcat76.agric.items;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.NeutralMob;
import net.minecraft.world.entity.animal.Bee;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BeehiveBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.thepigcat76.agric.blocks.entities.SmokeHive;

public class SmokerItem extends Item {

    public SmokerItem(Item.Properties properties) {
        super(properties);
    }

    public InteractionResult useOn(UseOnContext context) {
        if (!context.getLevel().isClientSide && context.getItemInHand().getDamageValue() < context.getItemInHand().getMaxDamage()) {
            smokeHive(context.getClickedPos(), context.getLevel());
            return InteractionResult.PASS;
        }
        return super.useOn(context);
    }

    protected void smokeHive(BlockPos pos, Level world) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof SmokeHive hive) {
            hive.smokeHive();
        }
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand, BlockPos pos) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (level instanceof ServerLevel serverLevel && blockEntity instanceof BeehiveBlockEntity) {
            player.getItemInHand(hand).hurtAndBreak(1, player, player1 -> player1.broadcastBreakEvent(hand));

            Vec3 vec3d = player.getLookAngle();
            double x = player.getX() + vec3d.x * 2;
            double y = player.getY() + vec3d.y * 2;
            double z = player.getZ() + vec3d.z * 2;

            AABB aabb = new AABB((player.getX() + vec3d.x), (player.getY() + vec3d.y), (player.getZ() + vec3d.z), (player.getX() + vec3d.x), (player.getY() + vec3d.y), (player.getZ() + vec3d.z)).inflate(2.5D);
            level.getEntitiesOfClass(Bee.class, aabb)
                    .stream()
                    .filter(NeutralMob::isAngry)
                    .forEach(bee -> {
                        bee.setRemainingPersistentAngerTime(0);
                        bee.setLastHurtByMob(null);
                    });

            serverLevel.sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE, x, y + 1.3D, z, 50, 0, 0, 0, 0.01F);
        }
        return super.use(level, player, hand);
    }
}