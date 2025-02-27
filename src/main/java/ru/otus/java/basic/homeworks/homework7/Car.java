package ru.otus.java.basic.homeworks.homework7;

class Car implements Transport {
    private int fuel;

    public Car(int fuel) {
        this.fuel = fuel;
    }

    @Override
    public boolean move(int distance, Terrain terrain) {
        if (terrain == Terrain.FOREST || terrain == Terrain.SWAMP) {
            System.out.println("Авто не может двигаться по этой местности");
            return false;
        }
        if (fuel >= distance) {
            fuel -= distance;
            System.out.println("Авто проехало " + distance + " км. Оставшееся топливо: " + fuel);
            return true;
        }
        System.out.println("Недостаточно топлива!");
        return false;
    }
}