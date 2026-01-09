package net.phoenix.core.mixin;

import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.integration.ae2.machine.MEPatternBufferPartMachine;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.registries.ForgeRegistries;

import appeng.menu.MenuOpener;
import appeng.menu.locator.MenuLocators;
import com.glodblock.github.extendedae.common.hooks.CutterHook;
import com.glodblock.github.extendedae.container.ContainerRenamer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = CutterHook.class, remap = false)
public class MixinCutterHook {

    @Inject(method = "onPlayerUseBlock", at = @At("HEAD"), cancellable = true)
    private void monilabs$onPlayerUseBlock(Player player, Level level, InteractionHand hand,
                                           BlockHitResult hitResult, CallbackInfoReturnable<InteractionResult> cir) {
        if (player.isSpectator() || hand != InteractionHand.MAIN_HAND) return;

        ItemStack stack = player.getItemInHand(hand);

        // Use registry names to avoid classloading issues with AE2 items
        var certusId = new net.minecraft.resources.ResourceLocation("ae2", "certus_quartz_cutting_knife");
        var netherId = new net.minecraft.resources.ResourceLocation("ae2", "nether_quartz_cutting_knife");

        boolean isKnife = stack.is(ForgeRegistries.ITEMS.getValue(certusId)) ||
                stack.is(ForgeRegistries.ITEMS.getValue(netherId));

        if (!isKnife) {
            return; // Not a knife, let the normal machine GUI open
        }

        var tile = level.getBlockEntity(hitResult.getBlockPos());

        if (tile instanceof IMachineBlockEntity machineHolder) {
            var metaMachine = machineHolder.getMetaMachine();

            // Check if it's your Expanded Pattern Buffer
            if (metaMachine instanceof MEPatternBufferPartMachine bufferMachine) {
                if (!level.isClientSide) {
                    MenuOpener.open(ContainerRenamer.TYPE, player, MenuLocators.forBlockEntity(tile));
                }
                cir.setReturnValue(InteractionResult.sidedSuccess(level.isClientSide));
            }

        }
    }
}
