package cn.mcxyhj.dnkiss;

import cn.mcxyhj.dnkiss.recipe.RecipeManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class Alchemy extends JavaPlugin {

    public static Plugin plugin;
    public static AlchemyItem alchemyItem = new AlchemyItem();
    public static RecipeManager recipeManager = new RecipeManager();
    public static AlchemyManager alchemyManager = new AlchemyManager();
    public static  AlchemyConfig alchemyConfig = new AlchemyConfig();

    @Override
    public void onEnable(){
        plugin = this;
        System.out.println("星夜幻境炼金插件加载");
        Bukkit.getPluginManager().registerEvents(new AlchemyListener(),this);
        Objects.requireNonNull(this.getCommand("Alchemy")).setExecutor(new AlchemyCommand());
        //-----------------------------------
        saveDefaultConfig();

    }

    @Override
    public void onDisable(){
        System.out.println("星夜幻境炼金插件卸载");
    }

}
