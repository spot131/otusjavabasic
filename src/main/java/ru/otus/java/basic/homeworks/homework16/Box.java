package ru.otus.java.basic.homeworks.homework16;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    private final List<T> fruits;

    public Box() {
        this.fruits = new ArrayList<>();
    }

    public void addFruit(T fruit) {
        fruits.add(fruit);
    }

    public void addFruits(List<T> newFruits) {
        fruits.addAll(newFruits);
    }

    public double getWeight() {
        double totalWeight = 0;
        for (T fruit : fruits) {
            totalWeight += fruit.getWeight();
        }
        return totalWeight;
    }

    public boolean compare(Box<?> anotherBox) {
        return Math.abs(this.getWeight() - anotherBox.getWeight()) < 0.0001;
    }

    public int getCount() {
        return fruits.size();
    }

    public void pourInto(Box<? super T> anotherBox) {
        if (this == anotherBox) {
            return;
        }

        anotherBox.addFruits(new ArrayList<>(this.fruits));
        this.fruits.clear();
    }

    public List<T> getFruits() {
        return new ArrayList<>(fruits);
    }
}