package net.skillcode.aimcraftlobby.listeners;

import net.skillcode.aimcraftlobby.inventories.CompassInventory;
import net.skillcode.aimcraftlobby.misc.Constants;
import net.skillcode.aimcraftlobby.utils.ItemUtils;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.jetbrains.annotations.NotNull;

public class PlayerInteractListener implements Listener {

    private final CompassInventory compassInventory;

    public PlayerInteractListener(final @NotNull CompassInventory compassInventory) {
        this.compassInventory = compassInventory;
    }

    @EventHandler
    public void onInteract(final @NotNull PlayerInteractEvent event) {
        final Player player = event.getPlayer();

        if (!ItemUtils.isNull(player.getItemInHand())) {
            if (player.getItemInHand().getItemMeta().getDisplayName().equals(Constants.COMPASS_NAME)) {
                compassInventory.openInventory(player);
            } else if (player.getItemInHand().getItemMeta().getDisplayName().equals(Constants.RADIO_NAME)) {
                player.performCommand("acr");
            }

        }
        if (player.getGameMode() != GameMode.CREATIVE) {
            event.setCancelled(true);
        }
    }

}
