package com.github.hjafres.util;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

public class Config {
    // This class holds constants which will be configurable in the future.
    public static final ItemStack SELECTOR = new ItemBuilder(Material.FEATHER)
                                            .setTitle("&eClick to join the server.")
                                            .addEnchantment(Enchantment.DURABILITY, 1)
                                            .build();
    // BungeeCord server name which player will be connected to.
    public static final String SERVER = "survival";
    // Interval (in seconds) of queue progressing.
    public static final long QUEUE_INTERVAL = 5L;
    // Location where the player is spawned.
    public static final Location SPAWN = new Location(Bukkit.getWorld("world_the_end"), 900, 90000, 900);
}