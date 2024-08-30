package net.serric.createbaas.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.block.FluidBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.serric.createbaas.CreateBAAS;
import net.serric.createbaas.fluid.ModFluids;

public class ModBlocks {
    public static final Block TIN_ORE = registerBlock("tin_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.IRON_ORE).hardness(2.4f), UniformIntProvider.create(2,5)));
    public static final Block DEEPSLATE_TIN_ORE = registerBlock("deepslate_tin_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_IRON_ORE).hardness(4f), UniformIntProvider.create(4,7)));
    public static final Block ACID = registerFluidBlock("acid",
            new FluidBlock(ModFluids.STILL_ACID, FabricBlockSettings.copy(Blocks.WATER).mapColor(DyeColor.GREEN)));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(CreateBAAS.MOD_ID, name), block);
    }
    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(CreateBAAS.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    private static Block registerFluidBlock(String name, FluidBlock fluidBlock) {
        return Registry.register(Registries.BLOCK, new Identifier(CreateBAAS.MOD_ID, name), fluidBlock);
    }

    public static void registerModBlocks() {
        CreateBAAS.LOGGER.info("Registering ModBlocks for " + CreateBAAS.MOD_ID);
    }
}
