package de.fhe.tutoriumplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {

  @Override
  public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
    if (commandSender instanceof final Player player) {
      if (args.length == 1) {
        final String playerName = args[0];
        final Player target = Bukkit.getPlayer(playerName);
        if (target == null) {
          player.sendMessage("§e" + playerName + " §cist offline.");
          return true;
        }
        toggleFly(target);
        player.sendMessage(
            "§aDu hast dem Spieler §e" + playerName + " §aden Flugmodus " + (target.getAllowFlight()
                ? "§2aktiviert" : "§cdeaktiviert") + "§8.");
      } else if (args.length == 0) {
        toggleFly(player);
      } else {
        player.sendMessage("§7Bitte Verwende§8: /§cfly §8<§cSpielername§8>");
      }
    } else {
      commandSender.sendMessage("§4Du bist kein Spieler! Du darfst sowas nicht tun!");
    }
    return false;
  }

  private static void toggleFly(Player target) {
    target.setAllowFlight(!target.getAllowFlight());
    target.setFlying(target.getAllowFlight());
    target.sendMessage("§7Der Flugmodus für dich wurde " + (target.getAllowFlight() ? "§aaktiviert"
        : "§cdeaktiviert") + "§8.");
  }
}
