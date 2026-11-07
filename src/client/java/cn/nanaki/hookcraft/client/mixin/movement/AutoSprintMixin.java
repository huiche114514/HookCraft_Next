package cn.nanaki.hookcraft.client.mixin.movement;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.player.LocalPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static cn.nanaki.hookcraft.client.modules.movement.AutoSprint.autoSprint;

@Mixin(LocalPlayer.class)
@Environment(EnvType.CLIENT)
public class AutoSprintMixin {
    @Inject(method = "tick", at = @At("HEAD"))
    private void AutoSprintHook(CallbackInfo ci) {
        if (autoSprint == null || !autoSprint.getState()) return;

        LocalPlayer player = (LocalPlayer) (Object) this;
        player.setSprinting(true);
    }
}
