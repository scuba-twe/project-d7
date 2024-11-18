package scubatwe.pd7.loot;

import net.minecraft.loot.LootTable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import scubatwe.pd7.Projectd7;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ModLootTables {
    private static final Set<RegistryKey<LootTable>> MOD_LOOT_TABLES = new HashSet<>();

    public static final RegistryKey<LootTable>
            DIRT_TYPE_RESULT_BYPRODUCT = registerLootTable("byproduct/dirt_type_result");

    private static RegistryKey<LootTable> registerLootTable(String name) {
        return register(RegistryKey.of(RegistryKeys.LOOT_TABLE, Identifier.of(Projectd7.MOD_ID, name)));
    }

    private static RegistryKey<LootTable> register(RegistryKey<LootTable> key) {
        if (MOD_LOOT_TABLES.add(key)) { return key; }
        else {
            throw new IllegalArgumentException(key.getValue() + " is already a registered built-in loot table ...");
        }
    }

    public static void registerModLootTables() {
        Projectd7.LOGGER.info("Registering loot tables for " + Projectd7.MOD_ID);
    }
}
