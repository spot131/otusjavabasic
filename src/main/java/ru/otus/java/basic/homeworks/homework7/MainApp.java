package ru.otus.java.basic.homeworks.homework7;

public class MainApp {
    public static void main(String[] args) {
       Car car = new Car(100);
       OffRoadVehicle ram = new OffRoadVehicle(100);
       Horse horse = new Horse(100);
       Human human = new Human("Аркаша");
       Bike bike = new Bike(human.getMaxDistance());

      human.getInto(ram);
      human.WannaGo(10,Landscape.SWAMP);

      human.getInto(bike);
      human.WannaGo(10, Landscape.SWAMP);
      System.out.println("done");
    }
}
