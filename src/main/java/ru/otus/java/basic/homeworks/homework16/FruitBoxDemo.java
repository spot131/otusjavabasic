package ru.otus.java.basic.homeworks.homework16;

public class FruitBoxDemo {
    public static void main(String[] args) {
        Box<Apple> appleBox1 = new Box<>();
        Box<Apple> appleBox2 = new Box<>();
        Box<Orange> orangeBox = new Box<>();
        MixedFruitBox mixedBox = new MixedFruitBox();

        for (int i = 0; i < 10; i++) {
            appleBox1.addFruit(new Apple());
            orangeBox.addFruit(new Orange());
        }

        for (int i = 0; i < 15; i++) {
            appleBox2.addFruit(new Apple());
        }

        mixedBox.addFruit(new Apple());
        mixedBox.addFruit(new Orange());
        mixedBox.addFruit(new Apple());

        System.out.println("Apple Box 1 weight: " + appleBox1.getWeight());
        System.out.println("Apple Box 2 weight: " + appleBox2.getWeight());
        System.out.println("Orange Box weight: " + orangeBox.getWeight());
        System.out.println("Mixed Box weight: " + mixedBox.getWeight());

        System.out.println("Apple Box 1 equals Orange Box in weight? " + appleBox1.compare(orangeBox));
        System.out.println("Apple Box 2 equals Orange Box in weight? " + appleBox2.compare(orangeBox));

        System.out.println("\nBefore pouring:");
        System.out.println("Apple Box 1 count: " + appleBox1.getCount());
        System.out.println("Mixed Box count: " + mixedBox.getCount());

        appleBox1.pourInto(mixedBox);
        System.out.println("\nAfter pouring:");
        System.out.println("Apple Box 1 count: " + appleBox1.getCount());
        System.out.println("Mixed Box count: " + mixedBox.getCount());
        System.out.println("Mixed Box weight: " + mixedBox.getWeight());

        appleBox2.pourInto(mixedBox);
        System.out.println("\nAfter pouring Apple Box 2:");
        System.out.println("Apple Box 2 count: " + appleBox2.getCount());
        System.out.println("Mixed Box count: " + mixedBox.getCount());
    }
}