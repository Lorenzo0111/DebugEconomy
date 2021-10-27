package me.lorenzo0111.debugeconomy.command;

import me.lorenzo0111.debugeconomy.DebugEconomy;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.Collections;
import java.util.List;

public class DebugEconomyCommand implements TabExecutor {
    private final DebugEconomy plugin;

    public DebugEconomyCommand(DebugEconomy plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return true;
        Player player = (Player) sender;

        if (plugin.getNoMoney().contains(player.getUniqueId())) {
            plugin.getNoMoney().remove(player.getUniqueId());
            sender.sendMessage(ChatColor.GREEN + "Now vault will see that you have sufficient money.");
            return true;
        }

        plugin.getNoMoney().add(player.getUniqueId());
        sender.sendMessage(ChatColor.RED + "Now vault will see that you don't have sufficient money.");
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return Collections.singletonList("toggle");
    }

}
