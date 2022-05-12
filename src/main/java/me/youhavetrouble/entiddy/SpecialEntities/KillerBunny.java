package me.youhavetrouble.entiddy.SpecialEntities;

import me.youhavetrouble.entiddy.EntiddyInterface;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Rabbit;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.jetbrains.annotations.NotNull;

public class KillerBunny implements EntiddyInterface {

    @Override
    public Entity spawn(@NotNull Location location, @NotNull CreatureSpawnEvent.SpawnReason spawnReason) {
        if (location.getWorld() == null) {
            throw new NullPointerException("World cannot be null");
        }
        return location.getWorld().spawnEntity(location, EntityType.RABBIT, spawnReason, (entity) -> {
            Rabbit rabbit = (Rabbit) entity;
            rabbit.setRabbitType(Rabbit.Type.THE_KILLER_BUNNY);
        });
    }

    @Override
    public boolean isInstance(@NotNull LivingEntity entity) {
        if (!(entity instanceof Rabbit)) return false;
        return ((Rabbit) entity).getRabbitType().equals(Rabbit.Type.THE_KILLER_BUNNY);
    }
}
