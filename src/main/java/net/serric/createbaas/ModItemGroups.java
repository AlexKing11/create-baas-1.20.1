package net.serric.createbaas;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.serric.createbaas.block.ModBlocks;
import net.serric.createbaas.item.ModItems;

public class ModItemGroups {
    public static final ItemGroup BAAS_MAIN = Registry.register(Registries.ITEM_GROUP,
            new Identifier(CreateBAAS.MOD_ID, "tin_ingot"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.baas_main"))
                    .icon(() -> new ItemStack(ModItems.TIN_INGOT)).entries((displayContext, entries) -> {
                        entries.add(ModBlocks.TIN_ORE);
                        entries.add(ModBlocks.DEEPSLATE_TIN_ORE);
                        entries.add(ModItems.RAW_TIN);
                        entries.add(ModItems.TIN_INGOT);

                    }).build());

    public static void registerItemGroups() {
        CreateBAAS.LOGGER.info("Registering Item Groups for " + CreateBAAS.MOD_ID);
    }
}
