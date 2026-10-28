package growthcraft.bees.common.block;

import growthcraft.api.core.definition.IItemStackFactory;
import growthcraft.bees.GrowthCraftBees;
import net.minecraft.item.ItemStack;

import java.util.Locale;

public enum EnumBeeBoxFA implements IItemStackFactory {

    ANCIENT,
    PALAEORAPHE;

    public static final EnumBeeBoxFA[] VALUES = {ANCIENT, PALAEORAPHE};
    public final String name;
    public final int meta;

    EnumBeeBoxFA() {
        this.name = name().toLowerCase(Locale.ENGLISH);
        this.meta = ordinal();
    }

    public ItemStack asStack(int size) {
        if (GrowthCraftBees.blocks.beeBoxFossilsAndArchaeology != null) {
            return GrowthCraftBees.blocks.beeBoxFossilsAndArchaeology.asStack(size, meta);
        }
        return null;
    }

    public ItemStack asStack() {
        return asStack(1);
    }
}
