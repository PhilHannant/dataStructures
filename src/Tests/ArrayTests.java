package Tests;

import org.junit.*;
import questions.ArraysStuff;
import questions.Quicksort;

import java.util.Arrays;
import java.util.Hashtable;

import static org.junit.Assert.assertEquals;

public class ArrayTests {

    @Test
    public void maxSumArrayTest(){
        ArraysStuff as = new ArraysStuff();
        int[] arr = {1, 2, 4, -5, 10, -11, 2, -15, 9};
        int maxSumActual = 12;
        assertEquals(maxSumActual, as.maxSumSubArray(arr));
    }

    @Test
    public void sorterTest(){
        ArraysStuff as = new ArraysStuff();
        int[] arr = {4,3,7,5,9,1,2};
        int[] expected = {1,2,3,4,5,7,9};
        arr = as.sorter(arr);
        for(int i = 0; i < arr.length; i++){
            assertEquals(arr[i], expected[i]);
        }
    }

    @Test
    public void missingNumberTest(){
        ArraysStuff as = new ArraysStuff();
        int[] arr = new int[100];
        for(int i = 0; i < arr.length; i++){
            arr[i] = i;
        }
        arr[60] = 0;
        int missing = as.missingNumbers(arr);
        int expected = 60;
        assertEquals(expected, missing);
    }

    @Test
    public void duplcateNumberTest(){
        ArraysStuff as = new ArraysStuff();
        int[] arr = {0,1,3,2,6,4,5,6};
        int duplicate = as.duplicateNumber(arr);
        int expected = 6;
        assertEquals(expected, duplicate);
    }

    @Test
    public void containsTest(){
        ArraysStuff as = new ArraysStuff();
        int[] arr = {0,1,3,2,6,4,5,6};
        boolean answer = as.contains(arr,5);
        assertEquals(true, answer);

    }

    @Test
    public void smallestLargest(){
        ArraysStuff as = new ArraysStuff();
        int[] arr = {0,1,3,2,6,4,5,6};
        int[] answer = as.largestSmallest(arr);
        assertEquals(0, answer[0]);
        assertEquals(6, answer[1]);

    }

    @Test
    public void pairsTest(){
        ArraysStuff as = new ArraysStuff();
        int[] arr = { 2, 4, 3, 5, 6, -2, 7, 8, 9 };
        Hashtable<Integer, Integer> answer = as.findPairs(arr, 7);
        Integer[][] expected = {{3, 4},{5,2}, {9,-2}};
        for(int i = 0; i < expected.length; i++){
            assertEquals(answer.get(expected[i][0]), expected[i][1]);
        }

    }

    @Test
    public void mulDuplicateTest(){
        ArraysStuff as = new ArraysStuff();
        int[] arr = {1, 4, 5, 6, 3, 6, 2, 6, 6, 7, 9};
        int answer = as.repeatedDuplicates(arr);
        int expected = 6;
        assertEquals(expected, answer);
    }

    @Test
    public void removeDuplicateTest(){
        ArraysStuff as = new ArraysStuff();
        int[] arr = {1, 2, 1, 2, 3, 4, 5};
        int[] answer = as.removeDuplicates(arr);
        int[] expected = {1,2,3,4,5};
        for(int i = 0; i < answer.length; i++){
            assertEquals(expected[i], answer[i]);
        }
    }

    @Test
    public void intertsectionTest(){
        ArraysStuff as = new ArraysStuff();
        int[] arr1 = {21, 34, 41, 22, 35};
        int[] arr2 = {61, 34, 45, 21, 11};
        int[] answer = as.intersection(arr1, arr2);
        Arrays.sort(answer);
        int[] expected = {21, 34};
        for(int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], answer[i]);
        }
    }

    @Test
    public void uniqueNumberTest(){
        ArraysStuff as = new ArraysStuff();
        int[] arr = {1, 1, 2, 2, 3, 4, 4, 5, 5};
        int answer = as.uniqueNumber(arr);
        int expected = 3;
        assertEquals(expected, answer);

    }

    @Test
    public void getKthSmallestTest(){
        ArraysStuff as = new ArraysStuff();
        int[] arr = {23,45,24,6,7,2,88,9,10};
        int answer = as.kthSmallest(arr, 4);
        int expected = 9;
        assertEquals(expected, answer);
    }

    @Test
    public void quickSortTest(){
        Quicksort qs = new Quicksort();
        int[] arr = {5,4,3,7,8,1,9,25,17,22,11,2};
        qs.sort(arr);
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
