package cn.mcxyhj.dnkiss;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPistonEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class AlchemyListener implements Listener {

    AlchemyItem alchemyItem = new AlchemyItem();

    //玩家破坏方块
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
    //玩家受到伤害
    @EventHandler
    public void playerDamagedEvent(EntityDamageByEntityEvent e){
        if(e.getEntity().getType().equals(EntityType.PLAYER)){
            Player p = (Player) e.getEntity();

            //终极头盔
            if(p.getInventory().getHelmet().equals(Alchemy.alchemyItem.getUltimateHelmet())
            && p.getInventory().getItemInOffHand().getItemMeta().equals(Alchemy.alchemyItem.getAlchemyStone_3().getItemMeta())){
                LivingEntity livingEntity = (LivingEntity) e.getDamager();
                livingEntity.setHealth(livingEntity.getHealth()-e.getDamage());
                if(p.getInventory().getItemInOffHand().getAmount()>1){
                    ItemStack itemStack = p.getInventory().getItemInOffHand();
                    itemStack.setAmount(itemStack.getAmount()-1);
                    p.getInventory().setItemInOffHand(itemStack);
                }else{
                    p.getInventory().setItemInOffHand(new ItemStack(Material.AIR));
                }
                e.setCancelled(true);
            }




        }
    }
}
