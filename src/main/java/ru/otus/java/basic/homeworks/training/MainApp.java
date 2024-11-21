package ru.otus.java.basic.homeworks.training;

public class MainApp {
    public static void main(String[] args) {
        Calendar calendar = new Calendar(DayOfWeek.MONDAY);
        if (calendar.dayOfWeek == DayOfWeek.MONDAY){
            System.out.println("Сегодня " + calendar.dayOfWeek.getIndex());
        }
    }
}
