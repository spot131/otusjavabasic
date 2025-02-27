package ru.otus.java.basic.homeworks.homework7;

class OffRoadVehicle implements Transport {
    private int fuel;

    public OffRoadVehicle(int fuel) {
        this.fuel = fuel;
    }

    @Override
    public boolean move(int distance, Terrain terrain) {
        if (fuel >= distance) {
            fuel -= distance;
            System.out.println("Внедорожник проехал " + distance + " км. оставшееся топливо: " + fuel);
            return true;
        }
        System.out.println("Недостаточно топлива!");
        return false;
    }
}