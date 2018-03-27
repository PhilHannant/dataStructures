package questions;

import java.util.Arrays;
import java.util.HashMap;

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


    public int[] mergeArrays2(int[] arr1, int[] arr2){
        int[] arr3 = new int[arr1.length + arr2.length];
        for(int i = 0; i < arr1.length; i++){
            arr3[i] = arr1[i];
        }
        int count = 0;
        for(int j = arr1.length; j < arr3.length; j++){
            arr3[j] = arr2[count];
            count++;
        }
        return arr3;
    }

    public void printSpiral(int[][] arr) {
        int top = 0;
        int left = 0;
        int right = arr[0].length;
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


    public int maxSumSubArray(int[] arr){
        int maxSumHere = arr[0];
        int currentMax = arr[0];
        for(int i = 1; i < arr.length; i++){
            maxSumHere = Math.max(arr[i], maxSumHere + arr[i]);
            currentMax = Math.max(currentMax, maxSumHere);
        }
        return currentMax;
    }


    public int largestZeroSum(int[] arr){
        HashMap<Integer, Integer> hm = new HashMap<>();
        int sum = 0;
        int max = 0;
        for(int i = 0; i < arr.length; i++){
            sum+= arr[i];
            if(!hm.containsKey(sum)){
                hm.put(sum, i);
            } else {
                max = Math.max(max, i - hm.get(sum));
            }
        }
        return max;
    }


    public int maxSumTwo(int[] arr){
        int first = Math.max(arr[0], arr[1]);
        int second = Math.min(arr[0], arr[1]);

        for(int i = 2; i < arr.length; i++){
            if(first < arr[i]){
                second = first;
                first = arr[i];
            }
        }
        return first + second;

    }

    public void minMax(int[] arr){
        long sum = 0;
        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;

        for(int i = 0; i < arr.length; i++){
            sum+= arr[i];
        }
        System.out.println(sum);

        for(int j = 0; j < arr.length; j++){
            max = Math.max(max, sum - arr[j]);
            min = Math.min(min, sum - arr[j]);
        }

        System.out.println("min="+min);
        System.out.println("max="+max);
    }

}
