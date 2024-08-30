package net.serric.createbaas;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;
import net.serric.createbaas.fluid.ModFluids;

public class CreateBAASClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_ACID, ModFluids.FLOWING_ACID, new SimpleFluidRenderHandler(
                new Identifier("minecraft:block/water_still"),
                new Identifier("minecraft:block/water_flow"),
                0x2dc728 //acid tint
        ));

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), ModFluids.STILL_ACID, ModFluids.FLOWING_ACID);

        //if you want to use custom textures they need to be registered.
        //In this example this is unnecessary because the vanilla water textures are already registered.
        //To register your custom textures use this method.
        //ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
        //    registry.register(new Identifier("tutorial:block/custom_fluid_still"));
        //    registry.register(new Identifier("tutorial:block/custom_fluid_flowing"));
        //});
    }
}
