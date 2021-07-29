package cn.mcxyhj.dnkiss.recipe;

import cn.mcxyhj.dnkiss.Alchemy;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class AlchemyStone_2 implements AlchemyRecipe {
    @Override
    public String getDisplayName() {
        return "中级炼金石";
    }

    @Override
    public List<ItemStack> getRawMaterial() {
        List<ItemStack> rawMaterial = new ArrayList<>();
        ItemStack alchemyStone_1 = Alchemy.alchemyItem.getAlchemyStone_1();
        alchemyStone_1.setAmount(16);
        rawMaterial.add(alchemyStone_1);
        return rawMaterial;
    }

    @Override
    public List<ItemStack> getResult() {
        List<ItemStack> result = new ArrayList<>();
        result.add(Alchemy.alchemyItem.getAlchemyStone_2());
        return result;
    }
}
