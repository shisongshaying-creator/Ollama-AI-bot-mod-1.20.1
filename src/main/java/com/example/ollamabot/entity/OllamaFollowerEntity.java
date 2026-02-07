package com.example.ollamabot.entity;

import java.util.EnumSet;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class OllamaFollowerEntity extends PathfinderMob {
    public OllamaFollowerEntity(EntityType<? extends PathfinderMob> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.25D)
                .add(Attributes.FOLLOW_RANGE, 24.0D);
    }

    @Override
    protected void registerGoals() {
        goalSelector.addGoal(1, new FollowNearestPlayerGoal(this, 1.2D, 3.0F, 12.0F));
        goalSelector.addGoal(2, new WaterAvoidingRandomStrollGoal(this, 1.0D));
    }

    private static class FollowNearestPlayerGoal extends Goal {
        private final PathfinderMob mob;
        private final double speed;
        private final float minDistance;
        private final float maxDistance;
        private Player target;
        private int timeToRecalcPath;

        FollowNearestPlayerGoal(PathfinderMob mob, double speed, float minDistance, float maxDistance) {
            this.mob = mob;
            this.speed = speed;
            this.minDistance = minDistance;
            this.maxDistance = maxDistance;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
        }

        @Override
        public boolean canUse() {
            Player nearest = mob.level().getNearestPlayer(mob, maxDistance);
            if (nearest == null) {
                return false;
            }
            if (mob.distanceToSqr(nearest) <= minDistance * minDistance) {
                return false;
            }
            target = nearest;
            return true;
        }

        @Override
        public boolean canContinueToUse() {
            if (target == null || !target.isAlive()) {
                return false;
            }
            double distance = mob.distanceToSqr(target);
            return distance > minDistance * minDistance && distance <= maxDistance * maxDistance;
        }

        @Override
        public void start() {
            timeToRecalcPath = 0;
        }

        @Override
        public void stop() {
            target = null;
            mob.getNavigation().stop();
        }

        @Override
        public void tick() {
            if (target == null) {
                return;
            }
            mob.getLookControl().setLookAt(target, 10.0F, mob.getMaxHeadXRot());
            if (--timeToRecalcPath <= 0) {
                timeToRecalcPath = 10;
                mob.getNavigation().moveTo(target, speed);
            }
        }
    }
}
