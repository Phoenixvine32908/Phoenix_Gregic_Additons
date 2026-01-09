package net.phoenix.core.client;

import com.gregtechceu.gtceu.client.renderer.machine.DynamicRenderManager;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.phoenix.core.PhoenixGregicAdditons;
import net.phoenix.core.client.renderer.machine.ArtificialStarRender;
import net.phoenix.core.client.renderer.machine.EyeOfHarmonyRender;
import net.phoenix.core.client.renderer.machine.PlasmaArcFurnaceRender;

@Mod.EventBusSubscriber(modid = PhoenixGregicAdditons.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class PhoenixClient {

    private PhoenixClient() {}

    public static void init(IEventBus modBus) {
        // You can remove this line as the @Mod.EventBusSubscriber annotation handles registration
        // modBus.register(PhoenixClient.class);
        DynamicRenderManager.register(PhoenixGregicAdditons.id("eye_of_harmony"), EyeOfHarmonyRender.TYPE);
        DynamicRenderManager.register(PhoenixGregicAdditons.id("artificial_star"), ArtificialStarRender.TYPE);
        DynamicRenderManager.register(PhoenixGregicAdditons.id("plasma_arc_furnace"), PlasmaArcFurnaceRender.TYPE);
    }

    @SubscribeEvent
    public static void registerAdditionalModels(ModelEvent.RegisterAdditional event) {
        event.register(EyeOfHarmonyRender.SPACE_SHELL_MODEL_RL);
        event.register(EyeOfHarmonyRender.STAR_MODEL_RL);
        EyeOfHarmonyRender.ORBIT_OBJECTS_RL.forEach(event::register);
        event.register(ArtificialStarRender.ARTIFICIAL_STAR_MODEL_RL);
        event.register(PlasmaArcFurnaceRender.RINGS_MODEL_RL);
        event.register(PlasmaArcFurnaceRender.SPHERE_MODEL_RL);
    }

    // This is the new method you need to add
    @SubscribeEvent
    public static void onClientSetup(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            // Register your coil block's render type here
            // ItemBlockRenderTypes.setRenderLayer(PhoenixBlocks.COIL_TRUE_HEAT_STABLE.get(),
            // RenderType.cutoutMipped());
        });
    }
}
