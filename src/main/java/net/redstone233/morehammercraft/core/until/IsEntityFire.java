package net.redstone233.morehammercraft.core.until;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;

public class IsEntityFire {

    private float tick;

    public float getEntityFire() {
        return tick;
    }

    public void setEntityFire(float entityFire) {
        this.tick = entityFire;
    }

    public void FireSetFor(Entity entity) {
        if (entity instanceof LivingEntity target) {
            target.setOnFireFor(getEntityFire());
        }
    }

    public static boolean Fire(Entity entity) {
        return entity instanceof LivingEntity target && target.isOnFire();
    }
}
