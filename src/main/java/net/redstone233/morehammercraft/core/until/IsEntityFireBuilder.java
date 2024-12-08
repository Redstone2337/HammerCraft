package net.redstone233.morehammercraft.core.until;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;

public class IsEntityFireBuilder {
    private final float tick;

    private IsEntityFireBuilder(IsFireBuilder builder) {
        this.tick = builder.tick;
    }

    public float getTick() {
        return tick;
    }

    public static class IsFireBuilder {
        private float tick;

        public IsFireBuilder() {
        }

        public IsFireBuilder tick(float tick) {
            this.tick = tick;
            return this;
        }

        public IsEntityFireBuilder fireBuilder() {
            return new IsEntityFireBuilder(this);
        }
    }

    public void FireSetFor(Entity entity) {
        if (entity instanceof LivingEntity target) {
            target.setOnFireFor(tick);
        }
    }

}
