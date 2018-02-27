package questions;

import java.util.Arrays;

public class ArraysStuff {

    public void missingNumbers(int[] arr) {
        int sumMissing = 0;
        int sumTotal = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            sumMissing += arr[i];
            max = arr[i];
        }
        for (int j = 0; j < max; j++) {
            sumTotal += j + 1;
        }


        int difference = sumTotal - sumMissing;

        System.out.println(sumMissing);
        System.out.println(sumTotal);
        System.out.println(difference);
    }

    public int[] mergeArrays(int[] arr1, int[] arr2) {
        int start = 0;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] == 0) {
                start = i;
                break;
            }
        }
        for (int j = start; j < arr1.length; j++) {
            arr1[j] = arr2[(j - arr2.length)];
        }
        Arrays.sort(arr1);
        return arr1;
    }


    public void printSpiral(int[][] arr) {
        int top = 0;
        int left = 0;
        int right = arr.length;
        int bottom = arr.length;

        while (top < bottom && left < right) {


            for (int i = left; i < right; i++) {
                System.out.println(arr[top][i]);
            }

            top++;

            for (int j = top; j < bottom; j++) {
                System.out.println(arr[j][right-1]);
            }

            right--;
            if (top < bottom) {

                for (int k = right-1; k >= left; k--) {
                    System.out.println(arr[bottom-1][k]);
                }

                bottom--;
            }
            if (left < right) {

                for (int l = bottom-1; l >= top; l--) {
                    System.out.println(arr[l][left]);
                }

                left++;
            }
        }

    }

    public void printKthSmallest(int[][] arr, int[] queries){
        System.out.println("printKthSmallest");
        int[] lastRange = arr[arr.length - 1];
        int lastElem = lastRange[lastRange.length - 1];
        int[] rangeArr = new int[lastElem - arr[0][0]];

        for(int i = arr[0][0]; i < rangeArr.length; i++){
            rangeArr[i]=i;
        }

        for(int i = 0; i < queries.length; i++){
            if(queries[i] > rangeArr[rangeArr.length-1]){
                System.out.println("-1");
            } else {
                System.out.println(rangeArr[queries[i]]);
            }

        }

    }

    public int findMaxSum(int[][]arr, int matrix){
        System.out.println("findMax");
        int maxSum = 0;
        for(int i = 0; i < arr.length-matrix+1; i++){
            for (int j = 0; j < arr.length-matrix+1; j++) {
                int sum = 0;
                for (int k = i; k < matrix+i; k++) {
                    for(int l = j; l < matrix+j; l++) {
                        sum+= arr[k][l];
                    }
                }
                if (sum > maxSum) maxSum = sum;
            }

        }
        return maxSum;
    }

    public int findMaxSumKadane(int[][] arr, int matrix){
        System.out.println("findMaxSumKadane");
        int[][] verticalSum = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++){
            int sum = 0;
            for(int j = 0; j < arr[0].length; j++){
                sum+=arr[j][i];
                verticalSum[j][i]=sum;
                System.out.println(sum);
            }
        }


        return 0;
    }

}
