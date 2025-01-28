package ru.otus.java.basic.homeworks.homework11;

import java.util.HashMap;
import java.util.EnumSet;
import java.util.Map;
import java.util.Set;

public class PersonDataBase {
    private Map<Long, Person> personMap = new HashMap<>();

    public Person findById(Long id) {
        return personMap.get(id);
    }

    public void add(Person person) {
        personMap.put(person.id, person);
    }

    private static final Set<Position> MANAGERIAL_POSITIONS = EnumSet.of(
            Position.MANAGER,
            Position.DIRECTOR,
            Position.BRANCH_DIRECTOR,
            Position.SENIOR_MANAGER
    );

    public boolean isManager(Person person) {
        return person != null && MANAGERIAL_POSITIONS.contains(person.position);
    }

    public boolean isEmployee(Long id) {
        Person person = findById(id);

        return person != null && person.position != null && !MANAGERIAL_POSITIONS.contains(person.position);
    }

}
