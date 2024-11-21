package ru.otus.java.basic.homeworks.homework5.animals;

public class Horse extends Animal {
    public Horse(String name, int speedRun, int speedSwim, int enduranceCount) {
        this.name = name;
        this.speedRun = speedRun;
        this.speedSwim = speedSwim;
        this.enduranceCount = enduranceCount;
        sound = "IGOGO";
        enduranceCost = 4;
    }

}