package ru.otus.java.basic.homeworks.homework6;

public class Cat
{
    private  String name;
    private int appetite;
    boolean isFull = false;

    public String getName() {
        return name;
    }

    public int getAppetite() {
        return appetite;
    }

    public boolean isFull() {
        return isFull;
    }

    public Cat (String name, int appetite){
        this.name = name;
        this.appetite = appetite;
    }

    public boolean eat(Plate plate){
        if (appetite > plate.currentFoodLevel){
            return false;
        }
        else { // если коту хватает пожрать
            isFull = true;
            plate.decreaseFood(appetite);
            return true;
            }
    }
}
