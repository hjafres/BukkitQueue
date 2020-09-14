package com.github.hjafres.util;

import net.md_5.bungee.api.ChatColor;

public class MessageUtil {
    public static String colored(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }
}