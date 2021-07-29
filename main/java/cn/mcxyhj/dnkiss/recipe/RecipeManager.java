package cn.mcxyhj.dnkiss.recipe;

import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class RecipeManager {
    public List<String> allRecipe = new ArrayList<>();
    public List<String> getAllRecipe(){
        return allRecipe;
    }

    private Pickaxe_1 pickaxe_1 = new Pickaxe_1();
    private AlchemyStone_2 alchemyStone_2 = new AlchemyStone_2();

    public RecipeManager(){
        allRecipe.add(pickaxe_1.getDisplayName());
        allRecipe.add(alchemyStone_2.getDisplayName());
    }

    public List<ItemStack> getRawMaterial(String DisplayName){
        if(DisplayName.equalsIgnoreCase(pickaxe_1.getDisplayName())){
            return pickaxe_1.getRawMaterial();
        }else if(DisplayName.equalsIgnoreCase(alchemyStone_2.getDisplayName())){
            return alchemyStone_2.getRawMaterial();
        }
        else{
            return null;
        }
    }

    public List<ItemStack> getResult(String DisplayName){
        if(DisplayName.equalsIgnoreCase(pickaxe_1.getDisplayName())){
            return pickaxe_1.getResult();
        }else if(DisplayName.equalsIgnoreCase(alchemyStone_2.getDisplayName())){
            return alchemyStone_2.getResult();
        }
        else{
            return null;
        }
    }
}
