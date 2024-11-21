package ru.otus.java.basic.homeworks.feedcats;

public class MainApp {
    public static void main(String[] args) {
        // Create a plate with food
        Plate plate = new Plate(50);
        System.out.println("Initial " + plate);

        // Create an array of cats
        Cat[] cats = {
                new Cat("Whiskers", 10),
                new Cat("Mittens", 20),
                new Cat("Shadow", 15),
                new Cat("Pumpkin", 25)
        };

        // Feed each cat
        for (Cat cat : cats) {
            cat.eat(plate);
            System.out.println(cat);
        }

        // Print the remaining food in the plate
        System.out.println("After feeding cats " + plate);

        // Add more food to the plate
        plate.addFood(30);
        System.out.println("After adding food " + plate);

        // Attempt to feed the cats again
        for (Cat cat : cats) {
            cat.eat(plate);
            System.out.println(cat);
        }

        // Print the final state of the plate
        System.out.println("Final " + plate);
    }
}
