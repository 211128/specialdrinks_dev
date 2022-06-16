package com.zenteno.specialdrinksmod;

import com.google.common.collect.ImmutableMap;
import com.zenteno.specialdrinksmod.block.ModBlocks;
import com.zenteno.specialdrinksmod.item.ModDrinks;
import com.zenteno.specialdrinksmod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.IEventBusInvokeDispatcher;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(SpecialDrinks.MOD_ID)
public class SpecialDrinks
{
    public static final String MOD_ID = "specialdrinks";

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public SpecialDrinks() {
        // Register the setup method for modloading
        IEventBus EventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(EventBus);
        ModBlocks.register(EventBus);
        ModDrinks.register(EventBus);


        // Register the enqueueIMC method for modloading
        EventBus.addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        EventBus.addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        EventBus.addListener(this::doClientStuff);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }



    private void doClientStuff(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.CEBADASEEDS.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.CHILE.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.FLORORO.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.PLANTABURBUJA.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.BURBUJAFUERZA.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.BURBUJAINVISIBILIDAD.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.BURBUJAREGEN.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.BURBUJACURACION.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.BURBUJACAIDA.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.BURBUJARESISTENCIA.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.BURBUJAVISION.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.BURBUJACONTRAFUEGO.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.HOJASCEREZO.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.SAPLING_CEREZO.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.BURBUJAVELOCIDAD.get(), RenderType.getCutout());//1.1
            RenderTypeLookup.setRenderLayer(ModBlocks.SPIKES.get(), RenderType.getCutout());//1.1
            RenderTypeLookup.setRenderLayer(ModBlocks.SUGAR.get(), RenderType.getCutout());//1.2
            RenderTypeLookup.setRenderLayer(ModBlocks.HONGO.get(), RenderType.getCutout());//1.2

        });


    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo("examplemod", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
        // some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            // register a new block here
            LOGGER.info("HELLO from Register Block");
        }
    }
}
