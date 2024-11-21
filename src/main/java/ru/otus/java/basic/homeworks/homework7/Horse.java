package ru.otus.java.basic.homeworks.homework7;

public class Horse implements Transport {
    private int maxDistance;

    public Horse(int maxDistance) {
        this.maxDistance = maxDistance;
    }

    public boolean run(int distance, Landscape land) {
        if (land == Landscape.SWAMP) {
            System.out.println("Лошадь не может перемещаться по такой местности");
            return false;
        }
        if (maxDistance < distance){
            System.out.println("Лошади не хватает сил");
            return false;
        }
        System.out.println("Лошадь успешно проехала " + distance);
        maxDistance -= distance;
        System.out.println("Сил осталось " + maxDistance);
        return true;
    }
}
