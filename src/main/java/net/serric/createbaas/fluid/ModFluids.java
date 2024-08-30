package net.serric.createbaas.fluid;

import net.minecraft.fluid.FlowableFluid;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.serric.createbaas.CreateBAAS;

public class ModFluids {
    public static final FlowableFluid STILL_ACID = registerFluid("still_acid", new AcidFluid.Still());
    public static final FlowableFluid FLOWING_ACID = registerFluid("flowing_acid", new AcidFluid.Flowing());

    private static FlowableFluid registerFluid(String name, FlowableFluid fluid) {
        return Registry.register(Registries.FLUID, new Identifier(CreateBAAS.MOD_ID, name), fluid);
    }

    public static void registerModFluids() {
        CreateBAAS.LOGGER.info("Registering fluids for " + CreateBAAS.MOD_ID);
    }
}
