package com.zenteno.specialdrinksmod.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup {

    public static final ItemGroup DRINKS_GROUP = new ItemGroup( "drinksgroup")
    {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.CEBADASEEDS.get());
        }


    };

}
