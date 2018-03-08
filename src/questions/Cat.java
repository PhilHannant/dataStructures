package questions;

import java.time.LocalTime;

public class Cat implements Animal {

    private String type;
    private LocalTime time;

    public Cat(LocalTime time){
        this.time = time;
        type = "cat";
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
