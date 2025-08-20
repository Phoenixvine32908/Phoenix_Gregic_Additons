package net.phoenix.core.common.machine.multiblock.part.hpca;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.capability.IHPCAComputationProvider;
import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.common.machine.multiblock.part.hpca.HPCAComputationPartMachine;

import com.lowdragmc.lowdraglib.gui.texture.ResourceTexture;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.phoenix.core.configs.PhoenixConfigs;

import javax.annotation.ParametersAreNonnullByDefault;

/**
 * A custom HPCA Computation Part for the Phoenix mod.
 * This part is designed to be a high-end component, offering
 * increased computation power (CWU) but also requiring more
 * energy and cooling.
 */
@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class PhoenixComputationPartMachine extends HPCAComputationPartMachine implements IHPCAComputationProvider {

    // You can define new tiers for your part if you need, or simply use a single tier.
    // For this example, we'll make a single, very powerful part.
    public PhoenixComputationPartMachine(IMachineBlockEntity holder) {
        // We pass 'false' to the super constructor because we are defining a new,
        // single-tier part that isn't 'advanced' in the base sense.
        super(holder, false);
    }

    /**
     * Defines the component icon.
     * You will need to define a custom ResourceTexture for this.
     * For now, we will use a placeholder texture from GTCEu and add a comment.
     * 
     * @return The resource texture for the part's icon.
     */
    @Override
    public ResourceTexture getComponentIcon() {
        if (isDamaged()) {
            // TODO: Replace with own damaged texture
            return GuiTextures.HPCA_ICON_DAMAGED_COMPUTATION_COMPONENT;
        }
        // TODO: Replace with own custom texture for the Phoenix part
        return GuiTextures.HPCA_ICON_ADVANCED_COMPUTATION_COMPONENT;
    }

    /**
     * Overrides the energy upkeep required per tick.
     * We'll make this part a late-game component, so it has a high upkeep.
     * 
     * @return The upkeep EUt per tick.
     */
    @Override
    public int getUpkeepEUt() {
        return GTValues.VA[GTValues.UV];
    }

    /**
     * Overrides the maximum EUt the part can handle before it breaks.
     * We'll set this to a very high value to match the part's tier.
     * 
     * @return The maximum EUt the part can handle.
     */
    @Override
    public int getMaxEUt() {
        return GTValues.VA[GTValues.MAX];
    }

    /**
     * Overrides the CWU (Computation Unit) output per tick.
     * This is the core purpose of the part.
     * We'll give it a very high value to make it worthwhile.
     * 
     * @return The CWU provided per tick.
     */
    @Override
    public int getCWUPerTick() {
        if (isDamaged()) return 0;
        return PhoenixConfigs.INSTANCE.features.PCUStrength;
    }

    /**
     * Overrides the amount of cooling the part provides.
     * Even though it's a powerful part, it still needs to be cooled.
     * You can customize this based on your balancing needs.
     * 
     * @return The amount of cooling provided per tick.
     */
    @Override
    public int getCoolingPerTick() {
        return 4; // Double the base advanced part's cooling.
    }
}
