package questions;

import java.util.*;

public class General {

    public int clockAngle(int hour, int minute){
        int angle = ((hour * 30) - (minute*6) + ((minute*30)/60));
        if (angle < 0) angle = angle * -1;
        return angle;
    }

    public int swaps(int[] arr, int k){
        int[] positions = new int[arr.length];
        int count = 0;
        int swaps = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] < k){
                positions[count] = i;
                count++;
            }
        }
        int start = positions[0];
        for(int j = 1; j < count; j++){
            if(start + 1 != positions[j]){
                swaps++;
            }
        }
        return swaps;
    }

    public void bitArr(int n, int[] a){
        Arrays.sort(a);
        if(n == 1){
            System.out.println(a[0]);
        } else {
            for(int i = 0; i < a.length; i+=2){
                if(i+1 == a.length){
                    System.out.println(a[i]);
                } else if(a[i] != a[i+1]){
                    System.out.println(a[i]);
                    break;
                }
            }
        }
    }

    public int swapper(int[] a){
        int swaps = 0;
        boolean notSwapped;
        do{
            notSwapped = false;
            for(int i = 1; i < a.length; i++){
                int temp;
                if(a[i-1] > a[i]){
                    System.out.println(a[i]);
                    temp = a[i];
                    a[i] = a[i-1];
                    a[i-1] = temp;
                    swaps++;
                    notSwapped = true;
                }
            }
            System.out.println(notSwapped);
        } while(notSwapped);
        return swaps;
    }

    public int anagram(String first, String second){
        StringBuilder sb = new StringBuilder(second);
        String ans = "";
        for(int i = 0; i < first.length(); i++){
            for(int j = 0; j < sb.length(); j++){
                if(first.charAt(i) == sb.charAt(j)){
                    ans+= first.charAt(i);
                    ans+= second.charAt(j);
                    sb.deleteCharAt(j);
                    break;

                }
            }
        }
        return (first.length()+second.length() - ans.length());
    }

    public static int getDelta(int[] arr1, int[] arr2){
        if(arr1.length != arr2.length){
            return -1;
        }
        int delta = 0;
        for(int i = 0; i < arr1.length; i++){
            int difference = Math.abs(arr1[i] - arr2[i]);
            delta+= difference;
        }
        return delta;
    }

    public static int[] getCharacterCounts(String str){
        int[] charCounts = new int[26];
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            int offset = (int) 'a';
            int code = c - offset;
            charCounts[code]++;
        }
        return charCounts;
    }


    public static int numberNeeded(String first, String second) {
        int[] arr1 = getCharacterCounts(first);
        int[] arr2 = getCharacterCounts(second);
        return getDelta(arr1, arr2);
    }


    public double[] getMedians(int n, int[] arr){
        PriorityQueue<Integer> high = new PriorityQueue<Integer>(n);
        PriorityQueue<Integer> low = new PriorityQueue<Integer>(new Comparator<Integer> () {
            public int compare(Integer x, Integer y) {
                return y - x;
            }
        });
        double medians[] = new double[arr.length];
        for(int i = 0; i < arr.length; i++){
            int number = arr[i];
            addNumber(number, low, high);
            balanceQueues(low, high);
            medians[i] = getMedian(low, high);
            System.out.println(medians[i]);
        }
        return medians;
    }

    public void addNumber(int number, PriorityQueue<Integer> low, PriorityQueue<Integer> high){
        if(low.size() == 0 || number < low.peek()){
            low.add(number);
        } else {
            high.add(number);
        }
    }

    public void balanceQueues(PriorityQueue<Integer> low, PriorityQueue<Integer> high){
        if(low.size() != high.size()){
            if(low.size() > high.size() && low.size() - high.size() > 1){
                high.add(low.poll());
            }
            if(high.size() > low.size() && high.size() - low.size() > 1){
                low.add(high.poll());
            }
        }

    }

    public double getMedian(PriorityQueue<Integer> low, PriorityQueue<Integer> high){
        if(low.size() != high.size()){
           if(low.size() > high.size()){
               return low.peek();
           } else {
               return high.peek();
           }
        } else {
            return ((double) (low.peek() + high.peek())/2);
        }
    }

    public void printMedian(int n, Queue<Integer> pq){
        List<Integer> tempPQ = new ArrayList<>(pq);
        Collections.sort(tempPQ);

        if(n == 1){
            System.out.println((double) tempPQ.get(0));
        } else {
            if (n % 2 != 0) {
                System.out.println((double) tempPQ.get(n / 2));
            }
            if (n % 2 == 0) {
                System.out.println((double) (tempPQ.get((n / 2) - 1) + tempPQ.get(n / 2)) / 2);
            }
        }
    }


    public void iceCreamSolver(int arr[], int money){
        int[] menu = arr.clone();
        Arrays.sort(menu);
        for(int i = 0; i < menu.length; i++){
            int compliment = money - menu[i];
            int index = Arrays.binarySearch(menu, i + 1, menu.length, compliment);

        }



    }



}
