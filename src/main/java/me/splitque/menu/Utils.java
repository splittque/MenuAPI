package me.splitque.menu;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntitySpawnEvent;

class Utils implements Listener {
    public static int getRows(int row) {
        return row * 9;
    }
    public static int getIndex(int row, int column) {
        return (row - 1) * 9 + column - 1;
    }
}
