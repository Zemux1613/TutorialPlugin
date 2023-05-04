package de.fhe.tutoriumplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand implements CommandExecutor {

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
        heal(target);
        player.sendMessage(
            "§aDu hast dem Spieler §e" + playerName + " §ageheilt§8.");
      } else if (args.length == 0) {
        heal(player);
      } else {
        player.sendMessage("§7Bitte Verwende§8: /§cheal §8<§cSpielername§8>");
      }
    } else {
      commandSender.sendMessage("§4Du bist kein Spieler! Du darfst sowas nicht tun!");
    }
    return false;
  }

  private static void heal(Player target) {
    // Minecraft zählt immer halbe Herzen, es gibt 10 Herzen, die ein Spieler haben kann
    // --> 20 halbe Herzen sind volle Leben
    target.setHealth(20);
    target.sendMessage("§7Du wurdest geheilt§8.");
  }
}
