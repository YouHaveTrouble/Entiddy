package me.youhavetrouble.entiddy.SpecialEntities;

import me.youhavetrouble.entiddy.EntiddyInterface;
import net.kyori.adventure.text.Component;
import org.bukkit.Location;
import org.bukkit.entity.*;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class JebSheep implements EntiddyInterface {

    @Override
    public Entity spawn(@NotNull Location location, @NotNull CreatureSpawnEvent.SpawnReason spawnReason) {
        if (location.getWorld() == null) {
            throw new NullPointerException("World cannot be null");
        }
        return location.getWorld().spawnEntity(location, EntityType.SHEEP, spawnReason, (entity) -> {
                    entity.customName(Component.text("jeb_"));
                    entity.setCustomNameVisible(false);
                });
    }

    @Override
    public boolean isInstance(@NotNull LivingEntity entity) {
        if (!(entity instanceof Sheep)) return false;
        return Objects.equals(entity.customName(), Component.text("jeb_"));
    }
}
