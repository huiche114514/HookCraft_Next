package cn.nanaki.hookcraft.client.modules;

import java.util.ArrayList;
import java.util.List;

public class Manager {
    private static final List<Modules> modules = new ArrayList<>();

    public static void init() {
    }

    public static List<Modules> getModules() {
        return modules;
    }

    public static Modules getModuleByName(String name) {
        for (Modules m : getModules()) {
            if (m.getName().equalsIgnoreCase(name)) return m;
        }
        return null;
    }

    public static void onClientTick() {
        for (Modules m : getModules()) {
            if (m.getState()) m.tick();
        }
    }

    public static void onClientRender() {
        for (Modules m : getModules()) {
            if (m.getState()) m.render();
        }
    }

    public static void onClientGeneral() {
        for (Modules m : getModules()) {
            if (m.getState()) m.general();
        }
    }
}
