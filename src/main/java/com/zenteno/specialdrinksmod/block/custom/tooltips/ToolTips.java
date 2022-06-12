package com.zenteno.specialdrinksmod.block.custom.tooltips;


import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;


public class ToolTips extends Item {

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {

        if(Screen.hasShiftDown()) {



            tooltip.add(new TranslationTextComponent("tooltip.specialdrinks.cebada_shift"));



        } else {



            tooltip.add(new TranslationTextComponent("tooltip.specialdrinks.cebada"));
            tooltip.add(new TranslationTextComponent("tooltip.specialdrinks.cebada1"));
            tooltip.add(new TranslationTextComponent("tooltip.specialdrinks.cebada2"));
            tooltip.add(new TranslationTextComponent("tooltip.specialdrinks.cebada3"));





        }
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }


    public boolean hasEffect(ItemStack stack){
        return true;
    }


    public ToolTips(Properties p_i48487_1_) {
        super(p_i48487_1_);
    }
}
