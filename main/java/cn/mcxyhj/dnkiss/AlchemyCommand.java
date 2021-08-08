package cn.mcxyhj.dnkiss;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class AlchemyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        Player p = (Player) commandSender;
        if (!p.hasPermission("mcxyhj.alchemy.admin") && Alchemy.plugin.getConfig().getBoolean("testmode")) {
            p.sendMessage("§4插件处于调试阶段，无法使用指令");
            return true;
        }
        if (args.length == 0) {
            p.sendMessage("§b使用：/alchemy help获取帮助");
            return true;
        } else if (args.length == 1) {
            if (args[0].equalsIgnoreCase("test")) {
                if (p.hasPermission("mcxyhj.alchemy.admin")) {
                    for (ItemStack itemStack : Alchemy.alchemyItem.getAllItem())
                        p.getInventory().addItem(itemStack);
                    p.sendMessage("已将所有Alchemy道具置于背包内，共 " + Alchemy.alchemyItem.getAllItem().size() + " 件");
                } else {
                    p.sendMessage("你没有权限获取测试道具");
                }
                return true;
            } else if (args[0].equalsIgnoreCase("enchant")) {
                if (Alchemy.alchemyManager.canDoEnchant(p)) {
                    Alchemy.alchemyManager.doEnchant(p);
                    p.sendMessage("§a附魔成功了！");
                } else {
                    p.sendMessage("§4附魔过程出错了，可能是材料并没有准备好!");
                }
                return true;
            } else if (args[0].equalsIgnoreCase("list")) {
                p.sendMessage("目前已知炼金产物名称如下");
                Alchemy.recipeManager.allRecipe.forEach(name -> {
                    p.sendMessage("§a" + name);
                });
                return true;
            } else if (args[0].equalsIgnoreCase("help")){
                p.sendMessage("§a星夜幻境炼金术插件指令帮助");
                p.sendMessage("§a/alchemy list：查看炼金配方列表");
                p.sendMessage("§a/alchemy start 炼金物名称：进行炼金");
                p.sendMessage("§a/alchemy enchant：使用附魔石类物品");
                if(p.hasPermission("mcxyhj.alchemy.admin")){
                    p.sendMessage("§d管理员指令：");
                    p.sendMessage("§d/alchemy test");
                }
                return true;
            }
        } else if (args.length == 2) {
            if (args[0].equalsIgnoreCase("start")) {
                if (Alchemy.recipeManager.getAllRecipe().contains(args[1])) {
                    String recipeDisplayName = args[1];
                    if (Alchemy.alchemyManager.canDoAlchemy(p, recipeDisplayName)) {
                        Alchemy.alchemyManager.doAlchemy(p, recipeDisplayName);
                        p.sendMessage("§6炼金产物出现了，这次炼金显然很成功，如果不算上你死了的话");
                    } else {
                        p.sendMessage("§4虽然你付出了生命之力，但是炼金实验失败了，一定是哪里搞错了！");
                        p.setHealth(0);
                    }
                } else {
                    p.sendMessage("这件物品不在任何炼金纪录内，请检查你输入的名字是否正确");
                }
                return true;
            }
        }
        return false;
    }
}
