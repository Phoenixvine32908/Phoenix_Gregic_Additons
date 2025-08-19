package net.phoenix.core.common.block;

import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.block.ActiveBlock;
import com.gregtechceu.gtceu.api.block.ICoilType;
import com.gregtechceu.gtceu.api.block.IFilterType;
import com.gregtechceu.gtceu.api.block.property.GTBlockStateProperties;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.common.block.CoilBlock;
import com.gregtechceu.gtceu.common.data.models.GTModels;
import com.gregtechceu.gtceu.data.recipe.CustomTags;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraftforge.client.model.generators.ModelFile;
import net.phoenix.core.phoenixcore;

import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.nullness.NonNullBiFunction;
import org.jetbrains.annotations.NotNull;

import static net.phoenix.core.common.registry.PhoenixRegistration.REGISTRATE;

@SuppressWarnings("unused")
public class PhoenixBlocks {

    public static void init() {}

    // A simple CoilType enum to define your coil types.
    // You will need to define your coil properties here.
    public enum CoilType implements ICoilType {

        ENTROPIC("entropic", 2048); // A placeholder value for heat capacity

        private final String name;
        private final int heatCapacity;

        CoilType(String name, int heatCapacity) {
            this.name = name;
            this.heatCapacity = heatCapacity;
        }

        @Override
        public String getName() {
            return this.name;
        }

        @Override
        public int getCoilTemperature() {
            return 0;
        }

        @Override
        public int getLevel() {
            return 0;
        }

        @Override
        public int getEnergyDiscount() {
            return 0;
        }

        @Override
        public int getTier() {
            return 0;
        }

        @Override
        public Material getMaterial() {
            return null;
        }

        @Override
        public ResourceLocation getTexture() {
            return null;
        }

        @Override
        public int getHeatCapacity() {
            return this.heatCapacity;
        }
    }

    // Coil Register
    // This now correctly calls the createCoilBlockWithCustomModel method
    // and passes the custom model provider as a lambda.
    public static final BlockEntry<CoilBlock> ENTROPIC = createCoilBlockWithCustomModel(
            CoilType.ENTROPIC,
            // The lambda function is now correctly passed as an argument
            (ctx, prov) -> {
                String name = ctx.getName();
                ActiveBlock block = ctx.getEntry();
                ModelFile inactive = prov.models()
                        .cubeAll(name, phoenixcore.id("block/entropic_coil_block"));
                ModelFile active = prov.models()
                        .cubeAll(name + "_active", phoenixcore.id("block/entropic_coil_block_bloom"));

                prov.getVariantBuilder(block)
                        .partialState().with(GTBlockStateProperties.ACTIVE, false).modelForState().modelFile(inactive)
                        .addModel()
                        .partialState().with(GTBlockStateProperties.ACTIVE, true).modelForState().modelFile(active)
                        .addModel();
            });

    private static @NotNull BlockEntry<Block> registerSimpleBlock(String name, String id, String texture,
                                                                  NonNullBiFunction<Block, Item.Properties, ? extends BlockItem> func) {
        return REGISTRATE
                .block(id, Block::new)
                .initialProperties(() -> Blocks.IRON_BLOCK)
                .properties(p -> p.isValidSpawn((state, level, pos, ent) -> false))
                .blockstate((ctx, prov) -> prov.simpleBlock(ctx.getEntry(),
                        prov.models().cubeAll(ctx.getName(), phoenixcore.id("block/" + texture))))
                .lang(name)
                .item(func)
                .build()
                .register();
    }

    // Corrected method signature to accept a blockstate provider lambda.
    private static BlockEntry<CoilBlock> createCoilBlockWithCustomModel(ICoilType coilType,
                                                                        @NotNull NonNullBiFunction<com.tterrag.registrate.providers.DataGenContext<Block, CoilBlock>, com.tterrag.registrate.providers.RegistrateBlockstateProvider, Void> blockstateProvider) {
        BlockEntry<CoilBlock> coilBlock = REGISTRATE
                .block("%s_coil_block".formatted(coilType.getName()), p -> new CoilBlock(p, coilType))
                .initialProperties(() -> Blocks.IRON_BLOCK)
                .addLayer(() -> RenderType::cutoutMipped)
                .blockstate(blockstateProvider) // Pass the custom blockstate provider here
                .tag(CustomTags.MINEABLE_WITH_CONFIG_VALID_PICKAXE_WRENCH)
                .item(BlockItem::new)
                .build()
                .register();
        GTCEuAPI.HEATING_COILS.put(coilType, coilBlock);
        return coilBlock;
    }

