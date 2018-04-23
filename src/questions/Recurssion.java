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

    public int fib(int n){
        if(n <= 1) return n;
        else return (fib(n-1) + fib(n-2));
    }


    public int fibFor(int n){
        int last = 1;
        int fib = 0;
        int temp;
        for(int i = 0; i < n;  i++){
            if(n <= 1) return 1;
            temp = fib;
            fib = fib + last;
            last = temp;

        }
        return fib;
    }


}
