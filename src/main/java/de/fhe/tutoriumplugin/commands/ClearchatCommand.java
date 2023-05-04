package de.fhe.tutoriumplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClearchatCommand implements CommandExecutor {

  @Override
  public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
    if (commandSender instanceof final Player player) {
      if (args.length == 0) {
        for (int i = 0; i < 255; i++) {
          Bukkit.broadcastMessage("");
        }
        player.sendMessage("§aDu hast den Chat geleert§8.");
      } else {
        player.sendMessage("§7Bitte Verwende§8: /§cclearchat");
      }
    } else {
      commandSender.sendMessage("§4Du bist kein Spieler! Du darfst sowas nicht tun!");
    }
    return false;
  }
}
