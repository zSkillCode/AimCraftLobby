package net.skillcode.aimcraftlobby.listeners;

import net.skillcode.aimcraftlobby.misc.Constants;
import net.skillcode.aimcraftlobby.utils.BungeeUtils;
import net.skillcode.aimcraftlobby.utils.ItemUtils;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.jetbrains.annotations.NotNull;

public class InventoryClickListener implements Listener {

    private final BungeeUtils bungeeUtils;

    public InventoryClickListener(final @NotNull BungeeUtils bungeeUtils) {
        this.bungeeUtils = bungeeUtils;
    }

    @EventHandler
    public void onClick(final @NotNull InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player)) return;

        final Player player = (Player) event.getWhoClicked();

        if (!ItemUtils.isNull(event.getCurrentItem())) {
            if (event.getInventory().getTitle().equals(Constants.COMPASS_INVENTORY_NAME)) {
                if (event.getCurrentItem().getItemMeta().getDisplayName().equals(Constants.MLGRUSH_NAME)) {
                    bungeeUtils.connect(player, "mlgrush-1");
                    player.closeInventory();
                }
            }
        }

        if (player.getGameMode() != GameMode.CREATIVE) {
            event.setCancelled(true);
        }
    }

}
