package ru.otus.java.basic.homeworks.homework5;

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
        System.out.println("Выносливость: " + enduranceCount);
        return enduranceCount;
    }
    public int getSpeedRun(){
        System.out.println("Скорость бега " + name + ": " + speedRun+" м/с");
        return speedRun;
    }
    public int getSpeedSwim(){
        System.out.println("Скорость плавания: " + name + ": "+ speedSwim+" м/с");
        return speedSwim;
    }
    public void makeSound(){
        System.out.println(sound);
    }
    public boolean info(){
        System.out.println(name +" устал "+tired);
        return tired;
    }

    public float run(int distance) {
        if (enduranceCount < (enduranceCount - distance * 1)) {
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
        if (enduranceCount < (enduranceCount - distance * enduranceCost)) {
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
