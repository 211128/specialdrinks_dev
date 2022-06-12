package com.zenteno.specialdrinksmod.block;

import com.zenteno.specialdrinksmod.SpecialDrinks;
import com.zenteno.specialdrinksmod.block.custom.CropBlock;
import com.zenteno.specialdrinksmod.block.custom.bushes.*;
import com.zenteno.specialdrinksmod.block.custom.bushes.BushBlocks.BushBlockFertil;
import com.zenteno.specialdrinksmod.block.custom.tree.CerezoTree;
import com.zenteno.specialdrinksmod.item.ModItemGroup;
import com.zenteno.specialdrinksmod.item.ModItems;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.trees.OakTree;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.potion.Effect;
import net.minecraft.potion.Effects;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BlOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, SpecialDrinks.MOD_ID);

//bloques relacionados con cebada------------------------------------------------------------------
    public static final RegistryObject<Block> CEBADABLOQUE = registerBlock( "cebadabloque",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.from(Blocks.SPONGE)));

    public static final RegistryObject<Block> HOJASCEREZO = registerBlock("hojascerezo",
            () -> new LeavesBlock(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2f)
                    .tickRandomly().sound(SoundType.PLANT).notSolid()));

    public static final RegistryObject<Block> SAPLING_CEREZO = registerBlock("sapling_cerezo",
            () -> new SaplingBlock(new CerezoTree(), AbstractBlock.Properties.from(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> CEREZO = registerBlock( "cerezo",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.from(Blocks.OAK_LOG)));

    public static final RegistryObject<Block> CEREZO_LOG = registerBlock( "cerezo_log",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.from(Blocks.OAK_LOG)));

    public static final RegistryObject<Block> CEREZOSTRIPPET = registerBlock( "cerezostrippet",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.from(Blocks.OAK_LOG)));

    public static final RegistryObject<Block> CEBADASEEDS = BlOCKS.register("cebada_crop",
            () -> new CropBlock(AbstractBlock.Properties.from(Blocks.WHEAT)));


//bloques relacionados con cebada------------------------------------------------------------------

    public static final RegistryObject<Block> CHILE = BlOCKS.register("chile_crop",
            () -> new CropBlock(AbstractBlock.Properties.from(Blocks.WHEAT)));





    public static final RegistryObject<Block> BURBUJAFUERZA = BlOCKS.register("bush_fuerza_crop",
            () -> new Bushfuerza(AbstractBlock.Properties.from(Blocks.WHEAT)));

    public static final RegistryObject<Block> BURBUJAREGEN = BlOCKS.register("bush_regen_crop",
            () -> new Bushregen(AbstractBlock.Properties.from(Blocks.WHEAT)));

    public static final RegistryObject<Block> BURBUJAINVISIBILIDAD = BlOCKS.register("bush_invisibilidad_crop",
            () -> new Bushinvisibilidad(AbstractBlock.Properties.from(Blocks.WHEAT)));

    public static final RegistryObject<Block> BURBUJARESISTENCIA = BlOCKS.register("bush_resistencia_crop",
            () -> new Bushresistencia(AbstractBlock.Properties.from(Blocks.WHEAT)));

    public static final RegistryObject<Block> BURBUJACONTRAFUEGO = BlOCKS.register("bush_contrafuego_crop",
            () -> new Bushcontrafuego(AbstractBlock.Properties.from(Blocks.WHEAT)));

    public static final RegistryObject<Block> BURBUJACURACION = BlOCKS.register("bush_curacion_crop",
            () -> new Bushcuracion(AbstractBlock.Properties.from(Blocks.WHEAT)));

    public static final RegistryObject<Block> BURBUJACAIDA = BlOCKS.register("bush_caida_crop",
            () -> new Bushcaida(AbstractBlock.Properties.from(Blocks.WHEAT)));

    public static final RegistryObject<Block> BURBUJAVISION = BlOCKS.register("bush_vision_crop",
            () -> new Bushvision(AbstractBlock.Properties.from(Blocks.WHEAT)));

    public static final RegistryObject<Block> BURBUJAVELOCIDAD = BlOCKS.register("bush_velocidad_crop",
            () -> new Bushvelocidad(AbstractBlock.Properties.from(Blocks.WHEAT)));

public static final RegistryObject<Block> FLORORO = registerBlock("flororo",
        () -> new FlowerBlock(Effects.HASTE, 0, AbstractBlock.Properties.from(Blocks.DANDELION).setLightLevel((state -> {
            return 8; }))));

    public static final RegistryObject<Block> PLANTABURBUJA = registerBlock("plantaburbuja",
            () -> new FlowerBlock(Effects.HASTE, 1, AbstractBlock.Properties.from(Blocks.DANDELION).setLightLevel((state -> {
                return 8; }))));


    //1.1
    public static final RegistryObject<Block> BERRI = registerBlock("berri_crop",
            () -> new Pinchos(AbstractBlock.Properties.from(Blocks.WHEAT)));

    //1.1




//---------------------------------------------------------------------------------------------------------
    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BlOCKS.register(name, block);
        registerBlockItem(name, toReturn);

        return toReturn;
    }


    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block){
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
        new Item.Properties().group(ModItemGroup.DRINKS_GROUP)));
    }

    public static void register(IEventBus eventBus){

        BlOCKS.register(eventBus);
    }

}
