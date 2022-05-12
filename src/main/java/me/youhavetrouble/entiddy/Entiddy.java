package me.youhavetrouble.entiddy;


import me.youhavetrouble.entiddy.SpecialEntities.JebSheep;
import me.youhavetrouble.entiddy.SpecialEntities.Johnny;
import me.youhavetrouble.entiddy.SpecialEntities.KillerBunny;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public enum Entiddy {

    KILLER_BUNNY(EntityType.RABBIT, new KillerBunny()),
    JEB_SHEEP(EntityType.SHEEP, new JebSheep()),
    JOHNNY(EntityType.VINDICATOR, new Johnny());

    private final EntityType entityType;
    private final EntiddyInterface entiddy;

    Entiddy(EntityType entityType, EntiddyInterface entiddy) {
        this.entityType = entityType;
        this.entiddy = entiddy;
    }

    public EntityType getEntityType() {
        return entityType;
    }

    public EntiddyInterface entiddy() {
        return entiddy;
    }

    /**
     * Turn entity upside down. Doesn't work on players.
     * WARNING This overwrites entities name tag!
     */
    public static void upsideDown(@NotNull LivingEntity entity) {
        if (entity instanceof Player) return;
        entity.setCustomName("Grumm");
    }

    public static boolean isSpecialEntity(@NotNull LivingEntity entity) {
        if (entity instanceof Player) return false;
        for (Entiddy enTiddy: Entiddy.values()) {
            if (enTiddy.entiddy().isInstance(entity)) return true;
        }
        return false;
    }

}
