package gg.noc.nocutils.cmds;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Shrug extends JavaPlugin {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("shrug")) {
            if (sender instanceof Player) {
                if (sender.hasPermission("gg.nocutils.shrug")) {
                    Player player = (Player)sender;
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < args.length; ++i) {
                        sb.append(args[i]).append(" ");
                    }
                    String allArgs = sb.toString().trim();
                    String commandrun = "sudo " + player.getName() + " c:" + allArgs + " \u00af\\_(\u30c4)_/\u00af";
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

