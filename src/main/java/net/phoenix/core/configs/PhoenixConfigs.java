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

        // Features
        @Configurable
        @Configurable.Comment({ "Whether the Creative Energy Multiblock is enabled" })
        public boolean creativeEnergyEnabled = true;
        @Configurable
        @Configurable.Comment({ "Whether the Blazing Maintence Hatch is enabled" })
        public boolean blazingHatchEnabled = true;
        @Configurable
        @Configurable.Comment({
                "Whether the Blazing Cleanroom is enabled (This just disables the casings, you can have the hatch on with this off just fine fine)" })
        public boolean blazingCleanroomEnabled = false;
        @Configurable
        @Configurable.Comment({
                "Whether the Custom HPCA componets are enabled" })
        public boolean HPCAComponetsEnabled = true;

        // COMPUTATION

        @Configurable
        @Configurable.Comment({ "How powerful the normal Phoenix Computation Unit is (CWU/t)" })
        public int BasicPCUStrength = 24;
        @Configurable
        @Configurable.Comment({ "How powerful the Advanced Phoenix Computation Unit is (CWU/t)" })
        public int PCUStrength = 48;
        @Configurable
        @Configurable.Comment({
                "How much coolant the basic Phoenix Computation Unit uses (Coolant per tick for the advanced version is doubled from this number)" })
        public int BasicPCUCoolantUsed = 16;
        @Configurable
        @Configurable.Comment({
                "How much coolant the Advanced Phoenix Computation Unit uses (Coolant per tick for the advanced version is doubled from this number)" })
        public int PCUCoolantUsed = 4;
        @Configurable
        @Configurable.Comment({ "How powerful the normal Phoenix Computation Unit is (CWU/t) when damaged" })
        public int damagedBasicPCUStrength = 4;
        @Configurable
        @Configurable.Comment({ "How powerful the advanced Phoenix Computation Unit is (CWU/t) when damaged" })
        public int damagedPCUStrength = 8;
        @Configurable
        @Configurable.Comment({
                "How much EU the normal Phoenix Computation uses per tick (Goes off GTValues, ULV is 0, LV is 1, MV is 2, etc)" })
        public int basicPCUEutUpkeep = 8;
        @Configurable
        @Configurable.Comment({
                "How much EU the normal Phoenix Computation has for buffer (Goes off GTValues, ULV is 0, LV is 1, MV is 2, etc)" })
        public int basicPCUMaxEUt = 10;
        @Configurable
        @Configurable.Comment({
                "How much EU the advanced Phoenix Computation uses per tick (Goes off GTValues, ULV is 0, LV is 1, MV is 2, etc)" })
        public int PCUEutUpkeep = 8;
        @Configurable
        @Configurable.Comment({
                "How much EU the advanced Phoenix Computation has for buffer (Goes off GTValues, ULV is 0, LV is 1, MV is 2, etc)" })
        public int PCUMaxEUt = 10;

        // COOLING
        @Configurable
        @Configurable.Comment({ "How powerful the Phoenix Heat Sink is (Cooling Provided)" })
        public int HeatSinkStrength = 12;
        @Configurable
        @Configurable.Comment({ "How powerful the Phoenix Active Cooler is (Cooling Provided)" })
        public int ActiveCoolerStrength = 24;
        @Configurable
        @Configurable.Comment({
                "How much EU the Phoenix Heat Sink uses per tick (Goes off GTValues, ULV is 0, LV is 1, MV is 2, etc)" })
        public int HeatSinkEutUpkeep = 0;
        @Configurable
        @Configurable.Comment({
                "How much EU the Active Phoenix Cooler uses per tick (Goes off GTValues, ULV is 0, LV is 1, MV is 2, etc)" })
        public int ActiveCoolerEutUpkeep = 8;
        @Configurable
        @Configurable.Comment({ "How much coolant the Active Phoenix Cooler can use at max in milibuckets" })
        public int ActiveCoolerCoolantUse = 10;
    }
}
