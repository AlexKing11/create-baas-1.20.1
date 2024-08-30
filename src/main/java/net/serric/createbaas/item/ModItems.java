package net.serric.createbaas.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.serric.createbaas.CreateBAAS;

public class ModItems {
    public static final Item TIN_INGOT = registerItem("tin_ingot", new Item(new FabricItemSettings()));
    public static final Item RAW_TIN = registerItem("raw_tin", new Item(new FabricItemSettings()));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(CreateBAAS.MOD_ID, name), item);
    }

    public static void registerModItems() {
        CreateBAAS.LOGGER.info("Registering items for " + CreateBAAS.MOD_ID);
    }
}