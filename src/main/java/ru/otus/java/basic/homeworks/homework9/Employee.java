package ru.otus.java.basic.homeworks.homework9;

public class Employee {
    String name;
    Integer age;

    public Employee(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return ("Имя:"+this.getName()+ "\n" +
                " Возраст : " + this.getAge()) + "\n";
    }
}
