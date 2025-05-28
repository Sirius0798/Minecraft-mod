package net.sirius.testmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.sirius.testmod.TestMod;
import net.sirius.testmod.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TestMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.SNOWGOOMBA);
        simpleItem(ModItems.SNOWGOOMBAH);
        simpleItem(ModItems.SNOWGOOMBRAH);
        simpleItem(ModItems.METAL_DETECTOR);
        simpleItem(ModItems.METAL_DETECTOR_TWO);
        simpleItem(ModItems.GB);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.tryParse("item/generated")).texture("layer0",
                ResourceLocation.tryBuild(TestMod.MODID, "item/" + item.getId().getPath()));
    }
}
