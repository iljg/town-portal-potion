package net.iljg.townportalpotion.item;

import net.iljg.townportalpotion.TownPortalPotion;
import net.iljg.townportalpotion.utils.igEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

// Town Potion Portal Item Logic
public class TPPotionItem
{
    // Item register method
    public static final DeferredRegister<Potion> POTIONS =
            DeferredRegister.create(ForgeRegistries.POTIONS, TownPortalPotion.MOD_ID);

    // Town Portal
    public static final RegistryObject<Potion> TOWN_PORTAL =
            POTIONS.register("town_portal", () ->
                    new Potion("townportal", new MobEffectInstance(igEffects.TELEPORT.get())));
}
