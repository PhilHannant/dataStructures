package questions;


import java.time.LocalTime;
import java.util.LinkedList;
import java.util.Queue;

public class Shelter {

    private Queue<Animal> catList = new LinkedList<>();
    private Queue<Animal> dogList = new LinkedList<>();


    public void addCat(){
        enQueue(new Cat(LocalTime.now()));
    }

    public void addDog(){
        enQueue(new Dog(LocalTime.now()));
    }

    public void enQueue(Animal animal){
        if(animal.getAnimal().equals("cat")){
            catList.add(animal);
        } else {
            dogList.add(animal);
        }
    }

    public Animal deQueueAny(){
        if(catList.isEmpty()) return dogList.poll();
        if(dogList.isEmpty()) return catList.poll();
        if(catList.peek().getTime().isBefore(dogList.peek().getTime())){
            return catList.poll();
        } else {
            return dogList.poll();
        }
    }

    public Animal deQueueCat(){
        return catList.poll();
    }

    public Animal deQueueDog(){
        return dogList.poll();
    }

}
