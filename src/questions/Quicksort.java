package questions;

public class Quicksort {

    private int[] numbers;
    private int number;

    public void sort(int[] values){
        if(values == null || values.length == 0){
            return;
        }

        this.numbers = values;
        number = values.length;
        quicksort(0, number-1);
    }


    public void quicksort(int low, int high){
        int i = low;
        int j = high;
        int pivot = numbers[low + (high-low)/2];

        while(i <= j){

            while(numbers[i] < pivot){
                i++;
            }

            while(numbers[j] > pivot){
                j--;
            }

            if(i <= j){
                swap(i, j);
                i++;
                j--;
            }
        }

        if(low < j){
            quicksort(low, j);
        }
        if(i < high){
            quicksort(i, high);
        }
    }

    public void swap(int i, int j){
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}
