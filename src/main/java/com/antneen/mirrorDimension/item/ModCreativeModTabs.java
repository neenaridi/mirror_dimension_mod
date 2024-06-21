package com.antneen.mirrorDimension.item;

import com.antneen.mirrorDimension.Mirror_Dimension;
import com.antneen.mirrorDimension.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Mirror_Dimension.MODID);

    public static final RegistryObject<CreativeModeTab> MIRROR_DIMENSION_TAB = CREATIVE_MODE_TABS.register("mirror_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.KYRIUM.get()))
                    .title(Component.translatable("creativetab.mirror_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.KYRIUM.get());

                        pOutput.accept(ModBlocks.KYRIUM_ORE.get());
                        pOutput.accept(ModBlocks.KYRIUM_BLOCK.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
