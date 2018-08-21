package me.glaremasters.invfreeze.utils;

import org.bukkit.ChatColor;

/**
 * Created by GlareMasters
 * Date: 8/21/2018
 * Time: 1:05 PM
 */
public class ColorUtil {

    public static String color(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

}
