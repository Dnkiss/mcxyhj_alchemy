package cn.mcxyhj.dnkiss;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;

public class AlchemyListener implements Listener {

    AlchemyItem alchemyItem = new AlchemyItem();

    //玩家挖掘矿石
    @EventHandler
    public void playerBreakBlockEvent(BlockBreakEvent e){
        Player p = e.getPlayer();
        Block b = e.getBlock();
        if(b.getType().equals(Material.DEEPSLATE_COAL_ORE)){
            if(p.getInventory().getItemInMainHand().equals(alchemyItem.getAlchemyPickaxe_1())){
                b.getWorld().dropItem(b.getLocation(),alchemyItem.getAlchemyStone_1());
            }
        }
    }

}
