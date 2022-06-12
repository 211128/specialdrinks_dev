package com.zenteno.specialdrinksmod.world;

import com.zenteno.specialdrinksmod.SpecialDrinks;
import com.zenteno.specialdrinksmod.world.gen.ModFlowerBurbujaGeneration;
import com.zenteno.specialdrinksmod.world.gen.ModFlowerGenerator;
import com.zenteno.specialdrinksmod.world.gen.ModTreeGeneration;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


    @Mod.EventBusSubscriber(modid = SpecialDrinks.MOD_ID)
    public class ModWorldEvents {

        @SubscribeEvent
        public static void biomeLoadingEvent(final BiomeLoadingEvent event) {

            ModTreeGeneration.generateTrees(event);
            ModFlowerGenerator.generateFlowers(event);
            ModFlowerBurbujaGeneration.generateFlowers(event);
        }



}
