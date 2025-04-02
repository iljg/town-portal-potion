package net.iljg.townportalpotion.effects;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class Teleport extends MobEffect {

    // constructor
    public Teleport(MobEffectCategory mobEffectCategory, int colour) {
        super(mobEffectCategory, colour);
    }

    // effect
    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        if(!entity.level().isClientSide()) {
            if (entity.level().getServer() != null) {
                ServerLevel serverLevel = entity.level().getServer().getLevel(entity.level().dimension());
                assert serverLevel != null;
                if (!serverLevel.isClientSide && entity instanceof ServerPlayer) { // prevent teleporting invalid types
                    // get spawn/bed location
                    BlockPos targetCo = ((ServerPlayer) entity).getRespawnPosition();

                    // check if player has spawn point - set to world spawn seed if null
                    if (targetCo == null){
                        targetCo = ((ServerPlayer) entity).serverLevel().getSharedSpawnPos();
                    }

                    // make sure player spawns above bed not inside
                    double x = targetCo.getX() + 0.5;
                    double y = targetCo.getY() + 0.5;
                    double z = targetCo.getZ() + 0.5;

                    // DIMENSION HANDLING TO BE DONE NEXT

                    // mount handling
                    if (entity.isPassenger()) {
                        Entity mount = entity.getVehicle();
                        entity.stopRiding();
                        entity.teleportTo(x, y, z);
                        mount.teleportTo(x, y, z);
                    }

                    entity.teleportTo(x, y, z);
                }
            }
        }
    }

    @Override
    public boolean isInstantenous() {
        return true;
    }
}

