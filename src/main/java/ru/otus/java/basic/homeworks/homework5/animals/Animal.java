package ru.otus.java.basic.homeworks.homework5.animals;

public class Animal {
    String name;
    int speedRun;
    int speedSwim;
    int enduranceCount; // абсолютное значение выносливости
    int enduranceCost;
    boolean tired = false;
    String sound;

    public String getName(){
        return name;
    }
    public int getEndurance(){
        return enduranceCount;
    }
    public int getSpeedRun(){
        return speedRun;
    }
    public int getSpeedSwim(){
        return speedSwim;
    }
    public void makeSound(){
        System.out.println(sound);
    }
    public boolean info(){
        return tired;
    }

    public float run(int distance) {
        if (enduranceCount < distance ) {
            System.out.println(name + " устал");
            tired = true;
            return -1;
        }
        float time;
        time = (float) distance / speedRun;
        System.out.println(name + " пробежал " +distance+ " за " + time+" сек");
        enduranceCount -=  distance * 1;
        return time;

    }

    public float swim(int distance) {
        if (enduranceCount <  distance * enduranceCost) {
            System.out.println(name + " устал");
            tired = true;
            return -1;
        }
        float time;
        time = (float) distance / speedSwim;
        System.out.println(name + " проплыл " +distance+ " за " + time +" сек");
        enduranceCount -=  distance * enduranceCost;
        return time;
    }


}
