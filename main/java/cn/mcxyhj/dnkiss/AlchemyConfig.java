package cn.mcxyhj.dnkiss;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AlchemyConfig {

    public static Plugin plugin = Alchemy.plugin;
    public FileConfiguration getConfig(){
        return plugin.getConfig();
    }





    /*public static File configFile = null;
    public static FileConfiguration config = null;
    public FileConfiguration getConfig() {
        if (config == null) {
            if (configFile == null) {
                configFile = new File(plugin.getDataFolder(), "config.yml");
            }
            config = YamlConfiguration.loadConfiguration(configFile);
        }
        return config;
    }

    public void saveCustomConfig() {
        if (config == null || configFile == null) {
            return;
        }
        try {
            getConfig().save(configFile);
        } catch (IOException ex) {
            plugin.getLogger().warning("Could not save config to " + configFile);
        }
    }*/
}
