package net.skillcode.aimcraftlobby.misc;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public class Constants {

    public static final String COMPASS_NAME = "§8» §eMinigames";
    public static final String RADIO_NAME = "§8» §eRadio";
    public static final String MLGRUSH_NAME = "§8» §eAdvancedMLGRush";
    public static final String JOIN_MESSAGE = "§8» §6§lAimCraft §8| §7Welcome to AimCraft! \n" +
            "§8» §6§lAimCraft §8| §7Our Discord§8: §ehttps://discord.skillplugins.com";

    public static final String COMPASS_INVENTORY_NAME = "§8» §eCompass";

    public static final Location SPAWN_LOCATION = new Location(Bukkit.getWorld("world"),
            1.5, 36, 17.5, 0, 0);

    private Constants() {
    }

}
