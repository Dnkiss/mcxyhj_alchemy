package cn.mcxyhj.dnkiss;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlchemyItem {

    //从配置文件自定义item存储表
    public static Map<String, ItemStack> customItem = new HashMap<>();

    public static ItemStack createItemStack(Material material,String displayName,List<String> lore){
        ItemStack itemStack = new ItemStack(material,1);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(displayName);
        itemMeta.setLore(lore);
        itemMeta.setUnbreakable(true);
        itemMeta.addEnchant(Enchantment.MENDING,1,true);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public ItemStack getAlchemyWood(){
        List<String> lore = new ArrayList<>();
        lore.add("§7上古遗留的具有魔法力量的木头");
        lore.add("§7用来制作炼金术师初始的工具");
        lore.add("§7任何对此物件的改变都会使其魔法力量无效");
        return createItemStack(Material.DARK_OAK_WOOD,"§a蕴含着魔法力量的原木",lore);
    }

    public ItemStack getAlchemyStone_1(){
        List<String> lore = new ArrayList<>();
        lore.add("§7初级炼金石，可为炼金术或炼金工具提供魔法能量");
        lore.add("§7任何对此物件的改变都会使其魔法力量无效");
        return createItemStack(Material.EMERALD,"§a初级炼金石",lore);
    }

    public ItemStack getAlchemyStone_2(){
        List<String> lore = new ArrayList<>();
        lore.add("§7中级炼金石，可为炼金术或炼金工具提供魔法能量");
        lore.add("§7任何对此物件的改变都会使其魔法力量无效");
        return createItemStack(Material.EMERALD,"§a中级炼金石",lore);
    }

    public ItemStack getAlchemyPickaxe_1(){
        List<String> lore = new ArrayList();
        lore.add("§7一级魔法镐，可从深层煤矿石中采集炼金石");
        lore.add("§7任何对此物件的改变都会使其魔法力量无效");
        return createItemStack(Material.WOODEN_PICKAXE,"§a一级魔法镐",lore);
    }
}
