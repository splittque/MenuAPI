package me.splitque.impls;

import me.splitque.menu.ItemMenu;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ItemMenuWithInventoryImpl extends ItemMenu {
    public ItemMenuWithInventoryImpl(String title, Material item, int rows) {
        super(title, item, rows);
        super.registerToMenu(Material.DIAMOND, "diamond", "diamond", 2, 4);
        super.registerToMenu(Material.EMERALD, "emerald", "emerald", 2, 6);
    }

    @Override
    public void itemFunc(Player player) {
        super.openMenu(player);
    }

    @Override
    public void inventoryItemFunc(Player player, ItemStack itemStack) {
        switch (itemStack.getItemMeta().getDisplayName()) {
            case "diamond":
                player.getInventory().addItem(itemStack);
                player.sendMessage("yay diamond!");
                break;
            case "emerald":
                break;
            default:
                break;
        }
    }
}
