package me.youhavetrouble.entiddy;


import me.youhavetrouble.entiddy.SpecialEntities.JebSheep;
import me.youhavetrouble.entiddy.SpecialEntities.Johnny;
import me.youhavetrouble.entiddy.SpecialEntities.KillerBunny;
import me.youhavetrouble.entiddy.SpecialEntities.Toast;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public enum Entiddy {

    /**
     * Killer bunny that attacks players monthy python style
     */
    KILLER_BUNNY(EntityType.RABBIT, new KillerBunny()),

    /**
     * Its wool cycles with interpolation through all dye colors
     * Sheep with rgb lighting
     */
    JEB_SHEEP(EntityType.SHEEP, new JebSheep()),

    /**
     * Johnny is hostile to basically every mob with few exceptions
     * HERE'S JOHNNY
     */
    JOHNNY(EntityType.VINDICATOR, new Johnny()),

    /**
     * Toast has the appearance of a black dutch, with a large black and white patch and more black fur around the face
     * than the natural black and white spotted rabbit.
     */
    TOAST(EntityType.RABBIT, new Toast());

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

    /**
     * @return True if entity is one of special/easter egg entities
     */
    public static boolean isSpecialEntity(@NotNull LivingEntity entity) {
        if (entity instanceof Player) return false;
        for (Entiddy entiddy: Entiddy.values()) {
            if (entiddy.entiddy().isInstance(entity)) return true;
        }
        return false;
    }

    /**
     * @return Special entity type or null
     */
    public static Entiddy fromEntity(@NotNull LivingEntity entity) {
        if (entity instanceof Player) return null;
        for (Entiddy entiddy: Entiddy.values()) {
            if (entiddy.entiddy().isInstance(entity)) return entiddy;
        }
        return null;
    }

}
