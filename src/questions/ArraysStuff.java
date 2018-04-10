package questions;

import java.util.*;

public class ArraysStuff {

    public int missingNumbers(int[] arr) {
        int sumMissing = 0;
        int sumTotal = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            sumMissing += arr[i];
            max = arr[i];
        }
        for (int j = 1; j <= max; j++) {
            sumTotal += j;
        }

        return sumTotal - sumMissing;

    }

    public boolean contains(int[] arr, int number){
        for(int i = 0; i < arr.length; i++){
            if(number == arr[i]) return true;
        }
        return false;
    }

    public int duplicateNumber(int[] arr){
        int sumDuplicated = 0;
        int sumTotal = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            sumDuplicated += arr[i];
            max = arr[i];
        }
        for (int j = 0; j <= max; j++) {
            sumTotal += j;
        }

        return sumDuplicated - sumTotal;

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


    public int[] mergeArrays2(int[] arr1, int[] arr2) {
        int[] arr3 = new int[arr1.length + arr2.length];
        for (int i = 0; i < arr1.length; i++) {
            arr3[i] = arr1[i];
        }
        int count = 0;
        for (int j = arr1.length; j < arr3.length; j++) {
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
                System.out.println(arr[j][right - 1]);
            }

            right--;
            if (top < bottom) {

                for (int k = right - 1; k >= left; k--) {
                    System.out.println(arr[bottom - 1][k]);
                }

                bottom--;
            }
            if (left < right) {

                for (int l = bottom - 1; l >= top; l--) {
                    System.out.println(arr[l][left]);
                }

                left++;
            }
        }

    }

    public void printKthSmallest(int[][] arr, int[] queries) {
        System.out.println("printKthSmallest");
        int[] lastRange = arr[arr.length - 1];
        int lastElem = lastRange[lastRange.length - 1];
        int[] rangeArr = new int[lastElem - arr[0][0]];

        for (int i = arr[0][0]; i < rangeArr.length; i++) {
            rangeArr[i] = i;
        }

        for (int i = 0; i < queries.length; i++) {
            if (queries[i] > rangeArr[rangeArr.length - 1]) {
                System.out.println("-1");
            } else {
                System.out.println(rangeArr[queries[i]]);
            }

        }

    }

    public int findMaxSum(int[][] arr, int matrix) {
        System.out.println("findMax");
        int maxSum = 0;
        for (int i = 0; i < arr.length - matrix + 1; i++) {
            for (int j = 0; j < arr.length - matrix + 1; j++) {
                int sum = 0;
                for (int k = i; k < matrix + i; k++) {
                    for (int l = j; l < matrix + j; l++) {
                        sum += arr[k][l];
                    }
                }
                if (sum > maxSum) maxSum = sum;
            }

        }
        return maxSum;
    }

    public int findMaxSumKadane(int[][] arr, int matrix) {
        System.out.println("findMaxSumKadane");
        int[][] verticalSum = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = 0; j < arr[0].length; j++) {
                sum += arr[j][i];
                verticalSum[j][i] = sum;
                System.out.println(sum);
            }
        }


        return 0;
    }


    public int maxSumSubArray(int[] arr) {
        int maxSumHere = arr[0];
        int currentMax = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxSumHere = Math.max(arr[i], maxSumHere + arr[i]);
            currentMax = Math.max(currentMax, maxSumHere);
        }
        return currentMax;
    }


    public int largestZeroSum(int[] arr) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int sum = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (!hm.containsKey(sum)) {
                hm.put(sum, i);
            } else {
                max = Math.max(max, i - hm.get(sum));
            }
        }
        return max;
    }


    public int maxSumTwo(int[] arr) {
        int first = Math.max(arr[0], arr[1]);
        int second = Math.min(arr[0], arr[1]);

        for (int i = 2; i < arr.length; i++) {
            if (first < arr[i]) {
                second = first;
                first = arr[i];
            }
        }
        return first + second;

    }

    public void minMax(int[] arr) {
        long sum = 0;
        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println(sum);

        for (int j = 0; j < arr.length; j++) {
            max = Math.max(max, sum - arr[j]);
            min = Math.min(min, sum - arr[j]);
        }

        System.out.println("min=" + min);
        System.out.println("max=" + max);
    }

    public int[] sorter(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    private void swap(int i, int j) {
        int temp = i;
        i = j;
        j = temp;
    }


    public int[] largestSmallest(int[] arr){
        int smallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            smallest = Math.min(smallest, arr[i]);
            largest = Math.max(largest, arr[i]);
        }
        int[] result = {smallest, largest};
        return result;
    }

    public Hashtable<Integer, Integer> findPairs(int[] arr, int sum){
        Set<Integer> pairs = new HashSet<>(arr.length);
        Hashtable<Integer, Integer> result = new Hashtable<>();
        for(int i: arr){
            if(!pairs.contains(sum - i)){
                pairs.add(i);
            } else {
                result.put(i, sum -i);
            }
        }
        return result;
    }

    public int repeatedDuplicates(int[] arr){
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            if(!hm.containsKey(arr[i])){
                hm.put(arr[i], 1);
            } else {
                hm.put(arr[i], hm.get(arr[i]) +1);
            }
        }
        for(int counts: hm.keySet()){
            if(hm.get(counts) > 1){
                return counts;
            }
        }
        return -1;
    }

    public int[] removeDuplicates(int[] arr){
        Hashtable<Integer, Integer> ht = new Hashtable<>();
        for(int i = 0; i < arr.length; i++){
            ht.put(arr[i], 1);
        }
        int[] returnArr = new int[ht.size()];
        int count = 0;
        for(int keys: ht.keySet()){
            returnArr[count] = keys;
            count++;
        }
        Arrays.sort(returnArr);
        return returnArr;
    }

    public int[] intersection(int[] arr1, int[] arr2){
        Set<Integer> set1 = new HashSet<>();
        for(int i = 0; i < arr1.length; i++){
            set1.add(arr1[i]);
        }
        int count = 0;
        for(int j = 0; j < arr2.length; j++){
            if(set1.contains(arr2[j])){
                count++;
            }
        }
        int[] answer = new int[count];
        count = 0;
        for(int j = 0; j < arr2.length; j++){
            if(set1.contains(arr2[j])){
                answer[count] = arr2[j];
                count++;
            }
        }
        return answer;
    }

    public int uniqueNumber(int[] arr){
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            if(!hm.containsKey(arr[i])){
                hm.put(arr[i], 1);
            } else {
               hm.put(arr[i], hm.get(arr[i]) + 1);
            }
        }

        for(int keys: hm.keySet()){
            if(hm.get(keys) == 1){
                return keys;
            }
        }
        return -1;
    }


    public int kthSmallest(int[] arr, int k){
        Arrays.sort(arr);
        for(int i = 0; i < k; i++){
            if(i == k-1) return arr[i];
        }
        return -1;
    }

    public int diffAdj(int[] arr1){
        int[] arr2 = new int[arr1.length];
        int count = 0;
        for(int i = 0; i < arr1.length-1; i++){
            if(count != 0){
                if(Math.abs(arr1[i]-arr2[count-1]) <=1) {
                    arr2[count] = arr1[i];
                    count++;
                }
            } else {
                if(Math.abs(arr1[i]-arr1[i+1]) <=1) {
                    arr2[count] = arr1[i];
                    count++;
                }
            }

        }
        return count;
    }
}
