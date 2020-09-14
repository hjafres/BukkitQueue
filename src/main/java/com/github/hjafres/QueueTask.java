package com.github.hjafres;

import java.util.Optional;

import com.github.hjafres.util.Config;
import com.github.hjafres.util.MessageUtil;

import org.bukkit.entity.Player;

public class QueueTask implements Runnable {
    private final BukkitQueue plugin;

    public QueueTask(BukkitQueue plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {
        Optional<Player> optional = this.plugin.getFirst();
        optional.ifPresent(player -> {
            player.sendMessage(MessageUtil.colored("&6You are being sent to the target server..."));
            this.plugin.connectPlayer(player, Config.SERVER);
        });
    }
}