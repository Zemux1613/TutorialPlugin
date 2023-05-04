package de.fhe.tutoriumplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;

public class CraftCommand implements CommandExecutor {

  @Override
  public boolean onCommand(CommandSender commandSender, Command command, String s,
      String[] args) {

    if (commandSender instanceof final Player player) {
      if (args.length == 1) {
        final String playerName = args[0];
        final Player target = Bukkit.getPlayer(playerName);
        if (target == null) {
          player.sendMessage("§e" + playerName + " §cist offline.");
          return true;
        }
        target.openInventory(Bukkit.createInventory(null, InventoryType.CRAFTING));
        player.sendMessage(
            "§aDu hast dem Spieler §e" + playerName + " §adie Werkbank geöffnet§8.");
      } else if (args.length == 0) {
        player.openInventory(Bukkit.createInventory(null, InventoryType.CRAFTING));
      } else {
        player.sendMessage("§7Bitte Verwende§8: /§ccraft §8<§cSpielername§8>");
      }
    } else {
      commandSender.sendMessage("§4Du bist kein Spieler! Du darfst sowas nicht tun!");
    }
    return false;
  }
}
