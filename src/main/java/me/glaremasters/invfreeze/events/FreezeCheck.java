package me.glaremasters.invfreeze.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

/**
 * Created by GlareMasters
 * Date: 8/21/2018
 * Time: 1:06 PM
 */
public class FreezeCheck implements Listener {

    @EventHandler
    public void onInteract(InventoryInteractEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (!player.hasPermission("invfreeze.bypass")) return;
        if (player.hasPermission("invfreeze.frozen")) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent event) {
        Player player = event.getPlayer();
        if (!player.hasPermission("invfreeze.bypass")) return;
        if (player.hasPermission("invfreeze.frozen")) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPickup(PlayerPickupItemEvent event) {
        Player player = event.getPlayer();
        if (!player.hasPermission("invfreeze.bypass")) return;
        if (player.hasPermission("invfreeze.frozen")) {
            event.setCancelled(true);
        }
    }

}
