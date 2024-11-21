package ru.otus.java.basic.homeworks.homework7;

public class Human {
    private String name;
    private Transport currentTransport;
    private int maxDistance = 20;

    public int getMaxDistance() {
        return maxDistance;
    }

    public Human(String name) {
        this.name = name;
    }

    public boolean getInto(Transport transport){
        currentTransport = transport;
        System.out.println(name + " сел в " + transport.getClass());
        return true;
    }

    public boolean getOut(){
        currentTransport = null;
        return true;
    }

    public boolean WannaGo(int distance, Landscape landscape){
        if (currentTransport == null){

        }
        currentTransport.run(distance, landscape);
        return true;
    }
}
