package ru.otus.java.basic.homeworks.homework7;

class Human {
    private String name;
    private Transport currentTransport;

    public Human(String name) {
        this.name = name;
    }

    public void boardTransport(Transport transport) {
        this.currentTransport = transport;
        System.out.println(name + " залез в " + transport.getClass().getSimpleName());
    }

    public void dismount() {
        this.currentTransport = null;
        System.out.println(name + " вылез");
    }

    public boolean move(int distance, Terrain terrain) {
        if (currentTransport != null) {
            return currentTransport.move(distance, terrain);
        }
        System.out.println(name + " прошел " + distance + " км.");
        return true;
    }
}