package cn.mcxyhj.dnkiss;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AlchemyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        Player p = (Player)commandSender;
        if(args[0].equalsIgnoreCase("test")){
            if(p.hasPermission("mcxyhj.alchemy.admin")){
                p.getInventory().addItem(Alchemy.alchemyItem.getAlchemyPickaxe_1());
                p.getInventory().addItem(Alchemy.alchemyItem.getAlchemyStone_1());
                p.getInventory().addItem(Alchemy.alchemyItem.getAlchemyWood());
                p.getInventory().addItem(Alchemy.alchemyItem.getAlchemyStone_2());
                p.sendMessage("已将所有Alchemy道具置于背包内，共3件");
            }
            else{
                p.sendMessage("你没有权限获取测试道具");
            }
            return true;
        }else if(args[0].equalsIgnoreCase("start")){
            if(Alchemy.recipeManager.getAllRecipe().contains(args[1])) {
                String recipeDisplayName = args[1];
                if (Alchemy.alchemyManager.canDoAlchemy(p, recipeDisplayName)) {
                    Alchemy.alchemyManager.doAlchemy(p, recipeDisplayName);
                    p.sendMessage("§6炼金产物出现了，这次炼金显然很成功，如果不算上你死了的话");
                } else {
                    p.sendMessage("§4虽然你付出了生命之力，但是炼金实验失败了，一定是哪里搞错了！");
                    p.setHealth(0);
                }
            }
            else{
                p.sendMessage("这件物品不在任何炼金纪录内，请检查你输入的名字是否正确");
            }
            return true;
        }else if(args[0].equalsIgnoreCase("list")){
            p.sendMessage("目前已知炼金产物名称如下");
            Alchemy.recipeManager.allRecipe.forEach(name ->{
                p.sendMessage("§a"+name);
            });
            return true;
        }
        return false;
    }
}
