package gg.noc.TekkitUtils.Interaction;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.block.Action;
import org.bukkit.block.Sign;

import java.util.Random;

public class RTPInteract extends JavaPlugin {

    @EventHandler
    public void SignListener(SignChangeEvent e) {
        FileConfiguration config = this.getConfig();
        if(e.getLine(0).equalsIgnoreCase("[RTP]")) {
            if (e.getPlayer().hasPermission("gg.nocutils.placetpsign")) {
                e.setLine(0, ChatColor.translateAlternateColorCodes('&', config.getString("s1")));
                e.setLine(1, ChatColor.translateAlternateColorCodes('&', config.getString("s2")));
                e.setLine(2, ChatColor.translateAlternateColorCodes('&', config.getString("s3")));
                e.setLine(3, ChatColor.translateAlternateColorCodes('&', config.getString("s4")));
            }
        }
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        if (!(e.getAction() == Action.RIGHT_CLICK_BLOCK)) return;
        if (e.getClickedBlock().getState() instanceof Sign) {
            Sign s = (Sign) e.getClickedBlock().getState();
            if(s.getLine(0).equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', getConfig().getString("s1")))) {
                Random random = new Random();
                Player player = e.getPlayer();
                int x = random.nextInt(getConfig().getInt("rtp-maxX"));
                int y = 0;
                int z = random.nextInt(getConfig().getInt("rtp-maxZ"));
                Location location = new Location(player.getWorld(),x, y, z);
                y = player.getWorld().getHighestBlockYAt(location);
                location.setY(y);
                player.teleport(location);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("scsmes")));
            }
        }
    }
}
