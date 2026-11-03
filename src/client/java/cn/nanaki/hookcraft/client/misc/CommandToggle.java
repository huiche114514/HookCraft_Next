package cn.nanaki.hookcraft.client.misc;

import cn.nanaki.hookcraft.client.modules.Manager;
import cn.nanaki.hookcraft.client.modules.Modules;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import net.fabricmc.fabric.api.client.command.v2.ClientCommands;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;

public class CommandToggle {
    public static void commands(CommandDispatcher<FabricClientCommandSource> dispatcher) {
        dispatcher.register(
                ClientCommands.literal("hookcraft").then(ClientCommands.literal("toggle")
                        .then(ClientCommands.argument("module", StringArgumentType.word())
                                .executes(ctx -> {
                                            Modules m = Manager.getModuleByName(
                                                    StringArgumentType.getString(ctx, "module"));
                                            if (m != null) m.toggle();
                                            return 1;
                                        }
                                )
                        )
                )
        );
    }
}