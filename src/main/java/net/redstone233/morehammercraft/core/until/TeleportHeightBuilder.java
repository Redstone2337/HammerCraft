package net.redstone233.morehammercraft.core.until;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;

public class TeleportHeightBuilder {
    private final double x;
    private final double y;
    private final double z;
    private final double height;

    private TeleportHeightBuilder(HeightBuilders builder) {
        this.x = builder.x;
        this.y = builder.y;
        this.z = builder.z;
        this.height = builder.height;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public double getHeight() {
        return height;
    }

    public static class HeightBuilders {
        private double x;
        private double y;
        private double z;
        private double height;

        public HeightBuilders() {
        }

        public HeightBuilders X(double x) {
            this.x = x;
            return this;
        }

        public HeightBuilders Y(double y) {
            this.y = y;
            return this;
        }

        public HeightBuilders Z(double z) {
            this.z = z;
            return this;
        }

        public HeightBuilders Height(double height) {
            this.height = height;
            return this;
        }

        public TeleportHeightBuilder heightBuilder() {
            return new TeleportHeightBuilder(this);
        }
    }

    public void TeleportPos(Entity entity) {
        if (entity instanceof LivingEntity target) {
            target.teleport(getX(),getY() + getHeight(),getZ(),false);
        }
    }
}
