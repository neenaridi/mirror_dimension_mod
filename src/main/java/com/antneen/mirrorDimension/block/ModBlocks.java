package com.antneen.mirrorDimension.block;

import com.antneen.mirrorDimension.Mirror_Dimension;
import com.antneen.mirrorDimension.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Mirror_Dimension.MODID);

    public static final RegistryObject<Block> KYRIUM_BLOCK = registerBlock("kyrium_block", () -> new Block(
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.COLOR_PURPLE)
                            .requiresCorrectToolForDrops()
                            .strength(7.0F, 6.0F)
                            .sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> KYRIUM_ORE = registerBlock("kyrium_ore", () -> new DropExperienceBlock(BlockBehaviour
            .Properties.of()
            .mapColor(MapColor.STONE)
            .requiresCorrectToolForDrops()
            .strength(3.0F, 4.0F)
            .sound(SoundType.AMETHYST),
            UniformInt.of(3, 7))
    );

    public static final RegistryObject<Block> DEEPSLATE_KYRIUM_ORE = registerBlock("deepslate_kyrium_ore", () -> new DropExperienceBlock(BlockBehaviour
            .Properties.of()
            .mapColor(MapColor.DEEPSLATE)
            .requiresCorrectToolForDrops()
            .strength(4.0F, 5.0F)
            .sound(SoundType.AMETHYST),
            UniformInt.of(3, 7))
    );

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) { BLOCKS.register(eventBus); }

}
