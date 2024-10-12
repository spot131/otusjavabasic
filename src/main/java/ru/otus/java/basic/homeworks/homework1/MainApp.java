package ru.otus.java.basic.homeworks.homework1;

import java.util.Scanner;

public class MainApp
{
    public static void main(String[] args) {
        greetings();
        checkSign();
        selectColor();
        compareNumbers();
        addOrSubtractAndPrint();
    }

    public static void greetings(){
        System.out.println("Hello");
        System.out.println("world");
        System.out.println("from");
        System.out.println("java");
    }

    public static void checkSign(){
        System.out.println("Введите a");
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();

        System.out.println("Введите b");
        int b = scanner.nextInt();

        System.out.println("Введите c");
        int c = scanner.nextInt();

        int sum = a+b+c;

        if (sum >= 0){
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void selectColor(){
        System.out.println("Введите data");
        Scanner scanner = new Scanner(System.in);
        int data = scanner.nextInt();
        if (data <= 10) {
            System.out.println("Red");
        }
        if (data > 10 && data <=20){
            System.out.println("Yellow");
        }
        if (data > 20){
            System.out.println("Green");
        }
    }

    public static void compareNumbers(){
        System.out.println("Введите a");
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();

        System.out.println("Введите b");
        int b = scanner.nextInt();

        if (a>=b){
            System.out.println("a > =b");
        } else {
            System.out.println("a < b");
        }
    }

    public static void addOrSubtractAndPrint(){
        System.out.println("Введите initValue");
        Scanner scanner = new Scanner(System.in);
        int initValue = scanner.nextInt();

        System.out.println("Введите delta");
        int delta = scanner.nextInt();

        System.out.println("Введите increment (true or false)");
        boolean increment = scanner.nextBoolean();

        if (increment) {
            System.out.println(initValue+delta);
        } else {
            System.out.println(initValue - delta);
        }
    }
}
