package com.antneen.mirrorDimension.item;

import com.antneen.mirrorDimension.Mirror_Dimension;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Mirror_Dimension.MODID);

    public static final RegistryObject<Item> KYRIUM = ITEMS.register("kyrium", () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus){ ITEMS.register(eventBus); }
}
