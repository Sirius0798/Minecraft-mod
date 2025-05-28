package net.sirius.testmod.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sirius.testmod.TestMod;
import net.sirius.testmod.item.custom.FuelItem;
import net.sirius.testmod.item.custom.MetalDetectorItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TestMod.MODID);

    public static final RegistryObject<Item> SNOWGOOMBA = ITEMS.register("snowgoomba",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SNOWGOOMBAH = ITEMS.register("snowgoombah",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
            () -> new MetalDetectorItem(new Item.Properties().durability(128), 1));
    public static final RegistryObject<Item> METAL_DETECTOR_TWO = ITEMS.register("metal_detector_two",
            () -> new MetalDetectorItem(new Item.Properties().durability(1028), 2));

    public static final RegistryObject<Item> GB = ITEMS.register("gb",
            () -> new Item(new Item.Properties().food(ModFoods.GB)));

    public static final RegistryObject<Item> SNOWGOOMBRAH = ITEMS.register("snowgoombrah",
            () -> new FuelItem(new Item.Properties(), 690));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
