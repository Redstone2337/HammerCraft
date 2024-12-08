package net.redstone233.morehammercraft.core.until;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;

public class TeleportHeight {
    private double x;
    private double y;
    private double z;
    private double height;

//    public TeleportHeight(double x, double y, double z, double height) {
//        this.x = x;
//        this.y = y;
//        this.z = z;
//        this.height = height;
//    }

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

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void TeleportPos(Entity entity) {
        if (entity instanceof LivingEntity target) {
            target.teleport(getX(),getY() + getHeight(),getZ(),false);
        }
    }

}
