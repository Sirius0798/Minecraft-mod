package net.sirius.testmod.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.sirius.testmod.TestMod;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> METAL_DETECTOR_VALUABLES = tag("metal_detector_valuables");
        public static final TagKey<Block> METAL_DETECTOR_TWO_VALUABLES = tag("metal_detector_two_valuables");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(ResourceLocation.tryBuild(TestMod.MODID, name));
        }
    }

    public static class Items {

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(ResourceLocation.tryBuild(TestMod.MODID, name));
        }
    }
}
