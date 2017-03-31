package com.example.admin.myexamples.Dao;

/**
 * Created by admin on 21-Nov-16.
 */
public class Drawer {
    public int icon;
    public String name;

    public Drawer(int icon, String name) {
        setIcon(icon);
        setName(name);
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIcon() {
        return icon;
    }

    public String getName() {
        return name;
    }
}
