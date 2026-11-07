package cn.nanaki.hookcraft.client.modules.movement;

import cn.nanaki.hookcraft.client.modules.Modules;

public class AutoSprint extends Modules {
    public static AutoSprint autoSprint;

    public AutoSprint() {
        super(Category.MOVEMENT, "AutoSprint", false);
        autoSprint = this;
    }
}
