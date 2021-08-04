package cn.mcxyhj.dnkiss.recipe;

import cn.mcxyhj.dnkiss.Alchemy;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class EnchantStone implements AlchemyRecipe {
    @Override
    public String getName() {
        return "附魔石";
    }

    @Override
    public List<ItemStack> getRawMaterial() {
        List<ItemStack> rawMaterial = new ArrayList<>();
        ItemStack alchemyStone = Alchemy.alchemyItem.getAlchemyStone_1();
        alchemyStone.setAmount(16);
        rawMaterial.add(alchemyStone);
        rawMaterial.add(new ItemStack(Material.LAPIS_BLOCK,1));
        return rawMaterial;
    }

    @Override
    public List<ItemStack> getResult() {
        List<ItemStack> result = new ArrayList<>();
        result.add(Alchemy.alchemyItem.getEnchantStone());
        return result;
    }
}
