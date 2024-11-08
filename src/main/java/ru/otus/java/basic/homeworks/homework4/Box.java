package ru.otus.java.basic.homeworks.homework4;

public class Box {
    private int width;
    private int length;
    private int height;
    public String color;
    public boolean isOpen;
    public boolean isClosed;
    public boolean isEmpty;

    public Box(int width, int length, int height, String color) {
        this.width = width;
        this.length = length;
        this.height = height;
        this.color = color;
        //коробка по дефолту пустая и закрытая
        isOpen = false;
        isClosed = true;
        isEmpty = true;
    }

    public void getInfo() {
        System.out.println("длина * ширина * высота: " + width + "*" + length + "*" + height);
        System.out.println("Цвет коробки: " + color);
        if (!isEmpty) System.out.println("Коробка не пустая");
        if (isEmpty) System.out.println("Коробка пустая");
    }

    public void close() {
        isClosed = true;
        isOpen = false;
        System.out.println("Коробка закрыта");
    }

    public void open() {
        isOpen = true;
        isClosed = false;
        System.out.println("Коробка открыта");
    }

    public void putObject() {
        if (isClosed) {
            System.out.println("Коробка закрыта. Для того, чтобы положить объект внутрь, коробку надо открыть");
        }
        if (!isEmpty) {
            System.out.println("Коробка не пуста");
        }
        if (!isClosed && isEmpty) {
            isEmpty = false;
            System.out.println("Объект помещен в коробку");
        }
    }

    public void getObject() {
        if (isClosed) {
            System.out.println("Коробка закрыта. Для того, чтобы вытащить объект, коробку надо открыть");
        }
        if (isEmpty) {
            System.out.println("Коробка уже пустая");
        }
        if (!isClosed && !isEmpty) {
            isEmpty = true;
            System.out.println("Объект убран из коробки");
        }
    }
}
