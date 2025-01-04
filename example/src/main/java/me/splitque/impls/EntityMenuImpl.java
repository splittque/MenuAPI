package me.splitque.impls;

import me.splitque.menu.EntityMenu;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Villager;
import org.bukkit.inventory.ItemStack;

public class EntityMenuImpl extends EntityMenu<Skeleton> {
    public EntityMenuImpl(String title, EntityType entityType) {
        super(title, entityType);
    }

    @Override
    public void entityFunc(Player player) {
        player.sendMessage("I'm skeleton!");
    }

    @Override
    public void inventoryItemFunc(Player player, ItemStack item) {}
}
