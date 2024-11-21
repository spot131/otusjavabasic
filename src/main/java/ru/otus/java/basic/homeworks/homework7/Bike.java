package ru.otus.java.basic.homeworks.homework7;

public class Bike implements Transport{
    int maxDistance;

    public Bike(int maxDistance) {
        this.maxDistance = maxDistance;
    }

    @Override
    public boolean run(int distance, Landscape land) {
        if (land == Landscape.SWAMP) {
            System.out.println("велосипед не может перемещаться по такой местности");
            return false;
        }
        if (maxDistance < distance){
            System.out.println("человеку не хватает сил");
            return false;
        }
        System.out.println("человек успешно проехал " + distance);
        maxDistance -= distance;
        System.out.println("Сил осталось " + maxDistance);
        return true;
    }
}
