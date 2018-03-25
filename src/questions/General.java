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


    public int indexOf(int[] menu, int value, int exclude){
        for(int i = 0; i < menu.length; i++){
            if(menu[i] == value && menu[i] != exclude){
                return i;
            }
        }return -1;
    }

    public int[] getIndices(int[] menu, int value1, int value2){
        int index1 = indexOf(menu, value1, -1);
        int index2 = indexOf(menu, value2, value1);
        int[] indices = {Math.min(value1, value2), Math.max(value1, value2)};
        return indices;
    }
    public int[] iceCreamSolver(int arr[], int money){
        int[] menu = arr.clone();
        Arrays.sort(menu);
        for(int i = 0; i < menu.length; i++){
            int compliment = money - menu[i];
            int index = Arrays.binarySearch(menu, i + 1, menu.length, compliment);
            if(index >= 0 && index < menu.length & menu[index] == compliment){
                int[] indices = getIndices(menu, menu[index], compliment);
                return indices;
            }
        }
        return null;
    }

    public boolean anagram2(String first, String second){

        if(first.length() != second.length()) return false;
        HashMap<Character, Integer> f = populateHash(first);
        HashMap<Character, Integer> s = populateHash(second);

        for(Character c : f.keySet()){
            if(!s.containsKey(c)) return false;
            if(s.get(c) != f.get(c)) return false;
        }
        return true;
    }

    public HashMap<Character, Integer> populateHash(String str){
        HashMap<Character, Integer> hm = new HashMap<>();
        char[] chars = str.toCharArray();
        for(int i = 0; i < chars.length; i++){
            if(!hm.containsKey(chars[i])){
                hm.put(chars[i], 1);
            } else {
                hm.put(chars[i], hm.get(chars[i] + 1));
            }
        }
        return hm;
    }


    public boolean ransom(String[] magazine, String[] ransom){
        HashMap<String, Integer> mag = new HashMap<>();
        HashMap<String, Integer> ran = new HashMap<>();

        for(int i = 0; i < magazine.length; i++){
            if(!mag.containsKey(magazine[i])){
                mag.put(magazine[i], 0);
            } else {
                mag.put(magazine[i], mag.get(magazine[i]) + 1);
            }
        }

        for(int j = 0; j < ransom.length; j++){
            if(!ran.containsKey(ransom[j])){
                ran.put(ransom[j], 0);
            } else {
                ran.put(ransom[j], ran.get(ransom[j]) + 1);
            }
        }

        for(String key: ran.keySet()){
            if(!mag.containsKey(key)) return false;
            int occurence = ran.get(key);
            if(mag.get(key) < occurence){
                return false;
            }
        }
        return true;
    }

    public String URLify(String str, int length){
        StringBuilder s = new StringBuilder();
        char[] arr = str.toCharArray();
        System.out.println(arr[2]);
        for(int i = 0; i < length; i++){
            if(arr[i] == ' '){
                s.append("20%");
            } else {
                s.append(arr[i]);
            }

        }
        return s.toString();
    }


    public String sherlock(String str){
        if(str.isEmpty() || str == null)return "NO";
        char[] arr = str.toCharArray();
        HashMap<Character, Integer> charCount = new HashMap<>();
        Set<Character> charSet = new HashSet<>();

        for(int i = 0; i < arr.length; i++){
            if(charCount.containsKey(arr[i])){
                charCount.put(arr[i], charCount.get(arr[i]) + 1);
            } else {
                charCount.put(arr[i], 1);
                charSet.add(arr[i]);
            }
        }

        if(checkDiff(charCount, charSet)) return "YES";
        return "NO";
    }


    public boolean checkDiff(HashMap<Character, Integer> hm, Set<Character> cSet) {
        int max = 0;
        int min;
        int freqMin = 0;
        int freqMax = 0;
        for (Character c : cSet) {
            max = Math.max(max, hm.get(c));
        }

        min = max;
        for(Character c: cSet){
            min = Math.min(min , hm.get(c));
        }


        for (Character c : cSet) {
            if (max == hm.get(c)) {
                freqMax++;
            }
            if (min == hm.get(c)) {
                freqMin++;
            }
        }

        if(max == min || (freqMax==cSet.size()-1 && min==1) || (freqMin==cSet.size()-1 && max-min==1)){

            return true;
        } else {
            return false;
        }
    }


    public String panagram(String s){
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] arr = s.toLowerCase().toCharArray();


        HashMap<Character, Integer> pana = new HashMap<>();
        for(int i = 0; i < alphabet.length; i++){
            pana.put(alphabet[i], 0);
        }

        for(int j = 0; j < arr.length; j++){

            if(pana.containsKey(arr[j])){
                pana.put(arr[j], pana.get(arr[j]) + 1);
            }
        }
        for(int key: pana.values()){
            if(key == 0){
                return "not pangram";
            }
        }
        return "pangram";
    }

    public String kangaroo(int x1, int v1, int x2, int v2) {
        int dis = Math.abs(x1-x2);
        int speed = Math.abs(v1-v2);
        if(v1 > v2){
            if(dis > speed){
                if(dis % speed == 0) return "YES";
            } else {
                if(speed % dis == 0) return "YES";
            }
        }
        return "NO";
    }


}
