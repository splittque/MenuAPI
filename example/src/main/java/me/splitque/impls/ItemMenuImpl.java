package me.splitque.impls;

import me.splitque.menu.ItemMenu;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ItemMenuImpl extends ItemMenu {
    public ItemMenuImpl(String title, Material item) {
        super(title, item);
    }

    @Override
    public void itemFunc(Player player) {
        player.sendMessage("yo!");
    }

    @Override
    public void inventoryItemFunc(Player player, ItemStack itemStack) {}
}
