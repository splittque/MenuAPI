package me.splitque.menu;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public abstract class ItemMenu extends Menu {
    private ItemStack item;

    public ItemMenu(String title, Material item, int rows) {
        super(title, rows);

        this.item = new ItemStack(item, 1);
        ItemMeta meta = this.item.getItemMeta();
        meta.setDisplayName(title);
        this.item.setItemMeta(meta);
    }
    public ItemMenu(String title, Material item) {
        super(title);

        this.item = new ItemStack(item, 1);
        ItemMeta meta = this.item.getItemMeta();
        meta.setDisplayName(title);
        this.item.setItemMeta(meta);
    }

    public abstract void itemFunc(Player player);

    public ItemStack getItem() {
        return item;
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent e) {
        Player player = e.getPlayer();
        ItemStack droppedItem = e.getItemDrop().getItemStack();

        if (droppedItem.equals(getItem())) {
            e.setCancelled(true);
            player.closeInventory();
            itemFunc(player);
        }
    }
    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        ItemStack interactedItem = player.getInventory().getItemInMainHand();

        if (interactedItem.equals(getItem())) {
            e.setCancelled(true);
            player.closeInventory();
            itemFunc(player);
        }
    }
    @EventHandler
    public void onInventory(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        ItemStack clickedItem = e.getCurrentItem();

        if (clickedItem == null || clickedItem.getType() == Material.AIR) return;

        if (clickedItem.equals(getItem())) {
            e.setCancelled(true);
            player.closeInventory();
            itemFunc(player);
        }
    }
}
