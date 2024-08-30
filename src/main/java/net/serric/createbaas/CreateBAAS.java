package net.serric.createbaas;

import net.fabricmc.api.ModInitializer;

import net.serric.createbaas.block.ModBlocks;
import net.serric.createbaas.fluid.ModFluids;
import net.serric.createbaas.item.ModItems;
import net.serric.createbaas.world.gen.ModWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateBAAS implements ModInitializer {
	public static final String MOD_ID = "createbaas";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModFluids.registerModFluids();

		ModItemGroups.registerItemGroups();

		ModWorldGeneration.generateModWorldGen();
	}
}