package net.skillcode.aimcraftlobby.utils;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class BungeeUtils {

    private final JavaPlugin javaPlugin;

    public BungeeUtils(final @NotNull JavaPlugin javaPlugin) {
        this.javaPlugin = javaPlugin;
    }

    public void connect(final @NotNull Player player, final @NotNull String server) {
        final ByteArrayDataOutput byteArrayDataOutput = ByteStreams.newDataOutput();
        byteArrayDataOutput.writeUTF("Connect");
        byteArrayDataOutput.writeUTF(server);

        player.sendPluginMessage(javaPlugin, "BungeeCord", byteArrayDataOutput.toByteArray());
    }

}
