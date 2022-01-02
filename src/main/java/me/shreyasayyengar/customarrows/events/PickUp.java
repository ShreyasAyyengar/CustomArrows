package me.shreyasayyengar.customarrows.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupArrowEvent;

public class PickUp implements Listener {

    @EventHandler
    private void onPickup(PlayerPickupArrowEvent e) {
        e.setCancelled(true);
    }
}
