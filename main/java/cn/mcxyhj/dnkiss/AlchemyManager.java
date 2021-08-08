package cn.mcxyhj.dnkiss;

import cn.mcxyhj.dnkiss.recipe.Pickaxe_1;
import cn.mcxyhj.dnkiss.recipe.RecipeManager;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Beacon;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;


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

    public boolean canDoEnchant(Player p){
        ItemStack mainHand = p.getInventory().getItemInMainHand();
        ItemStack offHand = p.getInventory().getItemInOffHand();
        ItemStack enchantStone = Alchemy.alchemyItem.getEnchantStone();
        if(mainHand.getType().equals(Material.ENCHANTED_BOOK)){
            EnchantmentStorageMeta enchantmentStorageMeta = (EnchantmentStorageMeta) mainHand.getItemMeta();
            Map<Enchantment,Integer> enchant = enchantmentStorageMeta.getStoredEnchants();
            if(enchant.size() == 1){
                if(offHand.equals(Alchemy.alchemyItem.getUlEnchantStone())){
                    p.sendMessage("§d天佑石的力量显现了");
                    return true;
                }

                //效率
                if(enchant.containsKey(Enchantment.DIG_SPEED)){
                    //5-7，消耗一颗附魔石
                    if(enchant.get(Enchantment.DIG_SPEED)>=5 && enchant.get(Enchantment.DIG_SPEED)<7){
                        enchantStone.setAmount(1);
                        return offHand.equals(enchantStone);
                    }
                    //7-9,消耗八颗附魔石
                    if(enchant.get(Enchantment.DIG_SPEED)>=7 && enchant.get(Enchantment.DIG_SPEED)<9){
                        enchantStone.setAmount(8);
                        return offHand.equals(enchantStone);
                    }
                    //9-n,每级翻倍
                    if(enchant.get(Enchantment.DIG_SPEED)>=9){
                        enchantStone.setAmount((int) (8 * Math.pow((enchant.get(Enchantment.DIG_SPEED)-8),2)));
                        return offHand.equals(enchantStone);
                    }
                }
                //锋利
                if(enchant.containsKey(Enchantment.DAMAGE_ALL)){
                    //5级开始，从1颗开始，每级增加一颗消耗
                    if(enchant.get(Enchantment.DAMAGE_ALL)>=5){
                        enchantStone.setAmount(enchant.get(Enchantment.DAMAGE_ALL)-4);
                        return offHand.equals(enchantStone);
                    }
                }
            }
        }
        return false;
    }

    public String isEnchantSuccess(Player p){
        String enchantResult = null;
        EnchantmentStorageMeta enchantmentStorageMeta = (EnchantmentStorageMeta) p.getInventory().getItemInMainHand().getItemMeta();
        int i = new Random().nextInt(100)+1;
        //效率
        return null;
    }

    public void doEnchant(Player p){
        ItemStack mainHand = p.getInventory().getItemInMainHand();
        EnchantmentStorageMeta enchantmentStorageMeta = (EnchantmentStorageMeta) mainHand.getItemMeta();
        Map<Enchantment,Integer> enchant = enchantmentStorageMeta.getStoredEnchants();
        enchant.forEach((k,v)->{
            enchantmentStorageMeta.removeStoredEnchant(k);
            enchantmentStorageMeta.addStoredEnchant(k,v+1,true);
        });
        mainHand.setItemMeta(enchantmentStorageMeta);
        p.getInventory().setItemInMainHand(mainHand);
        p.getInventory().setItemInOffHand(new ItemStack(Material.AIR));

    }

}
