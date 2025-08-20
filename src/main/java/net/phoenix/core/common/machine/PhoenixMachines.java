package net.phoenix.core.common.machine;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;
import com.gregtechceu.gtceu.api.pattern.Predicates;
import com.gregtechceu.gtceu.api.recipe.OverclockingLogic;
import com.gregtechceu.gtceu.api.registry.registrate.MachineBuilder;
import com.gregtechceu.gtceu.common.data.GTRecipeModifiers;
import com.gregtechceu.gtceu.common.machine.multiblock.part.CleaningMaintenanceHatchPartMachine;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.Block;
import net.phoenix.core.common.data.PhoenixRecipeTypes;
import net.phoenix.core.common.machine.multiblock.BlazingCleanroom;
import net.phoenix.core.common.machine.multiblock.CreativeEnergyMultiMachine;
import net.phoenix.core.configs.PhoenixConfigs;
import net.phoenix.core.phoenixcore;

import java.util.Locale;
import java.util.function.BiFunction;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.pattern.Predicates.*;
import static com.gregtechceu.gtceu.common.data.GTBlocks.*;
import static net.phoenix.core.common.registry.PhoenixRegistration.REGISTRATE;

@SuppressWarnings("unused")
public class PhoenixMachines {

    public static MultiblockMachineDefinition DANCE = null;
    public static MachineDefinition BLAZING_CLEANING_MAINTENANCE_HATCH = null;
    static {
        REGISTRATE.creativeModeTab(() -> phoenixcore.PHOENIX_CREATIVE_TAB);
    }

    static {
        if (PhoenixConfigs.INSTANCE.features.blazingHatchEnabled) {
            BLAZING_CLEANING_MAINTENANCE_HATCH = REGISTRATE
                    .machine("blazing_cleaning_maintenance_hatch",
                            holder -> new CleaningMaintenanceHatchPartMachine(holder,
                                    BlazingCleanroom.BLAZING_CLEANROOM))
                    .langValue("Blazing Cleaning Maintenance Hatch")
                    .rotationState(RotationState.ALL)
                    .abilities(PartAbility.MAINTENANCE)
                    .tooltips(Component.translatable("gtceu.part_sharing.disabled"),
                            Component.translatable("gtceu.machine.maintenance_hatch_cleanroom_auto.tooltip.0"),
                            Component.translatable("gtceu.machine.maintenance_hatch_cleanroom_auto.tooltip.1"))
                    .tooltipBuilder((stack, tooltips) -> tooltips.add(Component.literal("  ").append(Component
                            .translatable(BlazingCleanroom.BLAZING_CLEANROOM.getTranslationKey())
                            .withStyle(ChatFormatting.RED))))
                    .tier(UHV)
                    .overlayTieredHullModel(
                            phoenixcore.id("block/machine/part/overlay_maintenance_blazing_cleaning"))
                    // Tier can always be changed later
                    .register();
        }
    }

    public static MachineDefinition[] registerTieredMachines(String name,
                                                             BiFunction<IMachineBlockEntity, Integer, MetaMachine> factory,
                                                             BiFunction<Integer, MachineBuilder<MachineDefinition>, MachineDefinition> builder,
                                                             int... tiers) {
        MachineDefinition[] definitions = new MachineDefinition[GTValues.TIER_COUNT];
        for (int tier : tiers) {
            var register = REGISTRATE
                    .machine(GTValues.VN[tier].toLowerCase(Locale.ROOT) + "_" + name,
                            holder -> factory.apply(holder, tier))
                    .tier(tier);
            definitions[tier] = builder.apply(tier, register);
        }
        return definitions;
    }

