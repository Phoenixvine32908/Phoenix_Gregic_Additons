package net.phoenix.core.common.machine;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;
import com.gregtechceu.gtceu.api.pattern.Predicates;
import com.gregtechceu.gtceu.api.recipe.OverclockingLogic;
import com.gregtechceu.gtceu.common.data.GTRecipeModifiers;

import net.minecraft.world.level.block.Block;
import net.phoenix.core.common.data.PhoenixRecipeTypes;
import net.phoenix.core.common.machine.multiblock.CreativeEnergyMultiMachine;
import net.phoenix.core.phoenixcore;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.pattern.Predicates.*;
import static com.gregtechceu.gtceu.common.data.GTBlocks.*;
import static net.phoenix.core.common.registry.PhoenixRegistration.REGISTRATE;

@SuppressWarnings("unused")
public class PhoenixMachines {

    public static MultiblockMachineDefinition DANCE;

    public static void init() {
        REGISTRATE.creativeModeTab(() -> phoenixcore.PHOENIX_CREATIVE_TAB);

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
                                        .blocks(PartAbility.INPUT_ENERGY.getBlocks(GTValues.ZPM).toArray(Block[]::new))
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
