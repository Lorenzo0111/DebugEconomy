package me.lorenzo0111.debugeconomy;

import me.lorenzo0111.debugeconomy.command.DebugEconomyCommand;
import me.lorenzo0111.debugeconomy.manager.EconomyManager;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public final class DebugEconomy extends JavaPlugin {
    private final List<UUID> noMoney = new ArrayList<>();

    @Override
    public void onEnable() {
        File setup = new File(this.getDataFolder(),".setup");
        if (!this.getDataFolder().exists() || !setup.exists()) {
            try {
                this.getLogger().severe("Warning!! This is not a plugin. Use it only for development testing purposes.");
                this.getLogger().severe("This is the last time you'll se this message.");
                this.getDataFolder().mkdirs();
                setup.createNewFile();
            } catch (IOException ignored) {}
        }

        Bukkit.getServicesManager().register(Economy.class,new EconomyManager(this), this, ServicePriority.Low);
        this.getLogger().info("Hooked with Vault.");

        Objects.requireNonNull(this.getCommand("debugeconomy")).setExecutor(new DebugEconomyCommand(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public List<UUID> getNoMoney() {
        return noMoney;
    }
}
