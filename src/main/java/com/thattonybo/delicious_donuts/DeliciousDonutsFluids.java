package com.thattonybo.delicious_donuts;

import com.simibubi.create.AllTags;
import com.tterrag.registrate.fabric.SimpleFlowableFluid;
import com.tterrag.registrate.util.entry.FluidEntry;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariantAttributeHandler;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

import javax.annotation.Nullable;

@SuppressWarnings("UnstableApiUsage")
public class DeliciousDonutsFluids {
    public static void initialize() {}

    // -----------------------------------
    // Register all the fluids in the mod:
    // -----------------------------------

    // Caramel
    public static FluidEntry<SimpleFlowableFluid.Flowing> CARAMEL = DeliciousDonuts.REGISTRATE.fluid("caramel",
                    new Identifier(DeliciousDonuts.MOD_ID, "block/fluid/caramel_still"),
                    new Identifier(DeliciousDonuts.MOD_ID, "block/fluid/caramel_flow")
            )
            .fluidAttributes(() -> new FluidAttributeHandler(String.format("fluid.%s.caramel", DeliciousDonuts.MOD_ID), 2500, 1600))
            .fluidProperties(p -> p.levelDecreasePerBlock(2)
                    .tickRate(15)
                    .flowSpeed(6)
                    .blastResistance(100f))
            .tag(AllTags.forgeFluidTag("caramel"), FluidTags.WATER)
            .source(SimpleFlowableFluid.Source::new)
            .register();

    // Sweet Berry Glaze
    public static FluidEntry<SimpleFlowableFluid.Flowing> SWEET_BERRY_GLAZE = DeliciousDonuts.REGISTRATE.fluid("sweet_berry_glaze",
                    new Identifier(DeliciousDonuts.MOD_ID, "block/fluid/sweet_berry_glaze_still"),
                    new Identifier(DeliciousDonuts.MOD_ID, "block/fluid/sweet_berry_glaze_flow")
            )
            .fluidAttributes(() -> new FluidAttributeHandler(String.format("fluid.%s.sweet_berry_glaze", DeliciousDonuts.MOD_ID), 2500, 1600))
            .fluidProperties(p -> p.levelDecreasePerBlock(2)
                    .tickRate(15)
                    .flowSpeed(6)
                    .blastResistance(100f))
            .tag(AllTags.forgeFluidTag("sweet_berry_glaze"), FluidTags.WATER)
            .source(SimpleFlowableFluid.Source::new)
            .register();

    // Handler for fluid attributes
    private record FluidAttributeHandler(Text name, int viscosity,
                                         boolean lighterThanAir) implements FluidVariantAttributeHandler {
        private FluidAttributeHandler(String key, int viscosity, int density) {
            this(Text.translatable(key), viscosity, density <= 0);
        }

        @Override
        public Text getName(FluidVariant fluidVariant) {
            return name;
        }

        @Override
        public int getViscosity(FluidVariant variant, @Nullable World world) {
            return viscosity;
        }

        @Override
        public boolean isLighterThanAir(FluidVariant variant) {
            return lighterThanAir;
        }
    }
}
