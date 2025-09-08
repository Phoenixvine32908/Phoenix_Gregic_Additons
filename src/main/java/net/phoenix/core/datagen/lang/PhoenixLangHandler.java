package net.phoenix.core.datagen.lang;

import net.phoenix.core.phoenixcore;

import com.tterrag.registrate.providers.RegistrateLangProvider;
import dev.toma.configuration.config.value.ConfigValue;
import dev.toma.configuration.config.value.ObjectValue;

import java.util.Map;
import java.util.Set;

public class PhoenixLangHandler {

    public static void init(RegistrateLangProvider provider) {
        provider.add("phoenixcore.tooltip.hyper_machine_coolant1", "%s: %sx CWU/t");
        provider.add("phoenixcore.tooltip.hyper_machine_coolant2", "%s: %sx CWU/t");
        provider.add("phoenixcore.tooltip.hyper_machine_coolant3", "%s: %sx CWU/t");
        provider.add("phoenixcore.tooltip.hyper_machine_purpose",
                "An upgraded HPCA that uses %s, %s, or %s to provide cooling");
        provider.add("tagprefix.nanites", "%s Nanites");
        provider.add("material.phoenixcore.phoenix_enriched_tritanium", "§cPhoenix Enriched Tritanium");
        provider.add("material.phoenixcore.extremely_modified_space_grade_steel",
                "§cExtremely Modified Space Grade Steel");
        provider.add("material.phoenixcore.eighty_five_percent_pure_nevvonian_steel",
                "§6Eighty Five Percent Pure Nevvonian Steel");
        provider.add("phoenixcore.tooltip.hyper_machine_1", "Each Coolant provides a boost:");
    }

    private static void dfs(RegistrateLangProvider provider, Set<String> added, Map<String, ConfigValue<?>> map) {
        for (var entry : map.entrySet()) {
            var id = entry.getValue().getId();
            if (added.add(id)) {
                provider.add(String.format("config.%s.option.%s", phoenixcore.MOD_ID, id), id);
            }
            if (entry.getValue() instanceof ObjectValue objectValue) {
                dfs(provider, added, objectValue.get());
            }
        }
    }

    protected static void multiLang(RegistrateLangProvider provider, String key, String... values) {
        for (var i = 0; i < values.length; i++) {
            provider.add(getSubKey(key, i), values[i]);
        }
    }

    protected static String getSubKey(String key, int index) {
        return key + "." + index;
    }
}
