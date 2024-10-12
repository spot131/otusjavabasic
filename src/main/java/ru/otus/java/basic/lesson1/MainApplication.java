package ru.otus.java.basic.lesson1;

import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.SimpleTimeZone;

public class MainApplication {
    public static void main(String[] args) {

        System.out.println("Введите число");
        Scanner scanner  = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println("Вы ввели: " +n);
        System.out.println("Multiple : " + (n*n));
    }


}