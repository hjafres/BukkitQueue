package com.github.hjafres.listener;

import com.github.hjafres.BukkitQueue;
import com.github.hjafres.util.Config;
import com.github.hjafres.util.MessageUtil;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerInteractListener implements Listener {
    private final BukkitQueue plugin;

    public PlayerInteractListener(BukkitQueue plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = event.getItem();

        if (item == null) {
            return;
        }

        if (item.equals(Config.SELECTOR)) {
            if (this.plugin.isQueued(player)) {
                player.sendMessage(MessageUtil.colored("&cYou are already in the queue!"));
                return;
            }

            this.plugin.queuePlayer(player);
            player.sendMessage(MessageUtil.colored("&aYou have been added to the queue!"));
        }
    }
}