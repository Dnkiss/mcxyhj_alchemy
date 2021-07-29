package cn.mcxyhj.dnkiss;

import cn.mcxyhj.dnkiss.recipe.Pickaxe_1;
import cn.mcxyhj.dnkiss.recipe.RecipeManager;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Beacon;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;


public class AlchemyManager {

    //判定炼金装置是否合理
    //目前炼金装置为一个信标且信标正下方为下界合金块
    public boolean isAlchemyPlant(Location location){
        location.add(0,-1,0);
        Block beacon = location.getBlock();
        location.add(0,-1,0);
        Block netherite = location.getBlock();
        if(beacon.getType().equals(Material.BEACON)){
            System.out.println("信标判断成功");
            Beacon realBeacon = (Beacon) beacon.getState();
            return realBeacon.getTier() >= 1 && netherite.getType().equals(Material.NETHERITE_BLOCK);
        }
        return false;
    }

    public boolean canDoAlchemy(Player p, String recipeDisplayName){
        List<ItemStack> RawMaterial = Alchemy.recipeManager.getRawMaterial(recipeDisplayName);
        for (ItemStack itemStack : RawMaterial) {
            if (!p.getInventory().contains(itemStack)) return false;
        }
        if(!isAlchemyPlant(p.getLocation())) return false;
        return true;
    }

    public void doAlchemy(Player p, String recipeDisplayName){
        List<ItemStack> result = Alchemy.recipeManager.getResult(recipeDisplayName);
        p.getInventory().clear();
        for(ItemStack itemStack : result){
            //p.getWorld().dropItem(p.getLocation(),itemStack);
            p.getInventory().addItem(itemStack);
        }
        p.setHealth(0);
    }

}
