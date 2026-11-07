package cn.nanaki.hookcraft.client;

import cn.nanaki.hookcraft.client.misc.CommandToggle;
import cn.nanaki.hookcraft.client.modules.Manager;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

public class HookCraftClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        Manager.init();
        Manager.onClientGeneral();
        ClientCommandRegistrationCallback.EVENT.register((dispatcher, _) -> CommandToggle.commands(dispatcher));
        ClientTickEvents.END_CLIENT_TICK.register(_ -> Manager.onClientTick());
    }
}