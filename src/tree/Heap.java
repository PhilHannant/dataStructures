package tree;


import java.util.PriorityQueue;
import java.util.Queue;

//min heap
public class Heap {

    private Integer size;
    private Integer capacity;
    private Integer[] harr;

    public Heap(Integer capacity){
        this.capacity = capacity;
        harr = new Integer[capacity];
        size = 0;
    }


    public int getMin(){
        return harr[0];
    }

    public int getParent(Integer index){
        return (index-1)/2;
    }

    public int getLeftChild(Integer index){
        return (2*index+1);
    }

    public int getRightChild(Integer index){
        return (2*index+2);
    }

    public void insertKey(Integer key){
        if(size == capacity){
            return;
        }
        harr[size] = key;
        Integer parentKey = size-1;
        size++;

        if(parentKey > 0) {
            while (harr[getParent(parentKey)] > harr[parentKey] && parentKey != 0) {
                swap(parentKey, getParent(parentKey));
                parentKey = getParent(parentKey);
            }
        }
    }

    public void print(){
        for(int i = 0; i < size; i++){
            System.out.println(harr[i]);
        }
    }

    public void swap(Integer index, Integer parent){
        int temp = harr[index];
        harr[index] = harr[parent];
        harr[parent] = temp;
    }

    public void decreaseKey(Integer index, Integer newValue){
        harr[index] = newValue;
        while (harr[getParent(index)] > harr[index] && index != 0) {
            swap(index, getParent(index));
            index = getParent(index);
        }

    }

    public Integer extractMin(){
        if(harr[0] != null && size == 0) {
            return null;
        }
        if(size == 1){
            size--;
            return harr[0];
        }
        System.out.println("extract new root="+harr[size-1]);
        Integer root = harr[0];
        harr[0] = harr[size-1];
        size--;
        rearrangeHeap(0);

        return root;
    }

    public void deleteKey(Integer index){
        decreaseKey(index, Integer.MIN_VALUE);
        extractMin();
    }

    public void rearrangeHeap(Integer index){
        System.out.println("index="+index);
        Integer left = getLeftChild(index);
        Integer right = getRightChild(index);
        Integer min = index;
        if(harr[left] != null){
            if(harr[left] < harr[index]){
                min = left;
            }
        }
        if(harr[right] != null){
            if(harr[right] < harr[min]) {
                min = right;
            }
        }
        if(min != index){
            swap(index, min);
            rearrangeHeap(min);
        }

    }



}
