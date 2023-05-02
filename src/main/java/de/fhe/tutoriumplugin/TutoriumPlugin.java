package de.fhe.tutoriumplugin;

import de.fhe.tutoriumplugin.commands.FlyCommand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class TutoriumPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // register fly command
        getCommand("fly").setExecutor(new FlyCommand());

        // send startup message
        Bukkit.getConsoleSender().sendMessage("§aDas Plugin ist hochgefahren!");
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("§4Das Plugin ist runtergerutscht!");
    }
}
