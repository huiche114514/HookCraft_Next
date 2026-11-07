package cn.nanaki.hookcraft.client.mixin.combat;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static cn.nanaki.hookcraft.client.modules.combat.Critical.critical;

@Mixin(Player.class)
@Environment(EnvType.CLIENT)
public class CriticalMixin {
    @Inject(method = "canCriticalAttack", at = @At("HEAD"), cancellable = true)
    private void CriticalHook(Entity entity, CallbackInfoReturnable<Boolean> cir) {
        if (critical == null || !critical.getState()) return;

        cir.setReturnValue(true);
    }
}
