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

}
