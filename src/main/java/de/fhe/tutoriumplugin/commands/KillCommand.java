package de.fhe.tutoriumplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KillCommand implements CommandExecutor {

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
        target.setHealth(0);
        player.sendMessage("§aDu hast dem Spieler §e" + playerName + " §agetötet§8.");
      } else if (args.length == 0) {
        player.setHealth(0);
        player.sendMessage("§cDu hast dich getötet.");
      } else {
        player.sendMessage("§7Bitte Verwende§8: /§cfly §8<§cSpielername§8>");
      }
    } else {
      commandSender.sendMessage("§4Du bist kein Spieler! Du darfst sowas nicht tun!");
    }
    return false;
  }
}