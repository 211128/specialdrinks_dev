package com.zenteno.specialdrinksmod.item;

import com.zenteno.specialdrinksmod.SpecialDrinks;

import com.zenteno.specialdrinksmod.block.ModBlocks;

import com.zenteno.specialdrinksmod.block.custom.tooltips.*;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries. ITEMS, SpecialDrinks. MOD_ID);

//items relacionados con cebada------------------------------------------------------------------
    public static final RegistryObject<Item> CEBADA = ITEMS.register("cebada",
            () -> new Item( new Item.Properties().group(ModItemGroup.DRINKS_GROUP)));

    public static final RegistryObject<Item> FRUTILLA = ITEMS.register("frutilla",
            () -> new Item( new Item.Properties().group(ModItemGroup.DRINKS_GROUP)));


    public static final RegistryObject<Item> RACIMO = ITEMS.register("racimo",
            () -> new Item( new Item.Properties().group(ModItemGroup.DRINKS_GROUP)
                    .food(new Food.Builder().hunger(1).saturation(0.0f).fastToEat()
                    .effect(() -> new EffectInstance(Effects.WITHER, 100, 2), 2.0f)
                    .build())));
    //1.1




    public static final RegistryObject<Item> CEBADAHORNEADA = ITEMS.register("cebadahorneada",
            () -> new Item( new Item.Properties().group(ModItemGroup.DRINKS_GROUP)));

    public static final RegistryObject<Item> CEBADAMASA = ITEMS.register("cebadamasa",
            () -> new Item( new Item.Properties().group(ModItemGroup.DRINKS_GROUP).food(new Food.Builder().hunger(2).saturation(0.2f)
            .effect(() -> new EffectInstance(Effects.HUNGER, 100, 2), 2.0f).build())));

    public static final RegistryObject<Item> CEBADASEEDS = ITEMS.register("cebadaseeds",
            () -> new BlockItem(ModBlocks.CEBADASEEDS.get(), new Item.Properties().group(ModItemGroup.DRINKS_GROUP)));

    public static final RegistryObject<Item> CEBADAAGUA = ITEMS.register("cebadaagua",
            () -> new ModDrinks( new Item.Properties().group(ModItemGroup.DRINKS_GROUP).food(new Food.Builder().hunger(4).saturation(0.5f).build())));

    public static final RegistryObject<Item> CEBADAPAN = ITEMS.register("cebadapan",
            () -> new Item( new Item.Properties().group(ModItemGroup.DRINKS_GROUP).food(new Food.Builder().hunger(9).saturation(0.8f).build())));
