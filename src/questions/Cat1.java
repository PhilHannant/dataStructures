package questions;

public class Cat1 extends Animal1{
    public void foo() {  // hides Animal.foo()
            System.out.println("Cat");
    }
}
