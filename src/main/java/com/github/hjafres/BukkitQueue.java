package com.github.hjafres;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.UUID;

import com.github.hjafres.listener.PlayerInteractListener;
import com.github.hjafres.listener.PlayerJoinListener;
import com.github.hjafres.util.Config;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class BukkitQueue extends JavaPlugin {
    private Queue<UUID> queue;

    @Override
    public void onEnable() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new PlayerJoinListener(), this);
        pm.registerEvents(new PlayerInteractListener(this), this);

        Bukkit.getScheduler().runTaskTimer(this, new QueueTask(this), 0L, Config.QUEUE_INTERVAL);
        this.queue = new PriorityQueue<>();
    }

    public boolean isQueued(Player player) {
        return this.queue.contains(player.getUniqueId());
    }

    public void queuePlayer(Player player) {
        this.queue.offer(player.getUniqueId());
    }

    public Optional<Player> getFirst() {
        return Optional.ofNullable(Bukkit.getPlayer(this.queue.poll()));
    }

    // Unused currently, but may be useful.
    public int getPosition(Player player) {
        int position = 0;
        for (UUID uuid : queue) {
            if (player.getUniqueId().equals(uuid)) {
                break;
            } else {
                position++;
            }
        }
        return position;
    }

    public void connectPlayer(Player player, String server) {
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(byteStream);
 
        try {
            out.writeUTF("Connect");
            out.writeUTF(server);
        } catch (IOException ex) {
            this.getLogger().warning("Could not send player " + player.getName() + " to " + server + ": " + ex.getMessage());
        }
 
        player.sendPluginMessage(this, "BungeeCord", byteStream.toByteArray());
    }
}