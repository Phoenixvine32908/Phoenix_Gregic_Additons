package net.phoenix.core.common.block;

import com.gregtechceu.gtceu.api.block.ICoilType;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.common.block.CoilBlock;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.phoenix.core.phoenixcore;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class PhoenixCoilBlock extends CoilBlock implements EntityBlock {

    public PhoenixCoilBlock(Properties properties, ICoilType coilType) {
        super(properties, coilType);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return PhoenixBlocks.COIL_CAUSAL_FABRIC.getSibling(Registries.BLOCK_ENTITY_TYPE)
                .get().create(pos, state);
    }

    public enum CoilType implements StringRepresentable, ICoilType {

        PRISMATIC_TUNGSTENSTEEL("prismatic_tungstensteel", 4500, 3, 4, 2, () -> CosmicMaterials.PrismaticTungstensteel,
                phoenixcore.id("block/casings/coils/prismatic_tungstensteel"));

        @NotNull
        @Getter
        private final String name;
        // electric blast furnace properties
        @Getter
        private final int coilTemperature;
        @Getter
        private final int tier;
        // multi smelter properties
        @Getter
        private final int level;
        @Getter
        private final int energyDiscount;
        @NotNull
        private final Supplier<Material> material;
        @NotNull
        @Getter
        private final ResourceLocation texture;

        CoilType(String name, int coilTemperature, int tier, int level, int energyDiscount, Supplier<Material> material,
                 ResourceLocation texture) {
            this.name = name;
            this.coilTemperature = coilTemperature;
            this.tier = tier;
            this.level = level;
            this.energyDiscount = energyDiscount;
            this.material = material;
            this.texture = texture;
        }

        public Material getMaterial() {
            return material.get();
        }

        @NotNull
        @Override
        public String toString() {
            return getName();
        }

        @Override
        @NotNull
        public String getSerializedName() {
            return name;
        }
    }
}
