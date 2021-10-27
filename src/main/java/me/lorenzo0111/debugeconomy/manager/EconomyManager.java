package me.lorenzo0111.debugeconomy.manager;

import me.lorenzo0111.debugeconomy.DebugEconomy;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;

import java.util.ArrayList;
import java.util.List;

public class EconomyManager implements Economy {
    private final DebugEconomy plugin;

    public EconomyManager(DebugEconomy plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean isEnabled() {
        return plugin.isEnabled();
    }

    @Override
    public String getName() {
        return plugin.getName();
    }

    @Override
    public boolean hasBankSupport() {
        return false;
    }

    @Override
    public int fractionalDigits() {
        return -1;
    }

    @Override
    public String format(double amount) {
        return "€" + amount;
    }

    @Override
    public String currencyNamePlural() {
        return "Euro";
    }

    @Override
    public String currencyNameSingular() {
        return "Euro";
    }

    @Override
    public boolean hasAccount(String playerName) {
        return true;
    }

    @Override
    public boolean hasAccount(OfflinePlayer player) {
        return true;
    }

    @Override
    public boolean hasAccount(String playerName, String worldName) {
        return true;
    }

    @Override
    public boolean hasAccount(OfflinePlayer player, String worldName) {
        return true;
    }

    @Override
    public double getBalance(String playerName) {
        return getBalance(Bukkit.getOfflinePlayer(playerName));
    }

    @Override
    public double getBalance(OfflinePlayer player) {
        return plugin.getNoMoney().contains(player.getUniqueId()) ? 0.0 : Integer.MAX_VALUE;
    }

    @Override
    public double getBalance(String playerName, String world) {
        return getBalance(Bukkit.getOfflinePlayer(playerName));
    }

    @Override
    public double getBalance(OfflinePlayer player, String world) {
        return getBalance(player);
    }

    @Override
    public boolean has(String playerName, double amount) {
        return getBalance(playerName) > 1;
    }

    @Override
    public boolean has(OfflinePlayer player, double amount) {
        return getBalance(player) > 1;
    }

    @Override
    public boolean has(String playerName, String worldName, double amount) {
        return getBalance(playerName) > 1;
    }

    @Override
    public boolean has(OfflinePlayer player, String worldName, double amount) {
        return getBalance(player) > 1;
    }

    @Override
    public EconomyResponse withdrawPlayer(String playerName, double amount) {
        return has(playerName,amount) ?
                new EconomyResponse(amount, getBalance(playerName), EconomyResponse.ResponseType.SUCCESS, null)
                : new EconomyResponse(amount, getBalance(playerName), EconomyResponse.ResponseType.FAILURE, null);
    }

    @Override
    public EconomyResponse withdrawPlayer(OfflinePlayer player, double amount) {
        return has(player,amount) ?
                new EconomyResponse(amount, getBalance(player), EconomyResponse.ResponseType.SUCCESS, null)
                : new EconomyResponse(amount, getBalance(player), EconomyResponse.ResponseType.FAILURE, null);

    }

    @Override
    public EconomyResponse withdrawPlayer(String playerName, String worldName, double amount) {
        return has(playerName,amount) ?
                new EconomyResponse(amount, getBalance(playerName), EconomyResponse.ResponseType.SUCCESS, null)
                : new EconomyResponse(amount, getBalance(playerName), EconomyResponse.ResponseType.FAILURE, null);
    }

    @Override
    public EconomyResponse withdrawPlayer(OfflinePlayer player, String worldName, double amount) {
        return has(player,amount) ?
                new EconomyResponse(amount, getBalance(player), EconomyResponse.ResponseType.SUCCESS, null)
                : new EconomyResponse(amount, getBalance(player), EconomyResponse.ResponseType.FAILURE, null);
    }

    @Override
    public EconomyResponse depositPlayer(String playerName, double amount) {
        return new EconomyResponse(amount, getBalance(playerName), EconomyResponse.ResponseType.SUCCESS, null);
    }

    @Override
    public EconomyResponse depositPlayer(OfflinePlayer player, double amount) {
        return new EconomyResponse(amount, getBalance(player), EconomyResponse.ResponseType.SUCCESS, null);
    }

    @Override
    public EconomyResponse depositPlayer(String playerName, String worldName, double amount) {
        return new EconomyResponse(amount, getBalance(playerName), EconomyResponse.ResponseType.SUCCESS, null);
    }

    @Override
    public EconomyResponse depositPlayer(OfflinePlayer player, String worldName, double amount) {
        return new EconomyResponse(amount, getBalance(player), EconomyResponse.ResponseType.SUCCESS, null);
    }

    @Override
    public EconomyResponse createBank(String name, String player) {
        return new EconomyResponse(0, 0, EconomyResponse.ResponseType.NOT_IMPLEMENTED, "DebugEconomy does not support bank accounts!");
    }

    @Override
    public EconomyResponse createBank(String name, OfflinePlayer player) {
        return new EconomyResponse(0, 0, EconomyResponse.ResponseType.NOT_IMPLEMENTED, "DebugEconomy does not support bank accounts!");
    }

    @Override
    public EconomyResponse deleteBank(String name) {
        return new EconomyResponse(0, 0, EconomyResponse.ResponseType.NOT_IMPLEMENTED, "DebugEconomy does not support bank accounts!");
    }

    @Override
    public EconomyResponse bankBalance(String name) {
        return new EconomyResponse(0, 0, EconomyResponse.ResponseType.NOT_IMPLEMENTED, "DebugEconomy does not support bank accounts!");

    }

    @Override
    public EconomyResponse bankHas(String name, double amount) {
        return new EconomyResponse(0, 0, EconomyResponse.ResponseType.NOT_IMPLEMENTED, "DebugEconomy does not support bank accounts!");

    }

    @Override
    public EconomyResponse bankWithdraw(String name, double amount) {
        return new EconomyResponse(0, 0, EconomyResponse.ResponseType.NOT_IMPLEMENTED, "DebugEconomy does not support bank accounts!");

    }

    @Override
    public EconomyResponse bankDeposit(String name, double amount) {
        return new EconomyResponse(0, 0, EconomyResponse.ResponseType.NOT_IMPLEMENTED, "DebugEconomy does not support bank accounts!");

    }

    @Override
    public EconomyResponse isBankOwner(String name, String playerName) {
        return new EconomyResponse(0, 0, EconomyResponse.ResponseType.NOT_IMPLEMENTED, "DebugEconomy does not support bank accounts!");

    }

    @Override
    public EconomyResponse isBankOwner(String name, OfflinePlayer player) {
        return new EconomyResponse(0, 0, EconomyResponse.ResponseType.NOT_IMPLEMENTED, "DebugEconomy does not support bank accounts!");

    }

    @Override
    public EconomyResponse isBankMember(String name, String playerName) {
        return new EconomyResponse(0, 0, EconomyResponse.ResponseType.NOT_IMPLEMENTED, "DebugEconomy does not support bank accounts!");

    }

    @Override
    public EconomyResponse isBankMember(String name, OfflinePlayer player) {
        return new EconomyResponse(0, 0, EconomyResponse.ResponseType.NOT_IMPLEMENTED, "DebugEconomy does not support bank accounts!");

    }

    @Override
    public List<String> getBanks() {
        return new ArrayList<>();
    }

    @Override
    public boolean createPlayerAccount(String playerName) {
        return true;
    }

    @Override
    public boolean createPlayerAccount(OfflinePlayer player) {
        return true;
    }

    @Override
    public boolean createPlayerAccount(String playerName, String worldName) {
        return true;
    }

    @Override
    public boolean createPlayerAccount(OfflinePlayer player, String worldName) {
        return true;
    }
}
