package me.splitque;

import me.splitque.impls.EntityMenuImpl;
import me.splitque.impls.EntityMenuWithInventoryImpl;
import me.splitque.impls.ItemMenuImpl;
import me.splitque.impls.ItemMenuWithInventoryImpl;
import me.splitque.menus.*;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    public static EntityMenuImpl entityMenu;
    public static EntityMenuWithInventoryImpl entityMenuWithInventory;
    public static ItemMenuImpl itemMenu;
    public static ItemMenuWithInventoryImpl itemMenuWithInventory;

    @Override
    public void onEnable() {
        getCommand("entityinit").setExecutor(new EntityMenuInitCommand());
        getCommand("entityinvinit").setExecutor(new EntityMenuWithInventoryInitCommand());
        getCommand("entitydespawn").setExecutor(new EntityMenuDespawnCommand());
        getCommand("entityinvdespawn").setExecutor(new EntityMenuWithInventoryDespawnCommand());
        getServer().getPluginManager().registerEvents(new ItemMenuInitEvent(), this);
        getServer().getPluginManager().registerEvents(new ItemMenuWithInventoryInitEvent(), this);

        entityMenu = new EntityMenuImpl("Skeleton", EntityType.SKELETON);
        entityMenu.init(this);

        entityMenuWithInventory = new EntityMenuWithInventoryImpl("diamonds!", EntityType.VILLAGER, 6);
        entityMenuWithInventory.init(this);

        itemMenu = new ItemMenuImpl("Item", Material.STICK);
        itemMenu.init(this);

        itemMenuWithInventory = new ItemMenuWithInventoryImpl("Menu", Material.COMPASS, 6);
        itemMenuWithInventory.init(this);
    }
}