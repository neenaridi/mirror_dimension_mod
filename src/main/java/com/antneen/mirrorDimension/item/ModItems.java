package com.antneen.mirrorDimension.item;

import com.antneen.mirrorDimension.Mirror_Dimension;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Mirror_Dimension.MODID);

    public static final RegistryObject<Item> KYRIUM = ITEMS.register("kyrium", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> KYRIUM_PICKAXE = ITEMS.register("kyrium_pickaxe",
            () -> new PickaxeItem(ModToolTiers.KYRIUM, 4, 1, new Item.Properties()));
    public static final RegistryObject<Item> KYRIUM_SHOVEL = ITEMS.register("kyrium_shovel",
            () -> new ShovelItem(ModToolTiers.KYRIUM, 0, 0, new Item.Properties()));
    public static final RegistryObject<Item> KYRIUM_AXE = ITEMS.register("kyrium_axe",
            () -> new AxeItem(ModToolTiers.KYRIUM, 6, 1, new Item.Properties()));
    public static final RegistryObject<Item> KYRIUM_HOE = ITEMS.register("kyrium_hoe",
            () -> new HoeItem(ModToolTiers.KYRIUM, 0, 0, new Item.Properties()));
    public static final RegistryObject<Item> KYRIUM_SWORD = ITEMS.register("kyrium_sword",
            () -> new SwordItem(ModToolTiers.KYRIUM, 4, 2, new Item.Properties()));

    // armor

    public static void register(IEventBus eventBus){ ITEMS.register(eventBus); }
}