//items relacionados con cebada------------------------------------------------------------------

    public static final RegistryObject<Item> CHILE = ITEMS.register("chile",
            () -> new BlockItem(ModBlocks.CHILE.get(), new Item.Properties().group(ModItemGroup.DRINKS_GROUP).food(new Food.Builder().hunger(4).saturation(0.2f)
                    .effect(() -> new EffectInstance(Effects.INSTANT_DAMAGE, 1, 1), 1f)
                    .effect(() -> new EffectInstance(Effects.SPEED, 220, 1), 0f).build())));

    public static final RegistryObject<Item> COMBATE = ITEMS.register("combate",
            () -> new Item( new Item.Properties().group(ModItemGroup.DRINKS_GROUP).food(new Food.Builder().fastToEat().setAlwaysEdible().hunger(3).saturation(4.8f)
                    .effect(() -> new EffectInstance(Effects.ABSORPTION, 1120, 1), 2.0f)
                    .effect(() -> new EffectInstance(Effects.REGENERATION, 720, 1), 2.0f).build())));


    public static final RegistryObject<Item> BURBUJAESPECIAL = ITEMS.register("burbujaespecial",
            () -> new Item( new Item.Properties().group(ModItemGroup.DRINKS_GROUP).food(new Food.Builder().hunger(5).saturation(4.8f)
                    .effect(() -> new EffectInstance(Effects.ABSORPTION, 3120, 3), 2.0f)
                    .effect(() -> new EffectInstance(Effects.REGENERATION, 720, 1), 2.0f).build())));

    public static final RegistryObject<Item> BURBUJAFUERZA = ITEMS.register("burbujafuerza",
            () -> new BlockItem(ModBlocks.BURBUJAFUERZA.get(), new Item.Properties().group(ModItemGroup.DRINKS_GROUP).food(new Food.Builder().hunger(2).saturation(0.8f)
                    .effect(() -> new EffectInstance(Effects.STRENGTH, 1020, 1), 2.0f).build())));

    public static final RegistryObject<Item> BURBUJAVELOCIDAD= ITEMS.register("burbujavelocidad",
            () -> new BlockItem(ModBlocks.BURBUJAVELOCIDAD.get(), new Item.Properties().group(ModItemGroup.DRINKS_GROUP).food(new Food.Builder().hunger(2).saturation(0.8f)
                    .effect(() -> new EffectInstance(Effects.SPEED, 1020, 1), 2.0f).build())));


    public static final RegistryObject<Item> BURBUJAINVISIBILIDAD = ITEMS.register("burbujainvisibilidad",
            () -> new BlockItem(ModBlocks.BURBUJAINVISIBILIDAD.get(), new Item.Properties().group(ModItemGroup.DRINKS_GROUP).food(new Food.Builder().hunger(2).saturation(0.8f)
                    .effect(() -> new EffectInstance(Effects.INVISIBILITY, 1020, 1), 2.0f).build())));

    public static final RegistryObject<Item> BURBUJACURACION = ITEMS.register("burbujacuracion",
            () -> new BlockItem(ModBlocks.BURBUJACURACION.get(), new Item.Properties().group(ModItemGroup.DRINKS_GROUP).food(new Food.Builder().hunger(2).saturation(0.8f)
                    .effect(() -> new EffectInstance(Effects.INSTANT_HEALTH, 1, 2), 2.0f).build())));

    public static final RegistryObject<Item> BURBUJARESISTENCIA = ITEMS.register("burbujaresistencia",
            () -> new BlockItem(ModBlocks.BURBUJARESISTENCIA.get(), new Item.Properties().group(ModItemGroup.DRINKS_GROUP).food(new Food.Builder().hunger(2).saturation(0.8f)
                    .effect(() -> new EffectInstance(Effects.RESISTANCE, 1020, 1), 2.0f).build())));

    public static final RegistryObject<Item> BURBUJAREGEN = ITEMS.register("burbujaregen",
            () -> new BlockItem(ModBlocks.BURBUJAREGEN.get(), new Item.Properties().group(ModItemGroup.DRINKS_GROUP).food(new Food.Builder().hunger(2).saturation(0.8f)
                    .effect(() -> new EffectInstance(Effects.REGENERATION, 820, 1), 2.0f).build())));

    public static final RegistryObject<Item> BURBUJACAIDA = ITEMS.register("burbujacaida",
            () -> new BlockItem(ModBlocks.BURBUJACAIDA.get(), new Item.Properties().group(ModItemGroup.DRINKS_GROUP).food(new Food.Builder().hunger(2).saturation(0.8f)
                    .effect(() -> new EffectInstance(Effects.SLOW_FALLING, 1020, 1), 2.0f).build())));

    public static final RegistryObject<Item> BURBUJACONTRAFUEGO = ITEMS.register("burbujacontrafuego",
            () -> new BlockItem(ModBlocks.BURBUJACONTRAFUEGO.get(), new Item.Properties().group(ModItemGroup.DRINKS_GROUP).food(new Food.Builder().hunger(2).saturation(0.8f)
                    .effect(() -> new EffectInstance(Effects.FIRE_RESISTANCE, 1020, 1), 2.0f).build())));

    public static final RegistryObject<Item> BURBUJAVISION = ITEMS.register("burbujavision",
            () -> new BlockItem(ModBlocks.BURBUJAVISION.get(), new Item.Properties().group(ModItemGroup.DRINKS_GROUP).food(new Food.Builder().hunger(2).saturation(0.8f)
                    .effect(() -> new EffectInstance(Effects.NIGHT_VISION, 1020, 1), 2.0f).build())));
    //pociones reducidas----------------------------------------------------------------------------


    public static final RegistryObject<Item> PREDUCIDAVELOCIDAD = ITEMS.register("potivelocidad",
            () -> new TipVelocidad( new Item.Properties().group(ModItemGroup.DRINKS_GROUP).maxStackSize(4)
                    .food(new Food.Builder().effect(() -> new EffectInstance(Effects.SPEED, 220, 2), 2.0f).build())));


    public static final RegistryObject<Item> PREDUCIDAINVISIBILIDAD = ITEMS.register("potiinvisibilidad",
            () -> new TipInvisibilidad( new Item.Properties().group(ModItemGroup.DRINKS_GROUP).maxStackSize(4)
                    .food(new Food.Builder().effect(() -> new EffectInstance(Effects.INVISIBILITY, 220, 1), 2.0f).build())));

    public static final RegistryObject<Item> PREDUCIDAREGENERACION = ITEMS.register("potiregeneracion",
            () -> new TipRegeneracion( new Item.Properties().group(ModItemGroup.DRINKS_GROUP).maxStackSize(4)
                    .food(new Food.Builder().effect(() -> new EffectInstance(Effects.REGENERATION, 220, 2), 2.0f).build())));

    public static final RegistryObject<Item> PREDUCIDACURACION = ITEMS.register("poticuracion",
            () -> new TipsCuracion( new Item.Properties().group(ModItemGroup.DRINKS_GROUP).maxStackSize(4)
                    .food(new Food.Builder().effect(() -> new EffectInstance(Effects.INSTANT_HEALTH, 1, 1), 2.0f).build())));

    public static final RegistryObject<Item> PREDUCIDACAIDALENTA = ITEMS.register("poticaidalenta",
            () -> new TipCaida( new Item.Properties().group(ModItemGroup.DRINKS_GROUP).maxStackSize(4)
                    .food(new Food.Builder().effect(() -> new EffectInstance(Effects.SLOW_FALLING, 220, 1), 2.0f).build())));

    public static final RegistryObject<Item> PREDUCIDAVISION = ITEMS.register("potivision",
            () -> new TipVision( new Item.Properties().group(ModItemGroup.DRINKS_GROUP).maxStackSize(4)
                    .food(new Food.Builder().effect(() -> new EffectInstance(Effects.NIGHT_VISION, 220, 1), 2.0f).build())));

    public static final RegistryObject<Item> PREDUCIDAFUERZA = ITEMS.register("potifuerza",
            () -> new TipFuerza( new Item.Properties().group(ModItemGroup.DRINKS_GROUP).maxStackSize(4)
                    .food(new Food.Builder().effect(() -> new EffectInstance(Effects.STRENGTH, 220, 2), 2.0f).build())));

    public static final RegistryObject<Item> PREDUCIDARESISTENCIACONTRAELFUEGO = ITEMS.register("poticontraelfuego",
            () -> new TipContraFuego( new Item.Properties().group(ModItemGroup.DRINKS_GROUP).maxStackSize(4)
                    .food(new Food.Builder().effect(() -> new EffectInstance(Effects.FIRE_RESISTANCE, 220, 1), 2.0f)
                    .build())));




    //pociones reducidas----------------------------------------------------------------------------




    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
