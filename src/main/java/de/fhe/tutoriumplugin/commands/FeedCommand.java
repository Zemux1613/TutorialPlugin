package de.fhe.tutoriumplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FeedCommand implements CommandExecutor {

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
            "§aDu hast dem Spieler §e" + playerName + " §agesättigt§8.");
      } else if (args.length == 0) {
        toggleFly(player);
      } else {
        player.sendMessage("§7Bitte Verwende§8: /§cfeed §8<§cSpielername§8>");
      }
    } else {
      commandSender.sendMessage("§4Du bist kein Spieler! Du darfst sowas nicht tun!");
    }
    return false;
  }

  private static void toggleFly(Player target) {
    // Minecraft zählt immer halbe Hungerbalken, es gibt 10 Hungerkeulen, die ein Spieler haben kann
    // --> 20 halbe Hungerkeulen sind volle Sättigung.
    target.setFoodLevel(20);
    target.sendMessage("§7Du wurdest gesättigt§8.");
  }
}
