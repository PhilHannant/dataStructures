package questions;

import java.util.Arrays;

public class QuestionsMain {

    public static void main(String[] args){
        ArraysStuff a = new ArraysStuff();
        int[] arr = {1,2,4,6,7, 8, 10 ,15};
        int[] arr1 = {1,3,5,0,0,0};
        int[] arr2 = {2,4,6};
        System.out.println(Arrays.toString(a.mergeArrays(arr1, arr2)));

        Recurssion r = new Recurssion();
        System.out.println(r.fibonacci(10));
        System.out.println(r.fibonacci(4));
        System.out.println(r.fibonacci(25));

        General g = new General();
        System.out.println(g.clockAngle(3, 40));

        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        a.printSpiral(matrix);
    }

}
