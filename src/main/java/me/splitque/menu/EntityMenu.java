package me.splitque.menu;

import org.bukkit.Location;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;

import java.util.ArrayList;
import java.util.List;

public abstract class EntityMenu<T extends LivingEntity> extends Menu {
    private List<T> entities;
    private EntityType entityType;

    public EntityMenu(String title, EntityType entityType, int rows) {
        super(title, rows);
        this.entityType = entityType;
        entities = new ArrayList<>();
    }
    public EntityMenu(String title, EntityType entityType) {
        super(title);
        this.entityType = entityType;
        entities = new ArrayList<>();
    }

    public abstract void entityFunc(Player player);

    public T spawnEntity(Location location) {
        T entity = (T) location.getWorld().spawnEntity(location, entityType);
        entity.setAI(false);
        entity.setSilent(true);
        entity.setCustomName(getTitle());
        entity.setCustomNameVisible(true);
        entities.add(entity);

        return entity;
    }
    public void despawnEntity(T entity) {
        if (entities.contains(entity)) {
            entity.setHealth(0);
            entities.remove(entity);
        }
    }
    public void despawnAllEntities(Player player) {
        for (T _entity : entities) {
            _entity.setHealth(0);
        }
        entities.clear();
    }

    @EventHandler
    public void entityFunc(PlayerInteractAtEntityEvent e) {
        for (T entity : entities) {
            if (entity == e.getRightClicked()) entityFunc(e.getPlayer());
        }
    }
    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        for (T entity : entities) {
            if (entity == e.getEntity()) e.setCancelled(true);
        }
    }
}
