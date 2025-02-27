package ru.otus.java.basic.homeworks.homework7;

public class MainApp {
    public static void main(String[] args) {
        Human dude = new Human("Аркадий");
        Car car = new Car(50);
        Horse horse = new Horse(30);
        Bike bike = new Bike();
        OffRoadVehicle offRoadVehicle = new OffRoadVehicle(60);

        dude.move(10, Terrain.FLATLAND);
        dude.boardTransport(car);
        dude.move(20, Terrain.FOREST);
        dude.move(20, Terrain.FLATLAND);
        dude.dismount();
        dude.boardTransport(horse);
        dude.move(15, Terrain.FLATLAND);
        dude.dismount();
        dude.boardTransport(bike);
        dude.move(10, Terrain.SWAMP);
    }
}
