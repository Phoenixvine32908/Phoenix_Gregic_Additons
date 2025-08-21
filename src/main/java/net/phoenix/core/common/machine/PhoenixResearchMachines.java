package net.phoenix.core.common.machine;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.machine.property.GTMachineModelProperties;
import com.gregtechceu.gtceu.api.registry.registrate.MachineBuilder;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.common.machine.multiblock.part.hpca.*;

import net.minecraft.network.chat.Component;
import net.phoenix.core.common.machine.multiblock.part.hpca.PhoenixComputationPartMachine;
import net.phoenix.core.common.machine.multiblock.part.hpca.PhoenixCoolerPartMachine;
import net.phoenix.core.configs.PhoenixConfigs;

import java.util.function.Function;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.machine.property.GTMachineModelProperties.IS_FORMED;
import static com.gregtechceu.gtceu.api.pattern.Predicates.*;
import static com.gregtechceu.gtceu.common.data.GTBlocks.*;
import static com.gregtechceu.gtceu.common.data.machines.GTResearchMachines.OVERHEAT_TOOLTIPS;
import static com.gregtechceu.gtceu.common.data.models.GTMachineModels.*;
import static net.phoenix.core.common.registry.PhoenixRegistration.REGISTRATE;

////////////////////////////////////////////
// ******** MULTIBLOCK PARTS ********//
////////////////////////////////////////////
public class PhoenixResearchMachines {

    //////////////////////////////////////
    // *********** HPCA ***********//
    //////////////////////////////////////

    // Here we define your new custom HPCA part.
    public static final MachineDefinition PHOENIX_COMPUTATION_COMPONENT = registerComputationHPCAPart(
            "phoenix_computation_component", "Phoenix Computation Component",
            // The constructor now uses your custom class.
            PhoenixComputationPartMachine::new, "reinforced_computation", false)
            .tooltips(
                    // Update the tooltips to reflect the new part's values.
                    Component.translatable("gtceu.machine.hpca.component_general.upkeep_eut", GTValues.VA[GTValues.IV]),
                    Component.translatable("gtceu.machine.hpca.component_general.max_eut", GTValues.VA[GTValues.ZPM]),
                    Component.translatable("gtceu.machine.hpca.component_type.computation_cwut",
                            PhoenixConfigs.INSTANCE.features.BasicPCUStrength),
                    Component.translatable("gtceu.machine.hpca.component_type.computation_cooling", 8),
                    Component.translatable("gtceu.part_sharing.disabled"))
            .tooltipBuilder(OVERHEAT_TOOLTIPS)
            .register();
    public static final MachineDefinition ADVANCED_PHOENIX_COMPUTATION_COMPONENT = registerComputationHPCAPart(
            "advanced_phoenix_computation_component", "Advanced Phoenix Computation Component",
            // The constructor now uses your custom class.
            PhoenixComputationPartMachine::new, "advanced_phoenix_computation_component", true)
            .tooltips(
                    // Update the tooltips to reflect the new part's values.
                    Component.translatable("gtceu.machine.hpca.component_general.upkeep_eut", GTValues.VA[GTValues.IV]),
                    Component.translatable("gtceu.machine.hpca.component_general.max_eut", GTValues.VA[GTValues.ZPM]),
                    Component.translatable("gtceu.machine.hpca.component_type.computation_cwut",
                            PhoenixConfigs.INSTANCE.features.PCUStrength),
                    Component.translatable("gtceu.machine.hpca.component_type.computation_cooling", 8),
                    Component.translatable("gtceu.part_sharing.disabled"))
            .tooltipBuilder(OVERHEAT_TOOLTIPS)
            .register();

    // Standard version of your custom cooler
    public static final MachineDefinition PHOENIX_COOLER_COMPONENT = registerCoolingHPCAPart(
            "phoenix_heat_sink_component", "Phoenix Heat Sink Component",
            // Use a lambda to correctly pass the 'advanced' boolean
            holder -> new PhoenixCoolerPartMachine(holder, false),
            "advanced_heat_sink", false) // Pass false for the advanced parameter
            .tooltips(Component.translatable("gtceu.machine.hpca.component_general.upkeep_eut", 0),
                    Component.translatable("gtceu.machine.hpca.component_type.cooler_passive"),
                    Component.translatable("gtceu.machine.hpca.component_type.cooler_cooling",
                            PhoenixConfigs.INSTANCE.features.BasicPCCUStrength),
                    Component.translatable("gtceu.part_sharing.disabled"))
            .register();

    // Advanced version of your custom cooler
    public static final MachineDefinition ACTIVE_PHOENIX_COOLER_COMPONENT = registerCoolingHPCAPart(
            "active_phoenix_cooling_component", "Active Phoenix Cooling Component",
            // Use a lambda to correctly pass the 'advanced' boolean
            holder -> new PhoenixCoolerPartMachine(holder, true),
            "advanced_active_cooler", true) // Pass true for the advanced parameter
            .tooltips(
                    Component.translatable("gtceu.machine.hpca.component_general.upkeep_eut", GTValues.VA[GTValues.IV]),
                    Component.translatable("gtceu.machine.hpca.component_type.cooler_active"),
                    Component.translatable("gtceu.machine.hpca.component_type.cooler_active_coolant",
                            12, GTMaterials.PCBCoolant.getLocalizedName()),
                    Component.translatable("gtceu.machine.hpca.component_type.cooler_cooling",
                            PhoenixConfigs.INSTANCE.features.PCCUStrength),
                    Component.translatable("gtceu.part_sharing.disabled"))
            .register();

    private static MachineBuilder<MachineDefinition> registerCoolingHPCAPart(String name, String displayName,
                                                                             Function<IMachineBlockEntity, MetaMachine> constructor,
                                                                             String texture, boolean isAdvanced) {
        return REGISTRATE.machine(name, constructor)
                .langValue(displayName)
                .rotationState(RotationState.ALL)
                .abilities(PartAbility.HPCA_COMPONENT)
                .modelProperty(IS_FORMED, false)
                .modelProperty(GTMachineModelProperties.IS_HPCA_PART_DAMAGED, false)
                .modelProperty(GTMachineModelProperties.IS_ACTIVE, false)
                .model(createHPCAPartModel(isAdvanced,
                        GTCEu.id("block/overlay/machine/hpca/cooling/" + texture),
                        GTCEu.id("block/overlay/machine/hpca/damaged" + (isAdvanced ? "_advanced" : ""))));
    }

    private static MachineBuilder<MachineDefinition> registerComputationHPCAPart(String name, String displayName,
                                                                                 Function<IMachineBlockEntity, MetaMachine> constructor,
                                                                                 String texture, boolean isAdvanced) {
        return REGISTRATE.machine(name, constructor)
                .langValue(displayName)
                .rotationState(RotationState.ALL)
                .abilities(PartAbility.HPCA_COMPONENT)
                .modelProperty(IS_FORMED, false)
                .modelProperty(GTMachineModelProperties.IS_HPCA_PART_DAMAGED, false)
                .modelProperty(GTMachineModelProperties.IS_ACTIVE, false)
                .model(createHPCAPartModel(isAdvanced,
                        GTCEu.id("block/machine/part/hpca/computation/" + texture),
                        GTCEu.id("block/machine/part/hpca/computation/damaged" + (isAdvanced ? "_advanced" : ""))));
    }

    public static void init() {}
}
