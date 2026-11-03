package cn.nanaki.hookcraft.client.modules;

import cn.nanaki.hookcraft.client.misc.SendMessage;

public abstract class Modules {
    public enum Category {
        COMBAT, MOVEMENT, VISUAL, HUD
    }

    private final Category category;
    private final String name;
    private boolean state;

    public Modules(Category category, String name, boolean state) {
        this.category = category;
        this.name = name;
        this.state = state;
    }

    public Category getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public boolean getState() {
        return state;
    }

    public void toggle() {
        this.state = !this.state;
        SendMessage.sendMessage(getName(), getState());
    }

    public void tick() {
    }

    public void render() {
    }

    public void general() {
    }
}