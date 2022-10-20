package gg.noc.nocutils.cmds;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class UnFlip extends JavaPlugin {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("unflip")) {
            if (sender instanceof Player) {
                if (sender.hasPermission("gg.nocutils.unflip")) {
                    Player player = (Player)sender;
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < args.length; ++i) {
                        sb.append(args[i]).append(" ");
                    }
                    String allArgs = sb.toString().trim();
                    String commandrun = "sudo " + player.getName() + " c:" + allArgs + " \u252c\u2500\u252c \u30ce( \u309c-\u309c\u30ce)";
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

