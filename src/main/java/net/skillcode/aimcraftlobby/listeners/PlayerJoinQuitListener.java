package net.skillcode.aimcraftlobby.listeners;

import net.skillcode.aimcraftlobby.items.LobbyItems;
import net.skillcode.aimcraftlobby.misc.Constants;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.jetbrains.annotations.NotNull;

public class PlayerJoinQuitListener implements Listener {

    private final LobbyItems lobbyItems;

    public PlayerJoinQuitListener(final LobbyItems lobbyItems) {
        this.lobbyItems = lobbyItems;
    }

    @EventHandler
    public void onJoin(final @NotNull PlayerJoinEvent event) {
        event.setJoinMessage("");
        final Player player = event.getPlayer();
        player.sendMessage(Constants.JOIN_MESSAGE);

        player.getInventory().clear();
        player.setFlying(false);
        player.setAllowFlight(false);
        player.setGameMode(GameMode.SURVIVAL);
        player.setHealth(20);
        player.setFoodLevel(20);
        player.setLevel(0);
        player.teleport(Constants.SPAWN_LOCATION);

        lobbyItems.setItems(player);
    }

    @EventHandler
    public void onQuit(final @NotNull PlayerQuitEvent event) {
        event.setQuitMessage("");
    }

}
