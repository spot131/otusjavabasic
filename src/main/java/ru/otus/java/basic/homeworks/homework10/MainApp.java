package ru.otus.java.basic.homeworks.homework10;

public class MainApp {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Иванов Аркадий", "+79161112233");
        phoneBook.add("Петров Мван", "+79161113344");
        phoneBook.add("Иванов Аркадий", "+79161114455");
        phoneBook.add("Сидоров Евгений", "+79161115566");

        System.out.println("Иванов Аркадий: " + phoneBook.find("Иванов Аркадий"));
        System.out.println("Петров Мван: " + phoneBook.find("Петров Мван"));
        System.out.println("Инкогнито: " + phoneBook.find("Инкогнито"));

        System.out.println("Contains +79161112233: " + phoneBook.containsPhoneNumber("+79161112233"));
        System.out.println("Contains +79161114455: " + phoneBook.containsPhoneNumber("+79161114455"));

    }
}
