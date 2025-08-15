package net.phoenix.core.common.machine;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;
import com.gregtechceu.gtceu.api.pattern.Predicates;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;

import net.phoenix.core.phoenixcore;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.pattern.Predicates.*;
import static com.gregtechceu.gtceu.common.data.GTBlocks.*;
import static net.phoenix.core.common.registry.PhoenixRegistration.REGISTRATE;

@SuppressWarnings("unused")
public class PhoenixMachines {

    static {
        REGISTRATE.creativeModeTab(() -> phoenixcore.PHOENIX_CREATIVE_TAB);
    }

    public static MultiblockMachineDefinition PTERB_MACHINE = null;

    static {
        PTERB_MACHINE = REGISTRATE
                .multiblock("pterb_machine", WorkableElectricMultiblockMachine::new)
                .langValue("Wireless Active Transformer")
                .rotationState(RotationState.ALL)
                .recipeType(GTRecipeTypes.DUMMY_RECIPES)
                .appearanceBlock(CASING_PALLADIUM_SUBSTATION)
                .pattern((definition) -> FactoryBlockPattern.start()
                        // spotless:off
                            .aisle("###XXX###", "####F####", "#########", "####H####", "####H####", "####H####", "####H####", "####H####")
                            .aisle("#XXXXXXX#", "###FHF###", "####H####", "####H####", "####H####", "####F####", "#########", "#########")
                            .aisle("#XXHHHXX#", "#########", "#########", "#########", "####F####", "####F####", "#########", "#########")
                            .aisle("XXHHHHHXX", "#F#####F#", "#########", "####S####", "###SSS###", "###SSS###", "###S#S###", "#########")
                            .aisle("XXHHHHHXX", "FH##H##HF", "#H##C##H#", "HH#SSS#HH", "HHFSSSFHH", "HFFSSSFFH", "H#######H", "H#######H")
                            .aisle("XXHHHHHXX", "#F#####F#", "#########", "####S####", "###SSS###", "###SSS###", "###S#S###", "#########")
                            .aisle("#XXHHHXX#", "#########", "#########", "#########", "####F####", "####F####", "#########", "#########")
                            .aisle("#XXXXXXX#", "###FHF###", "####H####", "####H####", "####H####", "####F####", "#########", "#########")
                            .aisle("###XXX###", "####F####", "#########", "####H####", "####H####", "####H####", "####H####", "####H####")
                            // spotless:on
                        .where('#', any())
                        .where('X',
                                blocks(CASING_PALLADIUM_SUBSTATION.get()).setMinGlobalLimited(30)
                                        .or(Predicates.autoAbilities(definition.getRecipeTypes())))
                        .where('S', blocks(SUPERCONDUCTING_COIL.get()))
                        .where('H', blocks(HIGH_POWER_CASING.get()))
                        .where('C', controller(blocks(definition.getBlock())))
                        .where('F', frames(GTMaterials.Neutronium))
                        .build())
                .workableCasingModel(GTCEu.id("block/casings/solid/machine_casing_palladium_substation"),
                        GTCEu.id("block/multiblock/data_bank"))
                .allowExtendedFacing(true)
                .hasBER(true)
                .register();

    }

    public static void init() {}
}
