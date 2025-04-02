package net.iljg.townportalpotion.registers;

import net.iljg.townportalpotion.TownPortalPotion;
import net.iljg.townportalpotion.effects.Teleport;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EffectsRegister {

    private static final DeferredRegister<MobEffect> EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, TownPortalPotion.MODID);

    public static final RegistryObject<MobEffect> TELEPORT =
            EFFECTS.register("teleport", () -> new Teleport(MobEffectCategory.NEUTRAL, 5636095));

    public static void register() {
        EFFECTS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
