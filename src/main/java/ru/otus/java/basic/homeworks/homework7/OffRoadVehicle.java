package ru.otus.java.basic.homeworks.homework7;

public class OffRoadVehicle implements Transport {
    private int maxDistance;

    public OffRoadVehicle(int distance) {
        this.maxDistance = distance;
    }
    public boolean run(int distance, Landscape land) {
        if (maxDistance < distance){
            System.out.println("Вездеходу не хватает топлива");
            return false;
        }
        System.out.println("Вездеход успешно проехал " + distance);
        maxDistance = maxDistance - distance;
        System.out.println("Топлива в баке осталось " + maxDistance);
        return true;
    }
}
