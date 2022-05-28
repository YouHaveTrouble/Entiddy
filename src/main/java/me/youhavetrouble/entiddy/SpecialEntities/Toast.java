package me.youhavetrouble.entiddy.SpecialEntities;

import me.youhavetrouble.entiddy.EntiddyInterface;
import net.kyori.adventure.text.Component;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Rabbit;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Toast implements EntiddyInterface {

    @Override
    public Entity spawn(@NotNull Location location, CreatureSpawnEvent.@NotNull SpawnReason spawnReason) {
        if (location.getWorld() == null) {
            throw new NullPointerException("World cannot be null");
        }
        return location.getWorld().spawnEntity(location, EntityType.RABBIT, spawnReason,
                (entity) -> {
                    entity.customName(Component.text("Toast"));
                    entity.setCustomNameVisible(false);
                });
    }

    @Override
    public boolean isInstance(@NotNull LivingEntity entity) {
        if (!(entity instanceof Rabbit)) return false;
        return Objects.equals(entity.customName(), Component.text("Toast"));
    }
}
