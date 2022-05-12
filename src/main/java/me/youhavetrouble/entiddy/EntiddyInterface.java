package me.youhavetrouble.entiddy;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.jetbrains.annotations.NotNull;

public interface EntiddyInterface {

    /**
     * @param location Location to spawn the entity at
     * @param spawnReason SpawnReason to set
     * @return Spawned entity
     */
    Entity spawn(@NotNull Location location, @NotNull CreatureSpawnEvent.SpawnReason spawnReason);

    boolean isInstance(LivingEntity entity);

}
