package growthcraft.bees.common.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import growthcraft.core.integration.natura.EnumNaturaWoodType;
import growthcraft.core.integration.witchery.EnumWitcheryWoodType;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

public class BlockBeeBoxWitchery extends BlockBeeBox {

    public BlockBeeBoxWitchery() {
        super();
        setHardness(2f);
        setBlockName("grc.BeeBox.Witchery");
    }

    @Override
    public String getMetaname(int meta) {
        if (meta >= 0 && meta < EnumWitcheryWoodType.VALUES.length) {
            return EnumWitcheryWoodType.VALUES[meta].name;
        }
        return super.getMetaname(meta);
    }

    @Override
    @SideOnly(Side.CLIENT)
    @SuppressWarnings({"rawtypes", "unchecked"})
    public void getSubBlocks(Item block, CreativeTabs tab, List list) {
        for (int i = 0; i < EnumWitcheryWoodType.VALUES.length; ++i) {
            list.add(new ItemStack(block, 1, i));
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister reg) {
        this.icons = new IIcon[4 * EnumWitcheryWoodType.VALUES.length];
        for (EnumWitcheryWoodType type : EnumWitcheryWoodType.VALUES) {
            registerBeeBoxIcons(reg, String.format("/witchery/%s/", type.name), type.meta);
        }
    }
}
