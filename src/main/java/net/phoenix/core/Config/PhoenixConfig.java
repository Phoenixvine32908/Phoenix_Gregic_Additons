package net.phoenix.core.config;

import com.gregtechceu.gtceu.api.GTValues;

import net.phoenix.core.phoenixcore;

import dev.toma.configuration.Configuration;
import dev.toma.configuration.config.Config;
import dev.toma.configuration.config.ConfigHolder;
import dev.toma.configuration.config.Configurable;
import dev.toma.configuration.config.format.ConfigFormats;

@Config(id = phoenixcore.MOD_ID)
public class PhoenixConfig {

    public static PhoenixConfig INSTANCE;

    public static ConfigHolder<PhoenixConfig> CONFIG_HOLDER;

    public static void init() {
        CONFIG_HOLDER = Configuration.registerConfig(PhoenixConfig.class, ConfigFormats.yaml());
        INSTANCE = CONFIG_HOLDER.getConfigInstance();
    }

    @Configurable
    public FeatureConfigs features = new FeatureConfigs();

    public static class FeatureConfigs {

        @Configurable
        @Configurable.Comment({ "Whether the Phoenix Computation Unit is enabled." })
        public boolean computationUnitEnabled = false;
        @Configurable
        @Configurable.Comment({ "Whether the Phoenix Computation Unit is enabled." })
        public boolean coolingUnitEnabled = true;
        @Configurable
        @Configurable.Comment({ "Whether the Creative Energy Multiblock is enabled." })
        public boolean creativeEnergyEnabled = false;
        @Configurable
        @Configurable.Comment({ "What tier the Omni-breaker is, if enabled. (ULV = 0, LV = 1, MV = 2, ...)",
                "(Unless the default recipe is overridden, can only support LV to IV!)" })
        public int omnibreakerTier = GTValues.IV;
        @Configurable
        @Configurable.Comment("The energy capacity of the Omni-breaker.")
        public long omnibreakerEnergyCapacity = 40_960_000L;

        @Configurable
        @Configurable.Comment({ "Whether the Wireless Active Transformer is enabled." })
        public boolean pterbEnabled = true;

        @Configurable
        @Configurable.Comment({ "Base amount of WAT coolant to drain every second.",
                "(Setting both this amount and the IO multiplier to 0 disables the coolant mechanic.)" })
        public int pterbCoolantBaseDrain = 0;

        @Configurable
        @Configurable.Comment({ "Multiplier over IO amount for additional coolant drain.",
                "(Setting both this and the base drain amount to 0 disables the coolant mechanic.)" })
        public float pterbCoolantIOMultiplier = 0;

        @Configurable
        @Configurable.Comment({ "Whether the coins/credits are enabled." })
        public boolean coinsEnabled = false;
    }

    public static boolean coolantEnabled() {
        return PhoenixConfig.INSTANCE.features.pterbCoolantBaseDrain != 0 ||
                PhoenixConfig.INSTANCE.features.pterbCoolantIOMultiplier != 0.0f;
    }
}
