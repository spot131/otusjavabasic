package ru.otus.java.basic.homeworks.homework7;

public enum Landscape {
    FOREST(1),
    SWAMP(2),
    FLATLAND(3);

    private int index;

    public int getIndex() {
        return index;
    }

    Landscape(int index) {
        this.index = index;
    }
}
