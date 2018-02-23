package questions;

public class Recurssion {

    public int fibonacci(int fib){
        if(fib <= 1) return fib;
        return fibonacci(fib - 1) +  fibonacci(fib - 2);
    }

}
