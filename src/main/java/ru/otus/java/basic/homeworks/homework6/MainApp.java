package ru.otus.java.basic.homeworks.homework6;

public class MainApp
{
    public static void main(String[] args) {
        Plate plate = new Plate(10);
        plate.info();
        plate.addFood();
        plate.decreaseFood(1); // для теста уменьшим кол-во еды в тарелке
        System.out.printf("Еды в тарелке %s%n", plate.currentFoodLevel);
        plate.addFood();


        Cat[] cats = new Cat[3];
        cats[0] = new Cat("Барсик", 5);
        cats[1] = new Cat("Снежок", 5);
        cats[2] = new Cat("Кузя", 7);

        for (Cat each : cats) {
            each.eat(plate);
            System.out.printf("Кот %s сыт %b%n", each.getName(), each.isFull());
        }
        System.out.printf("Еды в тарелке %s%n", plate.currentFoodLevel);


    }
}
