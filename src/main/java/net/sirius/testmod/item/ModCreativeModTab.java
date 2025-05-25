package net.sirius.testmod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.sirius.testmod.TestMod;
import net.sirius.testmod.block.ModBlocks;

public class ModCreativeModTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MOD_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TestMod.MODID);

    public static final RegistryObject<CreativeModeTab> TEST_TAB = CREATIVE_MOD_TABS.register("test_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SNOWGOOMBA.get()))
                    .title(Component.translatable("creativetab.test_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        for(RegistryObject<Item> item: ModItems.ITEMS.getEntries()){
                            output.accept(item.get());
                        }
                        output.accept(ModBlocks.SNOWGOOMBLOCK.get());
                        output.accept(Items.DRAGON_EGG);
                    })
                    .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MOD_TABS.register(eventBus);
    }
}
