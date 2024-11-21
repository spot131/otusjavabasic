package ru.otus.java.basic.homeworks.feedcats;

class Plate {
    private int maxFood;
    private int currentFood;

    public Plate(int maxFood) {
        this.maxFood = maxFood;
        this.currentFood = maxFood; // Plate is initially filled to its maximum.
    }

    public int getCurrentFood() {
        return currentFood;
    }

    public void addFood(int food) {
        if (food > 0) {
            currentFood += food;
            if (currentFood > maxFood) {
                currentFood = maxFood; // Ensure food does not exceed the plate's capacity.
            }
        }
    }

    public boolean decreaseFood(int amount) {
        if (amount > 0 && currentFood >= amount) {
            currentFood -= amount;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Plate{" + "currentFood=" + currentFood + '}';
    }
}
