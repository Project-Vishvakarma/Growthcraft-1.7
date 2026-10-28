package growthcraft.bees.integration;

import cpw.mods.fml.common.registry.GameRegistry;
import growthcraft.bees.GrowthCraftBees;
import growthcraft.bees.common.block.BlockBeeBoxWitchery;
import growthcraft.bees.common.item.ItemBlockBeeBox;
import growthcraft.core.integration.ModIntegrationBase;
import growthcraft.core.integration.witchery.EnumWitcheryWoodType;
import growthcraft.core.integration.witchery.WitcheryPlatform;
import net.minecraft.item.ItemStack;

public class WitcheryModule extends ModIntegrationBase {

    public WitcheryModule() {
        super(GrowthCraftBees.MOD_ID, WitcheryPlatform.MOD_ID);
    }

    @Override
    public void doPreInit() {
        GrowthCraftBees.blocks.beeBoxWitchery = GrowthCraftBees.blocks
            .newTypedDefinition(new BlockBeeBoxWitchery());
    }

    @Override
    public void doRegister() {
        GrowthCraftBees.blocks.beeBoxWitchery.register("grc.BeeBox.Witchery", ItemBlockBeeBox.class);
    }

    @Override
    protected void doLateRegister() {
        for (EnumWitcheryWoodType type : EnumWitcheryWoodType.VALUES) {
            final ItemStack planks = type.asPlanksItemStack();
            if (planks != null) {
                GameRegistry.addShapedRecipe(
                    GrowthCraftBees.blocks.beeBoxWitchery.asStack(1, type.meta),
                    " A ",
                    "A A",
                    "AAA",
                    'A',
                    planks);
            }
        }
    }
}
