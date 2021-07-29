package cn.mcxyhj.dnkiss;

import cn.mcxyhj.dnkiss.recipe.RecipeManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class Alchemy extends JavaPlugin {

    public static AlchemyItem alchemyItem = new AlchemyItem();
    public static RecipeManager recipeManager = new RecipeManager();
    public static AlchemyManager alchemyManager = new AlchemyManager();

    @Override
    public void onEnable(){
        System.out.println("星夜幻境炼金插件加载");
        Bukkit.getPluginManager().registerEvents(new AlchemyListener(),this);
        Objects.requireNonNull(this.getCommand("Alchemy")).setExecutor(new AlchemyCommand());
    }

    @Override
    public void onDisable(){
        System.out.println("星夜幻境炼金插件卸载");
    }

}
