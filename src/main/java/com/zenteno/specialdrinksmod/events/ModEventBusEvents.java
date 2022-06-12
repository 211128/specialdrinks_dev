package com.zenteno.specialdrinksmod.events;


import com.zenteno.specialdrinksmod.SpecialDrinks;
import com.zenteno.specialdrinksmod.events.loot.DropSeedsModificador;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(modid = SpecialDrinks.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerModifierSerializers(@Nonnull final RegistryEvent.Register<GlobalLootModifierSerializer<?>>
                                                           event) {
        event.getRegistry().registerAll(
                new DropSeedsModificador.Serializer().setRegistryName
                        (new ResourceLocation(SpecialDrinks.MOD_ID,"cebadaseeds_from_grass"))

        );

    }




}
