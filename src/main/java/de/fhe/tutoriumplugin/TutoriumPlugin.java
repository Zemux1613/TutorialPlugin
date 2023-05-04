package de.fhe.tutoriumplugin;

import de.fhe.tutoriumplugin.commands.ClearInventoryCommand;
import de.fhe.tutoriumplugin.commands.ClearchatCommand;
import de.fhe.tutoriumplugin.commands.CraftCommand;
import de.fhe.tutoriumplugin.commands.EnderchestCommand;
import de.fhe.tutoriumplugin.commands.FeedCommand;
import de.fhe.tutoriumplugin.commands.FlyCommand;
import de.fhe.tutoriumplugin.commands.GmCommand;
import de.fhe.tutoriumplugin.commands.HealCommand;
import de.fhe.tutoriumplugin.commands.KillCommand;
import de.fhe.tutoriumplugin.commands.SpeedCommand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class TutoriumPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // register commands
        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("heal").setExecutor(new HealCommand());
        getCommand("feed").setExecutor(new FeedCommand());
        getCommand("gm").setExecutor(new GmCommand());
        getCommand("enderchest").setExecutor(new EnderchestCommand());
        getCommand("craft").setExecutor(new CraftCommand());
        getCommand("clearinventory").setExecutor(new ClearInventoryCommand());
        getCommand("kill").setExecutor(new KillCommand());
        getCommand("clearchat").setExecutor(new ClearchatCommand());
        getCommand("speed").setExecutor(new SpeedCommand());

        // send startup message
        Bukkit.getConsoleSender().sendMessage("§aDas Plugin ist hochgefahren!");
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("§4Das Plugin ist runtergerutscht!");
    }
}
