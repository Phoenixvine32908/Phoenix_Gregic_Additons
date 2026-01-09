package net.phoenix.core.common.data;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.machine.multiblock.CleanroomType;
import com.gregtechceu.gtceu.common.data.*;
import com.gregtechceu.gtceu.config.ConfigHolder;
import com.gregtechceu.gtceu.data.recipe.CustomTags;

import net.minecraft.data.recipes.FinishedRecipe;
import net.phoenix.core.configs.PhoenixConfigs;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.pipeTinyFluid;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.plate;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.screw;
import static com.gregtechceu.gtceu.common.data.GTBlocks.OPTICAL_PIPES;
import static com.gregtechceu.gtceu.common.data.GTItems.*;
import static com.gregtechceu.gtceu.common.data.GTMachines.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;
import static com.gregtechceu.gtceu.common.data.machines.GTResearchMachines.*;
import static com.gregtechceu.gtceu.data.recipe.GTCraftingComponents.*;
import static net.phoenix.core.common.machine.PhoenixMachines.HIGH_YEILD_PHOTON_EMISSION_REGULATER;
import static net.phoenix.core.common.machine.PhoenixResearchMachines.*;

public class PhoenixMachineRecipes {

    public static void init(Consumer<FinishedRecipe> provider) {
        if (PhoenixConfigs.INSTANCE.features.recipesEnabled) {
            if (ConfigHolder.INSTANCE.machines.highTierContent) {
                ASSEMBLY_LINE_RECIPES.recipeBuilder("hyper_hpca")
                        .inputItems(DATA_BANK)
                        .inputItems(CustomTags.UHV_CIRCUITS, 4)
                        .inputItems(FIELD_GENERATOR_UHV, 8)
                        .inputItems(TOOL_DATA_MODULE)
                        .inputItems(HIGH_PERFORMANCE_COMPUTING_ARRAY)
                        .inputItems(wireGtDouble, RutheniumTriniumAmericiumNeutronate, 64)
                        .inputItems(OPTICAL_PIPES[0].asStack(48))
                        .inputFluids(SolderingAlloy, L * 16)
                        .inputFluids(VanadiumGallium, L * 16)
                        .inputFluids(PCBCoolant, 40000)
                        .outputItems(HIGH_YEILD_PHOTON_EMISSION_REGULATER)
                        .stationResearch(b -> b
                                .researchStack(HIGH_PERFORMANCE_COMPUTING_ARRAY.asStack())
                                .EUt(VA[UV])
                                .CWUt(200, 300000))
                        .duration(1800).EUt(UV)
                        .addMaterialInfo(true, true).save(provider);

                ASSEMBLER_RECIPES.recipeBuilder("phoenix_computation_component")
                        .inputItems(HPCA_ADVANCED_COMPUTATION_COMPONENT)
                        .inputItems(CustomTags.UHV_CIRCUITS, 4)
                        .inputItems(FIELD_GENERATOR_UHV)
                        .outputItems(PHOENIX_COMPUTATION_COMPONENT)
                        .inputFluids(PCBCoolant, 10000)
                        .cleanroom(CleanroomType.CLEANROOM)
                        .duration(1200).EUt(VA[UHV])
                        .addMaterialInfo(true).save(provider);

                ASSEMBLER_RECIPES.recipeBuilder("phoenix_advanced_computation_component")
                        .inputItems(PHOENIX_COMPUTATION_COMPONENT)
                        .inputItems(CustomTags.UEV_CIRCUITS, 4)
                        .inputItems(FIELD_GENERATOR_UEV)
                        .outputItems(ADVANCED_PHOENIX_COMPUTATION_COMPONENT)
                        .inputFluids(PCBCoolant, 10000)
                        .cleanroom(CleanroomType.CLEANROOM)
                        .duration(1200).EUt(VA[UEV])
                        .addMaterialInfo(true).save(provider);

                ASSEMBLER_RECIPES.recipeBuilder("phoenix_heat_sink_component")
                        .inputItems(HPCA_HEAT_SINK_COMPONENT)
                        .inputItems(plate, Darmstadtium, 32)
                        .inputItems(screw, NaquadahAlloy, 8)
                        .outputItems(PHOENIX_COOLER_COMPONENT)
                        .inputFluids(PCBCoolant, 10000)
                        .cleanroom(CleanroomType.CLEANROOM)
                        .duration(1200).EUt(VA[UHV])
                        .addMaterialInfo(true).save(provider);

                ASSEMBLER_RECIPES.recipeBuilder("phoenix_active_cooler_component")
                        .inputItems(PHOENIX_COOLER_COMPONENT.asStack())
                        .inputItems(plate, Neutronium, 16)
                        .inputItems(pipeTinyFluid, Naquadah, 16)
                        .inputItems(screw, Tritanium, 8)
                        .outputItems(ACTIVE_PHOENIX_COOLER_COMPONENT)
                        .inputFluids(PCBCoolant, 10000)
                        .cleanroom(CleanroomType.CLEANROOM)
                        .duration(1200).EUt(VA[UEV])
                        .addMaterialInfo(true).save(provider);
            }
        }
        PhoenixRecipeTypes.PLEASE.recipeBuilder("please")
                .inputFluids(GTMaterials.SolderingAlloy.getFluid(GTValues.L * 32))
                .duration(1200)
                .inputFluids(Acetone.getFluid(GTValues.L * 32))
                .save(provider);
        PhoenixRecipeTypes.PLEASE.recipeBuilder("modify")
                .inputFluids(Neutronium.getFluid(1))
                .duration(1200)
                .save(provider);
    }
}
