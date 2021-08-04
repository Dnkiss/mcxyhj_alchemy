package cn.mcxyhj.dnkiss.recipe;

import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class RecipeManager {
    public List<String> allRecipe = new ArrayList<>();
    public List<String> getAllRecipe(){
        return allRecipe;
    }

    private final AlchemyRecipe pickaxe_1 = new Pickaxe_1();
    private final AlchemyRecipe alchemyStone_2 = new AlchemyStone_2();
    private final AlchemyRecipe enchantStone = new EnchantStone();

    public RecipeManager(){
        allRecipe.add(pickaxe_1.getName());
        allRecipe.add(alchemyStone_2.getName());
        allRecipe.add(enchantStone.getName());
    }

    public List<ItemStack> getRawMaterial(String name){
        if(name.equalsIgnoreCase(pickaxe_1.getName())){
            return pickaxe_1.getRawMaterial();
        }else if(name.equalsIgnoreCase(alchemyStone_2.getName())){
            return alchemyStone_2.getRawMaterial();
        }else if(name.equalsIgnoreCase(enchantStone.getName())){
            return enchantStone.getRawMaterial();
        }
        else{
            return null;
        }
    }

    public List<ItemStack> getResult(String name){
        if(name.equalsIgnoreCase(pickaxe_1.getName())){
            return pickaxe_1.getResult();
        }else if(name.equalsIgnoreCase(alchemyStone_2.getName())){
            return alchemyStone_2.getResult();
        }else if(name.equalsIgnoreCase(enchantStone.getName())){
            return enchantStone.getResult();
        }
        else{
            return null;
        }
    }
}
