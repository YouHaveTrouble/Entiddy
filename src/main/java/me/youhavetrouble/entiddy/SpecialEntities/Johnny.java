package me.youhavetrouble.entiddy.SpecialEntities;

import me.youhavetrouble.entiddy.EntiddyInterface;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Vindicator;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.jetbrains.annotations.NotNull;

public class Johnny implements EntiddyInterface {
    @Override
    public Entity spawn(@NotNull Location location, @NotNull CreatureSpawnEvent.SpawnReason spawnReason) {
        if (location.getWorld() == null) {
            throw new NullPointerException("World cannot be null");
        }
        return location.getWorld().spawnEntity(location, EntityType.VINDICATOR, spawnReason, (entity) -> {
            Vindicator johnny = (Vindicator) entity;
            johnny.setJohnny(true);
        });
    }

    @Override
    public boolean isInstance(LivingEntity entity) {
        if (!(entity instanceof Vindicator)) return false;
        return ((Vindicator) entity).isJohnny();
    }
}
