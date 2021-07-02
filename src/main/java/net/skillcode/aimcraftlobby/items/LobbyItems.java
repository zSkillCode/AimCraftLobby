package net.skillcode.aimcraftlobby.items;

import net.skillcode.aimcraftlobby.misc.Constants;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

public class LobbyItems {

    private ItemStack compass;
    private ItemStack radio;

    public LobbyItems() {
        init();
    }

    private void init() {
        compass = new ItemStack(Material.COMPASS);
        final ItemMeta compassMeta = compass.getItemMeta();
        compassMeta.setDisplayName(Constants.COMPASS_NAME);
        compass.setItemMeta(compassMeta);

        radio = new ItemStack(Material.GOLD_RECORD);
        final ItemMeta radioMeta = radio.getItemMeta();
        radioMeta.setDisplayName(Constants.RADIO_NAME);
        radio.setItemMeta(radioMeta);
    }

    public void setItems(final @NotNull Player player) {
        player.getInventory().setItem(2, compass);
        player.getInventory().setItem(6, radio);
    }

}
