package cn.nanaki.hookcraft.client.modules.combat;

import cn.nanaki.hookcraft.client.modules.Modules;

public class Critical extends Modules {
    public static Critical critical;

    public Critical() {
        super(Category.COMBAT, "Critical", false);
        critical = this;
    }
}
