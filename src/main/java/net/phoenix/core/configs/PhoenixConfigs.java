package net.phoenix.core.configs;

import net.phoenix.core.phoenixcore;

import dev.toma.configuration.Configuration;
import dev.toma.configuration.config.Config;
import dev.toma.configuration.config.ConfigHolder;
import dev.toma.configuration.config.Configurable;
import dev.toma.configuration.config.format.ConfigFormats;

@Config(id = phoenixcore.MOD_ID)
public class PhoenixConfigs {

    public static PhoenixConfigs INSTANCE;

    public static ConfigHolder<PhoenixConfigs> CONFIG_HOLDER;

    public static void init() {
        CONFIG_HOLDER = Configuration.registerConfig(PhoenixConfigs.class, ConfigFormats.yaml());
        INSTANCE = CONFIG_HOLDER.getConfigInstance();
    }

    @Configurable
    public FeatureConfigs features = new FeatureConfigs();

    public static class FeatureConfigs {

        @Configurable
        @Configurable.Comment({ "Whether the Creative Energy Multiblock is enabled" })
        public boolean creativeEnergyEnabled = true;
        @Configurable
        @Configurable.Comment({ "Whether the Blazing Maintence Hatch is enabled" })
        public boolean blazingHatchEnabled = true;
        @Configurable.Comment({
                "Whether the Blazing Cleanroom is enabled (Warning, having this off but blazingHatchEnabled on will cause you to crash)" })
        public boolean blazingCleanroomEnabled = false;
        @Configurable
        @Configurable.Comment({ "How powerful the normal Phoenix Computation Unit is (CWU/t)" })
        public int BasicPCUStrength = 24;
        @Configurable
        @Configurable.Comment({ "How powerful the Advanced Phoenix Computation Unit is (CWU/t)" })
        public int PCUStrength = 48;
        @Configurable
        @Configurable.Comment({ "How powerful the Phoenix Heat Sink is (Cooling Provided)" })
        public int BasicPCCUStrength = 12;
        @Configurable
        @Configurable.Comment({ "How powerful the Phoenix Active Cooler is (Cooling Provided)" })
        public int PCCUStrength = 24;
        @Configurable
        @Configurable.Comment({
                "How much coolant the basic Phoenix Computation Unit uses (Coolant per tick for the advanced version is doubled from this number)" })
        public int BasicPCUCoolantUsed = 4;
        @Configurable
        @Configurable.Comment({
                "How much coolant the Advanced Phoenix Computation Unit uses (Coolant per tick for the advanced version is doubled from this number)" })
        public int PCUCoolantUsed = 4;
        @Configurable
        @Configurable.Comment({ "How powerful the normal Phoenix Computation Unit is (CWU/t) when damaged" })
        public int damagedBasicPCUStrength = 4;
    }
}
