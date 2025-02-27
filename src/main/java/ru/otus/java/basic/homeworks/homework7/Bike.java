package ru.otus.java.basic.homeworks.homework7;

class Bike implements Transport {
    @Override
    public boolean move(int distance, Terrain terrain) {
        if (terrain == Terrain.SWAMP) {
            System.out.println("Велосипед не может двигаться по болоту!");
            return false;
        }
        System.out.println("Велосипед проехал " + distance + " км.");
        return true;
    }
}