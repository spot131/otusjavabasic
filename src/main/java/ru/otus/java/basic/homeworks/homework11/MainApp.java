package ru.otus.java.basic.homeworks.homework11;

public class MainApp {
    public static void main(String[] args) {
        PersonDataBase dataBase = new PersonDataBase();

        Person person1 = new Person();
        person1.id = 1L;
        person1.name = "Аркадий";
        person1.position = Position.PLUMBER;

        Person person2 = new Person();
        person2.id = 2L;
        person2.name = "Борис";
        person2.position = Position.DEVELOPER;

        Person person3 = new Person();
        person3.id = 3L;
        person3.name = "Владимир";
        person3.position = Position.MANAGER;

        dataBase.add(person1);
        dataBase.add(person2);
        dataBase.add(person3);

        System.out.println("Find by ID 1: " + dataBase.findById(1L).name);
        System.out.println("Аркадий руководитель? " + dataBase.isManager(person1));
        System.out.println("Борис рядовой сотрудник? " + dataBase.isEmployee(2L));
        System.out.println("Владимир рядовой сотрудник? " + dataBase.isEmployee(3L));
    }
}
