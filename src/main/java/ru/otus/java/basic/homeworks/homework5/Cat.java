package ru.otus.java.basic.homeworks.homework5;

public class Cat extends Animal {
    public Cat(String name, int speedRun, int speedSwim, int enduranceCount) {
        this.name = name;
        this.speedRun = speedRun;
        this.speedSwim = speedSwim;
        this.enduranceCount =  enduranceCount;
        sound = "MEOW";
    }

    @Override
    public float swim(int distance) {
        System.out.println("Коты не умеют плавать, даже " + distance + " метров");
        return -1f;
    }

}
