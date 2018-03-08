package questions;

import lists.LinkedList;

import java.time.LocalTime;

public class Dog implements Animal{

    private String type;
    private LocalTime time;

    public Dog(LocalTime time){
        this.time = time;
        type = "dog";
    }


    @Override
    public String getAnimal() {
        return type;
    }

    @Override
    public LocalTime getTime() {
        return time;
    }
}