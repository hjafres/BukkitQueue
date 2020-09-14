package com.github.hjafres.listener;

import com.github.hjafres.BukkitQueue;
import com.github.hjafres.util.Config;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {
    private final BukkitQueue plugin;

    public PlayerJoinListener(BukkitQueue plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.teleport(Config.SPAWN)
        player.getInventory().setItem(4, Config.SELECTOR);

        for (int i = 0; i < 50; i++) {
            player.sendMessage("");
        }

        // Hiding the player who joined from other online players.
        for (Player online : Bukkit.getOnlinePlayers()) {
            online.hidePlayer(this.plugin, player);
        }
    }
}