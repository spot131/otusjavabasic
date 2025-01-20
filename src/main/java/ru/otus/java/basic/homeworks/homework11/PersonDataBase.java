package ru.otus.java.basic.homeworks.homework11;

import java.util.HashMap;
import java.util.Map;

public class PersonDataBase {
    private Map<Long, Person> personMap = new HashMap<>();

    public Person findById(Long id) {
        return personMap.get(id);
    }

    public void add(Person person) {
        personMap.put(person.id, person);
    }

    public boolean isManager(Person person) {
        if (person == null || person.position == null) {
            return false;
        }
        switch (person.position) {
            case MANAGER:
            case DIRECTOR:
            case BRANCH_DIRECTOR:
            case SENIOR_MANAGER:
                return true;
            default:
                return false;
        }
    }

    public boolean isEmployee(Long id) {
        Person person = findById(id);
        if (person == null || person.position == null) {
            return false;
        }

        switch (person.position) {
            case MANAGER:
            case DIRECTOR:
            case BRANCH_DIRECTOR:
            case SENIOR_MANAGER:
                return false;
            default:
                return true;
        }
    }
}
