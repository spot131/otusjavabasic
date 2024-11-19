package ru.otus.java.basic.homeworks.homework6;

public class Plate {
    private  int volume;
    int currentFoodLevel;

    public Plate(int volume) {
        this.volume = volume;
        currentFoodLevel = volume;

    }
    public  void info(){
        System.out.println("Объём миски - " + volume);
    }
    public int addFood() {
        if (currentFoodLevel + 1 > volume ){
            System.out.println("Тарелка уже полна");
            return currentFoodLevel;
        }

        currentFoodLevel += 1;
        System.out.println("Еды в тарелке стало " + currentFoodLevel);
        return currentFoodLevel;
    }

    public boolean decreaseFood(int appetite){
        if (currentFoodLevel - appetite >= 0) {
            currentFoodLevel -= appetite;
            return true;
        }
        else return false;
    }
}
