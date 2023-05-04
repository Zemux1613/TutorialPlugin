package de.fhe.tutoriumplugin.commands;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

public class GmCommand implements CommandExecutor, TabExecutor {

  @Override
  public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
    if (commandSender instanceof final Player player) {
      if (args.length == 2) {
        final String playerName = args[1];
        final Player target = Bukkit.getPlayer(playerName);
        if (target == null) {
          player.sendMessage("§e" + playerName + " §cist offline.");
          return true;
        }
        final String gamemode = args[0];
        // optional mit stream, geht natürlich auch ohne entsprechend mit Schleife
        if (Arrays.stream(GameMode.values())
            .noneMatch(gameMode -> gameMode.name().toLowerCase().equals(gamemode.toLowerCase()))) {
          player.sendMessage("§cDer Gamemode §e" + gamemode + " §cexistiert nicht.");
          return true;
        }
        target.setGameMode(GameMode.valueOf(gamemode));
        target.sendMessage("§aDu bist nun im Gamemode §e" + gamemode + "§8.");
        player.sendMessage("§aDu hast dem Spieler §e" + playerName + " §aden Gamemode §e" + gamemode
            + " §agegeben§8.");
      } else if (args.length == 2) {
        final String gamemode = args[0];
        // optional mit stream, geht natürlich auch ohne entsprechend mit Schleife
        if (Arrays.stream(GameMode.values())
            .noneMatch(gameMode -> gameMode.name().toLowerCase().equals(gamemode.toLowerCase()))) {
          player.sendMessage("§cDer Gamemode §e" + gamemode + " §cexistiert nicht.");
          return true;
        }
        player.setGameMode(GameMode.valueOf(gamemode));
        player.sendMessage("§aDu bist nun im Gamemode §e" + gamemode + "§8.");
      } else {
        player.sendMessage("§7Bitte Verwende§8: /§cgm §8<§cGamemode§8> §8<§cSpielername§8>");
      }
    } else {
      commandSender.sendMessage("§4Du bist kein Spieler! Du darfst sowas nicht tun!");
    }
    return false;
  }

  /**
   * OPTIONAL: Schlage die richtigen Gamemode namen vor.
   */
  @Override
  public List<String> onTabComplete(CommandSender commandSender, Command command, String s,
      String[] strings) {
    if (strings.length == 1) {
      return Arrays.stream(GameMode.values()).map(gameMode -> gameMode.name().toLowerCase())
          .toList();
    }
    return Collections.emptyList();
  }
}

