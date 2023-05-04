package de.fhe.tutoriumplugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpeedCommand implements CommandExecutor {

  @Override
  public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
    if (commandSender instanceof final Player player) {
      if (args.length == 2) {
        final String type = args[0];
        final String speedLevelStr = args[1];

        if (type.equalsIgnoreCase("fly") || type.equalsIgnoreCase("walk")) {
          // REGEX unbedingt durch IF-Statements zeigen
          if (speedLevelStr.matches("^([1-5])+$")) {
            int speedLevel = Integer.parseInt(speedLevelStr);
            toggleSpeed(player, speedLevel, type.equalsIgnoreCase("fly"));
            player.sendMessage("§aDu hast nun deine Geschwindigkeit geändert§8.");
          } else {
            player.sendMessage("§cBitte gib ein gültiges Level an§8.");
          }
        } else {
          player.sendMessage("§cBitte wähle §efly oder walk §cals Typ aus.");
        }
      } else {
        player.sendMessage("§7Bitte Verwende§8: /§cspeed §8<§cfly|walk§8> §8<§c1-5§8>");
      }
    } else {
      commandSender.sendMessage("§4Du bist kein Spieler! Du darfst sowas nicht tun!");
    }
    return false;
  }

  private void toggleSpeed(final Player player, final int speedLevel, boolean isFly) {
    float speed = 0.2f;
    switch (speedLevel) {
      case 1:
        speed = 0.2f;
      case 2:
        speed = 0.4f;
      case 3:
        speed = 0.6f;
      case 4:
        speed = 0.8f;
      case 5:
        speed = 1.0f;
    }
    if (isFly) {
      player.setFlySpeed(speed);
    } else {
      player.setWalkSpeed(speed);
    }
  }
}
