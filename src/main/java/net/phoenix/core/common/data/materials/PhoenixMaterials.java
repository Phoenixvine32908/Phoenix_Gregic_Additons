package net.phoenix.core.common.data.materials;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.fluids.FluidBuilder;
import com.gregtechceu.gtceu.api.fluids.FluidState;

import net.phoenix.core.phoenixcore;

public class PhoenixMaterials {

    public static Material QuantumCoolant;
    public static Material ExtremelyModifiedSpaceGradeSteel;
    public static Material EightyFivePercentPureNevvonianSteel;

    public static void register() {
        QuantumCoolant = new Material.Builder(phoenixcore.id("quantum_coolant"))
                .liquid(new FluidBuilder().state(FluidState.LIQUID).temperature(0))
                .color(0x0040ef).secondaryColor(0x0030cf)
                .buildAndRegister();
        ExtremelyModifiedSpaceGradeSteel = new Material.Builder(phoenixcore.id("extremely_modified_space_grade_steel"))
                .ingot()
                .color(0xad6161)
                .secondaryColor(0x593856)
                .cableProperties(GTValues.V[GTValues.LuV], 64, 0, true)
                .buildAndRegister();
        EightyFivePercentPureNevvonianSteel = new Material.Builder(
                phoenixcore.id("eighty_five_percent_pure_nevvonian_steel"))
                .ingot()
                .color(0x4B0082)
                .secondaryColor(0x000000)
                .element(PhoenixElements.APNS)
                .formula("APNS")
                .secondaryColor(593856)
                .iconSet(PhoenixMaterialSet.ALMOST_PURE_NEVONIAN_STEEL)
                .buildAndRegister();
    }
}
