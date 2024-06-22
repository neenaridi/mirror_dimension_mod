package com.antneen.mirrorDimension.item;

import com.antneen.mirrorDimension.Mirror_Dimension;
import com.antneen.mirrorDimension.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier KYRIUM = TierSortingRegistry.registerTier(
            new ForgeTier(4, 1750, 8.5f, 4.0f, 13,
                    ModTags.Blocks.NEEDS_KYRIUM_TOOL, () -> Ingredient.of(ModItems.KYRIUM.get())),
            new ResourceLocation(Mirror_Dimension.MODID, "kyrium"), List.of(Tiers.DIAMOND), List.of(Tiers.NETHERITE));

}
