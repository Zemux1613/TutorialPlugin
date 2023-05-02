package de.fhe.tutoriumplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {

  @Override
  public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
    if (commandSender instanceof Player) {
      Player player = (Player) commandSender;

      if (args.length == 1) {
        String playername = args[0];
        Player target = Bukkit.getPlayer(playername);
        if (target == null) {
          player.sendMessage("§e" + playername + " §cist offline.");
          return true;
        }
        if (target.getAllowFlight()) {
          target.setAllowFlight(false);
          target.setFlying(false);
          target.sendMessage("§cDu darf jetzt nicht mehr fliegen!");
        } else {
          target.setAllowFlight(true);
          target.setFlying(true);
          target.sendMessage("§aDu darf jetzt fliegen!");
        }
        player.sendMessage(
            "§aDu hast dem Spieler §e" + playername + " §aden Flugmodus " + (target.getAllowFlight()
                ? "§2aktiviert" : "§cdeaktiviert") + "§8.");
      } else {
        if (player.getAllowFlight()) {
          player.setAllowFlight(false);
          player.setFlying(false);
          player.sendMessage("§cDu darf jetzt nicht mehr fliegen!");
        } else {
          player.setAllowFlight(true);
          player.setFlying(true);
          player.sendMessage("§aDu darf jetzt fliegen!");
        }
      }
    } else {
      commandSender.sendMessage("§4Du bist kein Spieler! Du darfst sowas nicht tun!");
    }
    return false;
  }
}
