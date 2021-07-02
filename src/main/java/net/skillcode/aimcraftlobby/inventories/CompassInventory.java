package net.skillcode.aimcraftlobby.inventories;

import net.skillcode.aimcraftlobby.misc.Constants;
import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompassInventory {

    private final List<Integer> list = new ArrayList<>(Arrays.asList(0, 1, 7, 8, 9, 17, 18, 19, 25, 26));

    private Inventory inventory;

    public CompassInventory() {
        init();
    }

    private void init() {
        inventory = Bukkit.createInventory(null, 3 * 9, Constants.COMPASS_INVENTORY_NAME);
        final ItemStack background = getBackground(DyeColor.GRAY.getData());
        final ItemStack background2 = getBackground(DyeColor.PURPLE.getData());

        for (int i = 0; i < inventory.getSize(); i++) {
            inventory.setItem(i, list.contains(i) ? background2 : background);
        }

        final ItemStack mlgrush = new ItemStack(Material.STICK);
        final ItemMeta itemMeta = mlgrush.getItemMeta();
        itemMeta.setDisplayName(Constants.MLGRUSH_NAME);
        mlgrush.setItemMeta(itemMeta);
        inventory.setItem(13, mlgrush);
    }

    public void openInventory(final @NotNull Player player) {
        final Inventory clone = Bukkit.createInventory(null, inventory.getSize(), inventory.getTitle());
        clone.setContents(inventory.getContents());
        player.openInventory(clone);
    }

    private ItemStack getBackground(final byte data) {
        final ItemStack background = new ItemStack(Material.STAINED_GLASS_PANE, 1, data);
        final ItemMeta itemMeta = background.getItemMeta();
        itemMeta.setDisplayName(" ");
        background.setItemMeta(itemMeta);
        return background;
    }

}
