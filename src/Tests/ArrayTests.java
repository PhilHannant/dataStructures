package Tests;

import org.junit.*;
import questions.ArraysStuff;

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

}
