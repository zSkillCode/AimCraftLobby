package net.skillcode.aimcraftlobby;

import net.skillcode.aimcraftlobby.inventories.CompassInventory;
import net.skillcode.aimcraftlobby.items.LobbyItems;
import net.skillcode.aimcraftlobby.listeners.CancellableListeners;
import net.skillcode.aimcraftlobby.listeners.InventoryClickListener;
import net.skillcode.aimcraftlobby.listeners.PlayerInteractListener;
import net.skillcode.aimcraftlobby.listeners.PlayerJoinQuitListener;
import net.skillcode.aimcraftlobby.utils.BungeeUtils;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class ACLobby extends JavaPlugin {

    @Override
    public void onEnable() {
        final LobbyItems lobbyItems = new LobbyItems();
        final CompassInventory compassInventory = new CompassInventory();
        final BungeeUtils bungeeUtils = new BungeeUtils(this);

        final PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new PlayerJoinQuitListener(lobbyItems), this);
        pluginManager.registerEvents(new PlayerInteractListener(compassInventory), this);
        pluginManager.registerEvents(new InventoryClickListener(bungeeUtils), this);
        pluginManager.registerEvents(new CancellableListeners(), this);

        Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
    }
}
