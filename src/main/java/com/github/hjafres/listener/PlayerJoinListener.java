package com.github.hjafres.listener;

import com.github.hjafres.util.Config;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.getInventory().setItem(4, Config.SELECTOR);

        for (int i = 0; i < 50; i++) {
            player.sendMessage("");
        }
    }
}