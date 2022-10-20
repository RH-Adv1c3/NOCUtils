package gg.noc.nocutils.Interaction;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.Listener;

import java.util.Random;

public class RTP extends JavaPlugin implements Listener {
    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
        if (command.getName().equalsIgnoreCase("rtp")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("Console can't use this plugin!");
            }
            Player player = (Player) sender;
            if(args.length == 0) {
                Random random = new Random();

                int x = random.nextInt(getConfig().getInt("locx"));
                int y = 0;
                int z = random.nextInt(getConfig().getInt("locz"));
                Location l1 = new Location(player.getWorld(),x, y, z);
                y = player.getWorld().getHighestBlockYAt(l1);
                l1.setY(y);
                player.teleport(l1);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("scsmes")));
            }

        }
        return true;
    }
}
