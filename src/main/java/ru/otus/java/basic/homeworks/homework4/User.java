package ru.otus.java.basic.homeworks.homework4;

public class User {
    public String lastName;
    public String name;
    public String secondName;
    public int birthday;
    public String email;

    public User(String lastName, String name, String secondName, int birthday, String email) {
        this.lastName = lastName;
        this.name = name;
        this.secondName = secondName;
        this.birthday = birthday;
        this.email = email;
    }

    public void getInfo() {
        System.out.println("ФИО: " + lastName + " " + name + " " + secondName);
        System.out.println("Год рождения: " + birthday);
        System.out.println("email: " + email);
    }

}
