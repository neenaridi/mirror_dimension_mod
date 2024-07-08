package com.antneen.mirrorDimension.datagen;

import com.antneen.mirrorDimension.Mirror_Dimension;
import com.antneen.mirrorDimension.block.ModBlocks;
import com.antneen.mirrorDimension.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Mirror_Dimension.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.KYRIUM_BLOCK.get(),
                        ModBlocks.KYRIUM_ORE.get(),
                        ModBlocks.DEEPSLATE_KYRIUM_ORE.get(),
                        ModBlocks.CHROMIUM_BLOCK.get(),
                        ModBlocks.CHROMIUM_ORE.get(),
                        ModBlocks.DEEPSLATE_CHROMIUM_ORE.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.KYRIUM_BLOCK.get(),
                    ModBlocks.KYRIUM_ORE.get(),
                    ModBlocks.DEEPSLATE_KYRIUM_ORE.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.CHROMIUM_BLOCK.get(),
                    ModBlocks.CHROMIUM_ORE.get(),
                    ModBlocks.DEEPSLATE_CHROMIUM_ORE.get());
    }
}
