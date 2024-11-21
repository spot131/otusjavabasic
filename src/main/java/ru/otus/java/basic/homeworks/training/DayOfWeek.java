package ru.otus.java.basic.homeworks.training;

public enum DayOfWeek {
    MONDAY(1),
    TUESDAY(2),
    WEDNESDAY(3),
    THURSDAY(4),
    FRIDAY(5),
    SATURDAY(6),
    SUNDAY(7);

    private int index;

    public int getIndex() {
        return index;
    }

    DayOfWeek(int index) {
        this.index = index;
    }
}
