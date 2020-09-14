package com.github.hjafres.util;

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
}