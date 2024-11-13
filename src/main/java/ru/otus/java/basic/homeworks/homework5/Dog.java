package ru.otus.java.basic.homeworks.homework5;

public class Dog extends Animal {
    public Dog(String name, int speedRun, int speedSwim,int enduranceCount) {
        this.name = name;
        this.speedRun = speedRun;
        this.speedSwim = speedSwim;
        this.enduranceCount = enduranceCount;
        sound = "GAV";
        enduranceCost = 2;
    }

}