package net.phoenix.core.datagen.lang;

import com.tterrag.registrate.providers.RegistrateLangProvider;

public class PhoenixLangHandler {

    public static void init(RegistrateLangProvider provider) {
        provider.add("block.phoenix_gregic_additions.high_yield_photon_emission_regulator",
                "§dHigh Yield Photon Emission Regulator (HPCA)");
        provider.add("phoenix_gregic_additions.tooltip.hyper_machine_coolant1", "%s: %sx CWU/t");
        provider.add("phoenix_gregic_additions.tooltip.hyper_machine_coolant2", "%s: %sx CWU/t");
        provider.add("phoenix_gregic_additions.tooltip.hyper_machine_coolant_base", "%s: %sx CWU/t");
        provider.add("phoenix_gregic_additions.tooltip.hyper_machine_coolant3", "%s: %sx CWU/t");
        provider.add("phoenix_gregic_additions.tooltip.hyper_machine_purpose",
                "An upgraded HPCA that uses %s, %s, or %s to provide cooling");
        provider.add("phoenix_gregic_additions.tooltip.requires_fluid", "Needs: %s");
        provider.add("tagprefix.nanites", "%s Nanites");
        provider.add("material.phoenix_gregic_additions.phoenix_enriched_tritanium", "§cPhoenix Enriched Tritanium");
        provider.add("material.phoenix_gregic_additions.extremely_modified_space_grade_steel",
                "§cExtremely Modified Space Grade Steel");
        provider.add("material.phoenix_gregic_additions.quantum_coolant",
                "§bQuantum Coolant");
        provider.add("material.phoenix_gregic_additions.eighty_five_percent_pure_nevvonian_steel",
                "§6Eighty Five Percent Pure Nevvonian Steel");
        provider.add("material.phoenix_gregic_additions.phoenix_enriched_naquadah",
                "§6Phoenix Enriched Naquadah");
        provider.add("phoenix_gregic_additions.tooltip.hyper_machine_1", "Each Coolant provides a boost:");
    }

    protected static String getSubKey(String key, int index) {
        return key + "." + index;
    }
}
