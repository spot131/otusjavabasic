package ru.otus.java.basic.homeworks.homework7;

class Horse implements Transport {
    private int energy;

    public Horse(int energy) {
        this.energy = energy;
    }

    @Override
    public boolean move(int distance, Terrain terrain) {
        if (terrain == Terrain.SWAMP) {
            System.out.println("лошадь не может двигаться по болоту!");
            return false;
        }
        if (energy >= distance) {
            energy -= distance;
            System.out.println("Лошадь прошла " + distance + " км. оставшиеся силы: " + energy);
            return true;
        }
        System.out.println("лошадь слишком устала!");
        return false;
    }
}