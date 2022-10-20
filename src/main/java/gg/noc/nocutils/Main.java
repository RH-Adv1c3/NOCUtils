package gg.noc.nocutils;

import gg.noc.nocutils.Interaction.RTP;
import gg.noc.nocutils.cmds.Shrug;
import gg.noc.nocutils.cmds.TableFlip;
import gg.noc.nocutils.cmds.UnFlip;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public void onEnable() {
        FileConfiguration config = this.getConfig();
        config.addDefault("enable-signs", true);
        config.addDefault("enable-console-debug", true);
        config.addDefault("enable-console-logs", true);
        config.addDefault("rtp-maxX", 2000);
        config.addDefault("rtp-maxZ", 2000);
        config.addDefault("s1", "&5[RTP]");
        config.addDefault("s2", "&0Right click");
        config.addDefault("s3", "&0sign for");
        config.addDefault("s4", "&0random TP");
        config.options().copyDefaults();
        saveDefaultConfig();
        if (config.getBoolean("enable-console-debug")) { Bukkit.getServer().getLogger().info("[NOCUtils] Config loaded!"); }
        this.getCommand("tableflip").setExecutor(new TableFlip());
        this.getCommand("unflip").setExecutor(new UnFlip());
        this.getCommand("shrug").setExecutor(new Shrug());
        this.getCommand("rtp").setExecutor(new RTP());
        if (config.getBoolean("enable-console-debug")) { Bukkit.getServer().getLogger().info("[NOCUtils] Commands have been initialized!"); }
    }

    public void onDisable() {
        FileConfiguration config = this.getConfig();
        if (config.getBoolean("enable-console-debug")) { Bukkit.getServer().getLogger().info("[NOCUtils] Has been disabled!"); }
    }
}

