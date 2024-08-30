package net.serric.createbaas;

import net.fabricmc.api.ModInitializer;

import net.serric.createbaas.block.ModBlocks;
import net.serric.createbaas.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateBAAS implements ModInitializer {
	public static final String MOD_ID = "createbaas";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModItemGroups.registerItemGroups();
	}
}