package com.zenteno.specialdrinksmod.block.custom.tooltips;

import com.zenteno.specialdrinksmod.item.ModDrinks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class TipContraFuego extends ModDrinks {

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {

        if(Screen.hasShiftDown()) {


            tooltip.add(new TranslationTextComponent("tooltip.specialdrinks.fuego_shift"));


        } else {


            tooltip.add(new TranslationTextComponent("tooltip.specialdrinks.fuego"));


        }
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

    public boolean hasEffect(ItemStack stack){
        return true;
    }
    public TipContraFuego(Properties builder) {
        super(builder);
    }
}
