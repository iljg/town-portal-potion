package net.iljg.townportalpotion.utils;

import net.iljg.townportalpotion.TownPortalPotion;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class igEffects
{
    public static final DeferredRegister<MobEffect> EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, TownPortalPotion.MOD_ID);

    // teleportation
    public static final RegistryObject<MobEffect> TELEPORT =
            EFFECTS.register("teleport", () -> new MobEffect(MobEffectCategory.NEUTRAL, 5636095){
                public void applyEffectTick(ServerLevel level, LivingEntity entity, int amplifier){
                    // confirm entity and world are valid
                    if ((entity instanceof ServerPlayer player) && !level.isClientSide){
                        // get spawn/bed location
                        BlockPos playerSpawn = player.getRespawnPosition();

                        // check if player has spawn point - add different tp location later
                        if (playerSpawn == null){
                            return;
                        }

                        // offset bed coordinates - add into else when null spawn taken care of (don't forget scope)
                        double x = playerSpawn.getX() + 0.5;
                        double y = playerSpawn.getY() + 0.5;
                        double z = playerSpawn.getZ() + 0.5;

                        player.teleportTo(x, y, z);

                    }
                }

            });

}
