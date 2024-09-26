package net.possiedi.transportationstaff.util;

import net.possiedi.transportationstaff.item.ModItems;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ModLootTableModifiers {

    private static final Identifier JUNGLE_TEMPLE_ID =
            new Identifier("minecraft", "chests/jungle_temple");

    private static final Identifier DESERT_PYRAMID =
            new Identifier("minecraft", "chests/desert_pyramid");

    private static final Identifier BASTION_BRIDGE =
                new Identifier("minecraft", "chests/bastion_bridge");

    private static final Identifier BASTION_HOGLIN_STABLE =
            new Identifier("minecraft", "chests/bastion_hoglin_stable");

    private static final Identifier BASTION_OTHER =
            new Identifier("minecraft", "chests/bastion_other");

    private static final Identifier BASTION_TREASURE =
            new Identifier("minecraft", "chests/bastion_treasure");

    private static final Identifier SUSPICIOUS_SAND_ID =
            new Identifier("minecraft", "archaeology/desert_pyramid");

    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (JUNGLE_TEMPLE_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.3f))
                        .with(ItemEntry.builder(ModItems.WOODEN_STAFF))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.2f, 0.5f)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            if (DESERT_PYRAMID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.2f))
                        .with(ItemEntry.builder(ModItems.WOODEN_STAFF))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.2f, 0.5f)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            if (BASTION_BRIDGE.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.2f))
                        .with(ItemEntry.builder(ModItems.IRON_STAFF))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.2f, 0.5f)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            if (BASTION_TREASURE.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.2f))
                        .with(ItemEntry.builder(ModItems.IRON_STAFF))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.2f, 0.5f)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            if (BASTION_OTHER.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.2f))
                        .with(ItemEntry.builder(ModItems.IRON_STAFF))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.2f, 0.5f)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            if (BASTION_HOGLIN_STABLE.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.2f))
                        .with(ItemEntry.builder(ModItems.IRON_STAFF))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.2f, 0.5f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
        });

        LootTableEvents.REPLACE.register((resourceManager, lootManager, id, original, source) -> {
            if(SUSPICIOUS_SAND_ID.equals(id)) {
                List<LootPoolEntry> entries = new ArrayList<>(Arrays.asList(original.pools[0].entries));
                entries.add(ItemEntry.builder(ModItems.WOODEN_STAFF).build());

                LootPool.Builder pool = LootPool.builder().with(entries);
                return LootTable.builder().pool(pool).build();
            }

            return null;
        });
    }
}
