package ru.otus.java.basic.homeworks.homework5;

import ru.otus.java.basic.homeworks.homework5.animals.Cat;
import ru.otus.java.basic.homeworks.homework5.animals.Dog;
import ru.otus.java.basic.homeworks.homework5.animals.Horse;

public class MainApp {
    public static void main(String[] args) {

        Cat kotik = new Cat("Барсик", 10, 5, 1);
        kotik.makeSound();

        Dog sharik = new Dog("Шарик", 10, 3, 3);
        sharik.makeSound();

        Horse zorka = new Horse("Зорька", 15, 6, 20);
        zorka.makeSound();

        System.out.println(kotik.getName() + " " + (kotik.info() ? "устал" : "не устал"));
        System.out.println(sharik.getName() + " " + (sharik.info() ? "устал" : "не устал"));
        System.out.println(zorka.getName() + " " + (zorka.info() ? "устал" : "не устал"));

        System.out.printf("скорость бега %s: %d м/с %n", kotik.getName(), kotik.getSpeedRun());
        System.out.printf("скорость плавания %s: %d м/с %n", kotik.getName(), kotik.getSpeedSwim());
        kotik.run(10);
        kotik.swim(10);

        System.out.printf("скорость бега %s: %d м/с %n", sharik.getName(), sharik.getSpeedRun());
        System.out.printf("скорость плавания %s: %d м/с %n", sharik.getName(), sharik.getSpeedSwim());
        sharik.run(10);
        sharik.swim(10);

        System.out.printf("скорость бега %s: %d м/с %n", zorka.getName(), zorka.getSpeedRun());
        System.out.printf("скорость плавания %s: %d м/с %n", zorka.getName(), zorka.getSpeedSwim());
        zorka.run(10);
        zorka.swim(10);


        System.out.println(kotik.getName() + " " + (kotik.info() ? "устал" : "не устал"));
        System.out.println(sharik.getName() + " " + (sharik.info() ? "устал" : "не устал"));
        System.out.println(zorka.getName() + " " + (zorka.info() ? "устал" : "не устал"));

    }

}
