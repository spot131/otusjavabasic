package ru.otus.java.basic.homeworks.homework10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    private Map<String, List<String>> phoneBook ;
    public PhoneBook() {
        phoneBook = new HashMap<>();
    }
    public void add(String name, String phoneNumber) {
        phoneBook.computeIfAbsent(name, k -> new ArrayList<>()).add(phoneNumber);
    }
    public List<String> find(String name) {
        return phoneBook.getOrDefault(name, new ArrayList<>());
    }
    public boolean containsPhoneNumber(String phoneNumber) {
        for (List<String> phoneNumbers : phoneBook.values()) {
            for (String phone : phoneNumbers) {
                if (phone.equals(phoneNumber)) {
                    return true;
                }
            }
        }
        return false;
    }
}