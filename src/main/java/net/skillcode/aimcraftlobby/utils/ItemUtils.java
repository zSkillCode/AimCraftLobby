package net.skillcode.aimcraftlobby.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

public class ItemUtils {

    public static boolean isNull(final @Nullable ItemStack itemStack) {
        return itemStack == null
                || itemStack.getItemMeta() == null
                || itemStack.getItemMeta().getDisplayName() == null
                || itemStack.getType() == null
                || itemStack.getType() == Material.AIR;
    }

}
