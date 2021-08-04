package cn.mcxyhj.dnkiss.recipe;

import org.bukkit.inventory.ItemStack;

import java.util.List;

public interface AlchemyRecipe {
    public String getName();
    public List<ItemStack> getRawMaterial();
    public List<ItemStack> getResult();
}
