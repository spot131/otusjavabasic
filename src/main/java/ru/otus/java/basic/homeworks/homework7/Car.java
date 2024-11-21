package ru.otus.java.basic.homeworks.homework7;

public class Car implements Transport {
    private int maxDistance;

    public Car(int maxDistance) {
        this.maxDistance = maxDistance;
    }

    @Override
    public boolean run(int distance, Landscape land) {
        if (land == Landscape.FOREST || land == Landscape.SWAMP) {
            System.out.println("Машина не может перемещаться по такой местности");
            return false;
        }
        if (maxDistance < distance){
            System.out.println("Машине не хватает топлива");
            return false;
        }
        System.out.println("Машина успешно проехала " + distance);
        maxDistance -= distance;
        System.out.println("Топлива в баке осталось " + maxDistance);
        return true;
    }
}
