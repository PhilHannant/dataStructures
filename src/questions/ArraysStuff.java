package questions;

import java.util.Arrays;

public class ArraysStuff {

    public void missingNumbers(int[] arr){
        int sumMissing = 0;
        int sumTotal = 0;
        int max = 0;
        for(int i = 0; i < arr.length; i++){
            sumMissing += arr[i];
            max = arr[i];
        }
        for(int j = 0; j < max; j++){
            sumTotal += j+1;
        }


        int difference = sumTotal - sumMissing;

        System.out.println(sumMissing);
        System.out.println(sumTotal);
        System.out.println(difference);
    }

    public int[] mergeArrays(int[] arr1, int[] arr2){
        int start = 0;
        for(int i = 0; i < arr1.length; i++){
            if(arr1[i] == 0){
                start = i;
                break;
            }
        }
        for(int j = start; j< arr1.length; j++){
            arr1[j] = arr2[(j-arr2.length)];
        }
        Arrays.sort(arr1);
        return arr1;
    }

    public void printSpiral(int[][] arr){
        int top = 0;
        int left = 0;
        int right = arr.length -1;
        int bottome = arr.length-1;


    }


}
