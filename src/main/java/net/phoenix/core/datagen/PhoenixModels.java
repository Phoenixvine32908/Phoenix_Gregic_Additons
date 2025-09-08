/*package net.phoenix.core.datagen;

import net.minecraft.world.item.Item;
import net.phoenix.core.phoenixcore;

import com.tterrag.registrate.providers.DataGenContext;
import com.tterrag.registrate.providers.RegistrateItemModelProvider;
import com.tterrag.registrate.util.nullness.NonNullBiConsumer;

public class PhoenixModels {

    public static NonNullBiConsumer<DataGenContext<Item, Item>, RegistrateItemModelProvider> basicItemModel(String texturePath) {
        return (ctx, prov) -> prov.generated(ctx).texture("layer0", phoenixcore.id("item/" + texturePath));
    }
} */
