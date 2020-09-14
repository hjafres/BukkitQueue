package com.github.hjafres.util;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Class which allows easy creation of custom ItemStacks.
public class ItemBuilder {
    private final List<String> lore;
    private final HashMap<Enchantment, Integer> enchants;
    private final Material material;
    private final int amount;
    private String title;

    /**
     * Creating ItemBuilder only with Material type.
     *
     * @param material Item type.
     */
    public ItemBuilder(Material material) {
        this(material, 1);
    }

    /**
     * Creating ItemBuilder with type and amount.
     *
     * @param material Item type.
     * @param amount   Item amount.
     */
    public ItemBuilder(Material material, int amount) {
        this.title = null;
        this.lore = new ArrayList<>();
        this.enchants = new HashMap<>();
        this.material = material;
        this.amount = amount;
    }

    /**
     * Setting item title.
     *
     * @param title Item title.
     * @return Current ItemBuilder object.
     */
    public ItemBuilder setTitle(String title) {
        this.title = MessageUtil.colored(title);
        return this;
    }

    /**
     * @param lore Adding single string to item lore.
     * @return Current ItemBuilder object.
     */
    public ItemBuilder addLore(String lore) {
        this.lore.add(MessageUtil.colored(lore));
        return this;
    }

    /**
     * @param enchant Enchantment object
     * @param level   Level of enchantment
     * @return Current ItemBuilder object.
     */
    public ItemBuilder addEnchantment(Enchantment enchant, int level) {
        this.enchants.remove(enchant);
        this.enchants.put(enchant, level);
        return this;
    }

    /**
     * Building ItemBuilder to an ItemStack.
     *
     * @return Complete ItemStack with all data and meta.
     */
    public ItemStack build() {
        final ItemStack item = new ItemStack(this.material, this.amount);
        final ItemMeta meta = item.getItemMeta();
        if (this.title != null && meta != null) {
            meta.setDisplayName(this.title);
        }
        if (!this.lore.isEmpty() && meta != null) {
            meta.setLore(this.lore);
        }
        item.setItemMeta(meta);
        item.addUnsafeEnchantments(this.enchants);
        return item;
    }
}