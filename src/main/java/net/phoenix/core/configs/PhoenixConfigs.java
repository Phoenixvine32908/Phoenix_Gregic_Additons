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
        @Configurable
        @Configurable.Comment({ "How powerful the Phoenix Computation Unit is (CWU/t)" })
        public int PCUStrength = 16;
        @Configurable
        @Configurable.Comment({ "How powerful the Basic Phoenix Computation Unit is (CWU/t)" })
        public int BasicPCUStrength = 8;
    }
}
