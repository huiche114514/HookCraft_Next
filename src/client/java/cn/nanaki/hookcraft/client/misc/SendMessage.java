package cn.nanaki.hookcraft.client.misc;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;

public class SendMessage {
    public static void sendMessage(String modulesName, boolean modulesState) {
        Minecraft client = Minecraft.getInstance();
        if (client.player != null) {
            if (modulesState) {
                client.gui.hud.getChat().addClientSystemMessage(Component.literal("HookCraft: " + modulesName + "_ON"));
            } else {
                client.gui.hud.getChat().addClientSystemMessage(Component.literal("HookCraft: " + modulesName + "_OFF"));
            }
        }
    }
}
