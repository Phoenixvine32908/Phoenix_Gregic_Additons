package net.phoenix.core.common.data.materials;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;

import net.phoenix.core.phoenixcore;

import static com.gregtechceu.gtceu.common.data.GTMaterials.*;

public class PhoenixMaterials {

    public static Material QuantumCoolant;
    public static Material ExtremelyModifiedSpaceGradeSteel;
    public static Material EightyFivePercentPureNevvonianSteel;
    public static Material PHOENIX_ENRICHED_TRITANIUM;

    public static void register() {
        EightyFivePercentPureNevvonianSteel = new Material.Builder(
                phoenixcore.id("eighty_five_percent_pure_nevvonian_steel"))
                .ingot()
                .element(PhoenixElements.APNS)
                .flags(PhoenixMaterialFlags.GENERATE_NANITES)
                .formula("APNS")
                .secondaryColor(593856)
                .iconSet(PhoenixMaterialSet.ALMOST_PURE_NEVONIAN_STEEL)
                .buildAndRegister();
        PHOENIX_ENRICHED_TRITANIUM = new Material.Builder(
                phoenixcore.id("phoenix_enriched_tritanium"))
                .ingot()
                .color(0xFF0000)
                .secondaryColor(0x840707)
                .flags(PhoenixMaterialFlags.GENERATE_NANITES)
                .formula("PET")
                .iconSet(PhoenixMaterialSet.ALMOST_PURE_NEVONIAN_STEEL)
                .buildAndRegister();
    }

    public static void modifyMaterials() {
        Iron.addFlags(PhoenixMaterialFlags.GENERATE_NANITES);
    }
}
