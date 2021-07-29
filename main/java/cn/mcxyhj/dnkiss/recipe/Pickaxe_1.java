package cn.mcxyhj.dnkiss.recipe;

import cn.mcxyhj.dnkiss.Alchemy;
import cn.mcxyhj.dnkiss.AlchemyManager;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class Pickaxe_1 implements AlchemyRecipe {


    @Override
    public String getDisplayName() {
        return "一级魔法镐";
    }

    @Override
    public List<ItemStack> getRawMaterial() {
        List<ItemStack> itemStacks = new ArrayList<>();
        itemStacks.add(new ItemStack(Material.NETHERITE_PICKAXE,1));
        itemStacks.add(new ItemStack(Material.NETHER_STAR,1));
        itemStacks.add(Alchemy.alchemyItem.getAlchemyWood());
        return itemStacks;
    }

    @Override
    public List<ItemStack> getResult() {
        List<ItemStack> itemStacks = new ArrayList<>();
        itemStacks.add(Alchemy.alchemyItem.getAlchemyPickaxe_1());
        return itemStacks;
    }
}
