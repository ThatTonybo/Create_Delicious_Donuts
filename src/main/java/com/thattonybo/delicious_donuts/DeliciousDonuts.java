package com.thattonybo.delicious_donuts;

import com.simibubi.create.foundation.data.CreateRegistrate;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeliciousDonuts implements ModInitializer {
    // Mod ID
    public static final String MOD_ID = "delicious_donuts";

    // Get logger
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    // Get Registrate instance
    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(MOD_ID);

    @Override
    public void onInitialize() {
        // Initialize items/item group
        DeliciousDonutsItems.initialize();

        // Initialize fluids
        DeliciousDonutsFluids.initialize();

        // Register all Registrate entries
        REGISTRATE.register();

        // Log to console that the mod is loaded
        LOGGER.info("Create: Delicious Donuts - Mod loaded");
    }
}