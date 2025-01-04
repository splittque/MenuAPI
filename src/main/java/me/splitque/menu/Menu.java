package me.splitque.menu;

import me.splitque.menu.exceptions.InaccessibleMethodException;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Menu implements Listener {
    private String title;
    private Inventory inventory;

    public Menu(String title, int rows) {
        inventory = Bukkit.createInventory(null, Utils.getRows(rows), title);
        this.title = title;
    }
    public Menu(String title) {
        this.title = title;
    }

    public abstract void inventoryItemFunc(Player player, ItemStack item);

    public void init(JavaPlugin plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    public void registerToMenu(Material item, String name, String description, int row, int column) {
        if (inventory != null) {
            ItemStack itemStack = new ItemStack(item, 1);
            ItemMeta itemMeta = itemStack.getItemMeta();

            if (description != null) {
                List<String> lore = new ArrayList<>();
                lore.add(description);
                itemMeta.setLore(lore);
            }

            itemMeta.setDisplayName(name);
            itemStack.setItemMeta(itemMeta);

            inventory.setItem(Utils.getIndex(row, column), itemStack);
        } else {
            throw new InaccessibleMethodException();
        }
    }

    public void openMenu(Player player) {
        player.openInventory(inventory);
    }

    public String getTitle() {
        return title;
    }

    @EventHandler
    public void itemFunc(InventoryClickEvent e) {
        if (e.getView().getTitle().equals(title)) {
            e.setCancelled(true);
            Player player = (Player) e.getWhoClicked();
            ItemStack clickedItem = e.getCurrentItem();

            if (clickedItem == null || clickedItem.getType() == Material.AIR) return;

            for (ItemStack item : inventory.getContents()) {
                if (item != null) {
                    if (clickedItem.equals(item)) inventoryItemFunc(player, item);
                }
            }
        }
    }
}
