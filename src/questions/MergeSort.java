package questions;
//  MergeSort(arr[], l,  r)
// l = left
// r = right
//      If r > l
//        1. Find the middle point to divide the array into two halves:
//        middle m = (l+r)/2
//        2. Call mergeSort for first half:
//        Call mergeSort(arr, l, m)
//        3. Call mergeSort for second half:
//        Call mergeSort(arr, m+1, r)
//        4. Merge the two halves sorted in step 2 and 3:
//        Call merge(arr, l, m, r)


public class MergeSort {

    public long mSort(int[] arr, int[] temp, int leftStart, int rightEnd){
        long invCount = 0;
        if(leftStart >= rightEnd){
            return invCount;
        }

        int middle = (leftStart + rightEnd)/2;
        invCount = mSort(arr, temp, leftStart, middle);
        invCount+= mSort(arr, temp, middle+1, rightEnd);
        invCount+= mergeHalves(arr, temp, leftStart, middle, rightEnd);
        return invCount;
    }

    public long mergeHalves(int[] arr, int[] temp, int leftStart, int middle, int rightEnd){
        long invCount = 0;
        int leftEnd = (leftStart + rightEnd)/2;
        int rightStart = leftEnd + 1;
        int size = rightEnd - leftStart + 1;

        int left = leftStart;
        int right = rightStart;
        int index = leftStart;

        while(left <= leftEnd && right <= rightEnd){
            if(arr[left] <= arr[right]){
                temp[index] = arr[left];
                left++;
            } else {
                temp[index] = arr[right];
                right++;
            }
            index++;
        }
        invCount+= leftEnd - left;

        System.arraycopy(arr, left, temp, index, leftEnd - left + 1);
        System.arraycopy(arr, right, temp, index, rightEnd - right + 1);
        System.arraycopy(temp, leftStart, arr, leftStart, size);

        return invCount;
    }


    public long countInversions(int array) {
        // Complete this function
        int[] temp = new int[array.];

        return mSort(array, temp, 0, array.length-1);
    }

}
