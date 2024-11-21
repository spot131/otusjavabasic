package ru.otus.java.basic.homeworks.feedcats;


class Cat {
    private String name;
    private int appetite;
    private boolean isSatiety;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.isSatiety = false; // Cats are hungry by default.
    }

    public void eat(Plate plate) {
        if (!isSatiety && plate.decreaseFood(appetite)) {
            isSatiety = true; // Cat becomes satiated if it eats.
        }
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", appetite=" + appetite +
                ", isSatiety=" + (isSatiety ? "satiated" : "hungry") +
                '}';
    }
}