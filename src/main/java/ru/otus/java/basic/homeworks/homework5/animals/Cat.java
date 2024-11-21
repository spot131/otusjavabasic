package ru.otus.java.basic.homeworks.homework5.animals;

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
        System.out.println(String.format("Коты не умеют плавать, даже %d метров", distance));
        return -1f;
    }

}
