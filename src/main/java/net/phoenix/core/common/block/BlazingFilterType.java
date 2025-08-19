package net.phoenix.core.common.block;

import com.gregtechceu.gtceu.api.block.IFilterType;
import com.gregtechceu.gtceu.api.machine.multiblock.CleanroomType;

import net.phoenix.core.common.machine.multiblock.BlazingCleanroom;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

/**
 * Custom IFilterType enum for the Blazing Cleanroom.
 * Note: Enums in Java cannot extend other enums, so we create a new
 * enum that implements the same interface, IFilterType.
 */
public enum BlazingFilterType implements IFilterType {

    // Define the custom filter type entry, linking it to your BlazingCleanroom class.
    FILTER_CASING_BLAZING("blazing_filter_casing", BlazingCleanroom.BLAZING_CLEANROOM);

    private final String name;
    @Getter
    private final CleanroomType cleanroomType;

    /**
     * Constructs a new BlazingFilterType enum entry.
     * 
     * @param name          The unique name of the filter type.
     * @param cleanroomType The custom cleanroom type associated with this filter.
     */
    BlazingFilterType(String name, CleanroomType cleanroomType) {
        this.name = name;
        this.cleanroomType = cleanroomType;
    }

    @NotNull
    @Override
    public String getSerializedName() {
        return this.name;
    }

    @NotNull
    @Override
    public String toString() {
        return getSerializedName();
    }
}
