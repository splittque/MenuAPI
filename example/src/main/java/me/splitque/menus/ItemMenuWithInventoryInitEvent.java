package me.splitque.menus;

import me.splitque.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class ItemMenuWithInventoryInitEvent implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        p.getInventory().addItem(Main.itemMenuWithInventory.getItem());
    }
}
