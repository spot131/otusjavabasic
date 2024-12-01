package ru.otus.java.basic.homeworks.homework9;

import java.util.ArrayList;

public class MainApp {
    public static void main(String[] args) {

        System.out.println(returnSequential(5, 9));

        ArrayList<Integer> listInt = new ArrayList<>();
        listInt.add(2);
        listInt.add(3);
        listInt.add(4);
        listInt.add(5);
        listInt.add(6);

        System.out.println(returnSumGT5(listInt));

        rewriteList(listInt, 777);
        System.out.println(listInt);

        increaseListElements(listInt, 5);
        System.out.println(listInt);

        Employee Vasya = new Employee("Вася", 60);
        Employee Petya = new Employee("Петя", 70);
        Employee Arkasha = new Employee("Аркаша", 80);

        ArrayList<Employee> listEmployees = new ArrayList<>();
        listEmployees.add(Vasya);
        listEmployees.add(Petya);
        listEmployees.add(Arkasha);

        System.out.println(returnNamesEmployee(listEmployees));

        System.out.println(returnOldEmployees(listEmployees, 80));

        System.out.println(checkAverageAge(listEmployees, 69));

        System.out.println(getYoungestEmployee(listEmployees));

    }

    //Реализуйте метод, принимающий в качестве аргументов числа min и max, и возвращающий
    // ArrayList с набором последовательных значений в указанном диапазоне (min и max включительно, шаг - 1);
    public static ArrayList<Integer> returnSequential(int min, int max) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = min; i < max + 1; i++) {
            list.add(i);
        }
        return list;
    }

    //Реализуйте метод, принимающий в качестве аргумента список целых чисел, суммирующий все элементы,
    // значение которых больше 5, и возвращающий сумму;
    public static int returnSumGT5(ArrayList<Integer> list) {
        int sum = 0;
        for (Integer integer : list) {
            if (integer > 5) {
                sum += integer;
            }
        }
        return sum;
    }

    //Реализуйте метод, принимающий в качестве аргументов целое число и ссылку на список,
    // метод должен переписать каждую заполненную ячейку списка указанным числом;
    public static void rewriteList(ArrayList<Integer> list, int n) {
        list.replaceAll(ignored -> n);
    }

    //Реализуйте метод, принимающий в качестве аргументов целое число и ссылку на список,
    // увеличивающий каждый элемент списка на указанное число;
    public static void increaseListElements(ArrayList<Integer> list, int n) {
        list.replaceAll(integer -> integer + n);
    }

    //Реализуйте метод, принимающий в качестве аргумента список сотрудников, и возвращающий список их имен;
    public static ArrayList<String> returnNamesEmployee(ArrayList<Employee> list) {
        ArrayList<String> names = new ArrayList<>();
        for (Employee employee : list) {
            names.add(employee.name);
        }
        return names;
    }

    //Реализуйте метод, принимающий в качестве аргумента список сотрудников и минимальный возраст,
    // и возвращающий список сотрудников, возраст которых больше либо равен указанному аргументу;
    public static ArrayList<Employee> returnOldEmployees(ArrayList<Employee> list, int minAge) {
        ArrayList<Employee> oldEmployees = new ArrayList<>();
        for (Employee employee : list) {
            if (employee.age >= minAge) {
                oldEmployees.add(employee);
            }
        }
        return oldEmployees;
    }

    //Реализуйте метод, принимающий в качестве аргумента список сотрудников и минимальный средний возраст,
    // и проверяющий что средний возраст сотрудников превышает указанный аргумент;
    public static boolean checkAverageAge(ArrayList<Employee> list, int minAverageAge) {
        int averageAge = 0;
        int sumAge = 0;
        for (Employee employee : list) {
            sumAge += employee.getAge();
        }
        averageAge = sumAge / list.size();
        return averageAge > minAverageAge;
    }

    //Реализуйте метод, принимающий в качестве аргумента список сотрудников, и возвращающий ссылку на самого молодого сотрудника
    public static Employee getYoungestEmployee(ArrayList<Employee> list) {
        Employee youngest = list.get(0);
        for (Employee employee : list) {
            if (employee.getAge() < youngest.getAge()) {
                youngest = employee;
            }
        }
        return youngest;
    }
}
