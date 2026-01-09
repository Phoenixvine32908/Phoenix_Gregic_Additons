package net.phoenix.core.mixin;

import com.gregtechceu.gtceu.integration.ae2.machine.MEPatternBufferPartMachine;

import net.phoenix.core.api.CustomNameAccess;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value = MEPatternBufferPartMachine.class, remap = false)
public abstract class MixinMEPatternBufferPartMachine implements CustomNameAccess {

    @Shadow(remap = false)
    private String customName;

    @Override
    public String phoenix$getCustomName() {
        return this.customName;
    }
}
