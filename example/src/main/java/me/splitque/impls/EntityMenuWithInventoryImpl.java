package me.splitque.impls;

import me.splitque.menu.EntityMenu;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.inventory.ItemStack;

public class EntityMenuWithInventoryImpl extends EntityMenu<Villager> {
    public EntityMenuWithInventoryImpl(String title, EntityType entityType, int rows) {
        super(title, entityType, rows);

        super.registerToMenu(Material.DIAMOND, "diamond", "yay", 2, 2);
        super.registerToMenu(Material.EMERALD, "no diamond", "not yay", 2, 3);
    }

    @Override
    public void entityFunc(Player player) {
        super.openMenu(player);
    }

    @Override
    public void inventoryItemFunc(Player player, ItemStack item) {
        switch (item.getType()) {
            case DIAMOND:
                player.getInventory().addItem(item);
                player.sendMessage("yay diamond!");
                break;
            case EMERALD:
                break;
            default:
                break;
        }
    }
}
