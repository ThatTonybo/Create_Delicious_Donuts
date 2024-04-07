package com.thattonybo.delicious_donuts;

import com.tterrag.registrate.util.entry.ItemEntry;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

// Notes for self:
// - <x>mB (Forge) = <n> * 81 (Fabric) ... 250mB = 20250
// - 20 ticks = 1 second ... <seconds> * 20 ticks

public class DeliciousDonutsItems {
    public static void initialize() {
        // Register the mod's item group (creative inventory tab)
        Registry.register(Registries.ITEM_GROUP, new Identifier(DeliciousDonuts.MOD_ID, "main"), ITEM_GROUP);
    }

    // ----------------------------------
    // Register all the items in the mod:
    // ----------------------------------

    // Sprinkles
    public static final ItemEntry<Item> SPRINKLES = DeliciousDonuts.REGISTRATE.item("sprinkles", Item::new)
            .properties(p -> p.food(
                            new FoodComponent.Builder()
                                    .hunger(1)
                                    .saturationModifier(1.0F)
                                    .statusEffect(
                                            // 5 seconds of speed, eating concentrated sugar & honey will do that to you
                                            new StatusEffectInstance(StatusEffects.SPEED, 5 * 20, 0), 1.0f
                                    )
                                    .statusEffect(
                                            // 20% chance of nausea for the same reason
                                            new StatusEffectInstance(StatusEffects.NAUSEA, 10 * 20, 0), 0.2f
                                    )
                                    .alwaysEdible()
                                    .snack()
                                    .build()
                    )
            )
            .register();

    // Raw Donut
    public static final ItemEntry<Item> RAW_DONUT = DeliciousDonuts.REGISTRATE.item("raw_donut", Item::new)
            .properties(p -> p.food(
                            new FoodComponent.Builder()
                                    .hunger(1)
                                    .saturationModifier(0.0F)
                                    .statusEffect(
                                            // 50% chance of giving hunger for 15 seconds, cause who eats a raw donut?
                                            new StatusEffectInstance(StatusEffects.HUNGER, 15 * 20, 0), 0.5f
                                    )
                                    .build()
                    )
            )
            .register();

    // Donut
    public static final ItemEntry<Item> DONUT = DeliciousDonuts.REGISTRATE.item("donut", Item::new)
            .properties(p -> p.food(
                            new FoodComponent.Builder()
                                    .hunger(2)
                                    .saturationModifier(0.8F)
                                    .build()
                    )
            )
            .register();

    // Glazed Donut
    public static final ItemEntry<Item> GLAZED_DONUT = DeliciousDonuts.REGISTRATE.item("glazed_donut", Item::new)
            .properties(p -> p.food(
                            new FoodComponent.Builder()
                                    .hunger(4)
                                    .saturationModifier(0.8F)
                                    .build()
                    )
            )
            .register();

    // Sprinkled Glazed Donut
    public static final ItemEntry<Item> SPRINKLED_GLAZED_DONUT = DeliciousDonuts.REGISTRATE.item("sprinkled_glazed_donut", Item::new)
            .properties(p -> p.food(
                            new FoodComponent.Builder()
                                    .hunger(5)
                                    .saturationModifier(1.0F)
                                    .build()
                    )
            )
            .register();

    // Chocolate Donut
    public static final ItemEntry<Item> CHOCOLATE_DONUT = DeliciousDonuts.REGISTRATE.item("chocolate_donut", Item::new)
            .properties(p -> p.food(
                            new FoodComponent.Builder()
                                    .hunger(4)
                                    .saturationModifier(0.8F)
                                    .build()
                    )
            )
            .register();

    // Honey Donut
    public static final ItemEntry<Item> HONEY_DONUT = DeliciousDonuts.REGISTRATE.item("honey_donut", Item::new)
            .properties(p -> p.food(
                            new FoodComponent.Builder()
                                    .hunger(4)
                                    .saturationModifier(0.8F)
                                    .build()
                    )
            )
            .register();

    // Caramel Donut
    public static final ItemEntry<Item> CARAMEL_DONUT = DeliciousDonuts.REGISTRATE.item("caramel_donut", Item::new)
            .properties(p -> p.food(
                            new FoodComponent.Builder()
                                    .hunger(4)
                                    .saturationModifier(0.8F)
                                    .build()
                    )
            )
            .register();

    // Sweet Berry Glazed Donut
    public static final ItemEntry<Item> SWEET_BERRY_GLAZED_DONUT = DeliciousDonuts.REGISTRATE.item("sweet_berry_glazed_donut", Item::new)
            .properties(p -> p.food(
                            new FoodComponent.Builder()
                                    .hunger(5)
                                    .saturationModifier(1.0F)
                                    .build()
                    )
            )
            .register();

    // Define the mod's item group (creative inventory tab):
    // (this has to be last, so it can use one of the mod's items as the icon)
    private static final ItemGroup ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(GLAZED_DONUT))
            .displayName(Text.translatable(String.format("itemGroup.%s.main", DeliciousDonuts.MOD_ID)))
            .entries((context, entries) -> {
                // Add the mod's items to the item group
                entries.add(DeliciousDonutsFluids.CARAMEL.getSource().getBucketItem());
                entries.add(DeliciousDonutsFluids.SWEET_BERRY_GLAZE.getSource().getBucketItem());
                entries.add(SPRINKLES);
                entries.add(RAW_DONUT);
                entries.add(DONUT);
                entries.add(GLAZED_DONUT);
                entries.add(SPRINKLED_GLAZED_DONUT);
                entries.add(CHOCOLATE_DONUT);
                entries.add(HONEY_DONUT);
                entries.add(CARAMEL_DONUT);
                entries.add(SWEET_BERRY_GLAZED_DONUT);
            })
            .build();
}