    static {
        if (PhoenixConfigs.INSTANCE.features.creativeEnergyEnabled) {
            // 2. Mova toda a lógica de registro para dentro do método init()
            DANCE = REGISTRATE
                    .multiblock("dance", CreativeEnergyMultiMachine::new)
                    .langValue("dance")
                    .rotationState(RotationState.NON_Y_AXIS)
                    .recipeType(PhoenixRecipeTypes.PLEASE) // Agora isso não será mais nulo
                    .recipeModifiers(GTRecipeModifiers.PARALLEL_HATCH,
                            GTRecipeModifiers.ELECTRIC_OVERCLOCK.apply(OverclockingLogic.NON_PERFECT_OVERCLOCK_SUBTICK))

                    .pattern(definition -> FactoryBlockPattern.start()
                            .aisle("AAAAAABBBAABBBAAAAAAA", "AAAAAAAAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAAAAAAA",
                                    "AAAAAAAAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAAAAAAA",
                                    "AAAAAAAAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAAAAAAA",
                                    "AAAAAAAAAAAAAAAAAAAAA")
                            .aisle("AAAABBBBBBBBBBBBAAAAA", "AAAAABBBBBBBBBBAAAAAA", "AAAAAAAAAAAAAAAAAAAAA",
                                    "AAAAAAAAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAAAAAAA",
                                    "AAAAAAAAAAAAAAAAAAAAA", "AAAAAAAAABBAAAAAAAAAA", "AAAAAAAAAAAAAAAAAAAAA",
                                    "AAAAAAAAAAAAAAAAAAAAA")
                            .aisle("AAAABBBBBBBBBBBBAAAAA", "AAAABBBBBBBBBBBBAAAAA", "AAAAAAABBBBBBBAAAAAAA",
                                    "AAAAAAAAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAAAAAAA", "AAAAAAAABBBBAAAAAAAAA",
                                    "AAAAAAAABBBBAAAAAAAAA", "AAAAAAAABBBBAAAAAAAAA", "AAAAAAAAABBAAAAAAAAAA",
                                    "AAAAAAAAAAAAAAAAAAAAA")
                            .aisle("AAAABBBBBBBBBBBBAAAAA", "AAAABBBAAAAAAABBAAAAA", "AAAAABBBBBBBBBBAAAAAA",
                                    "AAAAAAAAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAAAAAAA",
                                    "AAAAAABBBBBBBBBAAAAAA", "AAAAABBBBBBBBBBAAAAAA", "AAAAABBBBBBBBBBAAAAAA",
                                    "AAAAABBBBBBBBBBAAAAAA")
                            .aisle("AAAABBBBBBBBBBBBAAAAA", "AAAAABAAAAAAAABBAAAAA", "AAAAABBBAABBBBBAAAAAA",
                                    "AAAAAABBBBBBBBAAAAAAA", "AAAAAAABBBBBBAAAAAAAA", "AAAAAABBBBBBBBAAAAAAA",
                                    "AAAAABBAAAAAAABBAAAAA", "AABBBBAAAAAAAAABBBBAA", "ABBBBBAAAAAAAAABBBBBA",
                                    "ABBBBBBBBBBBBBBBAAAAA")
                            .aisle("AAAAABBBBBBBBBBAAAAAA", "AAAAABBAAAAAABBAAAAAA", "AAAAAABBAAAAABAAAAAAA",
                                    "AAAAAAABAAAABBAAAAAAA", "AAAAAAABAAAAABAAAAAAA", "AAAAAABBAAAAABAAAAAAA",
                                    "AAAAABBAAAAAAABBBAAAA", "ABBBBBAAAAAAAAAABBBBA", "ABBAAAAAAAAAAAAABBBBB",
                                    "BBBBBBBBBBBBBBBBBBBBB")
                            .aisle("AAAAABBBBBBBBBBAAAAAA", "AAAAABBAAAAAABBAAAAAA", "AAAAAABBAAAAABAAAAAAA",
                                    "AAAAAAABAAAABBAAAAAAA", "AAAAAAABAAAAABAAAAAAA", "AAAAAABBAAAAABAAAAAAA",
                                    "AAAAABBAAAAAAABBBAAAA", "ABBBBBAAAAAAAAAABBBBA", "ABBAAAAAAAAAAAAABBBBB",
                                    "BBBBBBBBBBBBBBBBBBBBB")
                            .aisle("AAAABBBBBBBBBBBBAAAAA", "AAAAABAAAAAAAABBAAAAA", "AAAAABBBAAAAABBAAAAAA",
                                    "AAAAAABBBBBBBBAAAAAAA", "AAAAAAABBBBBBAAAAAAAA", "AAAAAABBBBBBBBAAAAAAA",
                                    "AAAAABBAAAAAAABBAAAAA", "AABBBBAAAAAAAAABBBBAA", "ABBBBBAAAAAAAAABBBBBA",
                                    "ABBBBBBBBBBBBBBBAAAAA")
                            .aisle("AAAABBBBBBBBBBBBAAAAA", "AAAABBBAAAAAAABBAAAAA", "AAAAAABBBBBBBBBAAAAAA",
                                    "AAAAAAAAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAAAAAAA", "AAAAAAAAABBAAAAAAAAAA",
                                    "AAAAAABBBBBBBBBAAAAAA", "AAAAABBBBBBBBBBAAAAAA", "AAAAABBBBBBBBBBAAAAAA",
                                    "AAAAABBBBBBBBBBAAAAAA")
                            .aisle("AAAABBBBBBBBBBBBAAAAA", "AAAABBBBBBBBBBBBAAAAA", "AAAAAABBBBBBBBAAAAAAA",
                                    "AAAAAAAAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAAAAAAA", "AAAAAAAABBBBAAAAAAAAA",
                                    "AAAAAAAABBBBAAAAAAAAA", "AAAAAAAABBBBAAAAAAAAA", "AAAAAAAAABBAAAAAAAAAA",
                                    "AAAAAAAAAAAAAAAAAAAAA")
                            .aisle("AAAABBBBBBBBBBBBAAAAA", "AAAAABBBBBBBBBBAAAAAA", "AAAAAAAAAAAAAAAAAAAAA",
                                    "AAAAAAAAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAAAAAAA",
                                    "AAAAAAAAAAAAAAAAAAAAA", "AAAAAAAAABBAAAAAAAAAA", "AAAAAAAAAAAAAAAAAAAAA",
                                    "AAAAAAAAAAAAAAAAAAAAA")
                            .aisle("AAAAAABBBAABDBAAAAAAA", "AAAAAAAAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAAAAAAA",
                                    "AAAAAAAAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAAAAAAA",
                                    "AAAAAAAAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAAAAAAA",
                                    "AAAAAAAAAAAAAAAAAAAAI")
                            .where("A", any())
                            .where("I",
                                    Predicates
                                            .blocks(PartAbility.INPUT_ENERGY.getBlocks(GTValues.ZPM)
                                                    .toArray(Block[]::new))
                                            .setMaxGlobalLimited(2))
                            .where('D', controller(blocks(definition.getBlock())))
                            .where("B", blocks(BRONZE_HULL.get()).setMinGlobalLimited(575)
                                    .or(autoAbilities(definition.getRecipeTypes()))
                                    .or(autoAbilities(true, false, true)))
                            .build())
                    .workableCasingModel(GTCEu.id("block/casings/solid/machine_casing_palladium_substation"),
                            GTCEu.id("block/multiblock/data_bank"))
                    .register();
        }
    }

    public static void init() {}
}
