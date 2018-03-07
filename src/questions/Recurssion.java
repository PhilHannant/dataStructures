package questions;

public class Recurssion {

    public int fibonacci(int fib, int[] memo){
        if(fib <= 1) {
            return fib;
        } else if (memo[fib] == 0){
            memo[fib] = fibonacci(fib - 1, memo) +  fibonacci(fib - 2, memo);
        }
        return memo[fib];
    }

}
