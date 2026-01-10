package net.phoenix.core.mixin;

import com.glodblock.github.extendedae.container.ContainerRenamer;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.phoenix.core.api.CustomNameAccess;
import net.phoenix.core.mixin.MEPatternBufferInvoker;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Consumer;
import java.util.function.Supplier;

@Mixin(value = ContainerRenamer.class, remap = false)
public abstract class MixinContainerRenamer {

    @Shadow @Final @Mutable
    private Consumer<String> setter;

    @Shadow
    @Final
    @Mutable
    private Supplier<Component> getter;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void phoenix$init(
            int id, Inventory playerInventory, Object host, CallbackInfo ci) {

        Object target = resolveTarget(host);
        if (!(target instanceof IMachineBlockEntity holder)) return;

        Object meta = holder.getMetaMachine();
        if (!(meta instanceof CustomNameAccess access)) return;

        Consumer<String> setterFn = name -> {
            if (meta instanceof MEPatternBufferInvoker invoker) {
                invoker.phoenix$invokeSetCustomName(name);
            }
        };

        apply(setterFn, access::phoenix$getCustomName);
    }

    private void apply(Consumer<String> setter, Supplier<String> getter) {
        this.setter = setter;
        this.getter = () -> Component.literal(getter.get());
        ((ContainerRenamer)(Object)this).setValidMenu(true);
    }

    private Object resolveTarget(Object host) {
        if (host instanceof IMachineBlockEntity) {
            return host;
        }
        return host;
    }
}
