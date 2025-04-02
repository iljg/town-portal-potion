package net.iljg.townportalpotion.registers;

import net.iljg.townportalpotion.TownPortalPotion;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class PotionRegister {

    private static final DeferredRegister<Potion> POTIONS =
            DeferredRegister.create(ForgeRegistries.POTIONS, TownPortalPotion.MODID);

    public static final RegistryObject<Potion> TOWN_PORTAL =
            POTIONS.register("town_portal", () -> new Potion(new MobEffectInstance(EffectsRegister.TELEPORT.get())));

    public static void register() {
        POTIONS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}