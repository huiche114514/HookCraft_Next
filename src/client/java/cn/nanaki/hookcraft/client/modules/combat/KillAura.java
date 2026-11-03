package cn.nanaki.hookcraft.client.modules.combat;

import cn.nanaki.hookcraft.client.modules.Modules;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class KillAura extends Modules {
    private long lastAttackTime = 0;
    public KillAura() {
        super(Category.COMBAT, "KillAura", false);
    }

    @Override
    public void tick() {
        Minecraft client = Minecraft.getInstance();
        if (client.player == null || client.level == null) return;

        double currentRange = 4;
        double currentCps = 7;

        long currentAttackTime = System.currentTimeMillis();
        long attackInterval = (long) (1000.0 / currentCps);

        if (currentAttackTime - lastAttackTime >= attackInterval) {
            AABB box = client.player.getBoundingBox().inflate(currentRange);
            List<Entity> entities = client.level.getEntities(client.player, box);
            LivingEntity target = null;
            double closest = currentRange;

            for (Entity entity : entities) {
                if (!(entity instanceof LivingEntity living)) continue;
                if (living == client.player || living.isDeadOrDying()) continue;

                double distance = client.player.distanceTo(living);
                if (distance < closest) {
                    closest = distance;
                    target = living;
                }
            }

            if (target != null && client.gameMode != null) {
                client.gameMode.attack(client.player, target);
                client.player.swing(InteractionHand.MAIN_HAND);
                lastAttackTime = currentAttackTime;
            }
        }
    }
}