    // Original method from your code, which uses the generic GTModels.
    // I've commented this out to avoid confusion, but you can use it if you don't need a custom model.
    /*
     * private static BlockEntry<CoilBlock> createCoilBlock(ICoilType coilType) {
     * BlockEntry<CoilBlock> coilBlock = REGISTRATE
     * .block("%s_coil_block".formatted(coilType.getName()), p -> new CoilBlock(p, coilType))
     * .initialProperties(() -> Blocks.IRON_BLOCK)
     * .addLayer(() -> RenderType::cutoutMipped)
     * .blockstate(GTModels.createCoilModel(coilType))
     * .tag(CustomTags.MINEABLE_WITH_CONFIG_VALID_PICKAXE_WRENCH)
     * .item(BlockItem::new)
     * .build()
     * .register();
     * GTCEuAPI.HEATING_COILS.put(coilType, coilBlock);
     * return coilBlock;
     * }
     */

    public static BlockEntry<Block> PHOENIX_ENRICHED_TRITANIUM_CASING = registerSimpleBlock(
            "§6Extremely Heat-Stable Casing", "phoenix_enriched_tritanium_casing",
            "phoenix_enriched_tritanium_casing", BlockItem::new);
    public static BlockEntry<Block> PHOENIX_GAZE_PANEL = registerSimpleBlock(
            "§cPhoenix Gaze Panel", "phoenix_gaze_panel",
            "phoenix_gaze_panel", BlockItem::new);
    public static BlockEntry<Block> PHOENIX_HEART_CASING = registerSimpleBlock(
            "§cPhoenix Heart Casing", "phoenix_heart_casing",
            "phoenix_heart_casing", BlockItem::new);
    public static BlockEntry<Block> TRUE_PHOENIX_INFUSED_CASING = registerSimpleBlock(
            "§cTrue Phoenix Infused Casing", "true_phoenix_infused_casing",
            "true_phoenix_infused_casing", BlockItem::new);
    public static final BlockEntry<Block> BLAZING_CLEANROOM_FILTER_CASING = createCleanroomFilter(
            BlazingFilterType.FILTER_CASING_BLAZING);

    // Placeholder for BlazingFilterType, you'll need to define this as well.
    // I've commented out the import for PhoenixCoilBlockEntity as it's not
    // directly used in this code and was causing confusion.
    public enum BlazingFilterType implements IFilterType {

        FILTER_CASING_BLAZING("blazing_filter_casing", 1); // Placeholder

        private final String name;
        private final int heatCapacity;

        BlazingFilterType(String name, int heatCapacity) {
            this.name = name;
            this.heatCapacity = heatCapacity;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public int getTier() {
            return heatCapacity;
        }
    }

    private static BlockEntry<Block> createCleanroomFilter(IFilterType filterType) {
        var filterBlock = REGISTRATE.block(filterType.getSerializedName(), Block::new)
                .initialProperties(() -> Blocks.IRON_BLOCK)
                .properties(properties -> properties.strength(2.0f, 8.0f).sound(SoundType.METAL)
                        .isValidSpawn((blockState, blockGetter, blockPos, entityType) -> false))
                .blockstate(GTModels.createCleanroomFilterModel(filterType))
                .tag(CustomTags.MINEABLE_WITH_CONFIG_VALID_PICKAXE_WRENCH, CustomTags.TOOL_TIERS[1])
                .item(BlockItem::new)
                .build()
                .register();
        GTCEuAPI.CLEANROOM_FILTERS.put(filterType, filterBlock);
        return filterBlock;
    }
}
