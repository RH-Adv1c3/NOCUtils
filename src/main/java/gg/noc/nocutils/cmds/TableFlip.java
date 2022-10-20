package gg.noc.nocutils.cmds;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class TableFlip
extends JavaPlugin {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("tableflip")) {
            if (sender instanceof Player) {
                if (sender.hasPermission("gg.nocutils.tableflip")) {
                    Player player = (Player)sender;
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < args.length; ++i) {
                        sb.append(args[i]).append(" ");
                    }
                    String allArgs = sb.toString().trim();
                    String commandrun = "sudo " + player.getName() + " c:" + allArgs + " (\u256f\u00b0\u25a1\u00b0\uff09\u256f\ufe35 \u253b\u2501\u253b";
                    sender.getServer().dispatchCommand((CommandSender)player.getServer().getConsoleSender(), commandrun);
                } else {
                    sender.sendMessage("You don't have enough permissions");
                }
            }
            return true;
        }
        return false;
    }
}

