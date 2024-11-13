package ru.otus.java.basic.homeworks.homework5;

public class MainApp {
    public static void main(String[] args) {

        Cat kotik = new Cat("Barsik", 10, 5, 10);
        kotik.makeSound();

        Dog sharik = new Dog("Sharik", 10, 3, 2);
        sharik.makeSound();

        Horse zorka = new Horse("Зорька", 15, 6, 20);
        zorka.makeSound();

        kotik.info();
        sharik.info();
        zorka.info();

        kotik.getSpeedRun();
        kotik.getSpeedSwim();
        kotik.run(10);
        kotik.swim(10);

        sharik.getSpeedRun();
        sharik.getSpeedSwim();
        sharik.run(10);
        sharik.swim(10);

        zorka.getSpeedRun();
        zorka.getSpeedSwim();
        zorka.run(10);
        zorka.swim(10);


        kotik.info();
        sharik.info();
        zorka.info();
    }

}
