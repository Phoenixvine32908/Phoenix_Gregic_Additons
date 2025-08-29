package net.phoenix.core.api;

import com.gregtechceu.gtceu.api.GTValues;

public class PhoenixGtValues extends GTValues {

    public static final int MAX_1 = 15;

    public static final int[] ALL_TIERS = new int[] { ULV, LV, MV, HV, EV, IV, LuV, ZPM, UV, UHV, UEV, UIV, UXV, OpV,
            MAX, MAX_1 };
    public static final int TIER_COUNT = ALL_TIERS.length;
}
